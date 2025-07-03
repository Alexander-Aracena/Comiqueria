package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.AutorDTO;
import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.dto.ProductosPorAutorDTO;
import com.minpay.Comiqueria.model.Autor;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AutorToProductosPorAutorDTO implements IMapper<Autor, ProductosPorAutorDTO> {
    @Override
    public ProductosPorAutorDTO map(Autor autor) {
        Set<ProductoDTO> productos = autor.getProductos().stream().map(producto -> {
            return new ProductoDTO(
                    producto.getId(), producto.getTitulo(), producto.getPrecio(), producto.getDescripcion(),
                    producto.getTapa(), producto.getIsbn(), producto.getPeso(), producto.getDimensiones(),
                    producto.getPaginas(),
                    producto.getSubcategoria().getId(), producto.getEditorial().getId(),
                    producto.getEsNovedad(), producto.getEsOferta(), producto.getEsMasVendido(),
                    producto.getIndex()
            );
        }).collect(Collectors.toSet());
        
        return new ProductosPorAutorDTO(
                autor.getId(),
                new AutorDTO(autor.getNombre(), autor.getApellido(),
                        autor.getFechaAlta(), autor.getFechaBaja()),
                productos
        );
    }

    @Override
    public ProductosPorAutorDTO map(Autor autor, ProductosPorAutorDTO productosPorAutorDTO) {
        productosPorAutorDTO.getAutor().setNombre(autor.getNombre());
        productosPorAutorDTO.getAutor().setApellido(autor.getApellido());
        productosPorAutorDTO.getAutor().setFechaAlta(autor.getFechaAlta());
        productosPorAutorDTO.getAutor().setFechaBaja(autor.getFechaBaja());
        return productosPorAutorDTO;
    }
}
