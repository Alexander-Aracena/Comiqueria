package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.DomicilioDTO;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.service.interfaces.IDomicilioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private IDomicilioService domicilioService;

    @GetMapping("/{id}")
    public Domicilio traerDomicilio(@PathVariable Long id) {
        return this.domicilioService.getDomicilio(id);
    }

    @GetMapping
    public List<Domicilio> traerDomicilios() {
        return this.domicilioService.getDomicilios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Domicilio guardarDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        return this.domicilioService.createDomicilio(domicilioDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Domicilio editarDomicilio(@PathVariable Long id, @RequestBody DomicilioDTO domicilioDTO) {
        return this.domicilioService.editDomicilioById(id, domicilioDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarDomicilio(@PathVariable Long id) {
        this.domicilioService.deleteDomicilioById(id);
    }
}
