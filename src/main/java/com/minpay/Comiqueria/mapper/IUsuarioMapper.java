package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.UsuarioRequestDTO;
import com.minpay.Comiqueria.dto.UsuarioResponseDTO;
import com.minpay.Comiqueria.model.Usuario;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface IUsuarioMapper {
    UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "fechaAlta", ignore = true)
    @Mapping(target = "fechaBaja", ignore = true)
    @Mapping(target = "estaActivo", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    Usuario toUsuario(UsuarioRequestDTO dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "fechaAlta", ignore = true)
    @Mapping(target = "fechaBaja", ignore = true)
    @Mapping(target = "estaActivo", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    void updateUsuarioFromDTO(UsuarioRequestDTO dto, @MappingTarget Usuario usuario);
}