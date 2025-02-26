package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Clase de configuración para la internacionalización.
 * Gestiona los mensajes en diferentes idiomas.
 */
@Configuration
public class ConfiguracionInternacionalizacion {

    /**
     * Configura un MessageSource que se encarga de cargar los archivos de propiedades
     * con los mensajes de la aplicación para la internacionalización.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        // Define el nombre base de los archivos de mensajes.
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}