package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.CarouselRequestDTO;
import com.minpay.Comiqueria.model.Carrusel;
import java.util.List;

public interface ICarouselService {
    public Carrusel getCarousel(Long id);
    public List<Carrusel> getCarouseles();
    public Carrusel createCarousel(CarouselRequestDTO carouselDTO);
    public Carrusel editCarouselById(Long id, CarouselRequestDTO carouselDTO);
    public void deleteCarouselById(Long id);
}
