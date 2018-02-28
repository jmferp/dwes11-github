<?php
$mensajeError='';
session_name("login");
session_start();
$user='';
$pass='';
if(isset($_SESSION['login'])){
    $login=$_SESSION['login'];
}else{
    $login=0;
}
if(isset($_SESSION['usuario'])){
    if($_SESSION['usuario']=='admin'){
        $user=$_SESSION['usuario'];
    }
}
if(isset($_SESSION['password'])){
    if($_SESSION['password']=='secreto'){
        $pass=$_SESSION['password'];
    }
}
if($login!=1) header('Location:admin-login.php');
?>


<html>
<head>
	<h1><img src='img/encabezado/encabezado.jpg'></h1>
    <title>ADMINISTRACIÓN_ADRIAN LOBATO</title>
</head>
<body>


<?php 
       echo "<h1>Bienvenido ".$user." </h1>\n";
?>

<a href="admin-baja.php">Dar baja a temas.</a><br>
<a href="admin-logout.php">Cerrar sesion.</a><br>

</body>
</html>