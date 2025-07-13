package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.LocalidadRequestDTO;
import com.minpay.Comiqueria.model.Localidad;
import com.minpay.Comiqueria.service.interfaces.ILocalidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {
    
    @Autowired
    private ILocalidadService localidadService;
}
