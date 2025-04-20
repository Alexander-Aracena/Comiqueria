package com.minpay.Comiqueria.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomicilioDTO {
    private Long id;
    private String calle;
    private String altura;
    private String departamento;
    private String cp;
    private Long idLocalidad;

    public DomicilioDTO(Long id, String calle, String altura, String departamento, String cp, Long idLocalidad) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
        this.departamento = departamento;
        this.cp = cp;
        this.idLocalidad = idLocalidad;
    }

    public DomicilioDTO(String calle, String altura, String departamento, String cp, Long idLocalidad) {
        this.calle = calle;
        this.altura = altura;
        this.departamento = departamento;
        this.cp = cp;
        this.idLocalidad = idLocalidad;
    }
}