package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.PaisRequestDTO;
import com.minpay.Comiqueria.model.Pais;
import com.minpay.Comiqueria.service.interfaces.IPaisService;
import com.minpay.Comiqueria.utils.Accion;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
public class PaisController {
    
    @Autowired
    private IPaisService paisService;
}
