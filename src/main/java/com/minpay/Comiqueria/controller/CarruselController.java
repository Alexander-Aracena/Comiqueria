package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.CarruselRequestDTO;
import com.minpay.Comiqueria.model.Carrusel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.minpay.Comiqueria.service.interfaces.ICarruselService;

@RestController
@RequestMapping("/carousel")
public class CarruselController {
    @Autowired
    private ICarruselService carouselService;
    
    @GetMapping("/{id}")
    public Carrusel traerCarrusel(@PathVariable Long id){
        return this.carouselService.getCarrusel(id);
    }
    
    @GetMapping
    public List<Carrusel> traerCarruseles(){
        return this.carouselService.getCarruseles();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrusel guardarCarrusel(@RequestBody CarruselRequestDTO carouselDTO){
        return this.carouselService.createCarrusel(carouselDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Carrusel editarCarrusel(@PathVariable Long id, @RequestBody CarruselRequestDTO carouselDTO){
        return this.carouselService.editCarruselById(id, carouselDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCarrusel(@PathVariable Long id){
        this.carouselService.deleteCarruselById(id);
    }
}
