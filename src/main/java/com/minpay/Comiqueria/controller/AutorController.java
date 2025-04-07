package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.AutorDTO;
import com.minpay.Comiqueria.dto.ProductosPorAutorDTO;
import com.minpay.Comiqueria.model.Autor;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.service.interfaces.IAutorService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private IAutorService autorService;
    
    @GetMapping("/{id}")
    public Autor traerAutor(@PathVariable Long id){
        return this.autorService.getAutor(id);
    }
    
    @GetMapping
    public List<Autor> traerAutores(){
        return this.autorService.getAutores();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor guardarAutor(@RequestBody AutorDTO autorDTO){
        return this.autorService.createAutor(autorDTO);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Autor editarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO){
        return this.autorService.editAutorById(id, autorDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarAutor(@PathVariable Long id){
        this.autorService.deleteAutorById(id);
    }
    
    @GetMapping("/productos/{idAutor}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductosPorAutorDTO traerProductos(@PathVariable Long idAutor){
        return this.autorService.getProductosSegunAutor(idAutor);
    }
    
    @PostMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarProductos(@PathVariable Long id, @RequestBody Set<Producto> productos){
        this.autorService.addProductos(id, productos);
    }
    
    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProductos(@PathVariable Long id, @RequestBody Set<Long> idsProductos){
        this.autorService.deleteProductos(id, idsProductos);
    }
}