package com.minpay.Comiqueria.dto;

import lombok.Data;

@Data
public class LocalidadDTO {
    private Long id;
    private String nombre;

    public LocalidadDTO(String nombre) {
        this.nombre = nombre;
    }

    public LocalidadDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
