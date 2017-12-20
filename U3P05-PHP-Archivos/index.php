<!DOCTYPE html>
<html><head><meta charset='UTF-8'/></head>
<body>
<?php
$rutaArchivo = "files/modulos.txt";
$ruta= "files/nuevo.txt";

//leer
readfile("files/modulos.txt");


//leer en array
/*$lineasArchivo = file($rutaArchivo);
print_r($lineasArchivo);*/

//mostrar sin separacion de lineas
/*$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
echo fread($archivo,filesize($rutaArchivo));
fclose($archivo);*/

//mostrar en lineas

/*$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    echo fgets($archivo) . "<br/>";
}
fclose($archivo);/*


//caracter a caracter con fin de linea
/*$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    $c = fgetc($archivo);
    if (($c == "\n") or ($c == "\r\n")) echo "<br/>";
    else echo $c;
}
fclose($archivo);*/

//abrir para escritura
$archivo = fopen($ruta, "a") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Programación\n");
fwrite($archivo,"Entornos de desarrollo\n");
$archmod= fopen($rutaArchivo, "a")  or die("Imposible  abrir el archivo para escritura");

fclose($archivo);




// Pruebas


?>
</body></html>