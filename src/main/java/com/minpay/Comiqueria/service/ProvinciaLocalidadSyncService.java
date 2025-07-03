package com.minpay.Comiqueria.service;

import com.minpay.Comiqueria.model.Localidad;
import com.minpay.Comiqueria.model.Provincia;
import com.minpay.Comiqueria.service.interfaces.ILocalidadService;
import com.minpay.Comiqueria.service.interfaces.IProvinciaLocalidadSyncService;
import com.minpay.Comiqueria.service.interfaces.IProvinciaService;
import com.minpay.Comiqueria.utils.Accion;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaLocalidadSyncService implements IProvinciaLocalidadSyncService {
    
    @Autowired
    private IProvinciaService provinciaService;
    
    @Autowired
    private ILocalidadService localidadService;

    @Override
    public void modificarLocalidades(Long idProvincia, Set<Long> idsLocalidades, Accion accion) {
        Provincia provincia = provinciaService.getProvincia(idProvincia);
        Set<Localidad> localidades = new HashSet<>(localidadService.getLocalidades(idsLocalidades));

        switch (accion) {
            case AGREGAR -> {
                provincia.getLocalidades().addAll(localidades);
                localidades.forEach(localidad -> localidad.setProvincia(provincia));
            }
            case ELIMINAR -> {
                provincia.getLocalidades().removeAll(localidades);
                localidades.forEach(localidad -> localidad.setProvincia(null));
            }
        }

        localidadService.saveLocalidades(localidades);
        provinciaService.saveProvincia(provincia);
    }
}
