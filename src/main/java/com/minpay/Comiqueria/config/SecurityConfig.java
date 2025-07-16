package com.minpay.Comiqueria.config;

import com.minpay.Comiqueria.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    
    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
            // Deshabilita la protección CSRF (Cross-Site Request Forgery)
            // ya que se asume que la aplicación es una API REST que usa JWT
            // y no sesiones basadas en cookies, lo que hace CSRF innecesario.
            .csrf(csrf -> csrf.disable())
            
            // Configura la gestión de sesiones para que sea sin estado (STATELESS).
            // Esto significa que Spring Security nunca creará una sesión HTTP ni la utilizará
            // para almacenar el contexto de seguridad, lo cual es ideal para JWT.
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // Configura las reglas de autorización para las solicitudes HTTP.
            .authorizeHttpRequests(authorize -> authorize
              
                // Permite el acceso sin autenticación a los endpoints de login y registro.
                .requestMatchers("/auth/**").permitAll()
                
                // Permite el acceso sólo para obtener información (GET)
                .requestMatchers(HttpMethod.GET, "/api/autores").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/productos").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/carrusel").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/editoriales").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/categorias").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/subcategorias").permitAll()
                
                // Cualquier otra solicitud HTTP debe estar autenticada.
                .anyRequest().authenticated()
            )
        
        // Configura el proveedor de autenticación que Spring Security usará
        .authenticationProvider(authenticationProvider)
        // Agrega tu filtro JWT ANTES del filtro estándar de autenticación por usuario/contraseña de Spring Security.
        // Esto es CRUCIAL: asegura que el JWT se procese primero para autenticar la petición.
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        
        // Construye y retorna la cadena de filtros de seguridad.
        return http.build();
    }
}
