package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un producto.
 */
@Data
@NoArgsConstructor
public class Producto {
    private String id;
    private String nombre;
    private Double precio;

    public Producto(String id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos getter y setter manuales
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String name) { this.nombre = name; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double price) { this.precio = price; }
}

