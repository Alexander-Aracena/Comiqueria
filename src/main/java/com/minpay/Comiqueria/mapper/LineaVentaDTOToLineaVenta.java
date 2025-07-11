package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.model.LineaVenta;
import org.springframework.stereotype.Component;

@Component
public class LineaVentaDTOToLineaVenta implements IMapper<LineaVentaRequestDTO, LineaVenta> {
    @Override
    public LineaVenta map(LineaVentaRequestDTO lineaVentaDTO) {
        return new LineaVenta(
                lineaVentaDTO.getProducto(),
                lineaVentaDTO.getCantidad(),
                lineaVentaDTO.getPrecio()
        );
    }

    @Override
    public LineaVenta map(LineaVentaRequestDTO lineaVentaDTO, LineaVenta lineaVenta) {
        lineaVenta.setProducto(lineaVentaDTO.getProducto());
        lineaVenta.setCantidad(lineaVentaDTO.getCantidad());
        lineaVenta.setPrecio(lineaVentaDTO.getPrecio());
        return lineaVenta;
    }
}
