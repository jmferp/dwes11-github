<?php
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
        $_SESSION['name']=$_POST['nombre'];
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
	
	
    <input type="submit" name="enviar">
	</form> 
</body>
</html>
<?php 
}
?>