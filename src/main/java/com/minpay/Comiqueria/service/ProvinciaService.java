package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LocalidadDTO;
import com.minpay.Comiqueria.dto.ProvinciaDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.IProvinciaService;
import com.minpay.Comiqueria.model.Localidad;
import com.minpay.Comiqueria.model.Pais;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.repository.ILocalidadRepository;
import com.minpay.Comiqueria.repository.IPaisRepository;
import com.minpay.Comiqueria.repository.IProvinciaRepository;
import com.minpay.Comiqueria.utils.Utils;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Autowired
    private IPaisRepository paisRepository;

    @Autowired
    private ILocalidadRepository localidadRepository;

    @Override
    public Provincia getProvincia(Long id) {
        return this.provinciaRepository.findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Provincia id: " + id + " no encontrado.")
            );
    }

    @Override
    public ProvinciaDTO getProvinciaDTO(Provincia provincia) {
        return new ProvinciaDTO(
            provincia.getId(),
            provincia.getNombre(),
            Utils.convertirASetDTO(
                provincia.getLocalidades(),
                localidad -> new LocalidadDTO(
                    localidad.getId(),
                    localidad.getNombre()
                )
            )
        );
    }

    @Override
    public List<Provincia> getProvincias() {
        return this.provinciaRepository.findAll();
    }

    @Override
    public List<Provincia> getProvincias(Set<Long> idsProvincias) {
        return this.provinciaRepository.findAllById(idsProvincias);
    }

    @Override
    public List<ProvinciaDTO> getProvinciasDTO() {
        List<Provincia> provincias = this.getProvincias();
        return traerListaDTO(provincias);
    }

    @Override
    public List<ProvinciaDTO> getProvinciasDTO(Set<Long> idsProvincias) {
        List<Provincia> provincias = this.getProvincias(idsProvincias);
        return traerListaDTO(provincias);
    }

    @Override
    public ProvinciaDTO createProvincia(String nombre, Long idPais) {
        Pais pais = this.paisRepository.findById(idPais)
            .orElseThrow(
                () -> new ResourceNotFoundException("País id: " + idPais + " no encontrado.")
            );
        Provincia provincia = new Provincia(nombre, pais);
        this.provinciaRepository.save(provincia);
        return this.getProvinciaDTO(provincia);
    }

    @Override
    public ProvinciaDTO editProvinciaById(
        Long id,
        String nombre,
        Long idPais,
        Set<Long> idLocalidades
    ) {
        Pais pais = this.paisRepository.findById(idPais)
            .orElseThrow(
                () -> new ResourceNotFoundException("País id: " + idPais + " no encontrado.")
            );
        Provincia provincia = this.getProvincia(id);
        Set<Localidad> localidades = Utils.convertirListaASet(
            this.localidadRepository.findAllById(idLocalidades)
        );
        provincia.setNombre(nombre);
        provincia.setPais(pais);
        provincia.setLocalidades(localidades);
        this.provinciaRepository.save(provincia);
        return this.getProvinciaDTO(provincia);
    }

    @Override
    public void saveProvincia(Provincia provincia) {
        this.provinciaRepository.save(provincia);
    }

    @Override
    public void saveProvincias(Set<Provincia> provincias) {
        this.provinciaRepository.saveAll(provincias);
    }

    @Override
    public void deleteProvinciaById(Long id) {
        this.provinciaRepository.deleteById(id);
    }

    private List<ProvinciaDTO> traerListaDTO(List<Provincia> provincias) {
        return Utils.convertirAListaDTO(
            provincias,
            provincia -> new ProvinciaDTO(
                provincia.getId(),
                provincia.getNombre(),
                Utils.convertirASetDTO(
                    provincia.getLocalidades(),
                    localidad -> new LocalidadDTO(localidad.getId(), localidad.getNombre())
                )
            )
        );
    }
}
