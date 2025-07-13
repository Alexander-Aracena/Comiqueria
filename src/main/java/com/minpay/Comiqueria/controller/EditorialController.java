package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.EditorialRequestDTO;
import com.minpay.Comiqueria.model.Editorial;
import com.minpay.Comiqueria.service.interfaces.IEditorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    @Autowired
    private IEditorialService editorialService;
}
