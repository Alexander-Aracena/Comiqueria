package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
    @Email(message = "El formato del email no es válido")
    @NotBlank(message = "La dirección de correo electrónico no puede estar vacía")
    @Size(max = 100, message = "La dirección de correo electrónico debe tener {max} caracteres")
    String email,
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 30, message = "La contraseña debe tener entre 8 y 30 caracteres")
    String contrasenia
) {}