package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.LocalidadDTO;
import com.minpay.Comiqueria.model.Localidad;
import java.util.List;
import java.util.Set;

public interface ILocalidadService {
    public Localidad getLocalidad(Long id);
    public LocalidadDTO getLocalidadDTO(Localidad localidad);
    public List<Localidad> getLocalidades();
    public List<Localidad> getLocalidades(Set<Long> idsLocalidades);
    public List<LocalidadDTO> getLocalidadesDTO();
    public List<LocalidadDTO> getLocalidadesDTO(Set<Long> idsLocalidades);
    public LocalidadDTO createLocalidad(String nombre, Long idProvincia);
    public LocalidadDTO editLocalidadById(Long id, String nombre, Long idProvincia);
    public void saveLocalidad(Localidad localidad);
    public void saveLocalidades(Set<Localidad> localidades);
    public void deleteLocalidadById(Long id);
}
