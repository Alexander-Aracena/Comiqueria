package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.CarouselRequestDTO;
import com.minpay.Comiqueria.model.Carrusel;
import com.minpay.Comiqueria.service.interfaces.ICarouselService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private ICarouselService carouselService;
    
    @GetMapping("/{id}")
    public Carrusel traerCarousel(@PathVariable Long id){
        return this.carouselService.getCarousel(id);
    }
    
    @GetMapping
    public List<Carrusel> traerCarouseles(){
        return this.carouselService.getCarouseles();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrusel guardarCarousel(@RequestBody CarouselRequestDTO carouselDTO){
        return this.carouselService.createCarousel(carouselDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Carrusel editarCarousel(@PathVariable Long id, @RequestBody CarouselRequestDTO carouselDTO){
        return this.carouselService.editCarouselById(id, carouselDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCarousel(@PathVariable Long id){
        this.carouselService.deleteCarouselById(id);
    }
}
