package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.dto.LocalidadDTO;
import com.minpay.Comiqueria.dto.PaisDTO;
import com.minpay.Comiqueria.dto.ProvinciaDTO;
import com.minpay.Comiqueria.exceptions.ResourceNotFoundException;
import com.minpay.Comiqueria.service.interfaces.IPaisService;
import com.minpay.Comiqueria.model.Pais;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.repository.IPaisRepository;
import com.minpay.Comiqueria.repository.IProvinciaRepository;
import com.minpay.Comiqueria.utils.Utils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisService implements IPaisService {

    @Autowired
    private IPaisRepository paisRepository;
    
    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Override
    public Pais getPais(Long id) {
        return this.paisRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("País id: " + id + " no encontrado."));
    }

    @Override
    public PaisDTO getPaisDTO(Pais pais) {
        Set<Provincia> provincias = pais.getProvincias()
            .iterator().next() != null ? Utils.convertirASetDTO(
                pais.getProvincias(),
                prov -> new ProvinciaDTO(
                    prov.getId(),
                    prov.getNombre(),
                    Utils.convertirASetDTO(
                        prov.getLocalidades(),
                        loc -> new LocalidadDTO(
                            loc.getId(),
                            loc.getNombre()
                        )
                    )
                )
            )
            : new HashSet<>();
        
        
        return new PaisDTO(
            pais.getId(),
            pais.getNombre(),
            Utils.convertirASetDTO(
                pais.getProvincias(),
                prov -> new ProvinciaDTO(
                    prov.getId(),
                    prov.getNombre(),
                    Utils.convertirASetDTO(
                        prov.getLocalidades(),
                        loc -> new LocalidadDTO(
                            loc.getId(),
                            loc.getNombre()
                        )
                    )
                )
            )
        );
    }

    @Override
    public List<PaisDTO> getPaisesDTO() {
        List<Pais> paises = this.paisRepository.findAll();
        return this.traerListaDTO(paises);
    }

    @Override
    @Transactional
    public PaisDTO createPais(String nombre) {
        Pais pais = new Pais(nombre);
        this.paisRepository.save(pais);
        return this.getPaisDTO(pais);
    }

    @Override
    @Transactional
    public PaisDTO editPaisById(Long id, PaisDTO paisDTO) {
        Pais pais = this.getPais(id);
        Set<Provincia> provincias = Utils.convertirASetDTO(
            paisDTO.getProvincias(),
            provinciaDTO -> this.provinciaRepository.findById(provinciaDTO.getId())
                .orElseThrow(
                    () -> new ResourceNotFoundException("Provincia id: " + provinciaDTO.getId() + " no encontrado.")
                )
        );
        pais.setNombre(paisDTO.getNombre());
        pais.setProvincias(provincias);
        this.paisRepository.save(pais);
        return this.getPaisDTO(pais);
    }

    @Override
    public void deletePaisById(Long id) {
        this.paisRepository.deleteById(id);
    }

    private List<PaisDTO> traerListaDTO(List<Pais> paises) {
        return Utils.convertirAListaDTO(
            paises,
            pais -> new PaisDTO(
                pais.getId(),
                pais.getNombre(),
                Utils.convertirASetDTO(
                    pais.getProvincias(),
                    prov -> new ProvinciaDTO(
                        prov.getId(),
                        prov.getNombre(),
                        Utils.convertirASetDTO(
                            prov.getLocalidades(),
                            loc -> new LocalidadDTO(
                                loc.getId(),
                                loc.getNombre()
                            )
                        )
                    )
                )
            )
        );
    }
}
