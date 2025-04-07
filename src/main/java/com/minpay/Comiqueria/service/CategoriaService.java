package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.ICategoriaService;
import com.minpay.Comiqueria.model.Categoria;
import com.minpay.Comiqueria.repository.ICategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public Categoria getCategoria(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría id: " + id + " no encontrado."));
    }

    @Override
    public List<Categoria> getCategorias() {
        return this.categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public Categoria createCategoria(String nombre) {
        Categoria categoria = new Categoria(nombre);
        return this.categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public Categoria editCategoriaById(Long id, String nombre) {
        Categoria categoria = this.getCategoria(id);
        categoria.setNombre(nombre);
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoriaById(Long id) {
        this.categoriaRepository.deleteById(id);
    }

    /*
    @Override
    public void addSubcategories(Long idCategoria, Set<Long> idsSubcategorias) {
        Categoria categoria = this.getCategoria(idCategoria);
        Set<Subcategoria> subcategorias = this.subcategoriaRepository.findAllById(idsSubcategorias)
                .stream().collect(Collectors.toSet());
        categoria.getSubcategorias().addAll(subcategorias);
        subcategorias.forEach(subcategoria -> subcategoria.setCategoria(categoria));
        this.subcategoriaRepository.saveAll(subcategorias);
        this.categoriaRepository.save(categoria);
    }

    @Override
    public void deleteSubcategories(Long idCategoria, Set<Long> idsSubcategorias) {
        Categoria categoria = this.getCategoria(idCategoria);
        Set<Subcategoria> subcategorias = this.subcategoriaRepository.findAllById(idsSubcategorias)
                .stream().collect(Collectors.toSet());
        categoria.getSubcategorias().removeAll(subcategorias);
        subcategorias.forEach(subcategoria -> subcategoria.setCategoria(null));
        this.subcategoriaRepository.saveAll(subcategorias);
        this.categoriaRepository.save(categoria);
    }
    */
}
