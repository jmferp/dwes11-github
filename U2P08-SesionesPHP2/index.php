<?php

session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:registro.php');
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

<p><a href="test1.php">Test1</a></p>

</body>
</html>