package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ProvinciaRequestDTO;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.service.interfaces.IProvinciaLocalidadSyncService;
import com.minpay.Comiqueria.service.interfaces.IProvinciaService;
import com.minpay.Comiqueria.utils.Accion;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {
    
    @Autowired
    private IProvinciaService provinciaService;
    
    @Autowired
    private IProvinciaLocalidadSyncService provinciaLocalidadSyncService;
    
    @GetMapping("/{id}")
    public ProvinciaRequestDTO traerProvincia(@PathVariable Long id){
        Provincia provincia = this.provinciaService.getProvincia(id);
        return this.provinciaService.getProvinciaDTO(provincia);
    }
    
    @GetMapping
    public List<ProvinciaRequestDTO> traerProvincias(){
        return this.provinciaService.getProvinciasDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProvinciaRequestDTO guardarProvincia(@RequestParam String nombre, @RequestParam Long idPais){
        return this.provinciaService.createProvincia(nombre, idPais);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProvinciaRequestDTO editarProvincia(
        @PathVariable Long id,
        @RequestParam String nombre,
        @RequestParam Long idPais,
        @RequestParam Set<Long> idLocalidades
    ){
        return this.provinciaService.editProvinciaById(id, nombre, idPais, idLocalidades);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarProvincia(@PathVariable Long id){
        this.provinciaService.deleteProvinciaById(id);
    }
    
    @PostMapping("/localidades/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarLocalidades(@PathVariable Long id, @RequestParam Set<Long> idsLocalidades){
        this.provinciaLocalidadSyncService.modificarLocalidades(id, idsLocalidades, Accion.AGREGAR);
    }
    
    @DeleteMapping("/localidades/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarLocalidades(@PathVariable Long id, @RequestParam Set<Long> idsLocalidades){
        this.provinciaLocalidadSyncService.modificarLocalidades(id, idsLocalidades, Accion.ELIMINAR);
    }
}
