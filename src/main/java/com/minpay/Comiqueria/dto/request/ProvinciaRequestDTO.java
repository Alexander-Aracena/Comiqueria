package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProvinciaRequestDTO(
    @NotBlank(message = "El nombre de la provincia no puede estar vacío")
    @Size(max = 30, message = "El nombre de la provincia no puede exceder los 30 caracteres")
    String nombre,

    @NotNull(message = "El ID del país padre no puede ser nulo")
    Long idPais
) {}