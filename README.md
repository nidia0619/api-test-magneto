# api-test-magneto
test project for Mercadolibre

Un resumen de la implementación, Para mayor información leer los archivos adjuntados en la carpeta /documentación.
1) Se utiliza arquitectura de microservicios 
2) El lenguaje utilizado para el desarrollo es JAVA con Framework Spring Boot
3) Se crea un controller con dos requestMapping (/stats: GET y /mutant: POST)
4) Se realiza una conexion a la Base de datos MySql donde se crearon dos SP y una tabla
5) Se hostear esa API en AWS.

URL de la API:
1) http://pruebaspring-env.eba-cfnhjmpq.us-east-2.elasticbeanstalk.com/stats (GET)
2) http://pruebaspring-env.eba-cfnhjmpq.us-east-2.elasticbeanstalk.com/mutant (POST)

Instrucciones de ejecución:
1) Ejecutar las anteriores URL por medido de cualquier ID que permita el consumo de peticiones HTTP REST. (POSTMAN)

Cosas para mejorar la implementación:


