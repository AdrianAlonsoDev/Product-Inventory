package dev.adrianalonso.inventoryproduct.service;

import java.util.List;

import dev.adrianalonso.inventoryproduct.model.Product;

public interface ProductService {

	List<Product> findAllProducts();

	Product findByProductName(String productName);

	Product saveOrUpdateProduct(Product product);

	void deleteProductByName(String productName);
}


