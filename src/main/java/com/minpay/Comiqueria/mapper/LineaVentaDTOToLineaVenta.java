package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.LineaVentaDTO;
import com.minpay.Comiqueria.model.LineaVenta;
import org.springframework.stereotype.Component;

@Component
public class LineaVentaDTOToLineaVenta implements IMapper<LineaVentaDTO, LineaVenta> {
    @Override
    public LineaVenta map(LineaVentaDTO lineaVentaDTO) {
        return new LineaVenta(
                lineaVentaDTO.getProducto(),
                lineaVentaDTO.getCantidad(),
                lineaVentaDTO.getPrecio()
        );
    }

    @Override
    public LineaVenta map(LineaVentaDTO lineaVentaDTO, LineaVenta lineaVenta) {
        lineaVenta.setProducto(lineaVentaDTO.getProducto());
        lineaVenta.setCantidad(lineaVentaDTO.getCantidad());
        lineaVenta.setPrecio(lineaVentaDTO.getPrecio());
        return lineaVenta;
    }
}
