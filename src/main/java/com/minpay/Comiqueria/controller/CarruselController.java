package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.CarruselRequestDTO;
import com.minpay.Comiqueria.model.Carrusel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.minpay.Comiqueria.service.interfaces.ICarruselService;

@RestController
@RequestMapping("/carousel")
public class CarruselController {
    @Autowired
    private ICarruselService carruselService;
}
