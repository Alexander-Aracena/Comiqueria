package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartamentoRequestDTO(
    @NotBlank(message = "El nombre del departamento no puede estar vacío")
    @Size(max = 50, message = "El nombre del departamento no puede exceder los 50 caracteres")
    String nombre,

    @NotNull(message = "El ID de la provincia padre no puede ser nulo")
    Long idProvincia
) {}