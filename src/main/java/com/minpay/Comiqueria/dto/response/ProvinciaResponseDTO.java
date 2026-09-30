package com.minpay.Comiqueria.dto.response;

import com.minpay.Comiqueria.dto.response.DepartamentoResponseDTO;
import java.time.LocalDateTime;
import java.util.Set;

public record ProvinciaResponseDTO(
    Long id,
    String nombre,
    LocalDateTime fechaAlta,
    LocalDateTime fechaBaja,
    PaisBasicoDTO pais,
    Set<DepartamentoResponseDTO> departamentos
) {
    public static record PaisBasicoDTO(
        Long id,
        String nombre
    ) {}
}