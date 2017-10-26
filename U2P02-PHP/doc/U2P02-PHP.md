###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P02 - Fundamentos de PHP
#### Entrega de: Jose María Fernández
----
#### 1. Descripción:

El objetivo de la práctica es familiarizarse con el lenguaje PHP y codificar un programa en el que queden ejemplificados sus componentes y estructuras básicas, sirviendo más adelante como referencia básica.

#### 2. Formato de entrega:

Inserta el código en este documento.

#### 3. Trabajo a realizar:

Crea un proyecto *U2P02-PHP* y codifica un programa PHP en el que incluyas ejemplos propios de los elementos que se van indicando. Incluye estos apartados antes de cada prueba en forma de comentario de línea. Recuerda incluir este archivo en la carpeta `doc` dentro del proyecto:

* Comentarios de los tres tipos

  ```php
  #comentario de linea
  $nombre="Jose"; //comentario
  /*comentario de
   bloque
   */
  ```


* Sentencias echo con los dos tipos de comillas

  ```php
  echo '<h3>Mi nombre es '. $nombre .' </h3>';
  echo "<h3>Probamos con ",$nombre," el comportamiento de echo \n </h3>";
  ```

* Uso de al menos tres operadores de comparación y dos operadores lógicos

  ```php
  $a="5";
  $b="4";
  if($a>$b):
  echo "<p>$a es mayor que $b \n</p>";
  elseif($a==$b):
  echo $a." es igual que ".$b;
  else:
  echo $a." es menor que ".$b;
  endif;

  if(($a<$b)||($a>$b)){
      echo $a." es distinto de ".$b;
  }

  $enc=true;
  if(($a<$b)&&($enc==true)){
      echo "encontrado";
  }

  ```

  ​

* Uso de un operador de asignación

  ```php
  $a="5";
  $b="4";
  ```

* Declaración y uso de una variable por referencia

  ```php
  $a=$b;
  ```

* Declaración y uso de dos constantes, una que obligue a respetar las mayúsculas en su uso y otra que no lo haga

  ```php
  define("ALUMNO","Jose Maria");
  echo "<p>El alumno es " .ALUMNO. "</p>";
  define("ALUMNO","Jose Maria",true);
  echo "<p>El alumno es " .alumno. "</p>";
  ```

* Declaración y uso de un variable booleana y otra de tipo double

  ```php
  $bol=true;
  $double=2.4;
  ```

* Uso de is_numeric, is_bool y is_double con estas variables

  ```php
  if(is_numeric($double)){
  	echo "<p>$double es numerico</p>";
  }

  if(is_bool($bol)){
  	echo '<p>$bol es booleano</p>';
  }

  if(is_double($double)){
  	echo "<p>$double es double</p>";
  }
  ```
  ​

* Declaración de una variable de tipo string. Pruebas con la función *strlen* y con tres de las funciones indicadas en el enlace.

  ```php
  $cadena="Esto es una cadena";
  echo "<p>El texto $cadena tiene una longitud de ".strlen($cadena)." caracteres </p>";
  echo "<p>substring ".substr($cadena,3,5)."</p>";
  echo "<p>Mayuscula la primera letra de palabra ".ucwords($cadena)."</p>";
  echo "<p>Al reves ".strrev($cadena)."</p>";
  ```

  ​

* Declaración de un array escalar y uno asociativo

  ```php
  $ciclos=array("SMR","ASIR","DAW");
  $ciclos=array(0=>"SMR",1=>"ASIR",4=>"DAW");
  ```

  ​

* Ordenación y volcado de información con *var_dump* siguiendo dos criterios de ordenación en cada uno de los arrays

  ```php
  var_dump($ciclos);
  print_r($ciclos);
  ```

  ​

* Una estructura de control de cada tipo (if-elsif-else, switch, while, do-while, for)

  ```php
  if(a>b):
  echo "<p>$a es mayor que $b \n</p>";
  elseif(a==b):
  echo $a." es igual que ".$b;
  else:
  echo $a." es menor que ".$b;
  endif;

  $op=2;
  switch ($op){
      case 1:echo "Es 1";
      break;
      case 2:echo "Es 2";
      break;
  }

  $i=0;
  $cont=5;
  while($i<=$cont){
       echo $i; 
       $i=$i+1;
  }

  do{
      echo $i;
      $i=$i+1;
  }while($i<=$cont);

  for($i=0;$i<=$cont;$i++){
      echo $i;
      $i=$i+1;
  }

  ```

* Un recorrido por cada uno de los dos arrays utilizando foreach, generando por ejemplo una lista ordenada con sus elementos

  ```php
  echo"<ol>";
  foreach(ciclos as actual){
  echo "<li>$actual</li>";
  }
  echo "</ol>";
  ```

* Dos pruebas con la variable superglobal _SERVER

  ```php
  echo $_SERVER['SCRIPT_NAME'];
  echo $_SERVER['PHP_SELF'];
  ```

* Dos pruebas de funciones: una devolverá algun tipo, la otra no

  ```php
  function suma(a,b){
  	$res=$a+$b;
  	return $res;
  }
  echo "<p>La suma de 2 y 3 es ".suma(2,3)."</p>"
    
  function suma1($a,$b):float{
      $res=$a+$b;
      return "no permitido";
  }
  ```

* Impresion de la fecha y hora con todo el detalle posible

  ```php
  echo "Hoy es ".date("d-m-y")." y son las ".date("h:i")."</p>";
  ```

* Una función que utilice una variable global

  ```php
  function suma2($a){
  global $cont;
  $res=$a+$cont;
  return $res;
  }
  echo "<p>La suma de 2 y $cont es ".suma2(2)."</p>";
  ```

* Un formulario que reciba tu nombre y lo muestre por pantalla

  ```php+HTML
  <?php 
  if(!isset($_POST['enviar'])){
  ?>
  <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
  Nombre:<input type="text" name="nombre">
  <input type="submit" name="enviar">
  </form>
  <?php
  }else{
  echo "<p>Bienvenido ".$_POST["nombre"]."</p>";
  }
  ?>
  ```


