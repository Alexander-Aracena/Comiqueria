package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.model.LineaVenta;
import java.util.List;
import org.springframework.stereotype.Service;
import com.minpay.Comiqueria.service.interfaces.ILineaVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import com.minpay.Comiqueria.repository.ILineaVentaRepository;

@Service
public class LineaVentaService implements ILineaVentaService {
    
    @Autowired
    private ILineaVentaRepository lineaVentaRepository;

    @Override
    public LineaVenta getLineaVenta(Long id) {
        return this.lineaVentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LineaVenta id: " + id + " no encontrado."));
    }

    @Override
    public List<LineaVenta> getLineasVentas() {
        return this.lineaVentaRepository.findAll();
    }

    @Override
    public LineaVenta createLineaVenta(LineaVentaRequestDTO lineaVentaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LineaVenta editLineaVentaById(Long id, LineaVentaRequestDTO lineaVentaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteLineaVentaById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
