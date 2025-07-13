package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.model.LineaVenta;
import com.minpay.Comiqueria.service.interfaces.ILineaVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lineasVentas")
public class LineaVentaController {
    @Autowired
    private ILineaVentaService lineaVentaService;
}
