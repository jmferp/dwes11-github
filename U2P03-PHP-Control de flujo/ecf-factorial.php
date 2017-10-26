<html>
<body>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Numero:<input type="text" name="x">
    <input type="submit" name="enviar">
	</form>
	<?php
}else{
    $x=$_POST["x"];
    $fact=1;
    for($i=1;$i<=$x;$i+=1){
        $fact=$fact*$i;
    }
    echo "<p>".$fact."</p>";
}
?>
    <a href="index.php">Volver</a>
 </body>
</html>