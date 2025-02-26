package com.example.demo.service;

import com.example.demo.model.Producto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Producto> productos = new ArrayList<>();

    public ProductService() {
        // Agregamos algunos productos de prueba
        productos.add(new Producto("1", "Laptop", 1200.0));
        productos.add(new Producto("2", "Mouse", 25.0));
        productos.add(new Producto("3", "Teclado", 45.0));
    }

    // Obtener todos los productos
    public Flux<Producto> getAllProducts() {
        return Flux.fromIterable(productos);
    }

    // Obtener un solo producto por ID
    public Mono<Producto> getProductById(String id) {
        return Mono.justOrEmpty(productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst());
    }

    // Crear un nuevo producto
    public Mono<Producto> createProduct(Producto producto) {
        Producto newProducto = new Producto(producto.getId(), producto.getNombre(), producto.getPrecio());
        productos.add(newProducto);
        return Mono.just(newProducto);
    }

    // Actualizar un producto
    public Mono<Producto> updateProduct(String id, Producto newProducto) {
        return getProductById(id)
                .flatMap(existingProducto -> {
                    existingProducto.setNombre(newProducto.getNombre());
                    existingProducto.setPrecio(newProducto.getPrecio());
                    return Mono.just(existingProducto);
                });
    }

    // Eliminar un producto
    public Mono<Void> deleteProduct(String id) {
        productos.removeIf(producto -> producto.getId().equals(id));
        return Mono.empty();
    }
}
