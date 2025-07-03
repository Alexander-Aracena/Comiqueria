package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.CarouselDTO;
import com.minpay.Comiqueria.model.Carousel;
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
    public Carousel traerCarousel(@PathVariable Long id){
        return this.carouselService.getCarousel(id);
    }
    
    @GetMapping
    public List<Carousel> traerCarouseles(){
        return this.carouselService.getCarouseles();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carousel guardarCarousel(@RequestBody CarouselDTO carouselDTO){
        return this.carouselService.createCarousel(carouselDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Carousel editarCarousel(@PathVariable Long id, @RequestBody CarouselDTO carouselDTO){
        return this.carouselService.editCarouselById(id, carouselDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCarousel(@PathVariable Long id){
        this.carouselService.deleteCarouselById(id);
    }
}
