###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U3P05 - Acceso a archivos en PHP
#### Entrega de: *pon aquí tu nombre*
----
#### 1. Descripción:

Esta práctica tiene dos partes:

* En la primera haremos diferentes pruebas para aprender a leer, escribir y borrar archivos en PHP. Utilizaremos el mismo texto de ejemplo que en los apuntes (un listado de módulos).
* En la segunda tendrás que crear una aplicación web sencilla que maneja archivos.

#### 2. Formato de entrega:

Incluye en este u otro documento capturas que documenten tu trabajo.

#### 3. Trabajo a realizar:

##### Parte 1: Gestión de archivos con PHP

* Comprobación previa: en *Window > Preferences > General > Content types* escoge *Text* y comprueba que aparece *UTF-8* como codificación de caracteres por defecto para los archivos de texto. Si no lo hiciste antes y no aparece, debes escribirlo y hacer clic en *Aplicar*.
* Crea un nuevo proyecto PHP en Eclipse, llamado U3P05-PHP-Archivos
* Crea una carpeta *files* en la estructura de proyecto: nos acostumbraremos a crear siempre una carpeta con este nombre cuando manejemos archivos
* Crea en la carpeta *files* un archivo *modulos.txt* en el que escribas los módulos en los que estás matriculado (un módulo por línea)
* Crea un archivo *index.php* en el que iremos haciendo pruebas de lectura y escritura (incluye captura del resultado para cada prueba). Define en el archivo la estructura básica del documento HTML de salida, y almacena en una variable la ruta del archivo:

```php
<!DOCTYPE html>
<html><head><meta charset='UTF-8'/></head>
<body>
<?php
$rutaArchivo = "files/modulos.txt";
// Pruebas
?>
</body></html>
```
* Prueba la forma más rápida y sencilla de leer un archivo: volcaremos el resultado en pantalla.

```php
readfile("files/modulos.txt");
```
* Lee ahora las líneas del archivo a un array:

```php
$lineasArchivo = file($rutaArchivo);
print_r($lineasArchivo);
```
* Muestra todo el archivo sin separación de líneas:

```php
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
echo fread($archivo,filesize($rutaArchivo));
fclose($archivo);
```
* Muestra todas las líneas del archivo

```php
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
  echo fgets($archivo) . "<br/>";
}
fclose($archivo);
```
* Lee ahora carácter a carácter, detectando fin de línea

```php
$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
	$c = fgetc($archivo);
	if (($c == "\n") or ($c == "\r\n")) echo "<br/>";
	else echo $c;
}
fclose($archivo);
```
* Ahora vamos a realizar pruebas de escritura. Antes de comenzar debes hacer dos tareas previas:
  * Haz una copia del archivo *modulos.txt*, o bien copia su contenido en un editor de texto que dejarás abierto: en las pruebas de escritura sufrirá cambios y queremos poder recuperar su contenido original.
  * Ten a mano el código para mostrar todas las líneas del archivo (ver apuntes). Lo utilizaremos después de nuestras pruebas para ver el resultado. Puede ser buena idea que lo conviertas en función para invocarlo más cómodamente.

* Abre el archivo para escritura, y escribe el nombre de dos módulos de primero:

```php
$archivo = fopen($rutaArchivo, "w") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
fclose($archivo);
```

* Ahora muestra el contenido del archivo utilizando la función que has creado. Recuerda que es imprescindible abrir de nuevo el fichero para lectura: el puntero ha quedado al final del archivo y ya no habría nada que leer.
   Comprueba el resultado. ¿Se mantiene el texto original?
* Recupera el contenido original del archivo *modulos.txt*, y repite la ejecución del código anterior sustituyendo "w" por "r+" (lectura y escritura con el puntero al inicio) en el parámetro de `fopen`. ¿Entiendes bien lo que ha ocurrido?
* Recupera el contenido original del archivo *modulos.txt*, y repite la ejecución del código anterior sustituyendo "w" por "a" (append). Comprueba que ahora sale bien
* Codifica un ejemplo en el que se escriban datos en un archivo *nuevo.txt* que previamente no existía.
* Estudia los [diferentes modos de apertura de archivos](http://php.net/manual/es/function.fopen.php)
* ¿Se te ocurre alguna solución para conseguir que los dos nuevos módulos se introduzcan al inicio del archivo? Codifícala
* Codifica ahora una solución para leer los módulos del archivo y escribirlos ordenados alfabéticamente.
* La función *fopen* sirve también para crear un archivo: basta indicarle la ruta de un archivo que aún no existe. Crea un archivo *temporal.txt*.
* Borra el archivo *temporal.txt* con el siguiente código:
```php
unlink("files/temporal.txt");
```
* Estudia la [referencia de funciones relacionadas con el sistema de archivos](http://php.net/manual/es/ref.filesystem.php)

##### Parte 2: Gestor de nombres
Codifica una aplicación web que funcione de la siguiente forma:
- Habrá un archivo para almacenar nombres de persona. El archivo estará inicialmente vacío
- Se mostrarán dos cosas en pantalla:
  - La lista de nombres (extraída del archivo) ordenada alfabéticamente (utilizaremos funciones de ordenación de arrays). Si está vacía, se mostrará un mensaje indicándolo
  - Un formulario con un campo de texto para introducir un nombre, y un botón de tipo radio para escoger *añadir* o *borrar*. Se mostrará un error si se intenta añadir un nombre que ya existe, o borrar un nombre que no existe.
  - (Opcional): añade una opción para invertir el orden.
