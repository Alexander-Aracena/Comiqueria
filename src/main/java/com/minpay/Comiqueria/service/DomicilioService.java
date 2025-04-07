package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.DomicilioDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.DomicilioDTOToDomicilio;
import com.minpay.Comiqueria.service.interfaces.IDomicilioService;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.repository.IDomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService {
    
    @Autowired
    private IDomicilioRepository domicilioRepository;
    
    @Autowired
    private DomicilioDTOToDomicilio mapper;

    @Override
    public Domicilio getDomicilio(Long id) {
        return this.domicilioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Domicilio id: " + id + " no encontrado."));
    }

    @Override
    public List<Domicilio> getDomicilios() {
        return this.domicilioRepository.findAll();
    }

    @Override
    public Domicilio createDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = this.mapper.map(domicilioDTO);
        return this.domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio editDomicilioById(Long id, DomicilioDTO domicilioDTO) {
        Domicilio domicilio = this.mapper.map(domicilioDTO, this.getDomicilio(id));
        return this.domicilioRepository.save(domicilio);
    }

    @Override
    public void deleteDomicilioById(Long id) {
        this.domicilioRepository.deleteById(id);
    }
}
