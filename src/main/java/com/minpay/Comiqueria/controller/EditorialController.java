package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.model.Editorial;
import com.minpay.Comiqueria.service.interfaces.IEditorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    @Autowired
    private IEditorialService editorialService;
    
    @GetMapping("/{id}")
    public Editorial traerEditorial(@PathVariable Long id){
        return this.editorialService.getEditorial(id);
    }
    
    @GetMapping
    public List<Editorial> traerEditoriales(){
        return this.editorialService.getEditoriales();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Editorial guardarEditorial(@RequestBody String nombre){
        return this.editorialService.createEditorial(nombre);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Editorial editarEditorial(@PathVariable Long id, @RequestBody String nombre){
        return this.editorialService.editEditorialById(id, nombre);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarEditorial(@PathVariable Long id){
        this.editorialService.deleteEditorialById(id);
    }
}
