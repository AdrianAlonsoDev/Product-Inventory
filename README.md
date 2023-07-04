# Product Inventory
Small web project developed in [Spring Boot](https://spring.io/projects/spring-boot) <img src="https://s12.gifyu.com/images/SQGEq.png" width="20" height="20"> that utilizes REST for creating a simple product inventory application.

## Technologies
- Spring Boot: Web + Lombok
- REST: RESTful API architecture integration and communication with the product inventory system.
- [MongoDB (Atlas)](https://www.mongodb.com/atlas/database): Cloud NoSQL database
<img src="https://s12.gifyu.com/images/SQGEp.png" width="420" height="320">
![Mongo DB Panel](https://s12.gifyu.com/images/SQGEp.png)
## Technical Features
Configuration: Java 17=, Maven, Mongo DB
- **CRUD Operations**: Full support for Create, Read, Update, and Delete operations on the product inventory.
- **MongoDB as NOSQL DB**: When using a Mongo database you can take advantage of setting up your repository extending of [MongoRepository](https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html), to get automatic query generation based on naming conventions.
Example (`ProductRepository.java`):
```java
public interface ProductRepository extends MongoRepository<Product, String>
```
- **Separation of Concerns**: The Product class represents the persistent entity stored in the database, while the ProductDTO class is a data transfer object used to communicate with other layers of the applicationinventory.
- **Data Mapping**: Utilizing [ModelMapper](https://modelmapper.org/getting-started/) to easily map the fields between the Product and ProductDTO classes. (Achieves precise control over the data that is exposed and transferred in the API.)
Example (`ProductController.java`):
```java
@GetMapping(value = "/byProductName/{productName}")
	public ProductDTO getProductByProductName(@PathVariable("productName") String productName) {
		return ObjectMapperUtils.map(productService.findByProductName(productName), ProductDTO.class);
	}
```

## REST API Endpoints
| HTTP Method | Endpoint                    | Description                                |
|-------------|-----------------------------|--------------------------------------------|
| GET         | `/`                         | Retrieves all products in the inventory.   |
| GET         | `/byProductName/{productName}` | Retrieves a product by its name.         |
| POST        | `/save`                     | Saves or updates a product in the inventory. |
| DELETE      | `/delete/{productName}`     | Deletes a product from the inventory by its name. |

## Demonstration
### GET -> `/products/`
![GET /products/](https://s11.gifyu.com/images/SQGTy.gif)
### GET -> `/products/byProductName/{productName}`
![GET /products/byProductName](https://s11.gifyu.com/images/SQGTJ.gif)
### POST -> `/products/save`
![GET /products/save](https://s12.gifyu.com/images/SQGwD.gif)
### DELETE -> `/products/delete/{productName}`
![GET /products/delete/](https://s11.gifyu.com/images/SQGwB.gif)

end.
