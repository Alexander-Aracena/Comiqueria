package com.minpay.Comiqueria.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AutorDTO {
    private String nombre;
    private String apellido;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;

    public AutorDTO() {
    }

    public AutorDTO(String nombre, String apellido, LocalDate fechaAlta, LocalDate fechaBaja) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }
}
