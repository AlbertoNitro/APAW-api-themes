# Arquitectura de un mini API-Rest simulado
> Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código
> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

### Estado del código

[![Build Status](https://travis-ci.org/miw-upm/APAW-api-themes.svg?branch=develop)](https://travis-ci.org/miw-upm/APAW-api-themes)

[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=es.upm.miw:APAW-api-themes)](https://sonarcloud.io/dashboard/index/es.upm.miw:APAW-api-themes)

### Tecnologías necesarias
* Java
* Maven
* Eclipse
* GitHub
* Travis-ci
* Sonarcloud

### Importar el proyecto mediante Eclipse
1. Clonar mediante Eclipse este repositorio en la máquina local: https://youtu.be/rQNixJQQ25g
1. Importar el repositorio clonado: https://youtu.be/yYvD8ZJtWwI
1. Crear en Eclipse las ramas locales asociadas a las remotas

## Análisis
En la figura siguiente tenemos un diagrama de los diferentes paquetes y sus dependencias que intervienen el la arquitectura. Se ha simplificado para realizar una primera aproximación. Como se ha realizado una simulación, se ha incluido el paquete `http` para todas aquellas clases que intervienen en las peticiones HTTP.  
Esta arquitectura pretende ser un punto de partida, pero no es cerrada, dependerá de la características de la aplicación a desarrollar para elegir la más adecuada.

![api-architecture-simulation-analysis](https://github.com/miw-upm/APAW-api-themes/blob/develop/docs/api-architecture-simulation-analysis.png)
### Capa de Presentación
 Incluye los paquetes de **_recursos_** y _**excepciones**_. Su responsabilidad es recoger las peticiones de los clientes y devolver la vista, ambas utilizan los _**tdos**_ como envoltorio de los datos. Se debe validar todos los datos de la petición, y si se considera necesario, generar la respuestas con los errores detectados. También es su responsabilidad garantizar la seguridad del API.

En esta capa no se procesa la petición en sí, sino que se delega en _**capa de negocio**_. La respuesta de la capa de negocio se reenvía al cliente, y si la petición es incorrecta, se generan respuestas de error asociada. Se ha apostado por un control de errores mediante _excepciones_.

Las entradas y salidas de datos se realizan a través de los **_dtos_**, son clase sencillas cuya utilidad es transportar un conjunto de datos y facilitar las conversiones a JSON.

Excepcionalmente, en algunas peticiones, se podría plantear utilizar las entidades como trasporte de datos.

Su referencia a HTTP suele venir en parámetros de anotaciones.

### Capa de negocio
Incluye los paquetes de **_controladores_**. Su responsabilidad es llevar toda la lógica de negocio. Los datos ya viene validados, aunque pueden tener funcionalidades para comprobar aspectos del negocio, como si un ID existe... El acceso a operaciones sobre las bases de datos se delega en la **_capa de persistencia_**.

Se comunica con la capa anterior con los _**dtos**_, y con la capa siguiente a través de las _**entidades**_. Para construir un **_dto_** a partir de una o varias _**entidades**_, se delega en el **_dto_**, pero no lo hace directamente el controlador.

No tiene ninguna referencia a aspectos de HTTP.

### Capa de persistencia
Incluye los paquete de _**daos**_ y de _**servicios**_, aunque en esta primera aproximación no se han incluido servicios. Nos basamos en el patrón `DAO` para la persistencia.

## Diseño
En la figura siguiente tenemos un diagrama de los diferentes paquetes, con sus dependencias, y algunas clases que intervienen el la arquitectura de este ejemplo.

![api-architecture-simulation-design](https://github.com/miw-upm/APAW-api-themes/blob/develop/docs/api-architecture-simulation-design.png)

Todas las peticiones llegan al `Dispatcher`, basándose en el patrón `Front-Controller`, viniendo ya implementado por el _**framework**_. Tiene una dependencia alta con HTTP.

El `Dispatcher` delega en los diferentes recursos, cuya dependencia a HTTP se elimina, salvo ciertas excepciones. Su relación con HTTP se reduce a parámetros de las anotaciones de las clases. Los clases de recursos tienen dependencias con los controladores, pudiendo ser varios para poder delegar las diferentes peticiones.

###### Autor: Jesús Bernal Bermúdez U.P.M.
