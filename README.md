# microservices
Microservices with Spring Boot and Spring Cloud Netflix Eureka


Basic Microservices Structure

-----------
(solo para Item)
+ Feign (Lib para comunicación entre microservicios - Original de Netflix) 
Interface/Feign client: ProductRestClient
Servicio: ItemService (item-service)
    Implementación: ItemServiceFeignImpl

-----------
MS Items (consume product-service para recuperar los productos) 
Modelos: Product, Item
Servicio: ItemService (item-service)
    Implementación: ItemServiceImpl
Controlador Rest: ItemController
Clase de configuración: AppConfig
Puerto: 8002

-----------
JPA (solo para Productos)
Datos de ejemplo: /spring-boot-service-products/src/main/resources/import.sql

-----------
MS Base - Product
Entity: Product
DAO: ProductDao
Servicio: ProductoService (product-service)
    Implementación: ProductoServiceImpl
Controlador Rest: ProductoController
Puerto: 8001
