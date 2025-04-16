package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.SubcategoriaDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.model.Categoria;
import com.minpay.Comiqueria.service.interfaces.ISubcategoriaService;
import com.minpay.Comiqueria.model.Subcategoria;
import com.minpay.Comiqueria.repository.ISubcategoriaRepository;
import com.minpay.Comiqueria.service.interfaces.ICategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcategoriaService implements ISubcategoriaService {
    
    @Autowired
    private ISubcategoriaRepository subcategoriaRepository;
    
    @Autowired
    private ICategoriaService categoriaService;

    @Override
    public SubcategoriaDTO getSubcategoriaDTO(Long id) {
        Subcategoria subcategoria = this.getSubcategoria(id);
        return new SubcategoriaDTO(id, subcategoria.getNombre());
    }

    @Override
    public List<SubcategoriaDTO> getSubcategoriasDTO() {
        List<Subcategoria> subcategorias = this.subcategoriaRepository.findAll();
        return subcategorias.stream().map(subcategoria -> new SubcategoriaDTO(
                    subcategoria.getId(),
                    subcategoria.getNombre()
            )
        ).toList();
    }
    
    @Override
    @Transactional
    public SubcategoriaDTO createSubcategoria(String nombreSubcategoria, Long idCategoria){
        Categoria categoria = this.categoriaService.getCategoria(idCategoria);
        Subcategoria subcategoria = new Subcategoria(nombreSubcategoria, categoria);
        this.subcategoriaRepository.save(subcategoria);
        return new SubcategoriaDTO(subcategoria.getId(), nombreSubcategoria);
    }

    @Override
    @Transactional
    public SubcategoriaDTO editSubcategoriaById(Long idSubcategoria, String nombreSubcategoria, Long idCategoria) {
        Categoria nuevaCategoria = this.categoriaService.getCategoria(idCategoria);
        Subcategoria subcategoria = this.getSubcategoria(idSubcategoria);
        subcategoria.setNombre(nombreSubcategoria);
        subcategoria.setCategoria(nuevaCategoria);
        this.subcategoriaRepository.save(subcategoria);
        return new SubcategoriaDTO(idSubcategoria, nombreSubcategoria);
    }
    
    @Override
    public void saveSubcategoria(Subcategoria subcategoria){
        this.subcategoriaRepository.save(subcategoria);
    }

    @Override
    public void deleteSubcategoriaById(Long id) {
        this.subcategoriaRepository.deleteById(id);
    }

    @Override
    public Subcategoria getSubcategoria(Long id) {
        return this.subcategoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subcategoría id: " + id + " no encontrado."));
    }
}
