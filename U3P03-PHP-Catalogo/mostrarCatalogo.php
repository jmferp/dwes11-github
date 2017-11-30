<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
include ("Obra.php");
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
$conexion->query("SET NAMES 'UTF8'");
$enviado=false;

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}


echo "<p>A continuación mostramos algunos registros:</p>";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>ID Obra</th>
<th>ID Autor</th>
<th>Titulo<a href=mostrarCatalogo.php?op=1>&#9650;</a><a href=mostrarCatalogo.php?op=2>&#9660;</a></th>
<th>Autor<a href=mostrarCatalogo.php?op=3>&#9650;</a><a href=mostrarCatalogo.php?op=4>&#9660;</a></th>
<th>Nacionalidad</th>
</tr>


<?php
$ruta="img/";

if (isset($_REQUEST["id_autor"])){
$id_autor = $_REQUEST["id_autor"];

    $resultado1 = $conexion -> query("SELECT * FROM autor,obra WHERE obra.id_autor=autor.id AND autor.id='$id_autor'");

if($resultado1->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra1 = $resultado1->fetch_assoc()) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra1['id_obra']."</a></td>\n";
    echo "<td>".$obra1['id_autor']."</a></td>\n";
    echo "<td><a href='mostrarObra.php?id_obra=".$obra1['id_obra']."'>".$obra1['titulo']."</td>\n";
    echo "<td><a href='mostrarCatalogo.php?id_autor=".$obra1['id_autor']."'>".$obra1['nombre']."</td>\n";
    echo "<td>".$obra1['nacionalidad']."</td>\n";
    echo "</tr>";
    
}

mysqli_free_result($resultado1);

$op = $_REQUEST["op"];
}elseif(isset($_REQUEST["op"])&&($op==1)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY titulo");
}elseif (isset($_REQUEST["op"])&&($op==2)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY titulo DESC");
}elseif ((isset($_REQUEST["op"]))&&($op==3)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY nombre");
}elseif ((isset($_REQUEST["op"]))&&($op==4)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY nombre DESC");





//$resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY id_obra");

//$resultado = $conexion -> query("SELECT distinct id_autor FROM obra,autor WHERE obra.id_autor=autor.id ORDER BY id_autor");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra->getId_obra()."</a></td>\n";
    echo "<td>".$obra->getId_autor()."</a></td>\n";
    echo "<td><a href='mostrarObra.php?id_obra=".$obra->getId_obra()."'>".$obra->getTitulo()."</td>\n";
    echo "<td><a href='mostrarCatalogo.php?id_autor=".$obra->getId_autor()."'>".$obra->getNombre()."</td>\n";
    echo "<td>".$obra->getNacionalidad()."</td>\n";
    echo "</tr>";
    
}


mysqli_free_result($resultado);

}else{

if (isset($_POST["enviar"])){
    $tit=$_POST['titulo'];
    $enviado=true;
    
    $resultado2=$conexion -> query("SELECT * FROM autor,obra WHERE obra.id_autor=autor.id AND obra.titulo='$tit'");
    if($resultado2->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
    while ($obra2 = $resultado2->fetch_assoc()) {
        echo "<tr bgcolor='lightgreen'>";
        echo "<td>".$obra2['id_obra']."</a></td>\n";
        echo "<td>".$obra2['id_autor']."</a></td>\n";
        echo "<td><a href='mostrarObra.php?id_obra=".$obra2['id_obra']."'>".$obra2['titulo']."</td>\n";
        echo "<td><a href='mostrarCatalogo.php?id_autor=".$obra2['id_autor']."'>".$obra2['nombre']."</td>\n";
        echo "<td>".$obra2['nacionalidad']."</td>\n";
        echo "</tr>";
    }
    mysqli_free_result($resultado2);
}

}
    ?>
</table>
<?php 
if($enviado==false){
?>
<form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
    <label>Buscar obra</label>
    <input type="text" name="titulo"><br/>
    <input type="submit" value="Enviar" name="enviar">
</form>
<?php 
}
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);

?>
<p><a href="mostrarCatalogo.php">Eliminar filtros</a></p>
</body>
</html>