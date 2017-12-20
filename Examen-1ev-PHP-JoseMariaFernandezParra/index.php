<html>
<head>
	<title>Index</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
$enviado=false;

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

$ruta="img/discografia/";

echo "<table style='border:0'>";
echo "<tr style='background-color:lightgreen'>";
if (isset($_REQUEST["tipo"])){
echo "<th>Titulo<a href=index.php?op=1>&#9650;</a><a href=index.php?op=2>&#9660;</a></th>";
echo "<th>Discografica</th>";
echo "<th>Año<a href=index.php?op=3>&#9650;</a><a href=index.php?op=4>&#9660;</a></th>";
echo "<th>Formato</th>";
echo "<th>Imagen</th>";
}
echo "</tr>";

if ((isset($_REQUEST["tipo"]))){
    $tipo=$_REQUEST["tipo"];
   
    
    if (isset($_POST["enviar"])){
        $dis=$_POST['nombre'];
        $enviado=true;
        
        $resultado = $conexion -> query("SELECT * FROM discos WHERE nombre='$dis'");
        
    }else{
        $resultado = $conexion -> query("SELECT * FROM discos WHERE tipo='$tipo'");
    }
}else{
    $resultado = $conexion -> query("SELECT DISTINCT tipo FROM discos");
/*
if(isset($_REQUEST["op"])&&($_REQUEST["op"]==1)){
    
    $resultado = $conexion -> query("SELECT * FROM discos WHERE tipo='$tipo' ORDER BY nombre");
}elseif (isset($_REQUEST["op"])&&($_REQUEST["op"]==2)){

    $resultado = $conexion -> query("SELECT * FROM discos WHERE tipo='$tipo' ORDER BY nombre DESC");
}elseif ((isset($_REQUEST["op"]))&&($_REQUEST["op"]==3)){

    $resultado = $conexion -> query("SELECT * FROM discos WHERE tipo='$tipo' ORDER BY year");
}elseif ((isset($_REQUEST["op"]))&&($_REQUEST["op"]==4)){

    $resultado = $conexion -> query("SELECT * FROM discos WHERE tipo='$tipo' ORDER BY year DESC");
}else{*/
   
}


if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($disco = $resultado->fetch_assoc()) {
    if (!isset($_REQUEST["tipo"])){
    echo "<p><a href='index.php?tipo=".$disco['tipo']."'>".$disco['tipo']."</a></p>\n";
    
    }
    if (isset($_REQUEST["tipo"])){
        echo "<tr bgcolor='lightblue'>";
        echo "<td>".$disco['nombre']."</a></td>\n";
        echo "<td>".$disco['discografica']."</a></td>\n";
        echo "<td>".$disco['year']."</a></td>\n";
        echo "<td>".$disco['soporte']."</a></td>\n";
        echo "<td><a href='disco.php?id=".$disco['id']."'><img src='$ruta".$disco['imagen'].".jpg"."' width=100 heigh=100></td>\n";
    }
    echo "</tr>";
        
    
}
mysqli_free_result($resultado);
echo "</table>";
if($enviado==false){
    ?>
<form action="<?php echo $_SERVER['PHP_SELF']?>" method="post"><br/>
    <label>Buscar disco: </label>
    <input type="text" name="nombre">
    <input type="submit" value="Enviar" name="enviar">
</form>


<?php 
}

?>
<a href="index.php">Volver</a><br>
<a href="admin-login.php">Login</a>
</body>
</html>