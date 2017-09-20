package ru.venkispb.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.venkispb.server.entity.Product;
import ru.venkispb.server.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/")
    public List<Product> getAll() {
        List<Product> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping(value = "/info")
    public Object getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("JDBC_DATABASE_USERNAME", System.getenv("JDBC_DATABASE_USERNAME"));
        map.put("JDBC_DATABASE_PASSWORD", System.getenv("JDBC_DATABASE_PASSWORD"));
        map.put("JDBC_DATABASE_URL", System.getenv("JDBC_DATABASE_URL"));
        return map;
    }


    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody Product product) {
        repository.save(product);
        return ResponseEntity.ok().build();
    }

}
