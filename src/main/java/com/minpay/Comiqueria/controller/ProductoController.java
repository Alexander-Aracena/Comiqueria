package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ProductoRequestDTO;
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
    public ProductoRequestDTO traerProducto(@PathVariable Long id){
        Producto producto = this.productoService.getProducto(id);
        return this.productoService.getProductoDTO(producto);
    }
    
    @GetMapping
    public List<ProductoRequestDTO> traerProductos(){
        return this.productoService.getProductosDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoRequestDTO guardarProducto(@RequestBody ProductoRequestDTO productoDTO){
        return this.productoService.createProducto(productoDTO);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductoRequestDTO editarProducto(@PathVariable Long id, @RequestBody ProductoRequestDTO productoDTO){
        return this.productoService.editProductoById(id, productoDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProducto(@PathVariable Long id){
        this.productoService.deleteProducto(id);
    }
}
