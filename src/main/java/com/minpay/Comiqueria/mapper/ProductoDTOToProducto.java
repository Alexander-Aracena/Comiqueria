package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoDTOToProducto implements IMapper<ProductoDTO, Producto> {
    @Override
    public Producto map(ProductoDTO productoDTO) {
        return new Producto(
                productoDTO.getTitulo(),
                productoDTO.getPrecio(),
                productoDTO.getDescripcion(),
                productoDTO.getTapa(),
                productoDTO.getIsbn(),
                productoDTO.getPeso(),
                productoDTO.getDimensiones(),
                productoDTO.getPaginas(),
                productoDTO.getSubcategoria(),
                productoDTO.getEditorial(),
                productoDTO.getEsNovedad(),
                productoDTO.getEsOferta(),
                productoDTO.getEsMasVendido(),
                productoDTO.getIndex()
        );
    }

    @Override
    public Producto map(ProductoDTO productoDTO, Producto producto) {
        producto.setTitulo(productoDTO.getTitulo());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setTapa(productoDTO.getTapa());
        producto.setIsbn(productoDTO.getIsbn());
        producto.setPeso(productoDTO.getPeso());
        producto.setDimensiones(productoDTO.getDimensiones());
        producto.setPaginas(productoDTO.getPaginas());
        producto.setSubcategoria(productoDTO.getSubcategoria());
        producto.setEditorial(productoDTO.getEditorial());
        producto.setEsNovedad(productoDTO.getEsNovedad());
        producto.setEsOferta(productoDTO.getEsOferta());
        producto.setEsMasVendido(productoDTO.getEsMasVendido());
        producto.setIndex(productoDTO.getIndex());
        return producto;
    }
}
