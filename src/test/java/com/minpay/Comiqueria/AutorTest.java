package com.minpay.Comiqueria;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static com.minpay.Comiqueria.utils.TestsUtils.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AutorTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private static Long idAutor;
    private static Long idCategoria;
    private static Long idSubcategoria;
    private static Long idEditorial;
    private static String categoriaResponse;
    private static String subcategoriaResponse;
    private static String editorialResponse;

    @BeforeAll
    static void setup() {
        idAutor = null;
        idCategoria = null;
        idSubcategoria = null;
        idEditorial = null;
    }

    @BeforeEach
    void ensureAutorExists() throws Exception {
        if (idAutor == null) {
            String response = crearAutor("Juan", "Pérez");
            idAutor = extraerIdDeResponse(response);
        }
    }
    
    @BeforeEach
    void ensureSetProductosExists(TestInfo testInfo) throws Exception {
        String nombreTest = testInfo.getDisplayName();
        if(nombreTest.equals("shouldAddProductos") || nombreTest.equals("shouldDeleteProductos")) {
            if (idCategoria == null) {
                categoriaResponse = crearCategoria();
                idCategoria = extraerIdDeResponse(categoriaResponse);
            }
            
            if(idSubcategoria == null) {
                subcategoriaResponse = crearSubcategoria(categoriaResponse);
                idSubcategoria = extraerIdDeResponse(subcategoriaResponse);
            }
            
            if(idEditorial == null) {
                editorialResponse = crearEditorial();
                idEditorial = extraerIdDeResponse(editorialResponse);
            }
        }
    }

    @Test
    @Order(1)
    void shouldReturnAnAutor() throws Exception {
        mockMvc.perform(get("/autores/" + idAutor))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idAutor))
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.apellido").value("Pérez"))
                .andExpect(jsonPath("$.productos").isEmpty())
                .andExpect(jsonPath("$.fechaAlta").value(LocalDate.now().toString()));
    }

    @Test
    @Order(2)
    void shouldReturnAllAutores() throws Exception {
        mockMvc.perform(get("/autores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[" + (idAutor - 1) + "].id").value(idAutor))
                .andExpect(jsonPath("$[" + (idAutor - 1) + "].nombre").value("Juan"))
                .andExpect(jsonPath("$[" + (idAutor - 1) + "].apellido").value("Pérez"))
                .andExpect(jsonPath("$[" + (idAutor - 1) + "].productos").isEmpty())
                .andExpect(jsonPath("$[" + (idAutor - 1) + "].fechaAlta").value(LocalDate.now().toString()));
    }
    
    @Test
    @Order(3)
    void shouldEditAndReturnAutor() throws Exception {
        String autorCorregido = """
                                {
                                    "nombre": "Fernando",
                                    "apellido": "Solis"
                                }
                                """;

        mockMvc.perform(patch("/autores/" + idAutor)
                .contentType(MediaType.APPLICATION_JSON)
                .content(autorCorregido))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.nombre").value("Fernando"))
                .andExpect(jsonPath("$.apellido").value("Solis"));
    }

    @Test
    @Order(4)
    void shouldDeleteAnAutor() throws Exception {
        mockMvc.perform(delete("/autores/" + idAutor))
                .andExpect(status().isAccepted());
        
        // Intenta obtener el autor eliminado y verifica el 404
        mockMvc.perform(get("/autores/" + idAutor))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fechaBaja").value(LocalDate.now().toString()));
        
        idAutor = null;
    }

    @Test
    @Order(5)
    void shouldAddProductos() throws Exception {
        String productosJson = armarJsonProductos();
        agregarProductoMediantePost(idAutor, productosJson)
            .andExpect(status().isAccepted());
    }

    @Test
    @Order(6)
    void shouldDeleteProductos() throws Exception {
        String productosJson = armarJsonProductos();
        agregarProductoMediantePost(idAutor, productosJson);
        
        String actorJson = mockMvc.perform(get("/autores/productos/" + idAutor))
                .andReturn()
                .getResponse()
                .getContentAsString();
        Set<Long> idsProductos = new LinkedHashSet<>(JsonPath.read(actorJson, "$.productos[*].idProducto"));
        String idsProductosJson = objectMapper.writeValueAsString(idsProductos);
        
        mockMvc.perform(delete("/autores/productos/" + idAutor)
                .contentType(MediaType.APPLICATION_JSON)
                .content(idsProductosJson))
                .andExpect(status().isAccepted());
        
        mockMvc.perform(get("/autores/productos/" + idAutor))
                .andExpect(jsonPath("$.productos").isEmpty());
        
    }
    
    private ResultActions agregarProductoMediantePost(Long idAutorConProductos, String productosJson) throws Exception {
        return mockMvc.perform(post("/autores/productos/" + idAutorConProductos)
                .contentType(MediaType.APPLICATION_JSON)
                .content(productosJson));
    }
    
    private String crearAutor(String nombre, String apellido) throws Exception {
        String autorJson = String.format("""
                           {
                                "nombre": "%s",
                                "apellido": "%s"
                           }
                           """, nombre, apellido);
        return crearMediantePost(mockMvc, "/autores", autorJson, MediaType.APPLICATION_JSON);
    }
    
    private String crearCategoria() throws Exception {
        String nombreCategoria = "COMICS";
        return crearMediantePost(mockMvc, "/categorias", nombreCategoria, MediaType.TEXT_PLAIN);
    }
    
    private String crearSubcategoria(String categoriaResponse) throws Exception {
        String nombreSubcategoria = "USA";
        String subcategoriaJson = String.format(
                """
                {
                    "nombre":"%s",
                    "categoria":%s
                }
                """, nombreSubcategoria, categoriaResponse);
        return crearMediantePost(mockMvc, "/subcategorias", subcategoriaJson, MediaType.APPLICATION_JSON);
    }
    
    private String crearEditorial() throws Exception {
        String nombreEditorial = "OVNI PRESS DC";
        return crearMediantePost(mockMvc, "/editoriales", nombreEditorial, MediaType.TEXT_PLAIN);
    }
    
    private String armarJsonProductos() throws Exception {
        String producto1Json = String.format("""
                                                     {"titulo":"LA MUERTE DE SUPERMAN",
                                                     "precio":"1200",
                                                     "descripcion":"¡El evento épico que conmovió al mundo y cambió a superman para siempre! Doomsday,una criatura cuyo único propósito es la destrucción, ha aterrizado en la Tierra. La Liga de la Justicia hizo un valiente y desesperado intento por detenerlo, pero cuando la bestia se acercó a Metrópolis fue Superman quien respondió a la llamada para enfrentarlo. Y entonces sucedió lo impensable. El Hombre de Acero... ¡murió!",
                                                     "tapa": "https://tap-multimedia-1172.nyc3.digitaloceanspaces.com/productimage/18235/9789877245882.jpg?size=4&h=610",
                                                     "isbn": "978-987-724-588-2",
                                                     "peso": 383,
                                                     "dimensiones": "17x24",
                                                     "paginas": 224,
                                                     "subcategoria": %s,
                                                     "editorial": %s,
                                                     "esNovedad": 1,
                                                     "esOferta": 0,
                                                     "esMasVendido": 0,
                                                     "index": 0}""", subcategoriaResponse, editorialResponse);
        String responseProducto1 = crearMediantePost(mockMvc, "/productos", producto1Json, MediaType.APPLICATION_JSON);
        String producto2Json = String.format("""
                                                     {"titulo":"ACTION COMICS VOL. 01: SENDERO DE PERDICION",
                                                     "precio":"950",
                                                     "descripcion":"JUNTO A SU FAMILIA, EL HOMBRE DE ACERO ESCAPO A UNA NUEVA VERSION DE LA TIERRA Y ESTA LISTO PARA VOLVER A SER SUPERMAN. ¿EL PROBLEMA? LEX LUTHOR QUIERE SER EL NUEVO SUPERHEROE DE METROPOLIS, UN EXTRAÑO RECLAMA SER CLARK KENT, Y JUICIO FINAL REAPARECE DISPUESTO A DEJAR UN NUEVO SENDERO DE PERDICION.",
                                                     "tapa": "http://d3ugyf2ht6aenh.cloudfront.net/stores/001/184/069/products/action_comics_vol_01_cov_arg1-e971f540e4dabedada15952922634188-640-0.jpg",
                                                     "isbn": "978-84-17106-67-6",
                                                     "peso": 370,
                                                     "dimensiones": "17x24",
                                                     "paginas": 144,
                                                     "subcategoria": %s,
                                                     "editorial": %s,
                                                     "esNovedad": 0,
                                                     "esOferta": 0,
                                                     "esMasVendido": 0,
                                                     "index": 0}""", subcategoriaResponse, editorialResponse);
        String responseProducto2 = crearMediantePost(mockMvc, "/productos", producto2Json, MediaType.APPLICATION_JSON);
        Set<String> productos = new LinkedHashSet<>();
        productos.add(responseProducto1);
        productos.add(responseProducto2);
        return String.format("%s", productos);
    }
}
