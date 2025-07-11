package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.model.LineaVenta;
import java.util.List;

public interface ILineaVentaService {
    public LineaVenta getLineaVenta(Long id);
    public List<LineaVenta> getLineasVentas();
    public LineaVenta createLineaVenta(LineaVentaRequestDTO lineaVentaDTO);
    public LineaVenta editLineaVentaById(Long id, LineaVentaRequestDTO lineaVentaDTO);
    public void deleteLineaVentaById(Long id);
}
