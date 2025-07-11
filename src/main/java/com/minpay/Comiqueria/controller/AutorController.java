package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.AutorResponseDTO;
import com.minpay.Comiqueria.model.Autor;
import com.minpay.Comiqueria.service.interfaces.IAutorService;
import java.util.ArrayList;
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
        return new Autor();
    }
    
    @GetMapping
    public List<Autor> traerAutores(){
        return new ArrayList<>();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor guardarAutor(@RequestBody AutorResponseDTO autorDTO){
        return new Autor();
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Autor editarAutor(@PathVariable Long id, @RequestBody AutorResponseDTO autorDTO){
        return new Autor();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarAutor(@PathVariable Long id){
        this.autorService.deleteAutorById(id);
    }
    
    @PostMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarProductos(@PathVariable Long id, @RequestBody Set<Long> idsProductos){
        this.autorService.addProductos(id, idsProductos);
    }
    
    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProductos(@PathVariable Long id, @RequestBody Set<Long> idsProductos){
        this.autorService.deleteProductos(id, idsProductos);
    }
}