package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.ProductoDTOToProducto;
import com.minpay.Comiqueria.service.interfaces.IProductoService;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Autowired
    private ProductoDTOToProducto mapper;

    @Override
    public Producto getProducto(Long id) {
        return this.productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto id: " + id + " no encontrado."));
    }

    @Override
    public List<Producto> getProductos() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto createProducto(ProductoDTO productoDTO) {
        Producto producto = this.mapper.map(productoDTO);
        return this.productoRepository.save(producto);
    }

    @Override
    public Producto editProductoById(Long id, ProductoDTO productoDTO) {
        Producto producto = this.mapper.map(productoDTO, this.getProducto(id));
        return this.productoRepository.save(producto);
    }

    @Override
    public void deleteProductoById(Long id) {
        this.productoRepository.deleteById(id);
    }
}