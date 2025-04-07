package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.SubcategoriaDTO;
import com.minpay.Comiqueria.model.Subcategoria;
import java.util.List;

public interface ISubcategoriaService {
    public SubcategoriaDTO getSubcategoriaDTO(Long id);
    public List<SubcategoriaDTO> getSubcategoriasDTO();
    public SubcategoriaDTO createSubcategoria(String nombreSubcategoria, Long idCategoria);
    public SubcategoriaDTO editSubcategoriaById(Long idSubcategoria, String nombreSubcategoria, Long idCategoria);
    public void deleteSubcategoriaById(Long id);
    public Subcategoria getSubcategoria(Long id);
}
