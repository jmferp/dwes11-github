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
    if(($a >-1 && $a<11)&&($b >-1 && $b<11)){
        if($a < $b){
            while($a<$b && $a<11){
                echo"*";
                $a+=1;
            }
        }else{
            while($b<$a && $b<11){
                echo"*";
                $b+=1;
            }
        }
        $a=$_POST["a"];
        $b=$_POST["b"];
        if($a < $b){
            for($a;$a<$b;$a++){
                echo"#";
            }
        }else{
            for($b;$b<$a;$b++){
                echo"#";
            }
        }
    }
}
?>
    <a href="index.php">Volver</a>
 </body>
</html>