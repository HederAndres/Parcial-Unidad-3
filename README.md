## Instrucciones para ejecutar la aplicación
1. Ingresar al enlace adjunto que lleva al Github donde se encuentra el código, esté se debe descargar.
2. Ingresar a IntelliJ, dar click en "Abrir" y buscar el repositorio.
3. buscar el archivo "ParcialApplication" dentro de src/main/java/com/example.
4. Dar click derecho en el archivo y seleccionar ejecutar "ParcialApplication.Main()"
## Evidencias
Endpoint para ver mensaje en español:
```
curl --location 'localhost:8080/api/saludo?lang=es'
```
![img.png](img.png)
Endpoint para ver mensaje en ingles:
```
curl --location 'localhost:8080/api/saludo?lang=en'
```
![img_1.png](img_1.png)
Endpoint para ver todos los productos disponibles:
```
curl --location 'localhost:8080/api/productos'
```
![img_2.png](img_2.png)
Endpoint para ver un producto:
```
curl --location 'localhost:8080/api/productos/1'
```
![img_3.png](img_3.png)
Endpoint para crear un producto:
```
curl --location 'localhost:8080/api/productos' \
--header 'Content-Type: application/json' \
--data '{
"id": "4",
"nombre": "Audifonos",
"precio": 560.99
}'
```
![img_4.png](img_4.png)
Endpoint para modificar un producto:
```
curl --location --request PUT 'localhost:8080/api/productos/1' \
--header 'Content-Type: application/json' \
--data '{
"nombre": "Laptop Lenovo",
"precio": 1850
}'
```
![img_5.png](img_5.png)
Endpoint para eliminar un producto:
```
curl --location --request DELETE 'localhost:8080/api/productos/3' \
--data ''
```
![img_6.png](img_6.png)
Resultado de los cambios:

![img_7.png](img_7.png)