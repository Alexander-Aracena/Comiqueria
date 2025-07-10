package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.CarouselRequestDTO;
import com.minpay.Comiqueria.model.Carrusel;
import org.springframework.stereotype.Component;

@Component
public class CarouselDTOToCarousel implements IMapper<CarouselRequestDTO, Carrusel> {
    @Override
    public Carrusel map(CarouselRequestDTO carouselDTO) {
        return new Carrusel(
                carouselDTO.getSubtitulo(),
                carouselDTO.getTexto(),
                carouselDTO.getImagen()
        );
    }

    @Override
    public Carrusel map(CarouselRequestDTO carouselDTO, Carrusel carousel) {
        carousel.setSubtitulo(carouselDTO.getSubtitulo());
        carousel.setTexto(carouselDTO.getTexto());
        carousel.setImagen(carouselDTO.getImagen());
        return carousel;
    }
}
