package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Agregamos algunos productos de prueba
        products.add(new Product("1", "Laptop", 1200.0));
        products.add(new Product("2", "Mouse", 25.0));
        products.add(new Product("3", "Teclado", 45.0));
    }

    // Obtener todos los productos (Flux)
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(products);
    }

    // Obtener un solo producto por ID (Mono)
    public Mono<Product> getProductById(String id) {
        return Mono.justOrEmpty(products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst());
    }

    // Crear un nuevo producto (Mono)
    public Mono<Product> createProduct(Product product) {
        Product newProduct = new Product(product.getId(), product.getName(), product.getPrice());
        products.add(newProduct);
        return Mono.just(newProduct);
    }

    // Actualizar un producto (Mono)
    public Mono<Product> updateProduct(String id, Product newProduct) {
        return getProductById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setNombre(newProduct.getNombre());
                    existingProduct.setPrecio(newProduct.getPrecio());
                    return Mono.just(existingProduct);
                });
    }

    // Eliminar un producto (Mono<Void>)
    public Mono<Void> deleteProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
        return Mono.empty();
    }
}
