package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.VentaRequestDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.model.Venta;
import com.minpay.Comiqueria.repository.IVentaRepository;
import com.minpay.Comiqueria.service.interfaces.IVentaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepository;
    
    @Override
    public Venta getVenta(Long id){
        return this.ventaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta id: " + id + " no encontrado."));
    }

    @Override
    public List<Venta> getVentas() {
        return this.ventaRepository.findAll();
    }

    @Override
    public Venta createVenta(VentaRequestDTO ventaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta editVentaById(Long id, VentaRequestDTO ventaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteVentaById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> getProductosVenta(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
