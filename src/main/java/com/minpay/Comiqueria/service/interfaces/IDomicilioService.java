package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.DomicilioRequestDTO;
import com.minpay.Comiqueria.model.Domicilio;
import java.util.List;
import java.util.Set;

public interface IDomicilioService {
    public Domicilio getDomicilio(Long id);
    public DomicilioRequestDTO getDomicilioDTO(Domicilio domicilio);
    public List<Domicilio> getDomicilios();
    public List<Domicilio> getDomicilios(Set<Long> idsDomicilios);
    public List<DomicilioRequestDTO> getDomiciliosDTO();
    public List<DomicilioRequestDTO> getDomiciliosDTO(Set<Long> idsDomicilios);
    public List<DomicilioRequestDTO> traerListaDTO(List<Domicilio> domicilios);
    public DomicilioRequestDTO createDomicilio(DomicilioRequestDTO domicilioDTO);
    public DomicilioRequestDTO editDomicilio(Long id, DomicilioRequestDTO domicilioDTO);
    public void saveDomicilio(Domicilio domicilio);
    public void deleteDomicilio(Long id);
    public void saveDomicilios(Set<Domicilio> domicilios);
    public void deleteDomicilios(Set<Long> idsDomicilios);
}