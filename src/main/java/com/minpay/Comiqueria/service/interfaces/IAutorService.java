package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.AutorResponseDTO;
import com.minpay.Comiqueria.dto.ProductosPorAutorDTO;
import com.minpay.Comiqueria.model.Autor;
import java.util.List;
import java.util.Set;

public interface IAutorService {
    public Autor getAutor(Long id);
    public AutorResponseDTO getAutorDTO(Long id);
    public List<Autor> getAutores();
    public Autor createAutor(AutorResponseDTO autorDTO);
    public Autor editAutorById(Long id, AutorResponseDTO autorDTO);
    public void deleteAutorById(Long id);
    public void addProductos(Long idAutor, Set<Long> idsProductos);
    public void deleteProductos(Long idAutor, Set<Long> idsProductos);
    public ProductosPorAutorDTO getProductosSegunAutor(Long idAutor);
}
