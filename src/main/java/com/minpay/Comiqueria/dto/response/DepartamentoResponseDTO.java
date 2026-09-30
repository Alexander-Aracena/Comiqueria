package com.minpay.Comiqueria.dto.response;

import java.time.LocalDate;

public record DepartamentoResponseDTO(
    Long id,
    String nombre,
    LocalDate fechaAlta,
    LocalDate fechaBaja,
    ProvinciaBasicaDTO provincia
) {
    public static record ProvinciaBasicaDTO(
        Long id,
        String nombre,
        PaisBasicoDTO pais
    ) {}
    
    public static record PaisBasicoDTO(
        Long id,
        String nombre
    ) {}
}