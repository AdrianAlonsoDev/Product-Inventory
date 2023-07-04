package dev.adrianalonso.inventoryproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.adrianalonso.inventoryproduct.dto.ProductDTO;
import dev.adrianalonso.inventoryproduct.entity.Product;
import dev.adrianalonso.inventoryproduct.service.ProductService;
import dev.adrianalonso.inventoryproduct.util.ObjectMapperUtils;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/")
	public List<ProductDTO> getAllProducts() {
		return ObjectMapperUtils.mapAll(productService.findAllProducts(), ProductDTO.class);
	}

	@GetMapping(value = "/byProductName/{productName}")
	public ProductDTO getProductByProductName(@PathVariable("productName") String productName) {
		return ObjectMapperUtils.map(productService.findByProductName(productName), ProductDTO.class);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveOrUpdateProduct(@RequestBody ProductDTO productDTO) {
		productService.saveOrUpdateProduct(ObjectMapperUtils.map(productDTO, Product.class));
		return new ResponseEntity("Product added.", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{productName}")
	public ResponseEntity<?> deleteProductByProductName(@PathVariable String productName) {
		productService.deleteProductByName(productName);
		return new ResponseEntity("Product deleted.", HttpStatus.OK);
	}

}
