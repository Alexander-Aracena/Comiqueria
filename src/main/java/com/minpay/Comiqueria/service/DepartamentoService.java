package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.request.DepartamentoRequestDTO;
import com.minpay.Comiqueria.dto.response.DepartamentoResponseDTO;
import com.minpay.Comiqueria.exceptions.InvalidOperationException;
import com.minpay.Comiqueria.mapper.IDepartamentoMapper;
import com.minpay.Comiqueria.model.Departamento;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.repository.IDepartamentoRepository;
import com.minpay.Comiqueria.repository.IProvinciaRepository;
import com.minpay.Comiqueria.repository.specification.DepartamentoSpecifications;
import com.minpay.Comiqueria.service.interfaces.IDepartamentoService;
import com.minpay.Comiqueria.utils.Utils;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Autowired
    private IDepartamentoMapper departamentoMapper;
    
    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Override
    @Transactional(readOnly = true)
    public DepartamentoResponseDTO getDepartamento(Long id) {
        Departamento departamento = Utils.findByIdOrThrow(departamentoRepository, id, Departamento.class);
        return this.departamentoMapper.toDepartamentoResponseDTO(departamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartamentoResponseDTO> getDepartamentos(
        List<Long> idsDepartamentos,
        String nombre,
        Long idProvincia,
        String nombreProvincia,
        Long idPais,
        String nombrePais,
        Boolean estaVigente
    ) {
        Specification<Departamento> specs = DepartamentoSpecifications.byCriterios(
            idsDepartamentos,
            nombre,
            idProvincia,
            nombreProvincia,
            idPais,
            nombrePais,
            estaVigente
        );
        List<Departamento> departamentos = this.departamentoRepository.findAll(specs);
        return Utils.mapearListaA(departamentos, departamentoMapper::toDepartamentoResponseDTO);
    }

    @Override
    public DepartamentoResponseDTO createDepartamento(DepartamentoRequestDTO departamentoDTO) {
        Departamento departamento = this.departamentoMapper.toDepartamento(departamentoDTO);
        Provincia provincia = Utils.findByIdOrThrow(
            provinciaRepository, departamentoDTO.idProvincia(), Provincia.class
        );
        if (provincia.getFechaBaja() != null) {
            throw new InvalidOperationException("La provincia seleccionada no está vigente");
        }
        departamento.setProvincia(provincia);
        departamento = this.departamentoRepository.save(departamento);
        return this.departamentoMapper.toDepartamentoResponseDTO(departamento);
    }

    @Override
    public DepartamentoResponseDTO editDepartamento(Long id, DepartamentoRequestDTO departamentoDTO) {
        Departamento deptoModificado = Utils.findByIdOrThrow(
            departamentoRepository, id, Departamento.class
        );
        if (deptoModificado.getFechaBaja() != null) {
            throw new InvalidOperationException("El departamento ya está dado de baja.");
        }
        Provincia nuevaProvincia = Utils.findByIdOrThrow(
            provinciaRepository, departamentoDTO.idProvincia(), Provincia.class
        );
        if (nuevaProvincia.getFechaBaja() != null) {
            throw new InvalidOperationException("La provincia seleccionada no está vigente.");
        }

        if (!Objects.equals(deptoModificado.getProvincia().getId(), departamentoDTO.idProvincia())) {
            deptoModificado.setProvincia(nuevaProvincia); 
        }
        this.departamentoMapper.updateDepartamentoFromDTO(departamentoDTO, deptoModificado);
        deptoModificado = this.departamentoRepository.save(deptoModificado);
        return this.departamentoMapper.toDepartamentoResponseDTO(deptoModificado);
    }

    @Override
    public void deleteDepartamento(Long id) {
        Departamento deptoEliminado = Utils.findByIdOrThrow(
            departamentoRepository, id, Departamento.class
        );
        if (deptoEliminado.getFechaBaja() != null) {
            throw new InvalidOperationException("El departamento ya está dado de baja.");
        }
        this.departamentoRepository.delete(deptoEliminado);
    }
}