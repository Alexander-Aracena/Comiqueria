package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AutorRequestDTO(
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede exceder los 30 caracteres")
    String nombre,

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 30, message = "El apellido no puede exceder los 30 caracteres")
    String apellido
) {}