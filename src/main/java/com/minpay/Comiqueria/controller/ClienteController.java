package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ClienteRequestDTO;
import com.minpay.Comiqueria.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.minpay.Comiqueria.service.interfaces.IClienteService;
import java.util.Set;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;
    
    @GetMapping("/{idCliente}")
    public ClienteRequestDTO traerCliente(@PathVariable Long idCliente){
        Cliente cliente = this.clienteService.getCliente(idCliente);
        return this.clienteService.getClienteDTO(cliente);
    }
    
    @GetMapping
    public List<ClienteRequestDTO> traerClientes(){
        return this.clienteService.getClientesDTO();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteRequestDTO guardarCliente(@RequestBody ClienteRequestDTO clienteDTO){
        return this.clienteService.createCliente(clienteDTO);
    }
    
    @PatchMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteRequestDTO editarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequestDTO clienteDTO){
        return this.clienteService.editCliente(idCliente, clienteDTO);
    }
    
    @DeleteMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCliente(@PathVariable Long idCliente){
        this.clienteService.deleteCliente(idCliente);
    }
    
    @PostMapping("/favoritos/{idCliente}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarFavoritos(@PathVariable Long idCliente, @RequestBody Set<Long> idsProductos){
        this.clienteService.addFavoritos(idCliente, idsProductos);
    }
    
    @DeleteMapping("/favoritos/{idCliente}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarFavoritos(@PathVariable Long idCliente, @RequestBody Set<Long> idsProductos){
        this.clienteService.deleteFavoritos(idCliente, idsProductos);
    }
    
    @PostMapping("/domicilio/{idCliente}")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarDomicilio(@PathVariable Long idCliente, @RequestParam Long idDomicilio){
        this.clienteService.addDomicilio(idCliente, idDomicilio);
    }
    
    @DeleteMapping("/domicilio/{idCliente}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarDomicilio(@PathVariable Long idCliente, @RequestParam Long idDomicilio){
        this.clienteService.deleteDomicilio(idCliente, idDomicilio);
    }
}
