package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.VentaDTO;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.model.Venta;
import java.util.List;

public interface IVentaService {
    public Venta getVenta(Long id);
    public List<Venta> getVentas();
    public Venta createVenta(VentaDTO ventaDTO);
    public Venta editVentaById(Long id, VentaDTO ventaDTO);
    public void deleteVentaById(Long id);
    public List<Producto> getProductosVenta(Long id);
}
