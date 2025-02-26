package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Permite obtener un saludo en diferentes idiomas.
 */
@RestController
@RequestMapping("/api")
public class SaludoController {

    @Autowired
    private MessageSource messageSource;

    /**
     * Sirve para obtener un saludo en el idioma especificado.
     */
    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestParam(name = "lang", defaultValue = "es") String lang) {
        Locale locale = new Locale(lang);

        // Obtiene el mensaje de saludo desde los archivos de mensajes según el idioma
        return messageSource.getMessage("saludo", null, locale);
    }
}
