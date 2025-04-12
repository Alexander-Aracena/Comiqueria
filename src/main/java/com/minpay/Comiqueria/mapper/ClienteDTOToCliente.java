package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.ClienteDTO;
import com.minpay.Comiqueria.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDTOToCliente implements IMapper<ClienteDTO, Cliente> {
    @Override
    public Cliente map(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setFecha_nac(clienteDTO.getFechaNac());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setNroDocumento(clienteDTO.getNroDoc());
        cliente.setTipoDoc(clienteDTO.getTipoDoc());
        cliente.setDomicilios(clienteDTO.getDomicilios());
        cliente.setTelefono(clienteDTO.getTelefono());
        
        return cliente;
    }

    @Override
    public Cliente map(ClienteDTO clienteDTO, Cliente cliente) {
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setFecha_nac(clienteDTO.getFechaNac());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setNroDocumento(clienteDTO.getNroDoc());
        cliente.setTipoDoc(clienteDTO.getTipoDoc());
        cliente.setDomicilios(clienteDTO.getDomicilios());
        cliente.setTelefono(clienteDTO.getTelefono());
        return cliente;
    }
}
