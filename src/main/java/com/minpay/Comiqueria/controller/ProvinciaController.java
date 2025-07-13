package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ProvinciaRequestDTO;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.service.interfaces.IProvinciaService;
import com.minpay.Comiqueria.utils.Accion;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {
    
    @Autowired
    private IProvinciaService provinciaService;
}
