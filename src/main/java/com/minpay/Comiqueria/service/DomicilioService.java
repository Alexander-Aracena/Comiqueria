package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.DomicilioDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.mapper.DomicilioDTOToDomicilio;
import com.minpay.Comiqueria.service.interfaces.IDomicilioService;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.repository.IDomicilioRepository;
import com.minpay.Comiqueria.service.interfaces.ILocalidadService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService {
    
    @Autowired
    private IDomicilioRepository domicilioRepository;
    
    @Autowired
    private DomicilioDTOToDomicilio mapper;
    
    @Autowired
    private ILocalidadService localidadService;

    @Override
    public Domicilio getDomicilio(Long id) {
        return this.domicilioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Domicilio id: " + id + " no encontrado."));
    }
    
    @Override
    public DomicilioDTO getDomicilioDTO(Domicilio domicilio) {
        return domicilioADomicilioDTO(domicilio);
    }

    @Override
    public List<Domicilio> getDomicilios() {
        return this.domicilioRepository.findAll();
    }
    
    @Override
    public List<Domicilio> getDomicilios(Set<Long> idsDomicilios) {
        return this.domicilioRepository.findAllById(idsDomicilios);
    }
    
    @Override
    public List<DomicilioDTO> getDomiciliosDTO() {
        List<Domicilio> domicilios = this.getDomicilios();
        return this.traerListaDTO(domicilios);
    }
    
    @Override
    public List<DomicilioDTO> getDomiciliosDTO(Set<Long> idsDomicilios) {
        List<Domicilio> domicilios = this.getDomicilios(idsDomicilios);
        return this.traerListaDTO(domicilios);
    }

    @Override
    public DomicilioDTO createDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = this.mapper.map(domicilioDTO);
        domicilio.setLocalidad(
            this.localidadService.getLocalidad(domicilioDTO.getIdLocalidad())
        );
        this.domicilioRepository.save(domicilio);
        return this.getDomicilioDTO(domicilio);
    }

    @Override
    public DomicilioDTO editDomicilio(Long id, DomicilioDTO domicilioDTO) {
        Domicilio domicilio = this.mapper.map(domicilioDTO, this.getDomicilio(id));
        domicilio.setLocalidad(
            this.localidadService.getLocalidad(domicilioDTO.getIdLocalidad())
        );
        this.domicilioRepository.save(domicilio);
        return this.getDomicilioDTO(domicilio);
    }
    
    @Override
    public void saveDomicilio(Domicilio domicilio) {
        this.domicilioRepository.save(domicilio);
    }

    @Override
    public void deleteDomicilio(Long id) {
        this.domicilioRepository.deleteById(id);
    }
    
    @Override
    public void saveDomicilios(Set<Domicilio> domicilios) {
        this.domicilioRepository.saveAll(domicilios);
    }

    @Override
    public void deleteDomicilios(Set<Long> idsDomicilios) {
        this.domicilioRepository.deleteAllById(idsDomicilios);
    }
    
    @Override
    public List<DomicilioDTO> traerListaDTO(List<Domicilio> domicilios) {
        return domicilios.stream().map(domicilio -> domicilioADomicilioDTO(domicilio)
        ).toList();
    }
    
    public static DomicilioDTO domicilioADomicilioDTO(Domicilio domicilio) {
        return new DomicilioDTO(
            domicilio.getId(),
            domicilio.getCalle(),
            domicilio.getAltura(),
            domicilio.getDepartamento(),
            domicilio.getCp(),
            domicilio.getLocalidad().getId()
        );
    }
}
