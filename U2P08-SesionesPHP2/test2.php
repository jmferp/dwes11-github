<?php
session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:registro.php');
}else if (!isset($_SESSION['test1'])){
    header('location:test1.php');   
}else{
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
        $_SESSION['test2']=$_POST['res2'];
        if($_SESSION['test2']=="Thriller"){
            $_SESSION['acierto']+=1;
        }else{
            $_SESSION['fallo']+=1;
        }
        header('location:test3.php');
    }
    
    
    
    ?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	<p>¿Cual es el disco mas vendido de Michael Jackson?</p>
	<input type="radio" value="Bad" name="res2">Bad
	<input type="radio" value="Thriller" name="res2">Thriller
	<input type="radio" value="Dangerous" name="res2">Dangerous
    <input type="submit" name="enviar">
	</form> 
</body>
</html>
<?php 

}