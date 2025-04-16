package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.AutorDTO;
import com.minpay.Comiqueria.dto.ProductosPorAutorDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.AutorDTOToAutor;
import com.minpay.Comiqueria.mapper.AutorToProductosPorAutorDTO;
import com.minpay.Comiqueria.service.interfaces.IAutorService;
import com.minpay.Comiqueria.model.Autor;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.repository.IAutorRepository;
import com.minpay.Comiqueria.repository.IProductoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IAutorService {
    
    @Autowired
    private IAutorRepository autorRepository;
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Autowired
    private AutorDTOToAutor mapper;
    
    @Autowired
    private AutorToProductosPorAutorDTO prodAutorMapper;
    
    @Override
    public Autor getAutor(Long id){
        return this.autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor id: " + id + " no encontrado."));
    }
    
    @Override
    public AutorDTO getAutorDTO(Long id){
        Autor autor = this.autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor id: " + id + " no encontrado."));
        
        return new AutorDTO(
                autor.getNombre(), autor.getApellido(),
                autor.getFechaAlta(), autor.getFechaBaja()
        );
    }

    @Override
    public List<Autor> getAutores() {
        return this.autorRepository.findAll();
    }

    @Override
    public Autor createAutor(AutorDTO autorDTO) {
        Autor autor = this.mapper.map(autorDTO);
        return this.autorRepository.save(autor);
    }

    @Override
    public Autor editAutorById(Long id, AutorDTO autorDTO) {
        Autor autor = this.mapper.map(autorDTO, this.getAutor(id));
        return this.autorRepository.save(autor);
    }

    @Override
    public void deleteAutorById(Long id) {
        Autor autor = this.getAutor(id);
        if (autor.getFechaBaja() != null) {
            throw new IllegalStateException("El autor ya está dado de baja.");
        }
        autor.setFechaBaja(LocalDate.now());
        this.autorRepository.save(autor);
    }
    
    @Override
    public void addProductos(Long idAutor, Set<Long> idsProductos) {
        Autor autor = this.getAutor(idAutor);
        List<Producto> productos = this.productoRepository.findAllById(idsProductos);
        autor.getProductos().addAll(productos);
        //productos.forEach(producto -> producto.getAutores().add(autor));
        //this.productoRepository.saveAll(productos);
        this.autorRepository.save(autor);
    }
    
    @Override
    public void deleteProductos(Long idAutor, Set<Long> idsProductos) {
        Autor autor = this.getAutor(idAutor);
        List<Producto> productos = this.productoRepository.findAllById(idsProductos);
        if (autor.getFechaBaja() != null) {
            throw new IllegalStateException("El autor ya está dado de baja.");
        }
        autor.getProductos().removeAll(productos);
        productos.forEach(producto -> producto.getAutores().remove(autor));
        this.productoRepository.saveAll(productos);
        this.autorRepository.save(autor);
    }

    @Override
    public ProductosPorAutorDTO getProductosSegunAutor(Long idAutor) {
        Autor autor = this.getAutor(idAutor);
        return this.prodAutorMapper.map(autor);
    }
}