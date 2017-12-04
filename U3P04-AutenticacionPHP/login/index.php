<?php

session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:login.php');
}else{
    
    
    if(!empty($_SESSION['name'])){
        $mensaje="Damos la bienvenida a ".$_SESSION['name'];
    }else{
        $mensaje="Sesion no iniciada";
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

</body>
</html>