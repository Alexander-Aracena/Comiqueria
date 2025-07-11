package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.LineaVentaDTOToLineaVenta;
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
    
    @Autowired
    private LineaVentaDTOToLineaVenta mapper;

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
        LineaVenta lineaVenta = this.mapper.map(lineaVentaDTO);
        return this.lineaVentaRepository.save(lineaVenta);
    }

    @Override
    public LineaVenta editLineaVentaById(Long idLinea, LineaVentaRequestDTO lineaVentaDTO) {
        LineaVenta lineaVenta = this.mapper.map(lineaVentaDTO, this.getLineaVenta(idLinea));
        return this.lineaVentaRepository.save(lineaVenta);
    }

    @Override
    public void deleteLineaVentaById(Long id) {
        this.lineaVentaRepository.deleteById(id);
    }
}
