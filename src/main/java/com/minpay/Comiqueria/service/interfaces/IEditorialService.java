package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.model.Editorial;
import java.util.List;

public interface IEditorialService {
    public Editorial getEditorial(Long id);
    public List<Editorial> getEditoriales();
    public Editorial createEditorial(String nombre);
    public Editorial editEditorialById(Long id, String nombre);
    public void deleteEditorialById(Long id);
}
