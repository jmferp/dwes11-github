<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
$conexion->query("SET NAMES 'UTF8'");
$mensajeError="";

if (!session_status () == PHP_SESSION_NONE){
    session_name("idsesion11");
    session_start();
    if(isset($_SESSION["name"])){
        header('location:index.php');
    }
}else{
    
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
        $nom=$_POST['nombre'];
        $pas=$_POST['password'];
        $resultado = $conexion -> query("SELECT login,password FROM usuario where login='$nom' and password='$pas'");
        if($resultado->num_rows === 0){
            echo "<p>No hay usuario en la base de datos</p>";
            
        }else{
         $_SESSION['name']=$_POST['nombre'];
         $_SESSION['password']=$_POST['password'];
         
        }
        header('location:index.php');
    }
    
    ?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Usuario:<input type="text" name="nombre">
	Contraseña:<input type="text" name="password">
    <input type="submit" name="enviar">
	</form> 
<p>¿aún no tienes cuenta? Haz clic <a href="alta.php">aquí</a> para crear una.</p>
</body>
</html>
<?php 
}
?>