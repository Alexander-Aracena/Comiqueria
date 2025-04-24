package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.ClienteDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.ClienteDTOToCliente;
import com.minpay.Comiqueria.model.Cliente;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minpay.Comiqueria.repository.IClienteRepository;
import com.minpay.Comiqueria.service.interfaces.IClienteService;
import com.minpay.Comiqueria.service.interfaces.IDomicilioService;
import com.minpay.Comiqueria.service.interfaces.IProductoService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IDomicilioService domicilioService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ClienteDTOToCliente mapper;

    @Override
    public Cliente getCliente(Long id) {
        return this.clienteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente id: " + id + " no encontrado."));
    }

    @Override
    public ClienteDTO getClienteDTO(Cliente cliente) {
        return clienteAClienteDTO(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }

    @Override
    public List<Cliente> getClientes(Set<Long> idsClientes) {
        return this.clienteRepository.findAllById(idsClientes);
    }

    @Override
    public List<ClienteDTO> getClientesDTO() {
        List<Cliente> clientes = this.getClientes();
        return this.traerListaDTO(clientes);
    }

    @Override
    public List<ClienteDTO> getClientesDTO(Set<Long> idsClientes) {
        List<Cliente> clientes = this.getClientes(idsClientes);
        return this.traerListaDTO(clientes);
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = this.mapper.map(clienteDTO);
        this.clienteRepository.save(cliente);
        return this.getClienteDTO(cliente);
    }

    @Override
    public ClienteDTO editCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = this.mapper.map(clienteDTO, this.getCliente(id));
        this.clienteRepository.save(cliente);
        return this.getClienteDTO(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public void addFavoritos(Long idCliente, Set<Long> idsProductos) {
        Cliente cliente = this.getCliente(idCliente);
        Set<Producto> productos = this.productoService.getProductos(idsProductos)
            .stream().collect(Collectors.toSet());
        cliente.getFavoritos().addAll(productos);
        productos.forEach(producto -> producto.getClientes().add(cliente));
        this.productoService.saveProductos(productos);
        this.clienteRepository.save(cliente);
    }

    @Override
    public void deleteFavoritos(Long idCliente, Set<Long> idsProductos) {
        Cliente cliente = this.getCliente(idCliente);
        Set<Producto> productos = this.productoService.getProductos(idsProductos)
            .stream().collect(Collectors.toSet());
        cliente.getFavoritos().removeAll(productos);
        productos.forEach(producto -> producto.getClientes().remove(cliente));
        this.productoService.saveProductos(productos);
        this.clienteRepository.save(cliente);
    }

    @Override
    public void addDomicilio(Long idCliente, Long idDomicilio) {
        Cliente cliente = this.getCliente(idCliente);
        Domicilio domicilio = this.domicilioService.getDomicilio(idDomicilio);
        cliente.getDomicilios().add(domicilio);
        domicilio.setCliente(cliente);
        this.clienteRepository.save(cliente);
        this.domicilioService.saveDomicilio(domicilio);
    }

    @Override
    public void deleteDomicilio(Long idCliente, Long idDomicilio) {
        Cliente cliente = this.getCliente(idCliente);
        Domicilio domicilio = this.domicilioService.getDomicilio(idDomicilio);
        cliente.getDomicilios().remove(domicilio);
        this.clienteRepository.save(cliente);
        this.domicilioService.deleteDomicilio(idDomicilio);
    }

    private List<ClienteDTO> traerListaDTO(List<Cliente> clientes) {
        return clientes.stream().map(cliente -> clienteAClienteDTO(cliente)
        ).toList();
    }

    private ClienteDTO clienteAClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setFechaNac(cliente.getFecha_nac());
        clienteDTO.setSexo(cliente.getSexo());
        clienteDTO.setTipoDoc(cliente.getTipoDoc());
        clienteDTO.setNroDoc(cliente.getNroDocumento());
        clienteDTO.getFavoritos().addAll(
            productoService.traerListaDTO(
                cliente.getFavoritos().stream().collect(Collectors.toList())
            )
        );
        clienteDTO.getDomicilios().addAll(
            domicilioService.traerListaDTO(
                cliente.getDomicilios().stream().collect(Collectors.toList())
            )
        );
        clienteDTO.setTelefono(cliente.getTelefono());

        return clienteDTO;
    }
}
