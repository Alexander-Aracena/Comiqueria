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
    private Long idCliente;

    public DomicilioDTO(Long id, String calle, String altura, String departamento, String cp, Long idLocalidad, Long idCliente) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
        this.departamento = departamento;
        this.cp = cp;
        this.idLocalidad = idLocalidad;
        this.idCliente = idCliente;
    }

    public DomicilioDTO(String calle, String altura, String departamento, String cp, Long idLocalidad, Long idCliente) {
        this.calle = calle;
        this.altura = altura;
        this.departamento = departamento;
        this.cp = cp;
        this.idLocalidad = idLocalidad;
        this.idCliente = idCliente;
    }
}