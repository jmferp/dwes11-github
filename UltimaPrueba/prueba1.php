<!DOCTYPE HTML>
<html>
<head>
<title>Validacion</title>
<style>
.error {
	color: #FF0000;
}

form {
	border-style: solid;
}
</style>
</head>
<body>

<?php
$emailErr = $usuarioErr = $contraseñaErr = $marcaErr = $modeloErr = $fechaCompraErr = $colorErr = $kmErr = $precioErr = "";
$email = $usuario = $contraseña = $marca = $modelo = $fechaCompra = $color = $km = $precio = $descripcion = "";
$fallo = false;


if ($_SERVER ["REQUEST_METHOD"] == "POST") {
	// Pasamos los datos de las altas
	if (empty ( $_POST ["altas"] )) {
		$altas = $_POST ["altas"];
	}else {
		$altas .= "," + $_POST ["altas"];
	}
	// Comprobamos que el nombre contenga solo letras y espacios
	if (empty ( $_POST ["user"] )) {
		$usuarioErr = "Se requiere un nombre";
		$fallo = true;
	} else {
		$usuario = test_input ( $_POST ["user"] );
		if (! preg_match ( "/^[a-zA-Z ]*$/", $_POST ["user"] )) { // funcion para comprobar que solo existen letras y espacios
			$usuarioErr = "Solo espacios y letras";
			$fallo = true;
		}
	}
	// Comprobamos que la contraseña sea correcta
	if (empty ( $_POST ["passw"] )) {
		$contraseñaErr = "Se requiere una contraseña";
		$fallo = true;
	} else {
		// funcion para comprobar que la clave tiene entre 6 y 10 caracteres, con letras y numeros y una mayuscula
		if (! preg_match ( '`[0-9]`', $_POST ["passw"] )) {
			$contraseñaErr = "Contraseña incorrecta necesita al menos un numero";
			$fallo = true;
		} else if (strlen ( $_POST ["passw"] ) < 6) {
			$contraseñaErr = "Contraseña incorrecta necesita al menos 6 caracteres";
			$fallo = true;
		} else if (strlen ( $_POST ["passw"] ) > 10) {
			$contraseñaErr = "Contraseña incorrecta necesita como maximo 10 caracteres";
			$fallo = true;
		} else if (! preg_match ( '`[a-z]`', $_POST ["passw"] )) {
			$contraseñaErr = "Contraseña incorrecta necesita al menos una letra minuscula";
			$fallo = true;
		} else if (! preg_match ( '`[A-Z]`', $_POST ["passw"] )) {
			$contraseñaErr = "Contraseña incorrecta necesita al menos una letra mayuscula";
			$fallo = true;
		}else if ($_POST ["passw"] != $_POST ["passw2"]){
			$contraseñaErr = "Las contraseñas no coinciden";
			$fallo = true;
		}
	}
	if (empty ( $_POST ["email"] )) {
		$emailErr = "Email es campo obligatorio";
		$fallo = true;
	} else {
		if (! filter_var ( $email, FILTER_VALIDATE_EMAIL )) { // Comprobamos que el email es valido
			$emailErr = "Formato de email es invalido";
			$fallo = true;
		}
	}
	// Comprobamos que la marca contenga solo letras
	if (empty ( $_POST ["marca"] )) {
		$marcaErr = "Se requiere un nombre";
		$fallo = true;
	} else {
		// funcion para comprobar que solo existen letras
		if (! preg_match ( '`[A-Z]`', $_POST ["marca"] )) {
			$marcaErr = "Solo letras";
			$fallo = true;
		}else if (! preg_match ( '`[a-z]`', $_POST ["marca"] )) {
			$marcaErr = "Solo letras";
			$fallo = true;
		}
	}
	// Comprobamos que la marca contenga solo letras y numeros (ambos necesarios)
	if (empty ( $_POST ["modelo"] )) {
		$modeloErr = "Se requiere un nombre";
		$fallo = true;
	} else {
		// funcion para comprobar que solo existen letras y numeros (ambos necesarios)
		if (! preg_match ( '`[A-Z]`', $_POST ["marca"] ) and ! preg_match ( '`[a-z]`', $_POST ["marca"] )) {
			$modeloErr = "Solo letras y numeros";
			$fallo = true;
		}else if (! preg_match ( '`[0-9]`', $_POST ["marca"] )) {
			$modeloErr = "Solo letras";
			$fallo = true;
		}
	}
	// Comprobamos que la fecha sea correcta
	if (empty ( $_POST ["fechacompra"] )) {
		$fechaCompraErr = "Se requiere un año";
		$fallo = true;
	} else {
		$fechaComprabis = explode("/", $_POST ["fechacompra"]);
		if (!checkdate(intval($fechaComprabis[1]), intval($fechaComprabis[0]), intval($fechaComprabis[2]))) {
		$fechaCompraErr = "La fecha es invalida";
		$fallo = true;
		}
	}
	// Comprobamos que los kilometros sean un valor numerico
	if (empty ( $_POST ["km"] )) {
		$kmErr = "Se necesita un valor para los kilometros";
		$fallo = true;
	} else {
		if (!is_numeric($_POST ["km"])) {
		$kmErr = "El valor debe ser numerico";
		$fallo = true;
		}
	}
	// Comprobamos que el precio sea un valor numerico
	if (empty ( $_POST ["precio"] )) {
		$precioErr = "Se necesita un valor para el precio";
		$fallo = true;
	} else {
		if (!is_numeric($_POST ["precio"])) {
		$precioErr = "El valor debe ser numerico";
		$fallo = true;
		}
	}
	//Damos valor al comentario/descripcion
	if (empty ( $_POST ["comentario"] )) {
		$descripcion = "";
	} else {
		$descripcion = test_input ( $_POST ["comentario"] );
	}
}
function test_input($data) {
	$data = trim ( $data );
	$data = stripslashes ( $data );
	$data = htmlspecialchars ( $data );
	return $data;
}
?>
	<form method="post"
		style="text-align: center; background-color: lightblue"
		action="
		<?php
		echo htmlspecialchars ( $_SERVER ["PHP_SELF"] ) . '"';
		if (! empty ( $_POST ["submit"] ) and $fallo == false) {
			echo ' hidden="hidden';
		}?>">
		<span class="error">* Campo requerido.</span>
		<br>
 		<fieldset>
 		<legend>Datos del usuario</legend>
		Usuario:
		<br> <input type="text"	name="user" value="<?php echo $usuario;?>">
		<br> <span class="error">* <?php echo $usuarioErr;?></span>
		<br>
		Constraseña: <br>
		<input type="password" name="passw">
		<br>
		<span class="error">* <?php echo $contraseñaErr;?></span>
		<br>
		Repetir contraseña: <br>
		<input type="password" name="passw2">
		<br>
		<span class="error">*</span>
		<br>
		Correo electronico: <br>
		<input type="text" name="email" value="<?php echo $email;?>">
		<br>
		<span class="error">* <?php echo $emailErr;?></span>
		<br>
 		</fieldset>
 		<fieldset>
 		<legend>Datos del coche</legend>
		Marca:
		<br> <input type="text"	name="marca" value="<?php echo $marca;?>">
		<br> <span class="error">* <?php echo $marcaErr;?></span>
		<br>
		<br>
		Modelo: <br>
		<input type="text" name="modelo" value="<?php echo $modelo;?>">
		<br>
		<span class="error">* <?php echo $modeloErr;?></span>
		<br>
		<br>
		Fecha de compra: <br>
		<input type="text" name="fechacompra" placeholder="dd/mm/aaaa" value="<?php echo $fechaCompra;?>">
		<br>
		<span class="error">* <?php echo $fechaCompraErr;?></span>
		<br>
		<br>
		Kilometros: <br> <input type="text" name="km" value="<?php echo $km;?>">
		<br>
		<span class="error">* <?php echo $kmErr;?></span>
		<br>
		<br>
		Precio: <br>
		<input type="text" name="precio" value="<?php echo $precio;?>"> <br> <span class="error">* <?php echo $precioErr;?></span>
		<br>
		<br>
		Descripcion: <br>
		<textarea name="comentario" rows="5" cols="40" noresize><?php echo $descripcion;?></textarea>
		<br>
		<br>
 		</fieldset>
 		<input type="hidden" name="altas" value="<?php echo $altas; ?>">
		<input type="submit" name="submit" value="Enviar">
		<input type="reset" name="reset" value="Reestablecer">
	</form>

<?php

if (! empty ( $_POST ["submit"] ) and $fallo == false) {
	
}
?>

</body>
</html>