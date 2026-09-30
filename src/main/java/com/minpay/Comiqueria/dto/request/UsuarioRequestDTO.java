package com.minpay.Comiqueria.dto.request;

import com.minpay.Comiqueria.model.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
   @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    @Size(max = 100, message = "El email no puede exceder los 100 caracteres")
    String email,

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 15, message = "La contraseña debe tener entre 8 y 15 caracteres")
    String password,

    Rol rol 
) {}