package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.ProvinciaDTO;
import com.minpay.Comiqueria.model.Provincia;
import java.util.List;
import java.util.Set;

public interface IProvinciaService {
    public Provincia getProvincia(Long id);
    public ProvinciaDTO getProvinciaDTO(Provincia provincia);
    public List<Provincia> getProvincias();
    public List<Provincia> getProvincias(Set<Long> idsProvincias);
    public List<ProvinciaDTO> getProvinciasDTO();
    public List<ProvinciaDTO> getProvinciasDTO(Set<Long> idsProvincias);
    public ProvinciaDTO createProvincia(String nombre, Long idPais);
    public ProvinciaDTO editProvinciaById(Long id, String nombre, Long idPais, Set<Long> idLocalidades);
    public void saveProvincia(Provincia provincia);
    public void saveProvincias(Set<Provincia> provincias);
    public void deleteProvinciaById(Long id);
}
