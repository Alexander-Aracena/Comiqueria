package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.utils.Accion;
import java.util.Set;

public interface IProvinciaLocalidadSyncService {
    void modificarLocalidades(Long idProvincia, Set<Long> idsLocalidades, Accion accion);
}
