package com.minpay.Comiqueria.dto.response;

import java.time.LocalDate;

public record PaisResponseDTO(
    Long id,
    String nombre,
    LocalDate fechaAlta,
    LocalDate fechaBaja
) {}