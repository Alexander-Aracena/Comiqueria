package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.DomicilioRequestDTO;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.service.interfaces.IDomicilioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private IDomicilioService domicilioService;
}
