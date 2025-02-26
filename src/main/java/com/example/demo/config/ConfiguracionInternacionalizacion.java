package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Clase de configuración para la internacionalización en una aplicación Spring Boot.
 * Define un bean que gestiona los mensajes en diferentes idiomas.
 */
@Configuration
public class ConfiguracionInternacionalizacion {

    /**
     * Configura un MessageSource que se encarga de cargar los archivos de propiedades
     * con los mensajes de la aplicación para la internacionalización.
     *
     * @return una instancia de MessageSource configurada.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        // Define el nombre base de los archivos de mensajes (messages.properties, messages_es.properties, etc.)
        messageSource.setBasename("messages");

        // Especifica la codificación por defecto para los archivos de mensajes (UTF-8).
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}