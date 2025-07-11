package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.DomicilioRequestDTO;
import com.minpay.Comiqueria.model.Domicilio;
import org.springframework.stereotype.Component;

@Component
public class DomicilioDTOToDomicilio implements IMapper<DomicilioRequestDTO, Domicilio> {
    @Override
    public Domicilio map(DomicilioRequestDTO domicilioDTO) {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setAltura(domicilioDTO.getAltura());
        domicilio.setDepartamento(domicilioDTO.getDepartamento());
        domicilio.setCp(domicilioDTO.getCp());
        return domicilio;
    }

    @Override
    public Domicilio map(DomicilioRequestDTO domicilioDTO, Domicilio domicilio) {
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setAltura(domicilioDTO.getAltura());
        domicilio.setDepartamento(domicilioDTO.getDepartamento());
        domicilio.setCp(domicilioDTO.getCp());
        return domicilio;
    }
}
