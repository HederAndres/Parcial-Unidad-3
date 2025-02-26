package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un producto en el sistema.
 * Utiliza Lombok para reducir la cantidad de código boilerplate.
 */
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString.
@NoArgsConstructor // Genera un constructor sin argumentos.
public class Product {
    private String id;
    private String name;
    private Double price;

    /**
     * Constructor con parámetros para inicializar un producto.
     *
     * @param id    Identificador único del producto.
     * @param name  Nombre del producto.
     * @param price Precio del producto.
     */
    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Métodos getter y setter manuales (innecesarios si se usa @Data de Lombok).
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Nota: Hay una inconsistencia en los nombres de los métodos get/set de name y price.
    // Se usan "Nombre" y "Precio" en español en lugar de "Name" y "Price" en inglés.
    public String getNombre() { return name; }
    public void setNombre(String name) { this.name = name; }

    public Double getPrecio() { return price; }
    public void setPrecio(Double price) { this.price = price; }
}

