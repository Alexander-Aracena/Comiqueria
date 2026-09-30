package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CarruselRequestDTO(
    @NotBlank(message = "El subtítulo no puede estar vacío")
    @Size(max = 100, message = "El subtítulo no puede exceder los 100 caracteres")
    String subtitulo,

    @NotBlank(message = "El texto no puede estar vacío")
    @Size(max = 255, message = "El texto no puede exceder los 255 caracteres")
    String texto,

    @NotBlank(message = "La URL de la imagen no puede estar vacía")
    String imagen,
    
    @NotBlank(message = "La URL del destino no puede estar vacío")
    String urlDestino
) {}