<!-- PARA CAMBIAR DE IDIOMA, HAZ DOBLE CLICK SOBRE LA BANDERA -->
<html>
<head>
	<h1><img src='img/encabezado/encabezado.jpg'></h1>
	<title>DISCO_ADRIAN LOBATO</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
echo "<h3>PARA CAMBIAR DE IDIOMA, HAZ DOBLE CLICK SOBRE LA BANDERA CORRESPONDIENTE</h3>";
$mensaje='';
$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$where='';
if (isset($_GET['id'])){
    $where=" WHERE id=".$_GET['id'];
    $disco=$_GET['id'];
}else{
    $mensaje='Error, no se le ha pasado el id del disco.';
}
if (isset($_GET['idioma'])){
    setcookie("idioma", $_GET['idioma'], time() +  (86400*30), "/Examen-1ev-PHP-AdrianLobato/"); // 86400 = segundos en 1 día
}
$select="SELECT numero, nombre_i AS nombre, minutos, segundos FROM temas WHERE id_disco=".$disco;
if(isset($_COOKIE['idioma'])) {
    if($_COOKIE['idioma']=="espanya"){
        $select="SELECT numero, nombre_e AS nombre, minutos, segundos FROM temas WHERE id_disco=".$disco;
    }elseif ($_COOKIE['idioma']=="islandia"){
        $select="SELECT numero, nombre_i AS nombre, minutos, segundos FROM temas WHERE id_disco=".$disco;
        
    }
}
?>
<table style='border:0'>
<tr style='background-color:blue'>
	<th>Título</th>
	<th>Discografía </th>
	<th>Año</th>
	<th>Formato</th>
	<th>Imagen portada</th>
	<th>Idioma 'ESPAÑOL'</th>
	<th>Idioma 'ISLANDÉS'</th>
	<th>Comentarios</th>
</tr>
<?php
$es="espanya";
$is="islandia";
$resultado = $conexion -> query("SELECT * FROM discos ".$where);
if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($cd=$resultado-> fetch_assoc()) {
    
   
    echo "<tr bgcolor='green'>";
    echo "<td>".$cd['nombre']."</td>\n";
    echo "<td>".$cd['discografica']."</td>\n";
    echo "<td>".$cd['year']."</td>\n";
    echo "<td>".$cd['soporte']."</td>\n";
    echo "<td><img src='img/discografia/".$cd['imagen'].".jpg'></td>\n";
    echo "<td><a href='disco.php?id=".$disco."&idioma=".$es."'><img src='img/banderas/es.png'></a></td>\n";
    echo "<td><a href='disco.php?id=".$disco."&idioma=".$is."'><img src='img/banderas/is.png'></a></td>\n";
    echo "<td>".$cd['texto']."</td>\n";
    echo "</tr>"; 
    
}
    
?>
</table>
<table style='border:0'>
<tr style='background-color:ligthyellow'>
	<th>Numero tema</th>
	<th>Título</th>
	<th>Duración</th>
</tr>

<?php 
$resultado2 = $conexion -> query($select);
while ($tema=$resultado2-> fetch_assoc()) {
    echo "<tr bgcolor='ligthyellow'>";
    echo "<td bgcolor='ligthyellow'>".$tema['numero']."</th>";
    echo "<td bgcolor='ligthyellow'>".$tema['nombre']."</th>";
    echo "<td bgcolor='ligthyellow'>".$tema['minutos'].":".$tema['segundos']."</th>";
    echo "</tr>";    
}
?>
</table>
<a href='index.php'>Ver todo</a><br>
<?php If($mensaje!='') echo $mensaje;?>
</body>
</html>