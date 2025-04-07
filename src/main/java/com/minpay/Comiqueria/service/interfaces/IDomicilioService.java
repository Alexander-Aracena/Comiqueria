package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.DomicilioDTO;
import com.minpay.Comiqueria.model.Domicilio;
import java.util.List;

public interface IDomicilioService {
    public Domicilio getDomicilio(Long id);
    public List<Domicilio> getDomicilios();
    public Domicilio createDomicilio(DomicilioDTO domicilioDTO);
    public Domicilio editDomicilioById(Long id, DomicilioDTO domicilioDTO);
    public void deleteDomicilioById(Long id);
}