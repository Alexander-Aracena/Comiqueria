package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.ClienteRequestDTO;
import com.minpay.Comiqueria.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDTOToCliente implements IMapper<ClienteRequestDTO, Cliente> {
    @Override
    public Cliente map(ClienteRequestDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setFecha_nac(clienteDTO.getFechaNac());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setNroDocumento(clienteDTO.getNroDoc());
        cliente.setTipoDoc(clienteDTO.getTipoDoc());
        cliente.setTelefono(clienteDTO.getTelefono());
        
        return cliente;
    }

    @Override
    public Cliente map(ClienteRequestDTO clienteDTO, Cliente cliente) {
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setFecha_nac(clienteDTO.getFechaNac());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setNroDocumento(clienteDTO.getNroDoc());
        cliente.setTipoDoc(clienteDTO.getTipoDoc());
        cliente.setTelefono(clienteDTO.getTelefono());
        return cliente;
    }
}
