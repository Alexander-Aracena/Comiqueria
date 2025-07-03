package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.DomicilioDTO;
import com.minpay.Comiqueria.model.Domicilio;
import java.util.List;
import java.util.Set;

public interface IDomicilioService {
    public Domicilio getDomicilio(Long id);
    public DomicilioDTO getDomicilioDTO(Domicilio domicilio);
    public List<Domicilio> getDomicilios();
    public List<Domicilio> getDomicilios(Set<Long> idsDomicilios);
    public List<DomicilioDTO> getDomiciliosDTO();
    public List<DomicilioDTO> getDomiciliosDTO(Set<Long> idsDomicilios);
    public List<DomicilioDTO> traerListaDTO(List<Domicilio> domicilios);
    public DomicilioDTO createDomicilio(DomicilioDTO domicilioDTO);
    public DomicilioDTO editDomicilio(Long id, DomicilioDTO domicilioDTO);
    public void saveDomicilio(Domicilio domicilio);
    public void deleteDomicilio(Long id);
    public void saveDomicilios(Set<Domicilio> domicilios);
    public void deleteDomicilios(Set<Long> idsDomicilios);
}