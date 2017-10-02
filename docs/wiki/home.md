# APAW. Práctica ECP2: Desarrollo de un mini API-Rest simulado a partir de un modelo de entidades
> Este proyecto pretende ser un ejemplo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código.  
> El modelo de entidades ha sido indicado en la retroalimentación de la práctica ECP1
> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

## Proceso de trabajo
> Se utilizará el **flujo de trabajo ramificado**

Por cada fase, se crearán **issues** (mínimo uno por fase) con su descripción en la wiki de manera concisa. Sería suficiente una sola página organizada por capítulos.  
Se podrá copiar o adaptar cualquier clase de este mismo repositorio, pero siempre se deberá utilizar un léxico relacionado con el modelo de entidades dado en la retroalimentación de la práctica ECP1.  
También se podrá copiar cualquier clase desarrollada en la práctica ECP1.

## Fases del Ejercicio
### Fase 0: Preparación del proyecto
1. Creación del proyecto base. Nombre del proyecto: __APAW-ECP2-***__, siendo *** el nombre y apellido del alumno
1. Se subirá a **GitHub** y se conectara con **Travis-CI** para la integración continua y con **Sonarcloud** para el análisis del código

### Fase 1 **(+3)**: Definición del API Rest e implementación del dispatcher con los DTOs
1. Definición de los **recursos** en la wiki. Se detallarán las peticiones con los valores enviado y devueltos, los estados devueltos con sus códigos y las posibles excepciones provocadas
1. Copia del **paquete http** para la simulación de http, se puede localizar en este mismo repositorio
1. Programación de los **Test de Funcionalidad**
1. Programación del **Dispatcher**. Dependiendo de los recursos, devolverá valores fijos para pasar los test

### Fase 2 **(+3)**: Desarrollo de los paquetes _resources_ & _resources.exception_
1. Implementación de los paquetes de los recursos y las excepciones. 
1. Se realizará el control de datos de las diferentes peticiones con las excepciones necesarias para aquellos casos de error
1. Se conectará el Dispatcher con los diferentes métodos de las clases de recursos. Los recursos devolverán valores fijos para superar los test

### Fase 3 **(+4)**: Desarrollo de los paquetes _controllers_, _entities_ & _daos_
1. Implementación de las entidades con algún test unitario
1. Implementación de los daos. Se podrán copiar de este mismo repositorio
1. Ampliación de los DTOs para que se construyan a partir de entidades con sus test unitarios
1. Programación de los controladores con sus test de integración
1. Conectar el paquete de recursos con el paquete de controladores y superar los test de funcionalidad

### Repetir las Fases 1 a Fase 3, hasta que haya un mínimo de seis peticiones diferentes

### Criterios de evaluación
* Fase 1: **3 puntos**
* Fase 2: **3 puntos**
* Fase 3: **4 puntos**

Dentro de cada fase, la nota se obtendrá según el cumplimiento, calidad del proceso y resultado entregado.

### Suerte chic@s!!!