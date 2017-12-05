<?php
session_name('idsesion11');
session_start ();
    $_SESSION['name']="";
    session_destroy();
    header('location:login.php');
    
    ?>



