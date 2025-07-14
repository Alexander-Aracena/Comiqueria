package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.VentaRequestDTO;
import com.minpay.Comiqueria.model.Venta;
import com.minpay.Comiqueria.service.interfaces.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService ventaService;
}
