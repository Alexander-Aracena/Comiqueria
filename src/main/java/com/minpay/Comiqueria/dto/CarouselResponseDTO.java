package com.minpay.Comiqueria.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CarouselResponseDTO {
    private Long id;
    private String subtitulo;
    private String texto;
    private String imagen;
    private Boolean estaVigente;
}
