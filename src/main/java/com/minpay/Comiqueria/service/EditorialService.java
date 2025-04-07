package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.IEditorialService;
import com.minpay.Comiqueria.model.Editorial;
import com.minpay.Comiqueria.repository.IEditorialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService implements IEditorialService {
    
    @Autowired
    private IEditorialRepository editorialRepository;

    @Override
    public Editorial getEditorial(Long id) {
        return this.editorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localidad id: " + id + " no encontrado."));
    }

    @Override
    public List<Editorial> getEditoriales() {
        return this.editorialRepository.findAll();
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
    public void deleteEditorialById(Long id) {
        this.editorialRepository.deleteById(id);
    }
}
