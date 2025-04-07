package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.model.Sexo;
import com.minpay.Comiqueria.model.TipoDoc;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
public class ClienteDTO {
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Sexo sexo;
    private String nroDoc;
    private TipoDoc tipoDoc;
    private Set<Domicilio> domicilios;
    private String telefono;
}
