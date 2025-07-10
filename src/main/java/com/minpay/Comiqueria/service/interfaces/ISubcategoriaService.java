package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.SubcategoriaRequestDTO;
import com.minpay.Comiqueria.model.Subcategoria;
import java.util.List;

public interface ISubcategoriaService {
    public SubcategoriaRequestDTO getSubcategoriaDTO(Long id);
    public List<SubcategoriaRequestDTO> getSubcategoriasDTO();
    public SubcategoriaRequestDTO createSubcategoria(String nombreSubcategoria, Long idCategoria);
    public SubcategoriaRequestDTO editSubcategoriaById(Long idSubcategoria, String nombreSubcategoria, Long idCategoria);
    public void saveSubcategoria(Subcategoria subcategoria);
    public void deleteSubcategoriaById(Long id);
    public Subcategoria getSubcategoria(Long id);
}
