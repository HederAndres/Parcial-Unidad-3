package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Controlador REST para gestionar saludos internacionalizados.
 * Permite obtener un saludo en diferentes idiomas según el parámetro de consulta "lang".
 */
@RestController
@RequestMapping("/api")
public class SaludoController {

    // Inyección de la fuente de mensajes para la internacionalización
    @Autowired
    private MessageSource messageSource;

    /**
     * Endpoint para obtener un saludo en el idioma especificado.
     *
     * @param lang Código de idioma opcional pasado como parámetro de consulta (por defecto "es").
     * @return Un mensaje de saludo en el idioma solicitado.
     */
    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestParam(name = "lang", defaultValue = "es") String lang) {
        // Crea un objeto Locale basado en el parámetro de idioma recibido
        Locale locale = new Locale(lang);

        // Obtiene el mensaje de saludo desde los archivos de mensajes según el idioma
        return messageSource.getMessage("saludo", null, locale);
    }
}
