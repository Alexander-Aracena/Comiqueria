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
    public Producto traerProducto(@PathVariable Long id){
        return this.productoService.getProducto(id);
    }
    
    @GetMapping
    public List<Producto> traerProductos(){
        return this.productoService.getProductos();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardarProducto(@RequestBody ProductoDTO productoDTO){
        return this.productoService.createProducto(productoDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Producto editarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return this.productoService.editProductoById(id, productoDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProducto(@PathVariable Long id){
        this.productoService.deleteProductoById(id);
    }
}
