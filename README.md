### NUMERO DE KEVIN BACON ###

##  Descripción de la actividad:

En este proyecto deberán desarrollar un programa que les permita calcular el **Número de Kevin Bacon**. El Número de Kevin Bacon de un actor o actriz es el grado de separación que tiene ese actor o actriz en el grafo inducido por las películas en la que los actores han compartido roles. El Número de Kevin Bacon (NKB) de Kevin Bacon es 0. Los actores que han protagonizado una película con Kevin Bacon tienen NKB=1, quienes han protagonizado con alguien con NKB=1, tentrán un NKB=2. El punto de este estudio es ver que no hay ningun actor / actriz que tenga un numero de Kevin Bacon mayor a 6 (Esta teoria se basa en la teoria de los 6 grados de distancia).

### Entrada: 
El formato del archivo que contiene los datos de entrada:

```
nombreActor_1|nombrePelícula_1
...
nombreActor_n| nombrePelícula_n

```

Los nombres de los actores y de las películas son únicos. 

### Salida: 
Para cada actor en la lista de autores [nombre] seguido de ':',seguido de su [Número de Kevin BACON].

- Los actores que con tienen ninguna relación con Kevin Baconen base a los datos del archivo de entrada tienen NKB=infinito. 

- Es decir, el formato de salida sera el siguiente: 
```
nombreActor_1 : NKB_1
...
nombreActor_N : NKB_N

```

##  Observaciones: 

- La carpeta tad_grafo: Contiene todas las implementaciones para grafos, tanto para Grafos no dirigidos, como para Grafios Dirigidos (Digrafos).

- Para resolver el problema del numero de Kevin Bacon, se realizo la implementacion de un Digrafo y tambien la del recorrido BFS.

- Para ejecutar el programa en VSC solo se debe dar al boton de "Run" y si se quiere hacer otras pruebas, el archivo imdb.small.txt ya esta programado para proveer los datos al programa, asi que si se quieren probar otros datos se puede modificar este archivo.

- Para ejecutar en linux se debe llamar al programa de la siguiente manera:
 
Para compilar: javac ./KevinBacon.java
Para ejecutar: \> java KevinBacon \<archivoEntrada\>

donde, \<archivoEntrada\> es el nombre de un archivo con la información como se describe en la sección **Entrada**

