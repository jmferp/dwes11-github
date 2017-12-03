<html>
<body>

<?php 
$acum=0;
if(isset($_POST["enviar"])){
   
    $acum=$_POST["hid"]+$_POST["num"]; 
    echo $acum;
 
}else{
    
    $acum=0;
}

if($acum<=50){
    ?>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'],ENT_QUOTES, "UTF-8" );?>" method="post">
    Acumulador:<input type="text" name="num"> 
	<input type="hidden" name="hid" value=<?php echo $acum;?> >
    <input type="submit" name="enviar">
	</form>
	
	<?php
	
}else{
    
    echo "<p>Te has pasado de 50</p>";
}
?>
    <a href="index.php">Volver</a>
 </body>
</html>