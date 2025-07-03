package com.minpay.Comiqueria.mapper;

import com.minpay.Comiqueria.dto.AutorDTO;
import com.minpay.Comiqueria.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorDTOToAutor implements IMapper<AutorDTO, Autor> {
    @Override
    public Autor map(AutorDTO autorDTO) {
        return new Autor(autorDTO.getNombre(), autorDTO.getApellido());
    }
    
    @Override
    public Autor map(AutorDTO autorDTO, Autor autor) {
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        return autor;
    }
}
