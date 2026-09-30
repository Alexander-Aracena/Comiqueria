package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.request.LocalidadRequestDTO;
import com.minpay.Comiqueria.dto.response.LocalidadResponseDTO;
import java.util.List;

public interface ILocalidadService {
    public LocalidadResponseDTO getLocalidad(Long id);
    public List<LocalidadResponseDTO> getLocalidades(
        List<Long> ids,
        String nombre,
        Long idDepartamento,
        Boolean estaVigente
    );
    public LocalidadResponseDTO createLocalidad(LocalidadRequestDTO localidadRequestDTO);
    public LocalidadResponseDTO editLocalidad(Long id, LocalidadRequestDTO localidadRequestDTO);
    public void deleteLocalidad(Long id);
}