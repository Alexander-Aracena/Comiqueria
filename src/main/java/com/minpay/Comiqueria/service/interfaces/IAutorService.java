package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.AutorDTO;
import com.minpay.Comiqueria.dto.ProductosPorAutorDTO;
import com.minpay.Comiqueria.model.Autor;
import com.minpay.Comiqueria.model.Producto;
import java.util.List;
import java.util.Set;

public interface IAutorService {
    public Autor getAutor(Long id);
    public AutorDTO getAutorDTO(Long id);
    public List<Autor> getAutores();
    public Autor createAutor(AutorDTO autorDTO);
    public Autor editAutorById(Long id, AutorDTO autorDTO);
    public void deleteAutorById(Long id);
    public void addProductos(Long idAutor, Set<Long> idsProductos);
    public void deleteProductos(Long idAutor, Set<Long> idsProductos);
    public ProductosPorAutorDTO getProductosSegunAutor(Long idAutor);
}
