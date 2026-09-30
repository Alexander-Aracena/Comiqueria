package com.minpay.Comiqueria.dto.response;

import java.time.LocalDate;
import java.util.Set;

public record CategoriaResponseDTO(
    Long id,
    String nombre,
    LocalDate fechaAlta,
    LocalDate fechaBaja,
    Set<SubcategoriaResponseDTO> subcategorias
) {}