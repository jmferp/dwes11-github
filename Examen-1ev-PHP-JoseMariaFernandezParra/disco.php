<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
if (!isset($_REQUEST["id"])){
    
}else{
$id = $_REQUEST["id"];

$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");


if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

if (isset($_REQUEST["idioma"])){
if (($_REQUEST['idioma']=="is")){
    setcookie("islandia", "islandia", time() + 2592000, '/');
    setcookie("espana",null, time() - 1, "/");
    
}elseif(($_REQUEST['idioma']=="es")){
    setcookie("espana", "espana", time() + 2592000, '/');
    setcookie("islandia",null, time() - 1, "/");
    
}
}



?>
<p><a href="<?php echo $_SERVER['PHP_SELF']?>?id=<?php echo $id?>?idioma=is"><img src="img/banderas/is.png"></a></p>
<p><a href="<?php echo $_SERVER['PHP_SELF']?>?id=<?php echo $id?>?idioma=es"><img src="img/banderas/es.png"></a></p>

<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Titulo</th>
<th>Discografica</th>
<th>Año</th>
<th>Formato</th>
<th>Imagen</th>
</tr>
<?php
$ruta="img/discografia/";

$resultado = $conexion -> query("SELECT * FROM discos WHERE id='$id' ");
//$resultado = $conexion -> query("SELECT distinct id_autor FROM obra,autor WHERE obra.id_autor=autor.id ORDER BY id_autor");
if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($disco = $resultado->fetch_assoc()) {
    echo "<tr bgcolor='lightblue'>";
    echo "<td>".$disco['nombre']."</a></td>\n";
    echo "<td>".$disco['discografica']."</a></td>\n";
    echo "<td>".$disco['year']."</a></td>\n";
    echo "<td>".$disco['soporte']."</a></td>\n";
    echo "<td><a href='disco.php?id=".$disco['id']."'><img src='$ruta".$disco['imagen'].".jpg"."' width=100 heigh=100></td>\n";
    echo "</tr>";
    


?>
</table>
<?php 
echo "Comentarios";
echo $disco['texto'];
}
?>
<br>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Numero</th>
<th>Titulo</th>
<th>Duracion</th>
</tr>
<?php 

echo "Listado de canciones";
$resultado1 = $conexion -> query("SELECT * FROM discos,temas WHERE discos.id='$id' and temas.id_disco='$id'");
if($resultado1->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($disco1 = $resultado1->fetch_assoc()) {
    echo "<tr bgcolor='lightblue'>";
    echo "<td>".$disco1['numero']."</a></td>\n";
    if ((!isset($_REQUEST["idioma"]))||($_REQUEST["idioma"]=="is")){
    echo "<td>".$disco1['nombre_i']."</a></td>\n";
    }elseif((isset($_REQUEST["idioma"]))&&($_REQUEST["idioma"]=="es")){
    echo "<td>".$disco1['nombre_e']."</a></td>\n";
    }
    echo "<td>".$disco1['minutos'].":".$disco1['segundos']."</a></td>\n";
   
    echo "</tr>";
    
}


    ?>

</table>
<?php 

//echo "<h3>Desconectando...</h3>";
mysqli_free_result($resultado);
mysqli_free_result($resultado1);
mysqli_close($conexion);
}
?>
<a href="index.php">Volver</a>
</body>
</html>