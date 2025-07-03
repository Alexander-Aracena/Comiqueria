package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.SubcategoriaDTO;
import com.minpay.Comiqueria.service.interfaces.ISubcategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {
    @Autowired
    private ISubcategoriaService subcategoriaService;
    
    @GetMapping("/{id}")
    public SubcategoriaDTO traerSubcategoria(@PathVariable Long id){
        return this.subcategoriaService.getSubcategoriaDTO(id);
    }
    
    @GetMapping
    public List<SubcategoriaDTO> traerSubcategorias(){
        return this.subcategoriaService.getSubcategoriasDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubcategoriaDTO guardarSubcategoria(
            @RequestParam String nombreSubcategoria,
            @RequestParam Long idCategoria
    ){
        return this.subcategoriaService.createSubcategoria(nombreSubcategoria, idCategoria);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SubcategoriaDTO editarSubcategoria(
            @PathVariable Long id,
            @RequestParam String nombreSubcategoria,
            @RequestParam Long idCategoria
    ){
        return this.subcategoriaService.editSubcategoriaById(id, nombreSubcategoria, idCategoria);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarSubcategoria(@PathVariable Long id){
        this.subcategoriaService.deleteSubcategoriaById(id);
    }
}
