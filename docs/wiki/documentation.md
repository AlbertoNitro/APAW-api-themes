# Introducción
> Gestión de las votaciones de temas de interés

## Entities
A continuación presentamos el diagrama de clases del paquete de entidades:  
![api-architecture-simulation-theme-entities](https://github.com/miw-upm/APAW-api-themes/blob/develop/docs/api-architecture-simulation-theme-entities.png)

Esta aplicación permitirá crear temas de interés por los usuarios y realizar votaciones de los temas existentes.

# API Rest
## Crear un nuevo tema `POST /themes` 
> Admite varias veces el mismo tema, pero no llamadas sin tema o con tema vacío

Ejemplo: `POST /themes  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`themeName: String` Nombre del tema | `CREATED (201)` | `BAD_REQUEST(400) {"error"="ThemeFieldInvalidException"}`

## Lee un tema `GET /themes/{id}`  
Ejemplo: `GET /themes/2`

Parámetros | Respuesta | Respuesta si<br>_id_ no existe<br>_id_ no entero
--|--|--
-- | `OK (200) {"id"=2,"name"="Informática"}` | `BAD_REQUEST(400)`<br> `{"error"="ThemeIdNotFoundException"}`<br>`{"error"="RequestInvalidException"}`

## Media de los votos de un tema `GET /themes/{id}/overage`  
> Si no hay votaciones devuelve NaN

Ejemplo: `GET /themes/2/overage`

Parámetros | Respuesta | Respuesta si<br>_id_ no existe<br>_id_ no entero
--|--|--
-- | `OK (200) {2.51}` | `BAD_REQUEST(400)`<br> `{"error"="ThemeIdNotFoundException"}`<br>`{"error"="RequestInvalidException"}`

## Lista de los votos de un tema `GET /themes/{id}/votes`  
Ejemplo: `GET /themes/2/votes`

Parámetros | Respuesta | Respuesta si<br>_id_ no existe<br>_id_ no entero
--|--|--
-- | `OK (200) {{"id"=2,"name"="Informática"},[3,5,7]}}` | `BAD_REQUEST(400)`<br> `{"error"="ThemeIdNotFoundException"}`<br>`{"error"="RequestInvalidException"}`

## Vota un tema `POST /themes`  
Ejemplo: `POST /votes  {1:4}`

Entrada | Respuesta | Respuesta si<br>_themeId_ no existe<br>_vote_<0 o _vote_>10
--|--|--
`themeId: int` id del tema <br>`vote: int` voto | `CREATED (201)`|`BAD_REQUEST(400)`<br> `{"error"="ThemeIdNotFoundException"}`<br>` {"error"="VoteInvalidException"}`

## Lista de los votos `GET /votes`  

Parámetros| Respuesta 
--|--
-- | `OK (200) [{"themeName"="Informática","voteValue"=3},{"themeName"="Ocio","voteValue"=10}]`
