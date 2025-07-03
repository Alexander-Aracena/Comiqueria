package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.utils.Accion;
import java.util.Set;

public interface IPaisProvinciaSyncService {
    void modificarProvincias(Long idPais, Set<Long> idsProvincias, Accion accion);
}
