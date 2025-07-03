package com.minpay.Comiqueria.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private String nombre;
    private String apellido;
    private LocalDate fechaAlta = LocalDate.now();
    private LocalDate fechaBaja;

    public AutorDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
