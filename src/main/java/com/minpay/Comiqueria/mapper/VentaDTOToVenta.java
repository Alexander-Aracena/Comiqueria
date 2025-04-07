package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.VentaDTO;
import com.minpay.Comiqueria.model.Venta;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class VentaDTOToVenta implements IMapper<VentaDTO, Venta> {    
    @Override
    public Venta map(VentaDTO ventaDTO) {
        return new Venta(
                LocalDate.now(),
                ventaDTO.getTotal(),
                ventaDTO.getLineas(),
                ventaDTO.getCliente()
        );
    }

    @Override
    public Venta map(VentaDTO ventaDTO, Venta venta) {
        venta.setFecha_venta(ventaDTO.getFecha_venta());
        venta.setLineas(ventaDTO.getLineas());
        venta.setCliente(ventaDTO.getCliente());
        return venta;
    }
}
