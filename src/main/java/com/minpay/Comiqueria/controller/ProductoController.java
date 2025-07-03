package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ProductoDTO;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.service.interfaces.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/{id}")
    public ProductoDTO traerProducto(@PathVariable Long id){
        Producto producto = this.productoService.getProducto(id);
        return this.productoService.getProductoDTO(producto);
    }
    
    @GetMapping
    public List<ProductoDTO> traerProductos(){
        return this.productoService.getProductosDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDTO guardarProducto(@RequestBody ProductoDTO productoDTO){
        return this.productoService.createProducto(productoDTO);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductoDTO editarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return this.productoService.editProductoById(id, productoDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProducto(@PathVariable Long id){
        this.productoService.deleteProducto(id);
    }
}
