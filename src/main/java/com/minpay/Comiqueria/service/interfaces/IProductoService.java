package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ProductoRequestDTO;
import com.minpay.Comiqueria.model.*;
import java.util.List;
import java.util.Set;

public interface IProductoService {
    public Producto getProducto(Long id);
    public ProductoRequestDTO getProductoDTO(Producto producto);
    public List<Producto> getProductos();
    public List<Producto> getProductos(Set<Long> idsProductos);
    public List<ProductoRequestDTO> getProductosDTO();
    public List<ProductoRequestDTO> getProductosDTO(Set<Long> idsProductos);
    public List<ProductoRequestDTO> traerListaDTO(List<Producto> domicilios);
    public ProductoRequestDTO createProducto(ProductoRequestDTO productoDTO);
    public ProductoRequestDTO editProductoById(Long id, ProductoRequestDTO productoDTO);
    public void saveProducto(Producto producto);
    public void deleteProducto(Long id);
    public void saveProductos(Set<Producto> productos);
    public void deleteProductos(Set<Long> idsProductos);
}