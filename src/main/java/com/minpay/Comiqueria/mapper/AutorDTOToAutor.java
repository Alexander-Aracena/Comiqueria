package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.AutorResponseDTO;
import com.minpay.Comiqueria.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorDTOToAutor implements IMapper<AutorResponseDTO, Autor> {
    @Override
    public Autor map(AutorResponseDTO autorDTO) {
        return new Autor(autorDTO.getNombre(), autorDTO.getApellido());
    }
    
    @Override
    public Autor map(AutorResponseDTO autorDTO, Autor autor) {
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        return autor;
    }
}
