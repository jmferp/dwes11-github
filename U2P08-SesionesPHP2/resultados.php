<?php
session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:registro.php');
}else if (!isset($_SESSION['test1'])){
    header('location:test1.php');
}else if (!isset($_SESSION['test2'])){
    header('location:test2.php');
}else if (!isset($_SESSION['test3'])){
    header('location:test3.php');
}else{
    if(isset($_POST['enviar'])){
        session_name('idsesion11');
        session_start ();
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
        header('location:registro.php');
    }
    
    ?>

<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<p>Fallos: <?php echo $_SESSION['fallo']?></p>
<p>Aciertos: <?php echo $_SESSION['acierto']?></p>
<p><a href="<?php echo $_SERVER['PHP_SELF']."?cerrarSesion=true"?>">Cerrar sesión</a></p>
</body>
</html>
<?php 

}