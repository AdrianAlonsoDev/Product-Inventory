#### Lenguaje > ES/es·![image](https://github.com/AdrianAlonsoDev/Product-Inventory/assets/6146371/2fcce1b9-6e3c-48d3-893f-310a0e5d959c) | Others: [US/en·![image](https://raw.githubusercontent.com/DavideViolante/Wikipedia-Flag-Icons/master/Chrome%20Extension/WikipediaFlagIcons/flags/us.png)](https://github.com/AdrianAlonsoDev/Product-Inventory/blob/main/README.md) 

## Product Inventory
Pequeño proyecto web desarrollado en [Spring Boot](https://spring.io/projects/spring-boot) <img src="https://s12.gifyu.com/images/SQGEq.png" width="20" height="20"> para demostrar los fundamentos de los microservicios. Utiliza REST para crear una sencilla aplicación de inventario de productos.

## Tecnologías
- Spring Boot: Web + MongoDB & Maven.
- REST: Integración de la arquitectura API RESTful y comunicación con el sistema de inventario de productos.
- [MongoDB (Atlas)](https://www.mongodb.com/atlas/database): Base de datos Cloud NoSQL
<img src="https://s12.gifyu.com/images/SQGEp.png" width="420" height="320">

## Características de codigo
Configuración: Java 17+, Maven, Mongo DB
- **Operaciones CRUD**: Compatibilidad total con las operaciones de creación, lectura, actualización y eliminación del inventario de productos.
- **MongoDB como BD NoSQL**: Utilizando MongoDB puedes aventajarte de extender tu repositorio {tipo} con [MongoRepository](https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html), para obtener una generación automática de consultas basada en convenciones de nomenclatura.

Ejemplo ([ProductRepository.java](https://github.com/AdrianAlonsoDev/Product-Inventory/blob/main/src/main/java/dev/adrianalonso/inventoryproduct/repository/ProductRepository.java)):
```java
public interface ProductRepository extends MongoRepository<Product, String>
```
- **Separación de preocupaciones**: La clase Product representa la entidad persistente almacenada en la base de datos, mientras que la clase ProductDTO es un objeto de transferencia de datos utilizado para comunicarse con otras capas de la aplicación.
- **Mapeo de datos**: Utilizing [ModelMapper](https://modelmapper.org/getting-started/) para asignar fácilmente los campos entre las clases Product y ProductDTO, lo que puede ayudar a conseguir un control preciso sobre los datos que se exponen y transfieren en la API.

Ejemplo ([ProductController.java](https://github.com/AdrianAlonsoDev/Product-Inventory/blob/main/src/main/java/dev/adrianalonso/inventoryproduct/controller/ProductController.java#L35)):
```java
@GetMapping(value = "/byProductName/{productName}")
public ProductDTO getProductByProductName(@PathVariable("productName") String productName) {
    return ObjectMapperUtils.map(productService.findByProductName(productName), ProductDTO.class);
}
```

## REST API Endpoints
| Método HTTP | Endpoint                    | Descripcion                                |
|-------------|-----------------------------|--------------------------------------------|
| GET         | `/`                         | Recupera todos los productos del inventario.   |
| GET         | `/byProductName/{productName}` | Recupera un producto por su nombre.         |
| POST        | `/save`                     | Guarda o actualiza un producto en la colección (documento). |
| DELETE      | `/delete/{productName}`     | Elimina un producto por su nombre. |

## Demostración
### GET -> `/products/`
![GET /products/](https://s11.gifyu.com/images/SQGTy.gif)
### GET -> `/products/byProductName/{productName}`
![GET /products/byProductName](https://s11.gifyu.com/images/SQGTJ.gif)
### POST -> `/products/save`
![GET /products/save](https://s12.gifyu.com/images/SQGwD.gif)
### DELETE -> `/products/delete/{productName}`
![GET /products/delete/](https://s11.gifyu.com/images/SQGwB.gif)

fin.
