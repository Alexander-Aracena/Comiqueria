package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.PaisDTO;
import com.minpay.Comiqueria.model.Pais;
import java.util.List;

public interface IPaisService {
    public Pais getPais(Long id);
    public PaisDTO getPaisDTO(Pais pais);
    public List<PaisDTO> getPaisesDTO();
    public PaisDTO createPais(String nombre);
    public PaisDTO editPaisById(Long id, PaisDTO paisDTO);
    public void deletePaisById(Long id);
}
