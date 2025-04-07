package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Localidad;
import lombok.Data;

@Data
public class DomicilioDTO {
    private String calle;
    private String altura;
    private String departamento;
    private String cp;
    private Localidad localidad;
}
