package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador REST para gestionar productos.
 * Proporciona endpoints para crear, obtener, actualizar y eliminar productos
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductService productService;

    public ProductoController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Crea un nuevo producto.
     */
    @PostMapping
    public Mono<Producto> AddProduct(@RequestBody Producto producto) {
        return productService.createProduct(producto);
    }

    /**
     * Obtiene la lista de todos los productos.
     */
    @GetMapping
    public Flux<Producto> GetProducts() {
        return productService.getAllProducts();
    }

    /**
     * Obtiene un producto por su ID.
     */
    @GetMapping("/{id}")
    public Mono<Producto> GetProductByID(@PathVariable String id) {
        return productService.getProductById(id);
    }

    /**
     * Actualiza un producto existente.
     */
    @PutMapping("/{id}")
    public Mono<Producto> UpdateProduct(@PathVariable String id, @RequestBody Producto producto) {
        return productService.updateProduct(id, producto);
    }

    /**
     * Elimina un producto por su ID.
     */
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
