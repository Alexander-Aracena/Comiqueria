package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ClienteDTO;
import com.minpay.Comiqueria.model.Cliente;
import java.util.List;
import java.util.Set;

public interface IClienteService {
    public Cliente getCliente(Long id);
    public ClienteDTO getClienteDTO(Cliente cliente);
    public List<Cliente> getClientes();
    public List<Cliente> getClientes(Set<Long> idsClientes);
    public List<ClienteDTO> getClientesDTO();
    public List<ClienteDTO> getClientesDTO(Set<Long> idsClientes);
    public Cliente createCliente(ClienteDTO clienteDTO);
    public Cliente editClienteById(Long id, ClienteDTO clienteDTO);
    public void deleteClienteById(Long id);
    public void addFavoritos(Long idCliente, Set<Long> idsProductos);
    public void deleteFavoritos(Long idCliente, Set<Long> idsProductos);
    public void addDomicilio(Long idCliente, Long idDomicilio);
    public void deleteDomicilio(Long idCliente, Long idDomicilio);
}
