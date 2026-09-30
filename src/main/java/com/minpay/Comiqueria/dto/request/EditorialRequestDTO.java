package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EditorialRequestDTO(
    @NotBlank(message = "El nombre de la editorial no puede estar vacío")
    @Size(max = 50, message = "El nombre de la editorial no puede exceder los 50 caracteres")
    String nombre
) {}