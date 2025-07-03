package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.CarouselDTO;
import com.minpay.Comiqueria.model.Carousel;
import org.springframework.stereotype.Component;

@Component
public class CarouselDTOToCarousel implements IMapper<CarouselDTO, Carousel> {
    @Override
    public Carousel map(CarouselDTO carouselDTO) {
        return new Carousel(
                carouselDTO.getSubtitulo(),
                carouselDTO.getTexto(),
                carouselDTO.getImagen()
        );
    }

    @Override
    public Carousel map(CarouselDTO carouselDTO, Carousel carousel) {
        carousel.setSubtitulo(carouselDTO.getSubtitulo());
        carousel.setTexto(carouselDTO.getTexto());
        carousel.setImagen(carouselDTO.getImagen());
        return carousel;
    }
}
