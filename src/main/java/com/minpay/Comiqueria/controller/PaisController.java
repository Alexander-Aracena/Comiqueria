package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.PaisDTO;
import com.minpay.Comiqueria.model.Pais;
import com.minpay.Comiqueria.service.interfaces.IPaisProvinciaSyncService;
import com.minpay.Comiqueria.service.interfaces.IPaisService;
import com.minpay.Comiqueria.utils.Accion;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
public class PaisController {
    
    @Autowired
    private IPaisService paisService;
    
    @Autowired
    private IPaisProvinciaSyncService paisProvinciaSyncService;
    
    @GetMapping("/{id}")
    public PaisDTO traerPais(@PathVariable Long id){
        Pais pais = this.paisService.getPais(id);
        return this.paisService.getPaisDTO(pais);
    }
    
    @GetMapping
    public List<PaisDTO> traerPaises(){
        return this.paisService.getPaisesDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaisDTO guardarPais(@RequestParam String nombre){
        return this.paisService.createPais(nombre);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PaisDTO editarPais(
        @PathVariable Long id,
        @RequestBody PaisDTO paisDTO
    ){
        return this.paisService.editPaisById(id, paisDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarPais(@PathVariable Long id){
        this.paisService.deletePaisById(id);
    }
    
    @PutMapping("/provincias/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarProvincias(@PathVariable Long id, @RequestParam Set<Long> idsProvincias){
        this.paisProvinciaSyncService.modificarProvincias(id, idsProvincias, Accion.AGREGAR);
    }
    
    @DeleteMapping("/provincias/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProvincias(@PathVariable Long id, @RequestParam Set<Long> idsProvincias){
        this.paisProvinciaSyncService.modificarProvincias(id, idsProvincias, Accion.ELIMINAR);
    }
}
