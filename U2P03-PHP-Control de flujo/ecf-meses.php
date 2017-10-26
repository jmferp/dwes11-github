<html>
<body>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Mes:<input type="text" name="mes">
    <input type="radio" name="bisiesto" value="bisiesto"> Bisiesto
    <input type="radio" name="bisiesto" value="nobisiesto"> No Bisiesto
    <input type="submit" name="enviar">
	</form>
	<?php
}else{
    if(!isset($_POST["bisiesto"])){
        $_POST["bisiesto"]="nobisiesto";
    }
    $mes=$_POST["mes"];
    $bis=$_POST["bisiesto"];
    $nobis=$_POST["bisiesto"];
    if(is_numeric($mes)){
        switch($mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:echo "El mes $mes tiene 31 dias";
            break;
            case 4:
            case 6:
            case 9:
            case 11:echo "El mes $mes tiene 30 dias";
            break;
            case 2:
                if(strcmp($bis,"bisiesto")==0){
                    echo "El mes $mes tiene 29 dias";
                }else{
                    if(strcmp($nobis,"nobisiesto")==0){
                    echo "El mes $mes tiene 28 dias";
                    }else{
                        echo "Ese mes no existe";
                    }
                }
            break;
            default:echo "No existe ese mes";
        }
    }else if(strcasecmp($mes, "enero")==0||strcasecmp($mes, "marzo")==0||strcasecmp($mes, "mayo")==0
        ||strcasecmp($mes, "julio")==0||strcasecmp($mes, "agosto")==0||strcasecmp($mes, "octubre")==0
            ||strcasecmp($mes, "diciembre")==0){
            echo "El mes $mes tiene 31 dias";
            
    }else if(strcasecmp($mes, "abril")==0||strcasecmp($mes, "junio")==0||strcasecmp($mes, "septiembre")==0||
        strcasecmp($mes, "noviembre")==0){
        echo "El mes $mes tiene 30 dias";
    }else if((strcasecmp($mes, "febrero")==0)&&(strcmp($bis,"bisiesto")==0)){
        echo "El mes $mes tiene 29 dias";
    }else if((strcasecmp($mes, "febrero")==0)&&(strcmp($nobis,"nobisiesto")==0)){
        echo "El mes $mes tiene 28 dias";
    }else{
        echo "Ese mes no existe";
    }


}


?>
    <a href="index.php">Volver</a>
 </body>
</html>