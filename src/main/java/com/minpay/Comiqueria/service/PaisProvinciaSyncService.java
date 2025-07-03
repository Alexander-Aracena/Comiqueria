package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.model.Pais;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.service.interfaces.IPaisProvinciaSyncService;
import com.minpay.Comiqueria.service.interfaces.IPaisService;
import com.minpay.Comiqueria.service.interfaces.IProvinciaService;
import com.minpay.Comiqueria.utils.Accion;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisProvinciaSyncService implements IPaisProvinciaSyncService {
    
    @Autowired
    private IPaisService paisService;
    
    @Autowired
    private IProvinciaService provinciaService;

    @Override
    public void modificarProvincias(Long idPais, Set<Long> idsProvincias, Accion accion) {
        Pais pais = this.paisService.getPais(idPais);
        Set<Provincia> provincias = new HashSet<>(this.provinciaService.getProvincias(idsProvincias));
        
        switch (accion) {
            case AGREGAR -> {
                pais.getProvincias().addAll(provincias);
                provincias.forEach(provincia -> provincia.setPais(pais));
            }
            
            case ELIMINAR -> {
                pais.getProvincias().removeAll(provincias);
                provincias.forEach(provincia -> provincia.setPais(null));
            }
        }
    }
}
