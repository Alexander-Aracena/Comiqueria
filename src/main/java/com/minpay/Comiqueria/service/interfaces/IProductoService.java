package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.model.*;
import java.util.List;

public interface IProductoService {
    public Producto getProducto(Long id);
    public List<Producto> getProductos();
    public Producto createProducto(ProductoDTO productoDTO);
    public Producto editProductoById(Long id, ProductoDTO productoDTO);
    public void deleteProductoById(Long id);
}