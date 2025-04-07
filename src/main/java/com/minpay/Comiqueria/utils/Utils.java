package com.minpay.Comiqueria.utils;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {
    public static <T, R> Set<R> convertirASetDTO(Set<T> entidad, Function<T, R> mapper) {
        return entidad.stream().map(mapper).collect(Collectors.toSet());
    }
    
    public static <T, R> List<R> convertirAListaDTO(List<T> entidad, Function<T, R> mapper) {
        return entidad.stream().map(mapper).collect(Collectors.toList());
    }
    
    public static <T> Set<T> convertirListaASet(List<T> entidad) {
        return entidad.stream().collect(Collectors.toSet());
    }
}
