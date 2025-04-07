package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.ClienteDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.ClienteDTOToCliente;
import com.minpay.Comiqueria.model.Cliente;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.model.Sexo;
import com.minpay.Comiqueria.model.TipoDoc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minpay.Comiqueria.repository.IClienteRepository;
import com.minpay.Comiqueria.repository.IDomicilioRepository;
import com.minpay.Comiqueria.repository.IProductoRepository;
import com.minpay.Comiqueria.service.interfaces.IClienteService;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clienteRepository;
    
    @Autowired
    private IDomicilioRepository domicilioRepository;
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Autowired
    private ClienteDTOToCliente mapper;
    
    @Override
    public Cliente getCliente(Long id) {
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente id: " + id + " no encontrado."));
    }

    @Override
    public List<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = this.mapper.map(clienteDTO);
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente editClienteById(Long id, ClienteDTO clienteDTO){
        Cliente cliente = this.mapper.map(clienteDTO, this.getCliente(id));
        return this.clienteRepository.save(cliente);
    }

    @Override
    public void deleteClienteById(Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public void addFavoritos(Long idCliente, Set<Long> idsProductos) {
        Cliente cliente = this.getCliente(idCliente);
        Set<Producto> productos = this.productoRepository.findAllById(idsProductos)
                .stream().collect(Collectors.toSet());
        cliente.getFavoritos().addAll(productos);
        productos.forEach(producto -> producto.getClientes().add(cliente));
        this.productoRepository.saveAll(productos);
        this.clienteRepository.save(cliente);
    }
    
    @Override
    public void deleteFavoritos(Long idCliente, Set<Long> idsProductos) {
        Cliente cliente = this.getCliente(idCliente);
        Set<Producto> productos = this.productoRepository.findAllById(idsProductos)
                .stream().collect(Collectors.toSet());
        cliente.getFavoritos().removeAll(productos);
        productos.forEach(producto -> producto.getClientes().remove(cliente));
        this.productoRepository.saveAll(productos);
        this.clienteRepository.save(cliente);
    }

    @Override
    public void addDomicilio(Long idCliente, Long idDomicilio) {
        Cliente cliente = this.getCliente(idCliente);
        Domicilio domicilio = this.domicilioRepository.findById(idDomicilio)
                .orElseThrow(() -> new ResourceNotFoundException("Domicilio id: " + idDomicilio + " no encontrado."));
        cliente.getDomicilios().add(domicilio);
        domicilio.setCliente(cliente);
        this.clienteRepository.save(cliente);
    }

    @Override
    public void deleteDomicilio(Long idCliente, Long idDomicilio) {
        Cliente cliente = this.getCliente(idCliente);
        Domicilio domicilio = this.domicilioRepository.findById(idDomicilio)
                .orElseThrow(() -> new ResourceNotFoundException("Domicilio id: " + idDomicilio + " no encontrado."));
        cliente.getDomicilios().remove(domicilio);
        this.clienteRepository.save(cliente);
        this.domicilioRepository.deleteById(idDomicilio);
    }

    @Override
    public Set<Domicilio> findAllDomiciliosById(Set<Long> idsDomicilios) {
        return this.domicilioRepository.findAllById(idsDomicilios)
                .stream().collect(Collectors.toSet());
    }
}