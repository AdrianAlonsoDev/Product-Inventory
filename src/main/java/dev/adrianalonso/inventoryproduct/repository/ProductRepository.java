package dev.adrianalonso.inventoryproduct.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.adrianalonso.inventoryproduct.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	Product findByProductName(String productName);

	List<Product> findAll();
}
