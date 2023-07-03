package dev.adrianalonso.inventoryproduct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adrianalonso.inventoryproduct.model.Product;
import dev.adrianalonso.inventoryproduct.repository.ProductRepository;
import dev.adrianalonso.inventoryproduct.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductByName(String productName) {
		String productId = productRepository.findByProductName(productName).getId();
		productRepository.deleteById(productId);
	}
}
