package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.model.*;
import java.util.List;
import java.util.Set;

public interface IProductoService {
    public Producto getProducto(Long id);
    public ProductoDTO getProductoDTO(Producto producto);
    public List<Producto> getProductos();
    public List<Producto> getProductos(Set<Long> idsProductos);
    public List<ProductoDTO> getProductosDTO();
    public List<ProductoDTO> getProductosDTO(Set<Long> idsProductos);
    public ProductoDTO createProducto(ProductoDTO productoDTO);
    public ProductoDTO editProductoById(Long id, ProductoDTO productoDTO);
    public void deleteProductoById(Long id);
}