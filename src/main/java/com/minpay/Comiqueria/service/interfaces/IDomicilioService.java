package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.DomicilioRequestDTO;
import com.minpay.Comiqueria.dto.DomicilioResponseDTO;
import com.minpay.Comiqueria.model.Domicilio;
import java.util.List;
import java.util.Set;

public interface IDomicilioService {
    public Domicilio getDomicilio(Long id);
    public DomicilioResponseDTO getDomicilioDTO(Domicilio domicilio);
    public List<Domicilio> getDomicilios();
    public List<Domicilio> getDomicilios(Set<Long> idsDomicilios);
    public List<DomicilioResponseDTO> getDomiciliosDTO();
    public List<DomicilioResponseDTO> getDomiciliosDTO(Set<Long> idsDomicilios);
    public List<DomicilioResponseDTO> traerListaDTO(List<Domicilio> domicilios);
    public DomicilioResponseDTO createDomicilio(DomicilioRequestDTO domicilioDTO);
    public DomicilioResponseDTO editDomicilio(Long id, DomicilioRequestDTO domicilioDTO);
    public void saveDomicilio(Domicilio domicilio);
    public void deleteDomicilio(Long id);
    public void saveDomicilios(Set<Domicilio> domicilios);
    public void deleteDomicilios(Set<Long> idsDomicilios);
}