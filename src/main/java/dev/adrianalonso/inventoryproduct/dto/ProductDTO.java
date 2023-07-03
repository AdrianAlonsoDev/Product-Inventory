package dev.adrianalonso.inventoryproduct.dto;

public class ProductDTO {

	private String id;
	private String productName;
	private String description;
	private double price;
	private int stock;

	public ProductDTO() {
	}

	public ProductDTO(String id, String productName, String description, double price, int stock) {
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
