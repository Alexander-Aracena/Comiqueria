package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.model.Categoria;
import com.minpay.Comiqueria.service.interfaces.ICategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;
}