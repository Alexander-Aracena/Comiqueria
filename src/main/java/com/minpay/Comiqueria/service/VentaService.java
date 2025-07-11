package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.VentaRequestDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.VentaDTOToVenta;
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
    
    @Autowired
    private VentaDTOToVenta mapper;
    
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
        Venta venta = this.mapper.map(ventaDTO);
        return this.ventaRepository.save(venta);
    }

    @Override
    public Venta editVentaById(Long id, VentaRequestDTO ventaDTO) {
        Venta venta = this.mapper.map(ventaDTO, this.getVenta(id));
        return this.ventaRepository.save(venta);
    }

    @Override
    public void deleteVentaById(Long id) {
        this.ventaRepository.deleteById(id);
    }
    
    @Override
    public List<Producto> getProductosVenta(Long id){
        List<Producto> listaProductos = new ArrayList<>();
        this.getVenta(id).getLineas().forEach(linea -> listaProductos.add(linea.getProducto()));
        return listaProductos;
    }
}
