package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.LineaVentaRequestDTO;
import com.minpay.Comiqueria.dto.LineaVentaResponseDTO;
import com.minpay.Comiqueria.model.LineaVenta;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface ILineaVentaMapper {
    LineaVentaResponseDTO toLineaVentaResponseDTO(LineaVenta lineaVenta);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "precio", ignore = true)
    LineaVenta toLineaVenta(LineaVentaRequestDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "precio", ignore = true)
    void updateLineaVentaFromDTO(LineaVentaRequestDTO dto, @MappingTarget LineaVenta lineaVenta);
}