<?php

if (session_status () == PHP_SESSION_NONE){
    session_name('idsesionname');
    session_start ();
    $mensaje="Sesion no iniciada";
}

if(isset($_POST['enviar'])){
   if(!empty($_POST['nombre'])){
       $_SESSION['name']=$_POST['nombre'];
       $mensaje="Damos la bienvenida a ".$_SESSION['name'];
   }else{
       $mensaje="Sesion no iniciada";
 }
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
}

 ?>
<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<h3><?php echo $mensaje;?></h3>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Nombre:<input type="text" name="nombre">
    <input type="submit" name="enviar">
	</form> 
<p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>

</body>
</html>
