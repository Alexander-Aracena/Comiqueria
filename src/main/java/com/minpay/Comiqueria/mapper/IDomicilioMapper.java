package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.request.DomicilioRequestDTO;
import com.minpay.Comiqueria.dto.response.DomicilioResponseDTO;
import com.minpay.Comiqueria.model.Domicilio;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface IDomicilioMapper {
    DomicilioResponseDTO toDomicilioResponseDTO(Domicilio domicilio);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "localidad", ignore = true)
    @Mapping(target = "fechaAlta", ignore = true)
    @Mapping(target = "fechaBaja", ignore = true)
    Domicilio toDomicilio(DomicilioRequestDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "localidad", ignore = true)
    @Mapping(target = "fechaAlta", ignore = true)
    @Mapping(target = "fechaBaja", ignore = true)
    void updateDomicilioFromDTO(DomicilioRequestDTO dto, @MappingTarget Domicilio domicilio);
}