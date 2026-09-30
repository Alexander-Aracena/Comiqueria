package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.request.LocalidadRequestDTO;
import com.minpay.Comiqueria.dto.response.LocalidadResponseDTO;
import com.minpay.Comiqueria.exceptions.InvalidOperationException;
import com.minpay.Comiqueria.mapper.ILocalidadMapper;
import com.minpay.Comiqueria.model.Departamento;
import com.minpay.Comiqueria.service.interfaces.ILocalidadService;
import com.minpay.Comiqueria.model.Localidad;
import com.minpay.Comiqueria.repository.IDepartamentoRepository;
import com.minpay.Comiqueria.repository.ILocalidadRepository;
import com.minpay.Comiqueria.repository.specification.LocalidadSpecifications;
import com.minpay.Comiqueria.utils.Utils;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocalidadService implements ILocalidadService {
    
    @Autowired
    private ILocalidadRepository localidadRepository;
    
    @Autowired
    private ILocalidadMapper localidadMapper;
    
    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public LocalidadResponseDTO getLocalidad(Long id) {
        Localidad localidad = Utils.findByIdOrThrow(localidadRepository, id, Localidad.class);
        return this.localidadMapper.toLocalidadResponseDTO(localidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocalidadResponseDTO> getLocalidades(
        List<Long> ids,
        String nombre,
        Long idDepartamento,
        Boolean estaVigente
    ) {
        Specification<Localidad> specs = LocalidadSpecifications.byCriterios(
            ids, nombre, idDepartamento, estaVigente
        );
        List<Localidad> localidades = this.localidadRepository.findAll(specs);
        return Utils.mapearListaA(localidades, this.localidadMapper::toLocalidadResponseDTO);
    }

    @Override
    public LocalidadResponseDTO createLocalidad(LocalidadRequestDTO localidadRequestDTO) {
        Localidad localidad = this.localidadMapper.toLocalidad(localidadRequestDTO);
        Departamento nuevoDepartamento = Utils.findByIdOrThrow(
            departamentoRepository, localidadRequestDTO.idDepartamento(), Departamento.class
        );
        if (nuevoDepartamento.getFechaBaja() != null) {
            throw new InvalidOperationException("El nuevoDepartamento seleccionado no está vigente");
        }
        localidad.setDepartamento(nuevoDepartamento);
        localidad = this.localidadRepository.save(localidad);
        return this.localidadMapper.toLocalidadResponseDTO(localidad);
    }

    @Override
    public LocalidadResponseDTO editLocalidad(Long id, LocalidadRequestDTO localidadRequestDTO) {
        Localidad localidadModificada = Utils.findByIdOrThrow(localidadRepository, id, Localidad.class);
        if (localidadModificada.getFechaBaja() != null) {
            throw new InvalidOperationException("La localidad ya no está vigente");
        }
        Departamento nuevoDepartamento = Utils.findByIdOrThrow(
            departamentoRepository, localidadRequestDTO.idDepartamento(), Departamento.class
        );
        if (nuevoDepartamento.getFechaBaja() != null) {
            throw new InvalidOperationException("El departamento seleccionado no está vigente");
        }

        if (!Objects.equals(
            localidadModificada.getDepartamento().getId(), localidadRequestDTO.idDepartamento()
        )) {
            localidadModificada.setDepartamento(nuevoDepartamento); 
        }
        this.localidadMapper.updateLocalidadFromDTO(localidadRequestDTO, localidadModificada);
        localidadModificada = this.localidadRepository.save(localidadModificada);
        return this.localidadMapper.toLocalidadResponseDTO(localidadModificada);
    }

    @Override
    public void deleteLocalidad(Long id) {
        Localidad localidadEliminada = Utils.findByIdOrThrow(localidadRepository, id, Localidad.class);
        if (localidadEliminada.getFechaBaja() != null) {
            throw new InvalidOperationException("La localidad ya no está vigente");
        }
        this.localidadRepository.delete(localidadEliminada);
    }
}