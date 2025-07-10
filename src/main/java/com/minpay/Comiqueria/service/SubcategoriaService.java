package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.SubcategoriaRequestDTO;
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
    public SubcategoriaRequestDTO getSubcategoriaDTO(Long id) {
        Subcategoria subcategoria = this.getSubcategoria(id);
        return new SubcategoriaRequestDTO(id, subcategoria.getNombre());
    }

    @Override
    public List<SubcategoriaRequestDTO> getSubcategoriasDTO() {
        List<Subcategoria> subcategorias = this.subcategoriaRepository.findAll();
        return subcategorias.stream().map(subcategoria -> new SubcategoriaRequestDTO(
                    subcategoria.getId(),
                    subcategoria.getNombre()
            )
        ).toList();
    }
    
    @Override
    @Transactional
    public SubcategoriaRequestDTO createSubcategoria(String nombreSubcategoria, Long idCategoria){
        Categoria categoria = this.categoriaService.getCategoria(idCategoria);
        Subcategoria subcategoria = new Subcategoria(nombreSubcategoria, categoria);
        this.subcategoriaRepository.save(subcategoria);
        return new SubcategoriaRequestDTO(subcategoria.getId(), nombreSubcategoria);
    }

    @Override
    @Transactional
    public SubcategoriaRequestDTO editSubcategoriaById(Long idSubcategoria, String nombreSubcategoria, Long idCategoria) {
        Categoria nuevaCategoria = this.categoriaService.getCategoria(idCategoria);
        Subcategoria subcategoria = this.getSubcategoria(idSubcategoria);
        subcategoria.setNombre(nombreSubcategoria);
        subcategoria.setCategoria(nuevaCategoria);
        this.subcategoriaRepository.save(subcategoria);
        return new SubcategoriaRequestDTO(idSubcategoria, nombreSubcategoria);
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
