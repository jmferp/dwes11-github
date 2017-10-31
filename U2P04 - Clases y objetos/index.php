<?php
include("rectangulo.php");
if(!isset($_POST['enviar'])){
    ?>
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
	Base:<input type="number" name="base">
	Altura:<input type="number" name="altura">
	<input type="submit" name="enviar">
	</form>
	<?php
}else{
    $base=$_POST["base"];
    $altura=$_POST["altura"];
    $rec=new Rectangulo($base,$altura);
    echo "<p>Area: ".$rec->calcularArea()."</p>";
    echo "<p>Perimetro: ".$rec->calcularPerimetro()."</p>";
    $rec->setTitulo("Rectangulo 1");
    $rec->setColor("Rojo");
    echo "<p>Altura: ".$rec->getAltura()."</p>";
    echo "<p>Base: ".$rec->getBase()."</p>";
    echo "<p>Titulo: ".$rec->getTitulo()."</p>";
    echo "<p>Color: ".$rec->getColor()."</p>";
    
    foreach ($rec as $clave => $valor) {
        echo "$clave => $valor\n";
    }
    echo "<br>";
    $rec2=$rec;
    echo "".$rec->__toString()."<br>";
    
    
    
    
}
    