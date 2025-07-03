package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.LineaVentaDTO;
import com.minpay.Comiqueria.model.LineaVenta;
import java.util.List;

public interface ILineaVentaService {
    public LineaVenta getLineaVenta(Long id);
    public List<LineaVenta> getLineasVentas();
    public LineaVenta createLineaVenta(LineaVentaDTO lineaVentaDTO);
    public LineaVenta editLineaVentaById(Long id, LineaVentaDTO lineaVentaDTO);
    public void deleteLineaVentaById(Long id);
}
