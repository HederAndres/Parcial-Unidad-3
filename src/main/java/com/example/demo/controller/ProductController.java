package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador REST para gestionar productos.
 * Proporciona endpoints para crear, obtener, actualizar y eliminar productos utilizando
 * programación reactiva con Project Reactor.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductController {
    private final ProductService productService;

    /**
     * Constructor que inyecta el servicio de productos.
     *
     * @param productService servicio de gestión de productos.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Crea un nuevo producto.
     *
     * @param product objeto del producto recibido en el cuerpo de la solicitud.
     * @return un Mono que representa el producto creado.
     */
    @PostMapping
    public Mono<Product> AddProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return un Flux que representa la lista de productos.
     */
    @GetMapping
    public Flux<Product> GetProducts() {
        return productService.getAllProducts();
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id identificador único del producto.
     * @return un Mono que representa el producto encontrado o vacío si no existe.
     */
    @GetMapping("/{id}")
    public Mono<Product> GetProductByID(@PathVariable String id) {
        return productService.getProductById(id);
    }

    /**
     * Actualiza un producto existente.
     *
     * @param id identificador único del producto a actualizar.
     * @param product objeto con los nuevos datos del producto.
     * @return un Mono que representa el producto actualizado.
     */
    @PutMapping("/{id}")
    public Mono<Product> UpdateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param id identificador único del producto a eliminar.
     * @return un Mono vacío que indica la finalización de la operación.
     */
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
