<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
if (!isset($_REQUEST["id_obra"])) die ("<h3>ERROR en la petición. Falta identificador de obra</h3>");
$id = $_REQUEST["id_obra"];

$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
include ("Obra.php");
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
$conexion->query("SET NAMES 'UTF8'");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
//echo "<p>A continuación mostramos algunos registros:</p>";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>ID obra</th>
<th>Titulo</th>
<th>Autor</th>
<th>Imagen</th>
</tr>
<?php
$ruta="img/";
$resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor AND (obra.id_obra='$id') ORDER BY id_obra");
//$resultado = $conexion -> query("SELECT distinct id_autor FROM obra,autor WHERE obra.id_autor=autor.id ORDER BY id_autor");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra->getId_obra()."</td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getNombre()."</td>\n";
    echo "<td><img src='$ruta".$obra->getImagen()."' width=100 heigh=100></td>\n";
    echo "</tr>";
    
}
mysqli_free_result($resultado);
    ?>

</table>
<?php 
//echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
<a href="mostrarCatalogo.php">Volver</a>
</body>
</html>