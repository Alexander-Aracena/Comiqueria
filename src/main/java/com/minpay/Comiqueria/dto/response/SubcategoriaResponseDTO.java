package com.minpay.Comiqueria.dto.response;

import java.time.LocalDateTime;

public record SubcategoriaResponseDTO(
    Long id,
    String nombre,
    LocalDateTime fechaAlta,
    LocalDateTime fechaBaja,
    CategoriaBasicaDTO categoria
) {
    public static record CategoriaBasicaDTO(
        Long id,
        String nombre
    ) {}
}