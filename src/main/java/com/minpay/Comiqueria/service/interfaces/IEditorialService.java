package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.EditorialRequestDTO;
import com.minpay.Comiqueria.model.Editorial;
import java.util.List;
import java.util.Set;

public interface IEditorialService {
    public Editorial getEditorial(Long id);
    public EditorialRequestDTO getEditorialDTO(Editorial editorial);
    public List<Editorial> getEditoriales();
    public List<Editorial> getEditoriales(Set<Long> idsEditoriales);
    public List<EditorialRequestDTO> getEditorialesDTO();
    public List<EditorialRequestDTO> getEditorialesDTO(Set<Long> idsEditoriales);
    public Editorial createEditorial(String nombre);
    public Editorial editEditorialById(Long id, String nombre);
    public void saveEditorial(Editorial editorial);
    public void deleteEditorialById(Long id);
}
