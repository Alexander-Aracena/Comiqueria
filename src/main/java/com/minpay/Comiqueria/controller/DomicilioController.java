package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.DomicilioRequestDTO;
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
    public DomicilioRequestDTO traerDomicilio(@PathVariable Long id) {
        Domicilio domicilio = this.domicilioService.getDomicilio(id);
        return this.domicilioService.getDomicilioDTO(domicilio);
    }

    @GetMapping
    public List<DomicilioRequestDTO> traerDomicilios() {
        return this.domicilioService.getDomiciliosDTO();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DomicilioRequestDTO guardarDomicilio(@RequestBody DomicilioRequestDTO domicilioDTO) {
        return this.domicilioService.createDomicilio(domicilioDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DomicilioRequestDTO editarDomicilio(@PathVariable Long id, @RequestBody DomicilioRequestDTO domicilioDTO) {
        return this.domicilioService.editDomicilio(id, domicilioDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarDomicilio(@PathVariable Long id) {
        this.domicilioService.deleteDomicilio(id);
    }
}
