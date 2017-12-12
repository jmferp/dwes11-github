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
        
        if ($_POST['usuario']==""){
            $mensajeError="Error usuario";
        }else{
            if($_POST['password']==""){
                $mensajeError="Error contraseña";
            }else{
                $usu=$_POST['usuario'];
                $resultado = $conexion -> query("SELECT login FROM usuario where login='$usu'");
                if($resultado->num_rows === 0){
                    $_SESSION['name']=$_POST['usuario'];
                    $usu=$_POST['usuario'];
                    $pas=$_POST['password'];
                    $nom=$_POST['nombre'];
                    $desc=$_POST['descripcion'];
                    $admin=$_POST['admin'];
                    $_SESSION['password']=$pas;
                    $conexion -> query("INSERT INTO usuario VALUES ($usu,$pas,$nom,$admin,$desc)");
                }else{
                    $mensajeError="Usuario ya existe";
                }
        }
            
            
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
	Usuario:<input type="text" name="usuario">
	Nombre:<input type="text" name="nombre">
	Contraseña:<input type="text" name="password">
	Descripcion:<input type="text" name="descripcion">
	Tipo cuenta:<input type="radio" value="Administrador" name="admin">Administador
	<input type="radio" value="Estandar" name="admin">Estandar
    <input type="submit" name="enviar">
	</form> 
</body>
</html>
<?php 
}
?>