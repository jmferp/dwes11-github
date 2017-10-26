<html>
<body>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Numero X:<input type="text" name="x">
    <input type="submit" name="enviar">
	</form>
	<?php
}else{
    $x=$_POST["x"];
    $suma=0;
    for($i=0;$i<=$x;$i+=1){
        $suma=$suma+$i;
    }
    echo "<p>".$suma."</p>";
}
?>
    <a href="index.php">Volver</a>
 </body>
</html>