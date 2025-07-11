package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.EditorialResponseDTO;
import com.minpay.Comiqueria.model.Editorial;
import java.util.List;
import java.util.Set;

public interface IEditorialService {
    public Editorial getEditorial(Long id);
    public EditorialResponseDTO getEditorialDTO(Editorial editorial);
    public List<Editorial> getEditoriales();
    public List<Editorial> getEditoriales(Set<Long> idsEditoriales);
    public List<EditorialResponseDTO> getEditorialesDTO();
    public List<EditorialResponseDTO> getEditorialesDTO(Set<Long> idsEditoriales);
    public Editorial createEditorial(String nombre);
    public Editorial editEditorialById(Long id, String nombre);
    public void saveEditorial(Editorial editorial);
    public void deleteEditorialById(Long id);
}
