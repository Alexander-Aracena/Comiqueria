package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.SubcategoriaRequestDTO;
import com.minpay.Comiqueria.service.interfaces.ISubcategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {
    @Autowired
    private ISubcategoriaService subcategoriaService;
}
