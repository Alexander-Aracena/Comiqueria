package com.minpay.Comiqueria.utils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public static <T> Set<T> ordenarPorIds(Set<Long> ids, List<T> entities, Function<T, Long> getIdFunction) {
        // Convertimos la lista de entidades a un Map de ID -> Entidad
        Map<Long, T> entityMap = entities.stream()
            .collect(Collectors.toMap(getIdFunction, Function.identity()));

        // Creamos un Set respetando el orden de los IDs originales
        return ids.stream()
            .map(entityMap::get)
            .filter(Objects::nonNull) // Para evitar nulls si algún ID no existe
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
