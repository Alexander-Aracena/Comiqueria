package com.minpay.Comiqueria.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String titulo;
    private Double precio;
    private String descripcion;
    private String tapa;
    private String isbn;
    private int peso;
    private String dimensiones;
    private int paginas;
    private Long idSubcategoria;
    private Long idEditorial;
    private Boolean esNovedad;
    private Boolean esOferta;
    private Boolean esMasVendido;
    private Boolean index;

    public ProductoDTO(Long idProducto, String titulo, Double precio, String descripcion, String tapa,
        String isbn, int peso, String dimensiones, int paginas, Long idSubcategoria,
        Long idEditorial, Boolean esNovedad, Boolean esOferta, Boolean esMasVendido, Boolean index) {
        this.id = idProducto;
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tapa = tapa;
        this.isbn = isbn;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.paginas = paginas;
        this.idSubcategoria = idSubcategoria;
        this.idEditorial = idEditorial;
        this.esNovedad = esNovedad;
        this.esOferta = esOferta;
        this.esMasVendido = esMasVendido;
        this.index = index;
    }

    public ProductoDTO(String titulo, Double precio, String descripcion, String tapa, String isbn,
        int peso, String dimensiones, int paginas, Long idSubcategoria,
        Long idEditorial, Boolean esNovedad, Boolean esOferta, Boolean esMasVendido, Boolean index) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tapa = tapa;
        this.isbn = isbn;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.paginas = paginas;
        this.idSubcategoria = idSubcategoria;
        this.idEditorial = idEditorial;
        this.esNovedad = esNovedad;
        this.esOferta = esOferta;
        this.esMasVendido = esMasVendido;
        this.index = index;
    }
}
