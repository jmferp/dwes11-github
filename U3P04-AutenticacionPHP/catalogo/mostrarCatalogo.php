<?php
$usuario = "alumno";
$clave = "alumno";
$servidor = "localhost";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo11");
$conexion->query("SET NAMES 'UTF8'");

session_name('idsesion11');
session_start ();
if (!isset($_SESSION['name'])){
    header('location:login.php');
}else{
    
    
    if(!empty($_SESSION['name'])){
        
        $usu=$_SESSION['name'];
        $pas=$_SESSION['password'];

        $resultado = $conexion -> query("SELECT * FROM usuario where login='$usu' and password='$pas'");
        if($resultado->num_rows === 0){
            echo "<p>No hay usuario en la base de datos</p>";
        }else{
        while ($user= $resultado->fetch_assoc()) {
            echo $mensaje="Damos la bienvenida a ".$user['nombre'];
        }
        }
        
    }else{
        echo $mensaje="Sesion no iniciada";
        header("location:logout.php");
    }
}


?>
<html>
<head>
<title>Sesiones</title>
<meta charset="UTF-8"/>
</head>
<body>
<p><a href="logout.php">Cerrar Sesion</a></p>
<p><a href="baja.php">Borrar cuenta</a></p>

</body>
</html>
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


//echo "<p>A continuación mostramos algunos registros:</p>";

echo "<table style='border:0'>";
echo "<tr style='background-color:lightblue'>";
echo "<th>ID Obra</th>";
echo "<th>ID Autor</th>";
echo "<th>Titulo<a href=mostrarCatalogo.php?op=1>&#9650;</a><a href=mostrarCatalogo.php?op=2>&#9660;</a></th>";
echo "<th>Autor<a href=mostrarCatalogo.php?op=3>&#9650;</a><a href=mostrarCatalogo.php?op=4>&#9660;</a></th>";
if (isset($_REQUEST["id_autor"])){
echo "<th>Nacionalidad</th>";
echo "<th>Imagen</th>";
}
echo "</tr>";


$ruta="img/";

if (isset($_REQUEST["id_autor"])){
$id_autor = $_REQUEST["id_autor"];

    $resultado = $conexion -> query("SELECT * FROM autor,obra WHERE obra.id_autor=autor.id AND autor.id='$id_autor'");

}elseif(isset($_REQUEST["op"])&&($_REQUEST["op"]==1)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY titulo");
}elseif (isset($_REQUEST["op"])&&($_REQUEST["op"]==2)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY titulo DESC");
}elseif ((isset($_REQUEST["op"]))&&($_REQUEST["op"]==3)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY nombre");
}elseif ((isset($_REQUEST["op"]))&&($_REQUEST["op"]==4)){
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY nombre DESC");

//$resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY id_obra");
//$resultado = $conexion -> query("SELECT distinct id_autor FROM obra,autor WHERE obra.id_autor=autor.id ORDER BY id_autor");



}else{

if (isset($_POST["enviar"])){
    $tit=$_POST['titulo'];
    $enviado=true;
    
    $resultado=$conexion -> query("SELECT * FROM autor,obra WHERE obra.id_autor=autor.id AND (obra.titulo='$tit' OR autor.nombre='$tit')");

}else{
    $resultado = $conexion -> query("SELECT * FROM obra,autor WHERE autor.id=obra.id_autor ORDER BY titulo");
}

}

if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_assoc()) {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra['id_obra']."</a></td>\n";
    echo "<td>".$obra['id_autor']."</a></td>\n";
    echo "<td><a href='mostrarObra.php?id_obra=".$obra['id_obra']."'>".$obra['titulo']."</td>\n";
    echo "<td><a href='mostrarCatalogo.php?id_autor=".$obra['id_autor']."'>".$obra['nombre']."</td>\n";
    if (isset($_REQUEST["id_autor"])){
    echo "<td>".$obra['nacionalidad']."</td>\n";
    echo "<td><img src='$ruta".$obra['imag']."' width=100 heigh=100></td>\n";
    }
    echo "</tr>";
    
    /*while ($obra = $resultado->fetch_object('Obra')) {
        echo "<tr bgcolor='lightgreen'>";
        echo "<td>".$obra->getId_obra()."</a></td>\n";
        echo "<td>".$obra->getId_autor()."</a></td>\n";
        echo "<td><a href='mostrarObra.php?id_obra=".$obra->getId_obra()."'>".$obra->getTitulo()."</td>\n";
        echo "<td><a href='mostrarCatalogo.php?id_autor=".$obra->getId_autor()."'>".$obra->getNombre()."</td>\n";
        echo "<td>".$obra->getNacionalidad()."</td>\n";
        echo "</tr>";
    }*/
    
}
mysqli_free_result($resultado);
echo "</table>";
if($enviado==false){
?>
<form action="<?php echo $_SERVER['PHP_SELF']?>" method="post"><br/>
    <label>Buscar: </label>
    <input type="text" name="titulo">
    <input type="submit" value="Enviar" name="enviar">
</form>


<?php 
}
//echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);

?>
<p><a href="mostrarCatalogo.php">Eliminar filtros</a></p>
<a href="mostrarCatalogo.php">Volver</a>
</body>
</html>