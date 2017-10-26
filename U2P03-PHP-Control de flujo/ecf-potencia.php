<html>
<body>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Numero A:<input type="text" name="a">
	Numero B:<input type="text" name="b">
	<input type="submit" name="enviar">
	</form>
	<?php
}else{
    $a=$_POST["a"];
    $b=$_POST["b"];
    $pot=1;
    for($i=1;$i<=$b;$i++){
        $pot=$pot*$a;
    }
    echo $pot; 
}
    ?>
    <a href="index.php">Volver</a>
 </body>
</html>