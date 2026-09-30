package com.minpay.Comiqueria.repository.specification;

import com.minpay.Comiqueria.model.EstadoVenta;
import com.minpay.Comiqueria.model.LineaVenta;
import com.minpay.Comiqueria.model.Producto;
import com.minpay.Comiqueria.model.Venta;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class ProductoSpecifications {

    public static Specification<Producto> byCriterios(List<Long> ids, String titulo, BigDecimal minPrecio,
        BigDecimal maxPrecio, String descripcion, Long idAutor, Long idSubcategoria, Long idEditorial,
        Boolean esNovedad, Boolean esVisibleEnHome, Boolean esOferta, Boolean productosMasVendidos) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (ids != null && !ids.isEmpty()) {
                predicates.add(root.get("id").in(ids));
            }
            if (titulo != null && !titulo.trim().isEmpty()) {
                predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%"
                    )
                );
            }
            if (minPrecio != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("precio"), minPrecio));
            }
            if (maxPrecio != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("precio"), maxPrecio));
            }
            if (descripcion != null && !descripcion.trim().isEmpty()) {
                predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("descripcion")),
                        "%" + descripcion.toLowerCase() + "%"
                    )
                );
            }
            if (idAutor != null) {
                predicates.add(criteriaBuilder.equal(root.get("autor").get("id"), idAutor));
            }
            if (idSubcategoria != null) {
                predicates.add(criteriaBuilder.equal(root.get("subcategoria").get("id"), idSubcategoria));
            }
            if (idEditorial != null) {
                predicates.add(criteriaBuilder.equal(root.get("editorial").get("id"), idEditorial));
            }
            if (Boolean.TRUE.equals(esNovedad)) {
                predicates.add(criteriaBuilder.equal(root.get("esNovedad"), esNovedad));
            }
            if (Boolean.TRUE.equals(esVisibleEnHome)) {
                predicates.add(criteriaBuilder.equal(root.get("esVisibleEnHome"), esVisibleEnHome));
            }
            if (Boolean.TRUE.equals(esOferta)) {
                predicates.add(
                    criteriaBuilder.and(
                        criteriaBuilder.isNotNull(root.get("descuento")),
                        criteriaBuilder.greaterThan(root.get("descuento"), BigDecimal.ZERO)
                    )
                );
            }
            if (Boolean.TRUE.equals(productosMasVendidos)) {
                Join<Producto, LineaVenta> lineaVenta
                    = root.join("lineasVenta", JoinType.LEFT);

                Join<LineaVenta, Venta> venta
                    = lineaVenta.join("venta", JoinType.LEFT);

                Expression<Integer> cantidadVendida
                    = criteriaBuilder.sum(
                        criteriaBuilder.<Integer>selectCase()
                            .when(
                                criteriaBuilder.equal(
                                    venta.get("estado"),
                                    EstadoVenta.ENTREGADA
                                ),
                                lineaVenta.get("cantidad")
                            )
                            .otherwise(0)
                    );

                query.groupBy(root.get("id"));

                query.orderBy(
                    criteriaBuilder.desc(cantidadVendida)
                );
            }
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
