package ie.atu.cicd1.catalog.cicd1catalogservice.controller;

import ie.atu.cicd1.catalog.cicd1catalogservice.model.Product;
import ie.atu.cicd1.catalog.cicd1catalogservice.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }
}