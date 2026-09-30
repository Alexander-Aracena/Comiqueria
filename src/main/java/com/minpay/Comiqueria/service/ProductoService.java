package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.request.ProductoRequestDTO;
import com.minpay.Comiqueria.dto.response.ProductoResponseDTO;
import com.minpay.Comiqueria.exceptions.InvalidOperationException;
import com.minpay.Comiqueria.mapper.IProductoMapper;
import com.minpay.Comiqueria.model.Autor;
import com.minpay.Comiqueria.model.Editorial;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.model.Subcategoria;
import com.minpay.Comiqueria.repository.IAutorRepository;
import com.minpay.Comiqueria.repository.IEditorialRepository;
import com.minpay.Comiqueria.service.interfaces.IProductoService;
import com.minpay.Comiqueria.repository.IProductoRepository;
import com.minpay.Comiqueria.repository.ISubcategoriaRepository;
import com.minpay.Comiqueria.repository.specification.ProductoSpecifications;
import com.minpay.Comiqueria.utils.Utils;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IProductoMapper productoMapper;

    @Autowired
    private IAutorRepository autorRepository;

    @Autowired
    private ISubcategoriaRepository subcategoriaRepository;

    @Autowired
    private IEditorialRepository editorialRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductoResponseDTO getProducto(Long id) {
        Producto producto = Utils.findByIdOrThrow(productoRepository, id, Producto.class);
        return this.productoMapper.toProductoResponseDTO(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponseDTO> getProductos(
        List<Long> ids, String titulo, BigDecimal minPrecio, BigDecimal maxPrecio, String descripcion,
        Long idAutor, Long idSubcategoria, Long idEditorial, Boolean esNovedad, Boolean esOferta,
        Boolean productosMasVendidos, Boolean esVisibleEnHome
    ) {
        Specification<Producto> specs = ProductoSpecifications.byCriterios(
            ids, titulo, minPrecio, maxPrecio, descripcion, idAutor, idSubcategoria,
            idEditorial, esNovedad, esVisibleEnHome, esOferta, productosMasVendidos
        );
        List<Producto> productos = this.productoRepository.findAll(specs);
        return IntStream.range(0, productos.size())
            .mapToObj(i ->
                productoMapper.toProductoResponseDTO(
                    productos.get(i),
                    Boolean.TRUE.equals(productosMasVendidos)?
                        i + 1
                        : null
                )
            )
            .toList();
    }

    @Override
    public ProductoResponseDTO createProducto(ProductoRequestDTO productoDTO) {
        Producto producto = this.productoMapper.toProducto(productoDTO);
        Subcategoria subcategoria = Utils.findByIdOrThrow(
            subcategoriaRepository, productoDTO.idSubcategoria(), Subcategoria.class
        );
        if (subcategoria.getFechaBaja() != null) {
            throw new InvalidOperationException("La subcategoría no está vigente");
        }
        Editorial editorial = Utils.findByIdOrThrow(
            editorialRepository, productoDTO.idEditorial(), Editorial.class
        );
        if (editorial.getFechaBaja() != null) {
            throw new InvalidOperationException("La editorial no está vigente");
        }
        producto.setSubcategoria(subcategoria);
        producto.setEditorial(editorial);
        producto = this.productoRepository.save(producto);
        return this.productoMapper.toProductoResponseDTO(producto);
    }

    @Override
    public ProductoResponseDTO editProducto(Long id, ProductoRequestDTO productoDTO) {
        Producto productoEditado = Utils.findByIdOrThrow(productoRepository, id, Producto.class);
        this.productoMapper.updateProductoFromDTO(productoDTO, productoEditado);
        if (!productoDTO.idAutores().isEmpty()) {
            List<Autor> nuevosAutores = this.autorRepository.findAllById(productoDTO.idAutores());
            productoEditado.setAutores(Utils.convertirListaASet(nuevosAutores));
        }
        if (productoDTO.idSubcategoria() != null) {
            Subcategoria nuevaSubcategoria = Utils.findByIdOrThrow(
                subcategoriaRepository, productoDTO.idSubcategoria(), Subcategoria.class
            );
            if (nuevaSubcategoria.getFechaBaja() != null) {
                throw new InvalidOperationException("La subcategoría seleccionada no está vigente");
            }
            productoEditado.setSubcategoria(nuevaSubcategoria);
        }
        if (productoDTO.idEditorial() != null) {
            Editorial nuevaEditorial = Utils.findByIdOrThrow(
                editorialRepository, productoDTO.idEditorial(), Editorial.class
            );
            if (nuevaEditorial.getFechaBaja() != null) {
                throw new InvalidOperationException("La editorial seleccionada no está vigente");
            }
            productoEditado.setEditorial(nuevaEditorial);
        }
        productoEditado = this.productoRepository.save(productoEditado);
        return this.productoMapper.toProductoResponseDTO(productoEditado);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto productoEliminado = Utils.findByIdOrThrow(productoRepository, id, Producto.class);
        if (productoEliminado.getFechaBaja() != null) {
            throw new InvalidOperationException("El producto ya fue dado de baja");
        }
        this.productoRepository.delete(productoEliminado);
    }
}