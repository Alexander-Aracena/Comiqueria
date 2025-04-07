package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Editorial;
import com.minpay.Comiqueria.model.Subcategoria;
import lombok.Data;

@Data
public class ProductoDTO {
    private Long idProducto;
    private String titulo;
    private Double precio;
    private String descripcion;
    private String tapa;
    private String isbn;
    private int peso;
    private String dimensiones;
    private int paginas;
    private Subcategoria subcategoria;
    private Editorial editorial;
    private Boolean esNovedad;
    private Boolean esOferta;
    private Boolean esMasVendido;
    private Boolean index;

    public ProductoDTO() {
    }

    public ProductoDTO(Long idProducto, String titulo, Double precio, String descripcion, String tapa,
            String isbn, int peso, String dimensiones, int paginas, Subcategoria subcategoria,
            Editorial editorial, Boolean esNovedad, Boolean esOferta, Boolean esMasVendido, Boolean index) {
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tapa = tapa;
        this.isbn = isbn;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.paginas = paginas;
        this.subcategoria = subcategoria;
        this.editorial = editorial;
        this.esNovedad = esNovedad;
        this.esOferta = esOferta;
        this.esMasVendido = esMasVendido;
        this.index = index;
    }
    
    public ProductoDTO(String titulo, Double precio, String descripcion, String tapa, String isbn, int peso, String dimensiones, int paginas, Subcategoria subcategoria, Editorial editorial, Boolean esNovedad, Boolean esOferta, Boolean esMasVendido, Boolean index) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tapa = tapa;
        this.isbn = isbn;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.paginas = paginas;
        this.subcategoria = subcategoria;
        this.editorial = editorial;
        this.esNovedad = esNovedad;
        this.esOferta = esOferta;
        this.esMasVendido = esMasVendido;
        this.index = index;
    }
}
