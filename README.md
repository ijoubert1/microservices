# microservices
Microservices with Spring Boot and Spring Cloud Netflix Eureka
-----------
-----------

VIII - Trazabilidad distribuída
-----------
Sleuth dependency for 
zuul-server-service, item-service, oauth-service, product-service, user-service

-----------
SpanId: Seguimiento individual dentro de un microservicio
TraceId: Representa todo el recorrido de la petición a través de los distintos microservicios

-----------
Servidor Zipkin (Servidor para guardar las trazas y permite monitorizarlas)
Spring Cloud Sleuth (Dependencia para trazabilidad distribuída)

-----------
-----------

VII - MySql
-----------
PENDING - Actualizar repo item-service-config de github como privado

-----------
POSTGRES - PENDING
BD: db_springboot_cloud
Servicio: usuario-service

-----------
MYSQL
BD: db_springboot_cloud
Servicio: product-service
(Actualizado para conectarse al servidor de configuración)

-----------
-----------

VI - Spring Cloud Security

-----------
Validación de intentos

-----------
Manejo de eventos en la autenticación
Éxito, fracaso

-----------
Cors: Intercambio de recursos de origen cruzado

-----------
Oauth and Zuul as clients of config-server-service

-----------
Zuul as Resource Config Server

-----------
Servicio: oauth-service
Port: 9020
Se comunica con user-service a través de Feign Rest Client
Implementa UserDetailsService

-----------
Lib: users-common-service

-----------
Spring Security (FW de seguridad, ofrece autenticación y autorización (ACL))
Json Web Token (JWT) (Estándar abierto para implementar seguridad en aplicaciones API Rest)

-----------
Repositorio Rest para el CRUD
Queries personalizados

-----------
JPA for queries

-----------
Tables: users, roles, users_roles
Servicio: user-service

-----------
-----------

V - Common
-----------
Exclude autoconfiguration for datasource class

-----------
ijoubert@NTBK-TECH834:~/Documentos/CursosUdemy/Microservicios/microservices/spring-boot-service-commons$ mvnw install

-----------
JAVA_HOME: /usr/lib/jvm/java-11-oracle
PATH: /usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/usr/lib/jvm/java-11-oracle:/usr/share/maven/bin

-----------
Servicio: common-service

-----------
-----------

IV - CRUD
-----------
Product CRUD
GET - List
POST - Create
PUT - Update
DELETE - Delete

-----------
-----------

III - Spring Cloud Config Server
-----------
+Refresh Scope (item)
Actuator

-----------
+Profiles (item)
Default
Dev
Prod

-----------
Servicio: item-service
Type: Config client
File: bootstrap.properties

-----------
Config repo:
/home/ijoubert/Escritorio/config
File: item-service.properties

-----------
Servicio: config-server-service
Type: Config Server
Port: 8888

-----------
-----------

II - Eureka Server (Servidor de Registro)
-----------
+ Zuul (Enrutamiento dinámico, filtros pre/post, Latencia, entre otros)
Servicio: zuul-server-service
Type: Eureka Client, Zuul Server
Port: 8090

-----------
+ Hystrix (libreria para tolerancia a fallos, latencia)

-----------
Escalando servicios
product-service: dynamic ports

-----------
Servicios: item-service, product-service
Type: Eureka Clients
product-service
  Instancia 1: 8001
  Instancia 2: 9001
item-service: 8002 (fijo por ser el endpoint)

-----------
+ JAXB

Servicio: eureka-server-service
Type: Eureka Server
Port: 8761 (default)

-----------
-----------

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
