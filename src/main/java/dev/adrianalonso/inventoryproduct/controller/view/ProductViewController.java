package dev.adrianalonso.inventoryproduct.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.adrianalonso.inventoryproduct.model.Product;
import dev.adrianalonso.inventoryproduct.service.ProductService;

@Controller
public class ProductViewController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products/list")
	public String getAllProducts(Model model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "products";
	}
}
