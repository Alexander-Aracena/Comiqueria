package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.CarouselDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.CarouselDTOToCarousel;
import com.minpay.Comiqueria.service.interfaces.ICarouselService;
import com.minpay.Comiqueria.model.Carousel;
import com.minpay.Comiqueria.repository.ICarouselRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarouselService implements ICarouselService {
    
    @Autowired
    private ICarouselRepository carouselRepository;
    
    @Autowired
    private CarouselDTOToCarousel mapper;
    
    @Override
    public Carousel getCarousel(Long id) {
        return this.carouselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carousel id: " + id + " no encontrado."));
    }

    @Override
    public List<Carousel> getCarouseles() {
        return this.carouselRepository.findAll();
    }

    @Override
    public Carousel createCarousel(CarouselDTO carouselDTO) {
        Carousel carousel = this.mapper.map(carouselDTO);
        return this.carouselRepository.save(carousel);
    }

    @Override
    public Carousel editCarouselById(Long id, CarouselDTO carouselDTO) {
        Carousel carousel = this.mapper.map(carouselDTO, this.getCarousel(id));
        return this.carouselRepository.save(carousel);
    }

    @Override
    public void deleteCarouselById(Long id) {
        this.carouselRepository.deleteById(id);
    }
}
