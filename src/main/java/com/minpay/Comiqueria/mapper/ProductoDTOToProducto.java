package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.ProductoRequestDTO;
import com.minpay.Comiqueria.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoDTOToProducto implements IMapper<ProductoRequestDTO, Producto> {
    @Override
    public Producto map(ProductoRequestDTO productoDTO) {
        Producto producto = new Producto();
        producto.setTitulo(productoDTO.getTitulo());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setTapa(productoDTO.getTapa());
        producto.setIsbn(productoDTO.getIsbn());
        producto.setPeso(productoDTO.getPeso());
        producto.setDimensiones(productoDTO.getDimensiones());
        producto.setPaginas(productoDTO.getPaginas());
        producto.setEsNovedad(productoDTO.getEsNovedad());
        producto.setEsOferta(productoDTO.getEsOferta());
        producto.setEsMasVendido(productoDTO.getEsMasVendido());
        producto.setIndex(productoDTO.getIndex());
        
        return producto;
    }

    @Override
    public Producto map(ProductoRequestDTO productoDTO, Producto producto) {
        producto.setTitulo(productoDTO.getTitulo());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setTapa(productoDTO.getTapa());
        producto.setIsbn(productoDTO.getIsbn());
        producto.setPeso(productoDTO.getPeso());
        producto.setDimensiones(productoDTO.getDimensiones());
        producto.setPaginas(productoDTO.getPaginas());
        producto.setEsNovedad(productoDTO.getEsNovedad());
        producto.setEsOferta(productoDTO.getEsOferta());
        producto.setEsMasVendido(productoDTO.getEsMasVendido());
        producto.setIndex(productoDTO.getIndex());
        return producto;
    }
}
