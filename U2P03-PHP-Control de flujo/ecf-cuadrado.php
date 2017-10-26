<html>
<body>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Numero:<input type="text" name="num">
    <input type="submit" name="enviar">
	</form>
	<?php
}else{
    ?><table border="1"><?php
    for($i=1;$i<=$_POST["num"];$i++){
        if($i%2==0){
        ?> <tr bgcolor="lightblue"><?php
        }else{
        ?> <tr><?php
        }
        for($j=1;$j<=$_POST["num"];$j++){
        ?>
        	<td align="center" style='padding:0.3cm'><?php echo $j*$i?></td>
        
        <?php
        }
        ?></tr><?php
    }
   
}
?>
	</table>
    <a href="index.php">Volver</a>
 </body>
</html>