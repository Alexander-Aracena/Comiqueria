package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PaisRequestDTO(
    @NotBlank(message = "El nombre del país no puede estar vacío")
    @Size(max = 30, message = "El nombre del país no puede exceder los 30 caracteres")
    String nombre
) {}