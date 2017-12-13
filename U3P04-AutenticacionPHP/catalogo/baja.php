<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
$conexion->query("SET NAMES 'UTF8'");
$mensajeError="";


session_name("idsesion11");
session_start();


if($_SERVER['REQUEST_METHOD']=='POST'){
    
   
        if($_POST['password']==""){
            $mensajeError="Error contraseña";
        }else{
                $usu=$_SESSION['name'];
                $pas=$_POST['password'];
                $resultado = $conexion -> query("SELECT * FROM usuario where login='$usu' and password='$pas'");
                if($resultado->num_rows === 1){
                $_SESSION['name']="";
                $_SESSION['password']="";
                $consulta = "DELETE FROM usuario WHERE login='$usu'";
                $conexion -> query($consulta);
                if ($conexion->connect_error){
                    echo "Mal";
                }
                header('location:logout.php');
            }else{
                $mensajeError="Usuario no existe";
            }
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
	Contraseña:<input type="text" name="password"><br>
    <input type="submit" name="enviar">
	</form>
</body>
</html>
<?php 

?>
