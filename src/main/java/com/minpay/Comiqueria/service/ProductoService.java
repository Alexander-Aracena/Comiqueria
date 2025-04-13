package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.ProductoDTOToProducto;
import com.minpay.Comiqueria.service.interfaces.IProductoService;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.repository.IAutorRepository;
import com.minpay.Comiqueria.repository.IProductoRepository;
import com.minpay.Comiqueria.service.interfaces.IEditorialService;
import com.minpay.Comiqueria.service.interfaces.ISubcategoriaService;
import com.minpay.Comiqueria.utils.Utils;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Autowired
    private IAutorRepository autorRepository;
    
    @Autowired
    private ISubcategoriaService subcategoriaService;
    
    @Autowired
    private IEditorialService editorialService;
    
    @Autowired
    private ProductoDTOToProducto mapper;

    @Override
    public Producto getProducto(Long id) {
        return this.productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto id: " + id + " no encontrado."));
    }
    
    @Override
    public ProductoDTO getProductoDTO(Producto producto){
        return productoAProductoDTO(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return this.productoRepository.findAll();
    }
    
    @Override
    public List<Producto> getProductos(Set<Long> idsProductos){
        return this.productoRepository.findAllById(idsProductos);
    }
    
    @Override
    public List<ProductoDTO> getProductosDTO(){
        List<Producto> productos = this.getProductos();
        return this.traerListaDTO(productos);
    }
    
    @Override
    public List<ProductoDTO> getProductosDTO(Set<Long> idsProductos){
        List<Producto> productos = this.getProductos(idsProductos);
        return this.traerListaDTO(productos);
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = this.mapper.map(productoDTO);
        producto.setSubcategoria(
            this.subcategoriaService.getSubcategoria(productoDTO.getIdSubcategoria())
        );
        producto.setEditorial(
            this.editorialService.getEditorial(productoDTO.getIdEditorial())
        );
        
        this.productoRepository.save(producto);
        productoDTO.setId(producto.getId());
        
        return productoDTO;
    }

    @Override
    public ProductoDTO editProductoById(Long id, ProductoDTO productoDTO) {
        Producto producto = this.mapper.map(productoDTO, this.getProducto(id));
        producto.setSubcategoria(
            this.subcategoriaService.getSubcategoria(productoDTO.getIdSubcategoria())
        );
        producto.setEditorial(
            this.editorialService.getEditorial(productoDTO.getIdEditorial())
        );
        this.productoRepository.save(producto);
        productoDTO.setId(id);
        
        return productoDTO;
    }

    @Override
    public void deleteProductoById(Long id) {
        this.productoRepository.deleteById(id);
    }

    private List<ProductoDTO> traerListaDTO(List<Producto> productos) {
        return productos.stream().map(producto -> productoAProductoDTO(producto)
        ).toList();
    }

    private static ProductoDTO productoAProductoDTO(Producto producto) {
        return new ProductoDTO(
            producto.getId(),
            producto.getTitulo(),
            producto.getPrecio(),
            producto.getDescripcion(),
            producto.getTapa(),
            producto.getIsbn(),
            producto.getPeso(),
            producto.getDimensiones(),
            producto.getPaginas(),
            producto.getSubcategoria().getId(),
            producto.getEditorial().getId(),
            producto.getEsNovedad(),
            producto.getEsOferta(),
            producto.getEsMasVendido(),
            producto.getIndex()
        );
    }
}