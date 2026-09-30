package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.request.DomicilioRequestDTO;
import com.minpay.Comiqueria.dto.response.DomicilioResponseDTO;
import java.util.List;

public interface IDomicilioService {
    public DomicilioResponseDTO getDomicilio(Long id);
    public List<DomicilioResponseDTO> getDomicilios(
        List<Long> ids,
        String calle,
        String cp,
        Boolean estaVigente
    );
    public DomicilioResponseDTO createDomicilio(DomicilioRequestDTO domicilioDTO);
    public DomicilioResponseDTO editDomicilio(Long id, DomicilioRequestDTO domicilioDTO);
    public void deleteDomicilio(Long id);
}