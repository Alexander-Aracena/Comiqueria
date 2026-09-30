package com.minpay.Comiqueria.dto.response;

import java.time.LocalDate;

public record AutorResponseDTO(
    Long id,
    String nombre,
    String apellido,
    LocalDate fechaAlta,
    LocalDate fechaBaja
) {}