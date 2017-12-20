<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
$mensajeError="";
$enviado=false;

if (!session_status () == PHP_SESSION_NONE){
    session_name("idsesion11");
    session_start();

}else{
    
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
        $nom=$_POST['nombre'];
        $pas=$_POST['password'];
        if(($nom="admin")&&($pas=="secreto")){
            $_SESSION['name']=$nom;
            echo "Damos la bienvenida a $nom";
            echo "<p><a href='admin-baja.php'>Baja</a></p>";
        }
       $enviado=true;
    }
    
    if (isset($_REQUEST["cerrarSesion"])) {
        $_SESSION=array();
        session_unset();
        if (ini_get("session.use_cookies")) {
            $params = session_get_cookie_params();
            setcookie(session_name(), '', time() - 42000,
                $params["path"], $params["domain"],
                $params["secure"], $params["httponly"]
                );
        }
        session_destroy();
        header('location:index.php');
    }


    ?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<?php 
if ($enviado==false){
?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Usuario:<input type="text" name="nombre">
	Contraseña:<input type="password" name="password">
    <input type="submit" name="enviar">
	</form> 
	<br>
<?php 
}else{
?>
<p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>
</body>
</html>
<?php 
}
}
?>