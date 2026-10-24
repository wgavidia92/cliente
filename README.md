
# Devsu - Cliente API

RESTFul API para manipular informacion de clientes.


## Introduccion

Con esta API se puede consultar los clientes existentes en la base de datos.
Agregar o modificar informacion y eliminar clientes.

para mas detalles, consultar la documentacion de la API [aqui](./src/main/resources/api/openapi.yaml)

## Validacion

El projecto se puede ejecutar desde cualquier equipo y emplea una base de datos en memoria (H2).
Esto facilita la ejecucion del proyecto en ambientes de desarrollo y pruebas, aunque la informacion
almacenada es borrada de memoria cada vez que se reinicia.

Se recomienda usar Postman para importar la colleccion en formato JSON,
la cual ya se encuentra configurada para apuntar a un ambiente local (http://localhost/).

## Requerimientos

Este proyecto fue desarrollado usando las siguientes tecnologias y versiones:

> * JDK25
> * Gradle 9.8.1 | Embebido
> * Base de datos H2
> * Springboot 4.1.1
> * OpenApi Specification 3.0.3
> 
