package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ProductoRequestDTO;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.service.interfaces.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
}
