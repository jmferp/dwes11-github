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
    $mult=0;
    for($i=0;$i<=10;$i+=1){
        $mult=$x*$i;
        echo "<p>".$x."x".$i."=".$mult."</p>";
    }
    
}
?>
    <a href="index.php">Volver</a>
 </body>
</html>