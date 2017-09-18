package ru.venkispb.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.venkispb.server.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
