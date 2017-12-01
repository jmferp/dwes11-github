<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<?php
    $telefono=false;
    $direccion=false;
    $enviado=false;
    $clave=false;
    $errorP=true;
    $errorF=true;
if(isset($_POST["enviar"])) {
    $email=$_POST["email"];

    $fecha=$_POST["fecha"];
    $dia=(int)substr($fecha,0,2);
    $mes=(int)substr($fecha,3,2);
    $aÃ±o=(int)substr($fecha,6, 4);

    switch($mes){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if($dia>0 && $dia<=31){
                $errorF=true;
            }else{
                $fecha="";
                $errorF=false;
            }
            break;

        case 4:
        case 6:
        case 8:
        case 11:
        if($dia>0 && $dia<=30){
                $errorF=true;
        }else{
            $fecha="";
            $errorF=false;
        }
        break;

        case 2:

            if ($dia <= 28 && $dia >= 1) {
                $errorF=true;
            } else if (($dia == 29 && (($aÃ±o % 4 == 0 && $aÃ±o % 100 != 0) || $aÃ±o % 400 == 0))) {

                $errorF=true;

            } else {
                $errorF=false;
                $fecha="";

            }
            break;
    }


    if(!empty($_POST["pass"])) {

        if (strlen($_POST["pass"]) >= 8 && strlen($_POST["pass"]) <= 12) {
            $clave = true;
            $errorP = true;
            $pass = $_POST["pass"];
        } else {
            $clave = false;
            $pass = $_POST["pass"];
            $errorP = false;
        }
    }

    $nombre=$_POST["nombre"];
    $apellidos=$_POST["apellidos"];
    if(!empty($_POST["tlf"])) {
        $telefono=true;
        $tlf=$_POST["tlf"];
    }else{
        $tlf="";
    }
    if(!empty($_POST["dir"])) {
        $direccion=true;
        $dir=$_POST["dir"];
    }
    else{
        $dir="";
    }

    $ciclo=$_POST["ciclo"];
    $enviado=true;


}else {
    $email = "";
    $fecha = "";
    $pass = "";
    $nombre = "";
    $apellidos = "";
    $tlf = "";
    $dir = "";
    $ciclo = "";
}
if(!$enviado || !$clave ){
?>

<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'], ENT_QUOTES, "UTF-8"); ?> " method="post">
    Email:<input type="email" name="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" required value="<?php echo $email ;?>" /><br>
    Fecha de nacimiento:<input type="date" name="fecha" value="<?php echo $fecha ;?>" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" required /><?php if(!$errorF){echo" La fecha tiene que tener un formato dd/mm/aaaa y tiene que ser valida"; $errorF=true;}?><br>
    ContraseÃ±a:<input type="password" name="pass" pattern="[A-Za-z0-9!?-]{1,12}" value="<?php echo $pass ;?>" /><?php if(!$errorP){echo" La contraseÃ±a tiene que tener de 8 a 12 caracteres"; $errorP=true;}?><br>
    Nombre:<input type="text" name="nombre" pattern="[a-zA-Z Ã Ã¡Ã¢Ã¤Ã£Ã¥Ä…Ä�Ä‡Ä™Ã¨Ã©ÃªÃ«Ä—Ä¯Ã¬Ã­Ã®Ã¯Å‚Å„Ã²Ã³Ã´Ã¶ÃµÃ¸Ã¹ÃºÃ»Ã¼Å³Å«Ã¿Ã½Å¼ÅºÃ±Ã§Ä�Å¡Å¾Ã€Ã�Ã‚Ã„ÃƒÃ…Ä„Ä†ÄŒÄ–Ä˜ÃˆÃ‰ÃŠÃ‹ÃŒÃ�ÃŽÃ�Ä®Å�ÅƒÃ’Ã“Ã”Ã–Ã•Ã˜Ã™ÃšÃ›ÃœÅ²ÅªÅ¸Ã�Å»Å¹Ã‘ÃŸÃ‡Å’Ã†ÄŒÅ Å½âˆ‚Ã° ,.'-]{2,48}" value="<?php echo $nombre ;?>" required /><br>
    Apellidos:<input type="text" name="apellidos" pattern="[a-zA-Z Ã Ã¡Ã¢Ã¤Ã£Ã¥Ä…Ä�Ä‡Ä™Ã¨Ã©ÃªÃ«Ä—Ä¯Ã¬Ã­Ã®Ã¯Å‚Å„Ã²Ã³Ã´Ã¶ÃµÃ¸Ã¹ÃºÃ»Ã¼Å³Å«Ã¿Ã½Å¼ÅºÃ±Ã§Ä�Å¡Å¾Ã€Ã�Ã‚Ã„ÃƒÃ…Ä„Ä†ÄŒÄ–Ä˜ÃˆÃ‰ÃŠÃ‹ÃŒÃ�ÃŽÃ�Ä®Å�ÅƒÃ’Ã“Ã”Ã–Ã•Ã˜Ã™ÃšÃ›ÃœÅ²ÅªÅ¸Ã�Å»Å¹Ã‘ÃŸÃ‡Å’Ã†ÄŒÅ Å½âˆ‚Ã° ,.'-]{2,48}"value="<?php echo $apellidos ;?>" required /><br>
    TelÃ©fono:<input type="tel" name="tlf" pattern="[0-9]{9}" value="<?php echo $tlf ;?>" /><br>
    DirecciÃ³n:<input type="text" name="dir" pattern="[a-zA-Z0-9- \Ã Ã¡Ã¢Ã¤Ã£Ã¥Ä…Ä�Ä‡Ä™Ã¨Ã©ÃªÃ«Ä—Ä¯Ã¬Ã­Ã®Ã¯Å‚Å„Ã²Ã³Ã´Ã¶ÃµÃ¸Ã¹ÃºÃ»Ã¼Å³Å«Ã¿Ã½Å¼ÅºÃ±Ã§Ä�Å¡Å¾Ã€Ã�Ã‚Ã„ÃƒÃ…Ä„Ä†ÄŒÄ–Ä˜ÃˆÃ‰ÃŠÃ‹ÃŒÃ�ÃŽÃ�Ä®Å�ÅƒÃ’Ã“Ã”Ã–Ã•Ã˜Ã™ÃšÃ›ÃœÅ²ÅªÅ¸Ã�Å»Å¹Ã‘ÃŸÃ‡Å’Ã†ÄŒÅ Å½âˆ‚Ã° ,.'-]{2,48}" value="<?php echo $dir ;?>" /><br>
    Ciclo Formativo:<select name="ciclo" >
                         <option value="DAW">DAW</option>
                         <option value="ASIR">ASIR</option>
                         <option value="DAM">DAM</option>
                    </select>
    <br> <input name="enviar" type="submit" >
</form>
<?php }
    else{

    ?>


<div><h1>Datos personales</h1></div>
        <h2><?php echo "$nombre $apellidos";?></h2>
    <ul>

        <li>Email <?php echo $email?></li>
        <li>Fecha de nacimiento <?php echo $fecha?></li>
        <li>Ciclo <?php echo $ciclo?></li>

        <?php
            if($telefono ){
            echo "<li>Telefono $tlf </li>";
        }
        if($direccion){

       echo" <li>Direccion $dir</li>";
            }
        ?>

    </ul>

<?php

}

?>

</body>
</html>