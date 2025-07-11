package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ClienteRequestDTO;
import com.minpay.Comiqueria.model.Cliente;
import java.util.List;
import java.util.Set;

public interface IClienteService {
    public Cliente getCliente(Long id);
    public ClienteRequestDTO getClienteDTO(Cliente cliente);
    public List<Cliente> getClientes();
    public List<Cliente> getClientes(Set<Long> idsClientes);
    public List<ClienteRequestDTO> getClientesDTO();
    public List<ClienteRequestDTO> getClientesDTO(Set<Long> idsClientes);
    public ClienteRequestDTO createCliente(ClienteRequestDTO clienteDTO);
    public ClienteRequestDTO editCliente(Long id, ClienteRequestDTO clienteDTO);
    public void deleteCliente(Long id);
    public void addFavoritos(Long idCliente, Set<Long> idsProductos);
    public void deleteFavoritos(Long idCliente, Set<Long> idsProductos);
    public void addDomicilio(Long idCliente, Long idDomicilio);
    public void deleteDomicilio(Long idCliente, Long idDomicilio);
}
