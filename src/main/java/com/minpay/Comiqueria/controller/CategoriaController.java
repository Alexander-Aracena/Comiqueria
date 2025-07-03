package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.model.Categoria;
import com.minpay.Comiqueria.service.interfaces.ICategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;
    
    @GetMapping("/{id}")
    public Categoria traerCategoria(@PathVariable Long id){
        return this.categoriaService.getCategoria(id);
    }
    
    @GetMapping
    public List<Categoria> traerCategorias(){
        return this.categoriaService.getCategorias();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria guardarCategoria(@RequestBody String nombre){
        return this.categoriaService.createCategoria(nombre);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Categoria editarCategoria(
            @PathVariable Long id,
            @RequestBody String nombre){
        return this.categoriaService.editCategoriaById(id, nombre);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCategoria(@PathVariable Long id){
        this.categoriaService.deleteCategoriaById(id);
    }
    
    /*
    @PostMapping("/subcategorias/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarSubcategorias(
            @PathVariable Long id,
            @RequestBody Set<Long> idsSubcategorias
    ){
        this.categoriaService.addSubcategories(id, idsSubcategorias);
    }
    
    @DeleteMapping("/subcategorias/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarSubcategorias(
            @PathVariable Long id,
            @RequestBody Set<Long> idsSubcategorias
    ){
        this.categoriaService.deleteSubcategories(id, idsSubcategorias);
    }
    */
}