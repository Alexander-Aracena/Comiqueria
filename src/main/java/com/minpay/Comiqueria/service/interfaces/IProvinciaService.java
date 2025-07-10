package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ProvinciaRequestDTO;
import com.minpay.Comiqueria.model.Provincia;
import java.util.List;
import java.util.Set;

public interface IProvinciaService {
    public Provincia getProvincia(Long id);
    public ProvinciaRequestDTO getProvinciaDTO(Provincia provincia);
    public List<Provincia> getProvincias();
    public List<Provincia> getProvincias(Set<Long> idsProvincias);
    public List<ProvinciaRequestDTO> getProvinciasDTO();
    public List<ProvinciaRequestDTO> getProvinciasDTO(Set<Long> idsProvincias);
    public ProvinciaRequestDTO createProvincia(String nombre, Long idPais);
    public ProvinciaRequestDTO editProvinciaById(Long id, String nombre, Long idPais, Set<Long> idLocalidades);
    public void saveProvincia(Provincia provincia);
    public void saveProvincias(Set<Provincia> provincias);
    public void deleteProvinciaById(Long id);
}
