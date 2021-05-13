# microservices
Microservices with Spring Boot and Spring Cloud Netflix Eureka


I - Basic Microservices Structure

-----------
+ Ribbon con anotación @LoadBalanced
+ Ribbon (Balanceo de Carga)
(solo para Item)
    Levantando dos instancias de servicio producto: -Dserver.port=9001
    Instancia 1: 8001
    Instancia 2: 9001

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
