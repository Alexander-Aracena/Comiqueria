package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.request.DomicilioRequestDTO;
import com.minpay.Comiqueria.dto.response.DomicilioResponseDTO;
import com.minpay.Comiqueria.exceptions.InvalidOperationException;
import com.minpay.Comiqueria.mapper.IDomicilioMapper;
import com.minpay.Comiqueria.service.interfaces.IDomicilioService;
import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.repository.IDomicilioRepository;
import com.minpay.Comiqueria.repository.specification.DomicilioSpecifications;
import com.minpay.Comiqueria.utils.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    
    @Autowired
    private IDomicilioMapper domicilioMapper;

    @Override
    @Transactional(readOnly = true)
    public DomicilioResponseDTO getDomicilio(Long id) {
        Domicilio domicilio = Utils.findByIdOrThrow(domicilioRepository, id, Domicilio.class);
        return this.domicilioMapper.toDomicilioResponseDTO(domicilio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DomicilioResponseDTO> getDomicilios(
        List<Long> ids,
        String calle,
        String cp,
        Boolean estaVigente
    ) {
        Specification<Domicilio> specs = DomicilioSpecifications.byCriterios(ids, calle, cp, estaVigente);
        List<Domicilio> domicilios = this.domicilioRepository.findAll(specs);
        return Utils.mapearListaA(domicilios, this.domicilioMapper::toDomicilioResponseDTO);
    }

    @Override
    public DomicilioResponseDTO createDomicilio(DomicilioRequestDTO domicilioDTO) {
        Domicilio domicilio = this.domicilioMapper.toDomicilio(domicilioDTO);
        domicilio = this.domicilioRepository.save(domicilio);
        return this.domicilioMapper.toDomicilioResponseDTO(domicilio);
    }

    @Override
    public DomicilioResponseDTO editDomicilio(Long id, DomicilioRequestDTO domicilioDTO) {
        Domicilio domicilioModificado = Utils.findByIdOrThrow(domicilioRepository, id, Domicilio.class);
        if (domicilioModificado.getFechaBaja() != null) {
            throw new InvalidOperationException("El domicilio no está vigente");
        }
        this.domicilioMapper.updateDomicilioFromDTO(domicilioDTO, domicilioModificado);
        domicilioModificado = this.domicilioRepository.save(domicilioModificado);
        return this.domicilioMapper.toDomicilioResponseDTO(domicilioModificado);
    }

    @Override
    public void deleteDomicilio(Long id) {
        Domicilio domicilioEliminado = Utils.findByIdOrThrow(domicilioRepository, id, Domicilio.class);
        if (domicilioEliminado.getFechaBaja() != null) {
            throw new InvalidOperationException("El domicilio ya fue dado de baja");
        }
        this.domicilioRepository.delete(domicilioEliminado);
    }
}