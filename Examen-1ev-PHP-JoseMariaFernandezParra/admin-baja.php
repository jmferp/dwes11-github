<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
$mensajeError="";

session_name("idsesion11");
session_start();


if (!isset($_SESSION['name'])){
    header('location:admin-login.php');
}else{

if($_SERVER['REQUEST_METHOD']=='POST'){
    
    
   
    
    
}
}


?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	<input type="button" value="Eliminar">
    <input type="submit" name="enviar">
	</form>
	
<a href="admin-login.php">Volver a login</a>
</body>
</html>
<?php 

?>
