<?php
session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:registro.php');
}else if (!isset($_SESSION['test2'])){
        header('location:test2.php');
}else{
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
        $_SESSION['test3']=$_POST['res3'];
        if($_SESSION['test3']=="Sierra"){
            $_SESSION['acierto']+=1;
        }else{
            $_SESSION['fallo']+=1;
        }
        header('location:resultados.php');
    }
    
    ?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	<p>¿Quien es el premio Planeta del año 2017?</p>
	<input type="radio" value="Cristina" name="res3">Cristina Lopez Barrio
	<input type="radio" value="Sierra" name="res3">Javier Sierra
	<input type="radio" value="Redondo" name="res3">Dolores Redondo
    <input type="submit" name="enviar">
	</form> 
</body>
</html>
<?php 

}