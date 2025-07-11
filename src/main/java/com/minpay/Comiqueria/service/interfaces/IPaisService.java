package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.PaisRequestDTO;
import com.minpay.Comiqueria.model.Pais;
import java.util.List;

public interface IPaisService {
    public Pais getPais(Long id);
    public PaisRequestDTO getPaisDTO(Pais pais);
    public List<PaisRequestDTO> getPaisesDTO();
    public PaisRequestDTO createPais(String nombre);
    public PaisRequestDTO editPaisById(Long id, PaisRequestDTO paisDTO);
    public void deletePaisById(Long id);
}
