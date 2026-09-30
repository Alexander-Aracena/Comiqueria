package com.minpay.Comiqueria.dto.response;

import java.time.LocalDate;

public record LocalidadResponseDTO(
    Long id,
    String nombre,
    LocalDate fechaAlta,
    LocalDate fechaBaja,
    DepartamentoBasicoDTO departamento
) {
    public static record DepartamentoBasicoDTO(
        Long id,
        String nombre,
        ProvinciaBasicaDTO provincia
    ) {}
    
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