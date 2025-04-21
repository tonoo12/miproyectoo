package com.example.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Configuración de seguridad
        //         http.csrf(csrf -> csrf.disable())
        //                         .authorizeHttpRequests(auth -> auth
        //                                         .requestMatchers("/css/**", "/Js/**", "/images/**", "/", "/camisas", 
        //                                         "/gorras", "/pantalones", "/poleras", "/polos", "/prototipo", "/zapatillas", "/error404", "/api/productos",
        //                                         "/api/categorias")
        //                                         .permitAll())
        //                                         .exceptionHandling(ex -> ex.accessDeniedPage("/error404"));   
        // return http.build();
        
        // Configuracion para insertar sin que salga error 403(prohibido)
        http.csrf().disable()
            .authorizeHttpRequests()
            .anyRequest().permitAll();

        return http.build();
    
    }
}