package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.EditorialDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.IEditorialService;
import com.minpay.Comiqueria.model.Editorial;
import com.minpay.Comiqueria.repository.IEditorialRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService implements IEditorialService {
    
    @Autowired
    private IEditorialRepository editorialRepository;

    @Override
    public Editorial getEditorial(Long id) {
        return this.editorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editorial id: " + id + " no encontrado."));
    }

    @Override
    public EditorialDTO getEditorialDTO(Editorial editorial) {
        return new EditorialDTO(editorial.getId(), editorial.getNombre());
    }
    
    @Override
    public List<Editorial> getEditoriales() {
        return this.editorialRepository.findAll();
    }
    
    @Override
    public List<Editorial> getEditoriales(Set<Long> idsEditoriales) {
        return this.editorialRepository.findAllById(idsEditoriales);
    }
    
    @Override
    public List<EditorialDTO> getEditorialesDTO() {
        List<Editorial> editoriales = this.getEditoriales();
        return this.traerListaDTO(editoriales);
    }

    @Override
    public List<EditorialDTO> getEditorialesDTO(Set<Long> idsEditoriales) {
        List<Editorial> editoriales = this.getEditoriales(idsEditoriales);
        return this.traerListaDTO(editoriales);
    }

    @Override
    public Editorial createEditorial(String nombre) {
        Editorial editorial = new Editorial(nombre);
        return this.editorialRepository.save(editorial);
    }

    @Override
    public Editorial editEditorialById(Long id, String nombre) {
        Editorial editorial = this.getEditorial(id);
        editorial.setNombre(nombre);
        return this.editorialRepository.save(editorial);
    }
    
    @Override
    public void saveEditorial(Editorial editorial){
        this.editorialRepository.save(editorial);
    }

    @Override
    public void deleteEditorialById(Long id) {
        this.editorialRepository.deleteById(id);
    }
    
    private List<EditorialDTO> traerListaDTO(List<Editorial> editoriales) {
        return editoriales.stream().map(
            editorial -> new EditorialDTO(
                editorial.getId(),
                editorial.getNombre()
            )
        ).toList();
    }
}
