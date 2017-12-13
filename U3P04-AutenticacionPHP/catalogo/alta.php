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
   
        if ($_POST['usuario']==""){
            $mensajeError="Error usuario";
        }else{
            if($_POST['password']==""){
                $mensajeError="Error contraseña";
            }else{
                $usu=$_POST['usuario'];
                $resultado = $conexion -> query("SELECT * FROM usuario where login='$usu'");
                if($resultado->num_rows === 0){
                    $_SESSION['name']=$_POST['usuario'];
                    $usu=$_POST['usuario'];
                    $pas=$_POST['password'];
                    $nom=$_POST['nombre'];
                    $desc=$_POST['descripcion'];
                    $admin=$_POST['admin'];
                    $_SESSION['password']=$pas;
                    $consulta = "INSERT INTO usuario (login,password,nombre,admin,descripcion) VALUES ('$usu','$pas','$nom','$admin','$desc')";
                    
                    $conexion -> query($consulta);
                    echo "<h2>Hola</h2>";
                    if ($conexion->connect_error){
                        echo "Mal";
                    }
                    header('location:login.php');
                }else{
                    $mensajeError="Usuario ya existe";
                }
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
	Usuario:<input type="text" name="usuario"><br>
	Nombre:<input type="text" name="nombre"><br>
	Contraseña:<input type="text" name="password"><br>
	Descripcion:<input type="text" name="descripcion"><br>
	Tipo cuenta:<input type="radio" value="1" name="admin">Administador
	<input type="radio" value="0" name="admin">Estandar
    <input type="submit" name="enviar">
	</form>
</body>
</html>
<?php 

?>