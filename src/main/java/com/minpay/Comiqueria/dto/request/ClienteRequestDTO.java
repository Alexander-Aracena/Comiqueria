package com.minpay.Comiqueria.dto.request;

import com.minpay.Comiqueria.model.Sexo;
import com.minpay.Comiqueria.model.TipoDoc;
import com.minpay.Comiqueria.validation.ValidationGroups;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ClienteRequestDTO(
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede exceder los 30 caracteres")
    String nombre,

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 30, message = "El apellido no puede exceder los 30 caracteres")
    String apellido,

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    LocalDate fechaNac,

    @NotNull(message = "El sexo no puede ser nulo")
    Sexo sexo,

    @NotBlank(message = "El número de documento no puede estar vacío")
    @Size(max = 20, message = "El número de documento no puede exceder los 20 caracteres")
    String nroDocumento,

    @NotNull(message = "El tipo de documento no puede ser nulo")
    TipoDoc tipoDoc,

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 20, message = "El teléfono no puede exceder los 20 caracteres")
    String telefono,

    @NotNull(
        message = "El ID de usuario asociado no puede ser nulo",
        groups = {ValidationGroups.OnCreate.class}
    )
    Long idUsuario
) {}