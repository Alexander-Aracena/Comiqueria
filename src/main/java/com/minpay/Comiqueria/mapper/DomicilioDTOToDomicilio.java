package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.DomicilioDTO;
import com.minpay.Comiqueria.model.Domicilio;
import org.springframework.stereotype.Component;

@Component
public class DomicilioDTOToDomicilio implements IMapper<DomicilioDTO, Domicilio> {
    @Override
    public Domicilio map(DomicilioDTO domicilioDTO) {
        return new Domicilio(
                domicilioDTO.getCalle(),
                domicilioDTO.getAltura(),
                domicilioDTO.getCp(),
                domicilioDTO.getLocalidad()
        );
    }

    @Override
    public Domicilio map(DomicilioDTO domicilioDTO, Domicilio domicilio) {
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setAltura(domicilioDTO.getAltura());
        domicilio.setDepartamento(domicilioDTO.getDepartamento());
        domicilio.setCp(domicilioDTO.getCp());
        domicilio.setLocalidad(domicilioDTO.getLocalidad());
        return domicilio;
    }
}
