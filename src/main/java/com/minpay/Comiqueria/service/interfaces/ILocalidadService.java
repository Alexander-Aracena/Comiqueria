package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.LocalidadRequestDTO;
import com.minpay.Comiqueria.model.Localidad;
import java.util.List;
import java.util.Set;

public interface ILocalidadService {
    public Localidad getLocalidad(Long id);
    public LocalidadRequestDTO getLocalidadDTO(Localidad localidad);
    public List<Localidad> getLocalidades();
    public List<Localidad> getLocalidades(Set<Long> idsLocalidades);
    public List<LocalidadRequestDTO> getLocalidadesDTO();
    public List<LocalidadRequestDTO> getLocalidadesDTO(Set<Long> idsLocalidades);
    public LocalidadRequestDTO createLocalidad(String nombre, Long idProvincia);
    public LocalidadRequestDTO editLocalidadById(Long id, String nombre, Long idProvincia);
    public void saveLocalidad(Localidad localidad);
    public void saveLocalidades(Set<Localidad> localidades);
    public void deleteLocalidadById(Long id);
}
