package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.DepartamentoRequestDTO;
import com.minpay.Comiqueria.dto.DepartamentoResponseDTO;
import com.minpay.Comiqueria.model.Departamento;
import java.util.List;
import java.util.Set;

public interface IDepartamentoService {
    public DepartamentoResponseDTO getDepartamento(Long id);
    public List<DepartamentoResponseDTO> getDepartamentos(
        List<Long> idsDepartamentos,
        String nombre,
        Long idProvincia,
        String nombreProvincia,
        Long idPais,
        String nombrePais,
        Boolean estaVigente
    );
    public DepartamentoResponseDTO createDepartamento(DepartamentoRequestDTO departamentoDTO);
    public DepartamentoResponseDTO editDepartamento(Long id, DepartamentoRequestDTO departamentoDTO);
    public void deleteDepartamento(Long id);
}
