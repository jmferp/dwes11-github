<html>
<body>
<?php 
echo "Multiplos de 3 y 5 hasta 1000";
for($i=0;$i<1000;$i++){
    if(($i%3==0)&&($i%5==0)){
        echo "<p>$i<br></p>";
    }
}
$i=0;
$cont=0;
echo "20 primeros multiplos de 3 y 5";
while($cont<20){
    if(($i%3==0)&&($i%5==0)){
        echo "<p>$i<br></p>";
        $cont=$cont+1;
    }
    $i=$i+1;
}

   
   
?>
    <a href="index.php">Volver</a>
 </body>
</html>