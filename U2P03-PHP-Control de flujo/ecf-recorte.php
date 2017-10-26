<html>
<body>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Cadena:<input type="text" name="cad">
    <input type="submit" name="enviar">
	</form>
	<?php
}else{
    $cad=$_POST["cad"];
    $long=strlen($cad);
   
    for($i=$long;$i>=0;$i--){
        for($j=0;$j<$i;$j++){
            echo $cad[$j];
        }
        echo "<br>";
    }
}
?>
    <a href="index.php">Volver</a>
 </body>
</html>