package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.VentaDTO;
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
    
    @GetMapping("/{id}")
    public Venta traerVenta(@PathVariable Long id){
        return this.ventaService.getVenta(id);
    }
    
    @GetMapping
    public List<Venta> traerVentas(){
        return this.ventaService.getVentas();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venta guardarVenta(@RequestBody VentaDTO ventaDTO){
        return this.ventaService.createVenta(ventaDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Venta editarVenta(@PathVariable Long id, @RequestBody VentaDTO ventaDTO){
        return this.ventaService.editVentaById(id, ventaDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarVenta(@PathVariable Long id){
        this.ventaService.deleteVentaById(id);
    }
    
    
}
