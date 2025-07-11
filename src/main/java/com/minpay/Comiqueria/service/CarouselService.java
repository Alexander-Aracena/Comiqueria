package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.CarouselRequestDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.CarouselDTOToCarousel;
import com.minpay.Comiqueria.service.interfaces.ICarouselService;
import com.minpay.Comiqueria.model.Carrusel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minpay.Comiqueria.repository.ICarruselRepository;

@Service
public class CarouselService implements ICarouselService {
    
    @Autowired
    private ICarruselRepository carouselRepository;
    
    @Autowired
    private CarouselDTOToCarousel mapper;
    
    @Override
    public Carrusel getCarousel(Long id) {
        return this.carouselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carousel id: " + id + " no encontrado."));
    }

    @Override
    public List<Carrusel> getCarouseles() {
        return this.carouselRepository.findAll();
    }

    @Override
    public Carrusel createCarousel(CarouselRequestDTO carouselDTO) {
        Carrusel carousel = this.mapper.map(carouselDTO);
        return this.carouselRepository.save(carousel);
    }

    @Override
    public Carrusel editCarouselById(Long id, CarouselRequestDTO carouselDTO) {
        Carrusel carousel = this.mapper.map(carouselDTO, this.getCarousel(id));
        return this.carouselRepository.save(carousel);
    }

    @Override
    public void deleteCarouselById(Long id) {
        this.carouselRepository.deleteById(id);
    }
}
