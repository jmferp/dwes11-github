<?php
$usuario = "alumno";
$clave = "alumno";
$servidor = "localhost";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
$conexion->query("SET NAMES 'UTF8'");

session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:login.php');
}else{
    
    
    if(!empty($_SESSION['name'])){
        
        $usu=$_SESSION['name'];
        $pas=$_SESSION['password'];

        $resultado = $conexion -> query("SELECT login,nombre FROM usuario where login='$usu' and password='$pas'");
        if($resultado->num_rows === 0) echo "<p>No hay usuario en la base de datos</p>";
        while ($user= $resultado->fetch_assoc()) {
            echo "<p> Usuario: ".$user['login']."</p>\n";
            echo "<p> Nombre: ".$user['nombre']."</p>\n";
            $mensaje="Damos la bienvenida a ".$user['nombre'];
        }
        
    }else{
        $mensaje="Sesion no iniciada";
        header("location:logout.php");
    }
}

?>
<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<h3><?php echo $mensaje;?></h3>
<p><a href="logout.php">Cerrar Sesion</a></p>
<p><a href="baja.php">Borrar cuenta</a></p>

</body>
</html>