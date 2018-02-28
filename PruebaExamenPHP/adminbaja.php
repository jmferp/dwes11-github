<?php
$mensajeError='';
session_name("login");
session_start();
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$song='';
if(isset($_GET['id'])){
    $song=$_GET['id'];
    $resultado2 = $conexion->query('DELETE FROM temas WHERE id='.$song);
    if ($conexion->connect_error) {
        $mensajeError = "Ha surgido un problema con la base de datos";
    } else {
        echo "<p>El tema ha sido borrado con exito</p>";
        header('Location:admin-baja.php');
    }
}
?>


<html>
<head>
	<h1><img src='img/encabezado/encabezado.jpg'></h1>
    <title>BAJA TEMAS_ADRIAN LOBATO</title>
</head>
<h1>PINCHA SOBRE CADA ID PARA BORRAR EL TEMA</h1>
<body>
<table style='border:0'>
<tr style='background-color:yellow'>
	<th>ID tema</th>
	<th>Nombre tema(es)</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT * FROM temas");
if($resultado->num_rows === 0) echo "<p>No hay temas en la base de datos</p>";
while ($tema = $resultado->fetch_assoc()) {
    
    echo "<tr bgcolor='green'>";
    echo "<td><a href='admin-baja.php?id=".$tema['id']."'>".$tema['id']."</a></td>\n";
    echo "<td>".$tema['nombre_e']."</td>\n";
    echo "</tr>";
    
}
?>
</table>

<a href="administracion.php">Administración.</a><br>

</body>
</html>