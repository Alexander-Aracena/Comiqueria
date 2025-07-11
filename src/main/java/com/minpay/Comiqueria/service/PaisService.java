package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LocalidadRequestDTO;
import com.minpay.Comiqueria.dto.PaisRequestDTO;
import com.minpay.Comiqueria.dto.ProvinciaRequestDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.IPaisService;
import com.minpay.Comiqueria.model.Pais;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.repository.IPaisRepository;
import com.minpay.Comiqueria.repository.IProvinciaRepository;
import com.minpay.Comiqueria.utils.Utils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisService implements IPaisService {

    @Autowired
    private IPaisRepository paisRepository;

    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Override
    public Pais getPais(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PaisRequestDTO getPaisDTO(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PaisRequestDTO> getPaisesDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PaisRequestDTO createPais(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PaisRequestDTO editPaisById(Long id, PaisRequestDTO paisDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePaisById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
