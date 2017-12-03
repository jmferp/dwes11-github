<html>
<body>
<?php
#echo  "<h1>Funciona</h1>";
$nombre="Jose"; //comentario
/*comentario de
 bloque
 */
echo '<h3>Mi nombre es '. $nombre .' </h3>';
echo "<h3>Probamos con ",$nombre," el comportamiento de echo \n </h3>";
define("ALUMNO","Jose Maria",true);
echo "<p>El alumno es " .ALUMNO. "</p>";
echo "<p>El alumno es " .alumno. "</p>";
$a="5";
$b="4";
echo "<p>a= $a</p>";
echo "<p>b= $b</p>";
$a+=$b;
echo "<p>Suma:$a \n</p>";
$a-=$b;
echo "<p>Resta:$a \n</p>";
$a*=$b;
echo "<p>Mult:$a \n</p>";
$a/=$b;
echo "<p>Div:$a \n</p>";
$a.=$b;
echo "<p>Concat:$a \n</p>";

$a="5";
$b="4";
if($a>$b):
    echo "<p>$a es mayor que $b \n</p>";
elseif($a==$b):
    echo $a." es igual que ".$b;
else:
    echo $a." es menor que ".$b;
endif;

if(($a<$b)||($a>$b)){
    echo $a." es distinto de ".$b;
}
$enc=true;
if(($a<$b)&&($enc==true)){
    echo "encontrado";
}
for($i=0;$i<=5;$i++){
    echo "<p>$i</p>";
}

if(isset($a)){
    echo "<p> la variable \$a tiene el valor $a </p>";
}

$z=null;
if(isset($z)){
    echo "<p> no nulo </p>";
}else{
    echo "<p>nulo<p>";
}

$cadena="Esto es una cadena";
echo "<p>El texto $cadena tiene una longitud de ".strlen($cadena)." caracteres </p>";
echo "<p>primer caracter ".$cadena[0]."</p>";
echo "<p>ultimo caracter ".$cadena[strlen($cadena)-1]."</p>";
echo "<p>substring ".substr($cadena,3,5)."</p>";
echo "<p>Mayuscula la primera letra de palabra ".ucwords($cadena)."</p>";
echo "<p>Al reves ".strrev($cadena)."</p>";

$ciclos=array("SMR","ASIR","DAW");
echo "<p>Tamaño array:".sizeof($ciclos)."</p>";
$ciclos[0]="SMR";
$ciclos[1]="ASIR";
$ciclos[4]="DAW";
echo "<p>Tamaño array:".sizeof($ciclos)."</p>";
$ciclos=array(0=>"SMR",1=>"ASIR",4=>"DAW");
echo "<p>Tamaño array:".count($ciclos)."</p>";
$cont=0;
/*for($i=0;$i<=sizeof($ciclos)+1;$i++){
    if(isset($ciclos[$i])){
        echo "<p>$ciclos[$i]</p>";
    }else{    
    }
}*/
/*$i=0;
while($cont<=sizeof($ciclos)){
    if(isset($ciclos[$i])){
        echo "<p>$ciclos[$i]</p>";
        $cont=$cont+1;
    }else{
    }
   $i=$i+1;
}*/

echo "<br/>";
$ciclos=array("SMR","ASIR","DAW");
var_dump($ciclos);
echo "<br/>";
print_r($ciclos);

echo "<p>".var_dump($ciclos)."</p>";
//echo "<p>".print_r($ciclos)."</p>";

echo"<ol>";
foreach($ciclos as $actual){
    echo "<li>$actual</li>";
}
echo "</ol>";

$capitales=array("España"=>"Madrid","Portugal"=>"Lisboa","Francia"=>"Paris");
print_r($capitales);
echo"<br/>";
$horas["DWES"]=9;
$horas["DAW"]=4;
$horas["EIE"]=3;
print_r($horas);
echo"<br/>";

echo"<ul>";
foreach($capitales as $capital){
    echo "<li>$capital</li>";
}
echo "</ul>";

echo"<ul>";
foreach($capitales as $pais=>$capital){
    echo "<li>La capital de $pais es $capital</li>";
}
echo "</ul>";

echo $_SERVER['PHP_SELF']; //nombre archivo ejecutandose
echo $_SERVER['SCRIPT_NAME'];

$bol=true;
$double=2.4;
if(is_numeric($double)){
    echo "<p>$double es numerico</p>";
}
if(is_bool($bol)){
    echo '<p>$bol es booleano</p>';
}
if(is_double($double)){
    echo "<p>$double es double</p>";
}

$op=2;
switch ($op){
    case 1:echo "Es 1";
    break;
    case 2:echo "Es 2";
    break;
}
echo "<br/>";

$i=0;
$cont=5;
while($i<=$cont){
     echo $i; 
     $i=$i+1;
}
echo "<br/>";

$i=0;
do{
    echo $i;
    $i=$i+1;
}while($i<=$cont);
echo "<br/>";

for($i=0;$i<=$cont;$i++){
    echo $i;
}

function suma($a,$b){
    $res=$a+$b;
    return $res;
}
echo "<p>La suma de 2 y 3 es ".suma(2,3)."</p>";


function suma1($a,$b){
    $res=$a+$b;
    return "<p> no permitido </p>";
}

function suma2($a){
    global $cont;
    $res=$a+$cont;
    return $res;
}
echo "<p>La suma de 2 y $cont es ".suma2(2)."</p>";

echo "Hoy es ".date("d-m-y")." y son las ".date("H:i:s")."</p>";
?>
<?php 
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Nombre:<input type="text" name="nombre">
	<input type="submit" name="enviar">
	</form>
	<?php
}else{
    echo "<p>Bienvenido ".$_POST["nombre"]."</p>";
}
?>


</body>
</html>