package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.LocalidadRequestDTO;
import com.minpay.Comiqueria.model.Localidad;
import com.minpay.Comiqueria.service.interfaces.ILocalidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {
    
    @Autowired
    private ILocalidadService localidadService;
    
    @GetMapping("/{id}")
    public LocalidadRequestDTO traerLocalidad(@PathVariable Long id){
        Localidad localidad = this.localidadService.getLocalidad(id);
        return this.localidadService.getLocalidadDTO(localidad);
    }
    
    @GetMapping
    public List<LocalidadRequestDTO> traerLocalidades(){
        return this.localidadService.getLocalidadesDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocalidadRequestDTO guardarLocalidad(@RequestParam String nombre, @RequestParam Long idProvincia){
        return this.localidadService.createLocalidad(nombre, idProvincia);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LocalidadRequestDTO editarLocalidad(
        @PathVariable Long id,
        @RequestParam String nombre,
        @RequestParam Long idProvincia
    ){
        return this.localidadService.editLocalidadById(id, nombre, idProvincia);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarLocalidad(@PathVariable Long id){
        this.localidadService.deleteLocalidadById(id);
    }
}
