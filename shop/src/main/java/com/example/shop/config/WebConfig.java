package com.example.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @SuppressWarnings("null")
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/inicio", "/");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/administrador").setViewName("administrador");
        registry.addViewController("/camisas").setViewName("camisas");
        registry.addViewController("/gorras").setViewName("gorras");
        registry.addViewController("/pantalones").setViewName("pantalones");
        registry.addViewController("/poleras").setViewName("poleras");
        registry.addViewController("/polos").setViewName("polos");
        registry.addViewController("/prototipo").setViewName("prototipo");
        registry.addViewController("/zapatillas").setViewName("zapatillas");
    }
}
