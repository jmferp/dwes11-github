<?php
session_name("login");
session_start();
$_SESSION['login']=0;
header('Location:index.php');
?>