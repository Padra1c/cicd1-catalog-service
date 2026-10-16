package ie.atu.cicd1.catalog.cicd1catalogservice.service;

import ie.atu.cicd1.catalog.cicd1catalogservice.dto.CreateProductRequest;
import ie.atu.cicd1.catalog.cicd1catalogservice.model.Category;
import ie.atu.cicd1.catalog.cicd1catalogservice.model.Product;
import ie.atu.cicd1.catalog.cicd1catalogservice.repository.CategoryRepository;
import ie.atu.cicd1.catalog.cicd1catalogservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    public Product createProduct(CreateProductRequest request) {
        if (request.categoryId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "categoryId is required");
        }
        Category category = categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Category does not exist"));
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return productRepository.findByMinPrice(minPrice);
    }

    public List<Product> getByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }
}
