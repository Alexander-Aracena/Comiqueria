package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LocalidadDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.ILocalidadService;
import com.minpay.Comiqueria.model.Localidad;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.repository.ILocalidadRepository;
import com.minpay.Comiqueria.repository.IProvinciaRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadService implements ILocalidadService {
    
    @Autowired
    private ILocalidadRepository localidadRepository;
    
    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Override
    public Localidad getLocalidad(Long id) {
        return this.localidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localidad id: " + id + " no encontrado."));
    }
    
    @Override
    public LocalidadDTO getLocalidadDTO(Localidad localidad) {
        return new LocalidadDTO(localidad.getId(), localidad.getNombre());
    }
    
    @Override
    public List<Localidad> getLocalidades() {
        return this.localidadRepository.findAll();
    }

    @Override
    public List<Localidad> getLocalidades(Set<Long> idsLocalidades) {
        return this.localidadRepository.findAllById(idsLocalidades);
    }

    @Override
    public List<LocalidadDTO> getLocalidadesDTO() {
        List<Localidad> localidades = this.getLocalidades();
        return this.traerListaDTO(localidades);
    }

    @Override
    public List<LocalidadDTO> getLocalidadesDTO(Set<Long> idsLocalidades) {
        List<Localidad> localidades = this.getLocalidades(idsLocalidades);
        return this.traerListaDTO(localidades);
    }

    @Override
    public LocalidadDTO createLocalidad(String nombre, Long idProvincia) {
        Provincia provincia = this.provinciaRepository.findById(idProvincia)
            .orElseThrow(
                () -> new ResourceNotFoundException("Provincia id: " + idProvincia + " no encontrado.")
            );
        Localidad localidad = new Localidad(nombre, provincia);
        this.saveLocalidad(localidad);
        return this.getLocalidadDTO(localidad);
    }

    @Override
    public LocalidadDTO editLocalidadById(Long id, String nombre, Long idProvincia) {
        Provincia provincia = this.provinciaRepository.findById(idProvincia)
            .orElseThrow(
                () -> new ResourceNotFoundException("Provincia id: " + idProvincia + " no encontrado.")
            );
        Localidad localidad = this.getLocalidad(id);
        localidad.setNombre(nombre);
        localidad.setProvincia(provincia);
        this.saveLocalidad(localidad);
        return this.getLocalidadDTO(localidad);
    }
    
    @Override
    public void saveLocalidad(Localidad localidad) {
        this.localidadRepository.save(localidad);
    }

    @Override
    public void saveLocalidades(Set<Localidad> localidades) {
        this.localidadRepository.saveAll(localidades);
    }

    @Override
    public void deleteLocalidadById(Long id) {
        this.localidadRepository.deleteById(id);
    }
    
    private List<LocalidadDTO> traerListaDTO(List<Localidad> localidades) {
        return localidades.stream().map(
            localidad -> new LocalidadDTO(
                localidad.getId(),
                localidad.getNombre()
            )
        ).toList();
    }
}
