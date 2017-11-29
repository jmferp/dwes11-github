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
include ("Obra.php");
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
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
<th>ID Obra<a href=mostrarCatalogo.php?op=1>&#9650;</a><a href=mostrarCatalogo.php?op=2>&#9660;</a></th>
<th>ID Autor</th>
<th>Titulo</th>
<th>Autor</th>
</tr>
<?php
$ruta="img/";
if (!isset($_REQUEST["op"])) die (header("location:mostrarCatalogo.php?op=1"));
$op = $_REQUEST["op"];
if($op==1){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY id_obra");
}elseif ($op==2){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY id_obra DESC");
}
    
//$resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY id_obra");

//$resultado = $conexion -> query("SELECT distinct id_autor FROM obra,autor WHERE obra.id_autor=autor.id ORDER BY id_autor");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td><a href='mostrarObra.php?id_obra=".$obra->getId_obra()."'>".$obra->getId_obra()."</a></td>\n";
    echo "<td>".$obra->getId_autor()."</a></td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getNombre()."</td>\n";
    echo "</tr>";
    
}
mysqli_free_result($resultado);
    ?>

</table>
<?php 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>