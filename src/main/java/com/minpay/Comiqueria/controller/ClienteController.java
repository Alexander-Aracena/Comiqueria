package com.minpay.Comiqueria.controller;

import com.minpay.Comiqueria.dto.ClienteDTO;
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
    
    @GetMapping("/{id}")
    public Cliente traerCliente(@PathVariable Long id){
        return this.clienteService.getCliente(id);
    }
    
    @GetMapping
    public List<Cliente> traerClientes(){
        return this.clienteService.getClientes();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody ClienteDTO clienteDTO){
        return this.clienteService.createCliente(clienteDTO);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Cliente editarCliente(@PathVariable Long idCliente, @RequestBody ClienteDTO clienteDTO){
        return this.clienteService.editClienteById(idCliente, clienteDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCliente(@PathVariable Long id){
        this.clienteService.deleteClienteById(id);
    }
    
    @PostMapping("/favoritos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarFavoritos(@PathVariable Long id, @RequestBody Set<Long> idsProductos){
        this.clienteService.addFavoritos(id, idsProductos);
    }
    
    @DeleteMapping("/favoritos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarFavoritos(@PathVariable Long id, @RequestBody Set<Long> idsProductos){
        this.clienteService.deleteFavoritos(id, idsProductos);
    }
    
    @PostMapping("/domicilio/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void agregarDomicilio(@PathVariable Long id, @RequestBody Long idDomicilio){
        this.clienteService.addDomicilio(id, idDomicilio);
    }
    
    @DeleteMapping("/domicilio/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarDomicilio(@PathVariable Long id, @RequestBody Long idDomicilio){
        this.clienteService.deleteDomicilio(id, idDomicilio);
    }
}
