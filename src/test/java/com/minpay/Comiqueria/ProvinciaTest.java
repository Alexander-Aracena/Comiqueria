package com.minpay.Comiqueria;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static com.minpay.Comiqueria.utils.TestsUtils.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@TestMethodOrder(OrderAnnotation.class)
public class ProvinciaTest {
    @Autowired
    private MockMvc mockMvc;
    
    private static Long idProvincia;
    private static String provinciaResponse;

    @BeforeAll
    static void setup() {
        idProvincia = null;
    }

    @BeforeEach
    void ensureProvinciaExists() throws Exception {
        if (idProvincia == null) {
            String nombreProvincia = "Buenos Aires";
            provinciaResponse = crearMediantePost(mockMvc, "/provincias", nombreProvincia, MediaType.TEXT_PLAIN);
            idProvincia = extraerIdDeResponse(provinciaResponse);
        }
    }
    
    @Test
    @Order(1)
    void shouldReturnAProvincia() throws Exception {
        mockMvc.perform(get("/provincias/" + idProvincia))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idProvincia))
                .andExpect(jsonPath("$.nombre").value("Buenos Aires"))
                .andExpect(jsonPath("$.localidades").isArray())
                .andExpect(jsonPath("$.localidades").isEmpty())
                .andExpect(jsonPath("$.pais").isEmpty());
    }
    
    @Test
    @Order(2)
    void shouldReturnAllProvincias() throws Exception {
        mockMvc.perform(get("/provincias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[" + (idProvincia - 1) + "].id").value(idProvincia))
                .andExpect(jsonPath("$[" + (idProvincia - 1) + "].nombre").value("Buenos Aires"))
                .andExpect(jsonPath("$[" + (idProvincia - 1) + "].localidades").isArray())
                .andExpect(jsonPath("$[" + (idProvincia - 1) + "].localidades").isEmpty())
                .andExpect(jsonPath("$[" + (idProvincia - 1) + "].pais").isEmpty());
    }
    
    @Test
    @Order(3)
    void shouldCreateAndReturnProvincia() throws Exception {
        // Crea un JSON representando un autor
        String nombreProvincia = "Tucumán";

        // Realiza una petición POST al controlador
        mockMvc.perform(post("/provincias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(nombreProvincia))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombre").value("Tucumán"))
                .andExpect(jsonPath("$.localidades").isEmpty())
                .andExpect(jsonPath("$.pais").isEmpty());
    }

    @Test
    @Order(4)
    void shouldEditAndReturnProvincia() throws Exception {
        String provinciaCorregidaJson = "Santa Fe";

        mockMvc.perform(patch("/provincias/" + idProvincia)
                .contentType(MediaType.TEXT_PLAIN)
                .content(provinciaCorregidaJson))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.nombre").value("Santa Fe"));
    }

    @Test
    @Order(5)
    void shouldDeleteAProvincia() throws Exception {
        mockMvc.perform(delete("/provincias/" + idProvincia))
                .andExpect(status().isAccepted());

        // Intenta obtener la pais eliminada y verifica el 404
        mockMvc.perform(get("/provincias/" + idProvincia))
                .andExpect(status().isNotFound());
    }
}
