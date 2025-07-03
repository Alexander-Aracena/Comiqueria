package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.model.Categoria;
import java.util.List;

public interface ICategoriaService {
    public Categoria getCategoria(Long id);
    public List<Categoria> getCategorias();
    public Categoria createCategoria(String nombre);
    public Categoria editCategoriaById(Long id, String nombre);
    public void deleteCategoriaById(Long id);
}
