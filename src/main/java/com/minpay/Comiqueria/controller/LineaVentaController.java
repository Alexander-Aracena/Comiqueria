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
    
    @GetMapping("/{id}")
    public LineaVenta traerLineaVenta(@PathVariable Long id){
        return this.lineaVentaService.getLineaVenta(id);
    }
    
    @GetMapping
    public List<LineaVenta> traerLineasVentas(){
        return this.lineaVentaService.getLineasVentas();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LineaVenta guardarLineaVenta(@RequestBody LineaVentaRequestDTO lineaVentaDTO){
        return this.lineaVentaService.createLineaVenta(lineaVentaDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LineaVenta editarLineaVenta(@PathVariable Long id, @RequestBody LineaVentaRequestDTO lineaVentaDTO){
        return this.lineaVentaService.editLineaVentaById(id, lineaVentaDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarLineaVenta(@PathVariable Long id){
        this.lineaVentaService.deleteLineaVentaById(id);
    }
}
