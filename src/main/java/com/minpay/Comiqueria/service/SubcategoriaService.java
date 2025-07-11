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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SubcategoriaRequestDTO> getSubcategoriasDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubcategoriaRequestDTO createSubcategoria(String nombreSubcategoria, Long idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubcategoriaRequestDTO editSubcategoriaById(Long idSubcategoria, String nombreSubcategoria, Long idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveSubcategoria(Subcategoria subcategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteSubcategoriaById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subcategoria getSubcategoria(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
