package ie.atu.cicd1.catalog.cicd1catalogservice.service;

import ie.atu.cicd1.catalog.cicd1catalogservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextd = 1;

    public List<Product> getAll() {
        return products;
    }

    public Product create(Product product) {
        product.setId(nextd++);
        products.add(product);
        return product;
    }
}
