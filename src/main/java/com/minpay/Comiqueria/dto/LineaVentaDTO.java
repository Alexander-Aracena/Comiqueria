package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Producto;
import lombok.Data;

@Data
public class LineaVentaDTO {
    private Producto producto;
    private int cantidad;
    private Double precio;
}
