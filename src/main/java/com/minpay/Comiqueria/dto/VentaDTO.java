package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Cliente;
import com.minpay.Comiqueria.model.LineaVenta;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;

@Data
public class VentaDTO {
    private LocalDate fecha_venta;
    private Set<LineaVenta> lineas = new LinkedHashSet();
    private Cliente cliente;
    
    public Double getTotal(){
        Double total = 0d;
        
        for (LineaVenta linea : lineas) {
            total += (linea.getPrecio() * linea.getCantidad());
        }
        
        return total;
    }
}
