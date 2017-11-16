<?php
session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:registro.php');
}else{
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
        $_SESSION['test1']=$_POST['respuesta'];
        $_SESSION['acierto']=0;
        $_SESSION['fallo']=0;
        if($_SESSION['test1']=="ok"){
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
	Pregunta:<input type="text" name="respuesta">
    <input type="submit" name="enviar">
	</form> 
</body>
</html>
<?php 

}
