package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.dto.VentaRequestDTO;
import com.minpay.Comiqueria.dto.VentaResponseDTO;
import com.minpay.Comiqueria.exceptions.InvalidOperationException;
import com.minpay.Comiqueria.mapper.IVentaMapper;
import com.minpay.Comiqueria.model.Cliente;
import com.minpay.Comiqueria.model.EstadoVenta;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.model.Venta;
import com.minpay.Comiqueria.repository.IClienteRepository;
import com.minpay.Comiqueria.repository.IProductoRepository;
import com.minpay.Comiqueria.repository.IVentaRepository;
import com.minpay.Comiqueria.repository.specification.VentaSpecifications;
import com.minpay.Comiqueria.service.interfaces.IVentaService;
import com.minpay.Comiqueria.utils.Utils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IVentaMapper ventaMapper;

    @Autowired
    private IProductoRepository productoRepository;
    
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public VentaResponseDTO getVenta(Long id) {
        Venta venta = Utils.findByIdOrThrow(ventaRepository, id, Venta.class);
        return this.ventaMapper.toVentaResponseDTO(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VentaResponseDTO> getVentas(List<Long> ids, LocalDateTime minFechaVenta, LocalDateTime maxFechaVenta, BigDecimal minTotal, BigDecimal maxTotal, Long idCliente, EstadoVenta estado) {
        Specification<Venta> specs = VentaSpecifications.byCriterios(
            ids, minFechaVenta, maxFechaVenta, minTotal, maxTotal, idCliente, estado
        );
        List<Venta> ventas = this.ventaRepository.findAll(specs);
        return Utils.mapearListaA(ventas, this.ventaMapper::toVentaResponseDTO);
    }

    @Override
    public VentaResponseDTO createVenta(VentaRequestDTO ventaDTO) {
        Venta venta = this.ventaMapper.toVenta(ventaDTO);
        Cliente cliente = Utils.findByIdOrThrow(clienteRepository, ventaDTO.getIdCliente(), Cliente.class);
        BigDecimal totalVenta = this.calcularVenta(ventaDTO);
        venta.setTotal(totalVenta);
        if (!cliente.getEstaVigente()) {
            throw new InvalidOperationException(
                "El cliente no está vigente y no puede continuar la operación"
            );
        }
        venta.setCliente(cliente);
        venta.setEstado(EstadoVenta.PENDIENTE);
        venta = this.ventaRepository.save(venta);
        return this.ventaMapper.toVentaResponseDTO(venta);
    }

    @Override
    public VentaResponseDTO editVenta(Long id, VentaRequestDTO ventaDTO) {
        Venta ventaModificada = Utils.findByIdOrThrow(ventaRepository, id, Venta.class);
        if (ventaModificada.getEstado() != EstadoVenta.PENDIENTE) {
            throw new InvalidOperationException(
                "La venta ya fue procesada, por lo que no es posible modificarla"
            );
        }
        this.ventaMapper.updateVentaFromDTO(ventaDTO, ventaModificada);
        BigDecimal totalVenta = this.calcularVenta(ventaDTO);
        ventaModificada.setTotal(totalVenta);
        ventaModificada = this.ventaRepository.save(ventaModificada);
        return this.ventaMapper.toVentaResponseDTO(ventaModificada);
    }

    @Override
    public void deleteVenta(Long id) {
        Venta ventaEliminada = Utils.findByIdOrThrow(ventaRepository, id, Venta.class);
        ventaEliminada.setEstado(EstadoVenta.CANCELADA);
        this.ventaRepository.save(ventaEliminada);
    }

    private BigDecimal calcularVenta(VentaRequestDTO ventaDTO) {
        Set<LineaVentaRequestDTO> lineas = ventaDTO.getLineas();
        BigDecimal total = BigDecimal.ZERO;

        for (LineaVentaRequestDTO linea : lineas) {
            Producto producto = Utils.findByIdOrThrow(
                productoRepository, linea.getIdProducto(), Producto.class
            );
            if (!producto.getEstaVigente()) {
                throw new InvalidOperationException(
                    "El producto con ID " + linea.getIdProducto() +
                        " no está vigente y no puede ser vendido."
                );
            }
            BigDecimal cantidad = new BigDecimal(linea.getCantidad());
            BigDecimal subtotalLinea = cantidad.multiply(producto.getPrecio());
            total = total.add(subtotalLinea);
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}