<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
include ("Animal.php");
$conexion = new mysqli($servidor,$usuario,$clave,"animales");
$conexion->query("SET NAMES 'UTF8'");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos algunos registros:</p>";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Chip</th>
<th>Nombre</th>
<th>Especie</th>
<th>Imagen</th>
</tr>
<?php
$ruta="img/";
$resultado = $conexion -> query("SELECT chip, nombre, especie AS tipo, imagen FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
while ($animal = $resultado->fetch_object('Animal')) {
    // echo $animal."<br/>"; // primer intento más sencillo
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$animal->getChip()."</td>\n";
    echo "<td>".$animal->getNombre()."</td>\n";
    echo "<td>".$animal->getTipo()."</td>\n";
    echo "<td><img src='$ruta".$animal->getImagen()."' width=100 heigh=100></td>\n";
    echo "</tr>";
}

/*
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
while ($animal = $resultado->fetch_object('Animal')) {
    echo $animal."<br/>";
}*/


    ?>

</table>
<?php 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<p><a href="conexion2.php">Conexion 2</a></p>
<p><a href="conexion3.php">Conexion 3</a></p>
<p><a href="conexion4.php">Conexion 4</a></p>
<p><a href="conexion5.php">Conexion 5</a></p>
</body>
</html>