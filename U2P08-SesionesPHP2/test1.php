<?php
session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:registro.php');
}else{
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
        $_SESSION['test1']=$_POST['res1'];
        $_SESSION['acierto']=0;
        $_SESSION['fallo']=0;
        if($_SESSION['test1']=="Avatar"){
            $_SESSION['acierto']+=1;
        }else{
            $_SESSION['fallo']+=1;
        }
        header('location:test2.php');
    }


?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	<p>¿Cual es la pelicula mas taquillera de la historia?</p>
	<input type="radio" value="Avatar" name="res1">Avatar
	<input type="radio" value="Titanic" name="res1">Titanic
	<input type="radio" value="Jurassic" name="res1">Jurassic World
	<input type="submit" name="enviar">
	</form> 
</body>
</html>
<?php 

}
