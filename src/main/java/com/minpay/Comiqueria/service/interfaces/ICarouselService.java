package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.CarouselDTO;
import com.minpay.Comiqueria.model.Carousel;
import java.util.List;

public interface ICarouselService {
    public Carousel getCarousel(Long id);
    public List<Carousel> getCarouseles();
    public Carousel createCarousel(CarouselDTO carouselDTO);
    public Carousel editCarouselById(Long id, CarouselDTO carouselDTO);
    public void deleteCarouselById(Long id);
}
