package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.VentaDTO;
import com.minpay.Comiqueria.model.Venta;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class VentaDTOToVenta implements IMapper<VentaDTO, Venta> {    
    @Override
    public Venta map(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(ventaDTO.getTotal());
        venta.setLineas(ventaDTO.getLineas());
        venta.setCliente(ventaDTO.getCliente());
        
        return venta;
    }

    @Override
    public Venta map(VentaDTO ventaDTO, Venta venta) {
        venta.setFecha_venta(ventaDTO.getFecha_venta());
        venta.setLineas(ventaDTO.getLineas());
        venta.setCliente(ventaDTO.getCliente());
        return venta;
    }
}
