package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.ProductoRequestDTO;
import com.minpay.Comiqueria.dto.ProductoResponseDTO;
import com.minpay.Comiqueria.model.Producto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface IProductoMapper {
    ProductoResponseDTO toProductoResponseDTO(Producto producto);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autores", ignore = true)
    @Mapping(target = "subcategoria", ignore = true)
    @Mapping(target = "editorial", ignore = true)
    Producto toProducto(ProductoRequestDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autores", ignore = true)
    @Mapping(target = "subcategoria", ignore = true)
    @Mapping(target = "editorial", ignore = true)
    void updateProductoFromDTO(ProductoRequestDTO dto, @MappingTarget Producto producto);
}