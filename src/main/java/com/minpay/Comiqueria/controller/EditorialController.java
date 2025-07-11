package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.EditorialRequestDTO;
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
    public EditorialRequestDTO traerEditorial(@PathVariable Long id){
        Editorial editorial = this.editorialService.getEditorial(id);
        return new EditorialRequestDTO();
    }
    
    @GetMapping
    public List<Editorial> traerEditoriales(){
        return this.editorialService.getEditoriales();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Editorial guardarEditorial(@RequestParam String nombre){
        return this.editorialService.createEditorial(nombre);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Editorial editarEditorial(@PathVariable Long id, @RequestParam String nombre){
        return this.editorialService.editEditorialById(id, nombre);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarEditorial(@PathVariable Long id){
        this.editorialService.deleteEditorialById(id);
    }
}
