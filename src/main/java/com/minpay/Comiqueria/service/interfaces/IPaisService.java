package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.request.PaisRequestDTO;
import com.minpay.Comiqueria.dto.response.PaisResponseDTO;
import java.util.List;

public interface IPaisService {
    public PaisResponseDTO getPais(Long id);
    public List<PaisResponseDTO> getPaises(List<Long> ids, String nombre, Boolean estaVigente);
    public PaisResponseDTO createPais(PaisRequestDTO paisDTO);
    public PaisResponseDTO editPais(Long id, PaisRequestDTO paisDTO);
    public void deletePais(Long id);
}