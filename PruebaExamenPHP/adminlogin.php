<?php
session_name("login");
session_start();
$user='';
$pass='';
$login=0;
if(isset($_SESSION['login'])){
    $login=$_SESSION['login'];
    if($login==1) header('Location:administracion.php');
}
$mensajeError='';
if(isset($_POST['enviar'])){
    if(isset($_POST['user'])){
        $user=$_POST['user'];
    }
    if(isset($_POST['pass'])){
        $pass=$_POST['pass'];
    }
    if($user=='admin'){
        if($pass=='secreto'){
            $_SESSION['usuario'] = $user;
            $_SESSION['password'] = $pass;
            $_SESSION['login'] = 1;
            header('Location:administracion.php');
        }else{
            $mensajeError = "La contraseña es erronea, intentelo de nuevo";
        }
    }else{
        $mensajeError = "El usuario es erroneo, intentelo de nuevo";
        
    }
}
?>

<html>
<head>
	<h1><img src='img/encabezado/encabezado.jpg'></h1>
    <title>LOGIN_ADRIAN LOBATO</title>
</head>
<body>
<div >
<form action="admin-login.php" method="POST">
    <h1>Login</h1>
    <p>User:</p><input type="text" name="user">
    <p>Password:</p><input type="password" name="pass">
    <input type="submit" name="enviar" value="Entrar">
</form>
<p><?php if($mensajeError!='')echo $mensajeError;?></p>
</div>
</body>
</html>