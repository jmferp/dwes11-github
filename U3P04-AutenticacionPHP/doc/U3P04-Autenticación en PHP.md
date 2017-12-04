###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U3P04 - Autenticación en PHP
#### Entrega de: *pon aquí tu nombre*
----
#### 1. Descripción:

El objetivo de esta práctica es codificar un sistema de alta de usuario, inicio de sesión, cierre de sesión y baja de usuario. Utilizaremos la base de datos de usuarios del catálogo, de forma que podamos más tarde reutilizar este trabajo para añadir un sistema de autenticación a nuestro proyecto de catálogo.

En la última parte se hará una modificación para que las contraseñas no se almacenen en la base de datos *en claro*, sino encriptadas.

#### 2. Formato de entrega:

Enseña el resultado al profesor.

#### 3. Trabajo a realizar:


Vamos a manejar dos variables asociadas a la sesión de usuario:
	* `login`: sus valores serán 0 ó 1 y su misión es indicar si hay algún usuario autenticado
	* `usuario`: almacenará el nombre de usuario (por ejemplo `aruiz`, no confundir con el nombre completo *del* usuario) del usuario que se encuentra autenticado en este navegador

Observa que ambas variables podrían resumirse en una, asumiendo que si el usuario está vacío no existe sesión.

* Crea una carpeta 'login' dentro de tu proyecto de sesiones en PHP: en ella iremos creando a lo largo de esta práctica los siguientes archivos:

* `index.php`: simulará el contenido real de nuestra aplicación, sólo disponible para usuarios autenticados (en esta práctica será simplemente un saludo al usuario autenticado). Si un usuario accede a esta página sin estar autenticado, será redirigido de forma automática a `login.php`
* `login.php`: muestra un formulario para iniciar sesión. El formulario será tratado en esta misma página, y si las credenciales son correctas se iniciará sesión y se redirigirá automáticamente a `index.php`
* `logout.php`: cierra la sesión y redirige de forma automática a `login.php`
* `alta.php`: muestra un formulario para dar de alta un usuario. El formulario será tratado en esta misma página: si no hay errores añadirá el nuevo usuario a la base de datos y redirigirá a `login.php`
* `baja.php`: elimina el usuario de la base de datos y redirige a `logout.php` para cerrar la sesión. Para dar mayor realismo, solicitaremos al usuario que confirme su contraseña antes de proceder a la baja.

Asegúrate de que tienes claro el funcionamiento de nuestra aplicación de autenticación antes de comenzar a desarrollar el código.

Se indica a continuación el esquema de desarrollo de cada archivo: si tienes dudas consulta al profesor. En todos los archivos se distingue el código PHP que se debe incluir *antes* de emitir código HTML (es decir, antes de la primera etiqueta `<html>`), al ser relativo a sesiones.

En todas las páginas utilizaremos el mismo mecanismo de gestión de errores: habrá una variable `$mensajeError`, inicialmente vacía. Cuando surja cualquier problema se le dará valor con el mensaje explicativo correspondiente. Si realizadas las acciones necesarias la variable `$mensajeError` sigue vacía, sabremos que todo ha ido bien: de lo contrario, mostraremos dicha variable al usuario en forma de título o párrafo.

```php
$resultado = $conexion->query($consulta);
$mensajeError = $conexion->error;
if (empty($mensajeError))
	header ("Location: login.php");
```

Aunque no se reflejará en las indicaciones para no complicarlas más de lo necesario, este mecanismo debería incluir el posible fallo al conectar al motor de bases de datos:

```php
if ($conexion->connect_errno) {
	$mensajeError = "Error al establecer la conexión: " . $conexion->connect_errno . "-" . $conexion->connect_error;
}
```

##### Parte 1: Inicio de sesión: login.php

* Antes de emitir código HTML
  * Recuperar la sesión actual
  * Si existe sesión iniciada (variable de sesión *login* es 1) redirigir a `index.php`
  * Inicializar la variable "mensajeError" vacía
  * Si el usuario ha enviado el formulario...
    * ¿Existe el usuario en la base de datos?
      * No: actualizar "mensajeError"
      * Sí:
        * ¿Coincide la contraseña con la almacenada en la base de datos?
          * No: actualizar "mensajeError"
          * Sí:
            * Dar valor 1 la variable de sesión *login*
            * Dar el valor del nombre de usuario a la variable de sesión *usuario*
            * Redirigir a `index.php`
* Después de emitir la cabecera HTML (sólo se mostrará si el usuario no ha enviado el formulario o bien lo envió pero hubo algún error)
  * Mostrar el formulario para solicitar usuario y contraseña.  El formulario será procesado por este mismo archivo.
  * Añadir un enlace a `alta.php` con un texto parecido a este: *¿aún no tienes cuenta? Haz clic aquí para crear una*.

**Comentarios sobre el código**:
* Para probar la redirección deberás codificar un archivo `index.php` de muestra.

##### Parte 2: Contenido de la aplicación: index.php
* Antes de emitir código HTML
  * Inicializar la variable $mensajeError vacía
  * Recuperar la sesión actual
  * Si la variable de sesión *login* no tiene valor 1, redirigir a `login.php`
* Después de emitir la cabecera HTML (sólo se llega hasta aquí si hay sesión iniciada, gracias al punto anterior, de lo contrario se habrá redirigido a `login.php`))
  * ¿Se encuentra en la base de datos el usuario que ha iniciado sesión?
    * No: redirigir a `logout.php`. ¿Se te ocurre en qué caso podría ocurrir esto? La respuesta está más abajo.
    * Sí:
      * Obtener su nombre completo de la base de datos (y si lo deseas, la descripción o el tipo de cuenta)
      * Mostrar un mensaje de bienvenida al usuario dirigiéndonos a él por su nombre completo
      * Incluir un enlace para cerrar sesión, dirigido a `logout.php`
      * Incluir un enlace para eliminar la cuenta, dirigido a `baja.php`

**Comentarios sobre el código**:

* En este caso buscamos el usuario después de la cabecera HTML, mientras que en `login.php` lo hacíamos antes:
  * En `login.php` era necesario hacerlo así, puesto que de la búsqueda dependía la creación de sesión, y recuerda que eso se hace siempre antes de la cabecera
  * En `index.php` puedes elegir. En este enunciado se ha sugerido hacerlo después para poder escribir los mensajes de saludo al usuario: si lo pusieras antes, no podrías escribir código (porque aún no habríamos escrito la cabecera HTML), y tendrías que *preparar* los mensajes almacenándolos en variables para mostrarlos más adelante.
* Cuando buscamos en la base de datos el usuario que ha iniciado sesión, lo lógico es que siempre lo encontremos, pero podría darse el improbable caso de que el mismo usuario se hubiese dado de baja en otro navegador justo en ese momento, dejando la sesión actual inconsistente. En este caso *expulsamos* al usuario redirigiendo a `logout.php`. Intenta probar este caso dando de baja al usuario en medio de una sesión (puedes forzarlo borrando directamente la entrada del usuario en la base de datos).
* Observa que en el enlace de baja no se incluye parámetro: esto es así porque el usuario está almacenado como variable de sesión.

##### Parte 3: Cerrar sesión: logout.php
* Antes de emitir código HTML
  * Recuperar la sesión actual
  * Fijar a 0 el valor de la variable de sesión *login*
  * Redirigir a `login.php`

**Comentarios sobre el código**:
* Este archivo es muy breve (apenas tres líneas de código): observa que no se genera ninguna salida HTML
* Opcionalmente podrías borrar el balor de la variable de sesión *usuario*, pero no hace falta porque si *login* está a 0 se considera que no hay sesión
* Se ha separado este código en un archivo independiente por claridad, pero realmente se podría incluir este fragmento de código en `login.php` recibiendo un parámetro como hemos hecho en otras ocasiones. El enlace de `index.php` tendría este aspecto:

```html
<p><a href="login.php?cerrarSesion=true">Cerrar sesión</a></p>
```

* Con esta solución, en `login.php` se consultaría si la request contiene el parámetro *cerrarSesion*, ejecutando en ese caso las tres líneas de código mencionadas.

##### Parte 4: Alta de nuevos usuarios: alta.php
* Antes de emitir código HTML
  * Inicializar la variable "mensajeError" vacía
  * Si el usuario ha enviado el formulario...
    * ¿El campo de nombre de usuario está vacío?
      * Sí: Actualizar la variable "mensajeError"
      * No: ¿El campo de contraseña está vacío?
        * Sí: Actualizar la variable "mensajeError"
        * No: ¿Existe ya en la base de datos un usuario con el mismo nombre de usuario?
          * Sí: Actualizar la variable "mensajeError"
          * No: ¿Sucede un error al intentar insertar el nuevo usuario en la base de datos?
            * Sí: Actualizar la variable "mensajeError" con el atributo *error* del objeto "conexion"
            * No: redirigir a 'login.php'
* Después de emitir la cabecera HTML (sólo se llega hasta aquí si el usuario no ha enviado el formulario o bien lo envió pero hubo algún error, de lo contrario se habrá redirigido a `login.php`)
  * Mostrar un formulario de alta con campos para nombre, password, nombre completo, descripción, y tipo de cuenta (con un campo de tipo radio podrás elegir entre cuenta estándar o de administrador).  El formulario será procesado por este mismo archivo.
  * Incluir un enlace a `login.php` con un texto parecido a este: *¿Ya tienes cuenta? Haz clic aquí para iniciar sesión*.

**Comentarios sobre el código**:
	* Ten en cuenta que el usuario que uses para conectarte a la base de datos necesitará permisos de escritura
	* Puedes incluir operaciones de validación para restringir los nombres de usuario y contraseñas que se aceptan
	* En el código propuesto sólo exigimos valores no vacíos para nombre de usuario y contraseña, el resto se pueden dejar en blanco

##### Parte 5: Baja de usuarios: baja.php
* Antes de emitir código HTML
  * Inicializar la variable "mensajeError" vacía
  * Recuperar la sesión actual
  * Si el usuario ha enviado el formulario...
    * ¿El campo de contraseña está vacío?
      * Sí: Actualizar la variable "mensajeError"
      * No: ¿Coincide la contraseña con la almacenada en la base de datos?
        * No: actualizar "mensajeError"
        * Sí: ¿surge error al intentar eliminar el usuario de la base de datos?
          * Sí: Actualizar la variable "mensajeError" con el atributo *error* del objeto "conexion"
          * No: redirigir a 'logout.php'
* Después de emitir la cabecera HTML (sólo se llega hasta aquí si el usuario no envió el formulario, o bien lo envió pero surgieron errores, de lo contrario se habrá redirigido a `logout.php`)
  * Mostrar el formulario de confirmación de contraseña para proceder al borrado de la cuenta. El formulario será procesado por este mismo archivo.
  * Incluir un enlace para volver a `index.php` por si el usuario cambia de idea y no desea dar de baja la cuenta.

**Comentarios sobre el código**:
*  Observa que si la baja se produce de forma satisfactoria, redirigimos a `logout.php`. El motivo es que eliminar el usuario de la base de datos impide futuros accesos de dicho usuario, pero no afecta a la sesión que tenía ya iniciada.

##### Parte 6: Integración con el catálogo

Integra tu sistema de autenticación con la aplicación que ya tenías para visualizar el catálogo: sólo podrán verlo los usuarios registrados en tu tabla "usuario".

##### Parte 7 (opcional): Encriptación de contraseñas

###### 6.1 Descripción del mecanismo de encriptación
No es buena política almacenar las contraseñas sin encriptar en la base de datos. El administrador nunca debería conocer las contraseñas que ponen sus usuarios: sólo resetearlas si llega el caso. En su lugar se suele utilizar una función criptográfica hash (resumen) y almacenar su resultado. Así se hace, por ejemplo, en el archivo de contraseñas de Linux (`/etc/passwd`).

Una función hash (o función resumen) convierte cualquier cantidad de datos en un valor de longitud fija utilizando un algoritmo matemático. En nuestro caso utilizaremos el algoritmo bcrypt, que generará secuencias de 60 caracteres sin aparente relación con el original (por ejemplo `2y$10$IZaPBX`...)

Hasta ahora hacíamos esto para autenticar:
* Leer el campo de contraseña del formulario que ha rellenado el usuario
* Leer de la base de datos la contraseña del usuario
* Utilizar una función de comparación de String para ver si son iguales

Ahora en la base de datos almacenaremos el resumen (hash) encriptado de la contraseña del usuario utilizando la función `password_hash`, y no la contraseña *en claro*. El proceso será entonces:
* Leer el campo de contraseña del formulario que ha rellenado el usuario
* Leer de la base de datos el resumen de la contraseña
* Utilizar la función `password_verify`, que recibe dos parámetros: el primero será el password sin encriptar que ha introducido el usuario, y el segundo el resumen hash de la contraseña real. Esta función devolverá *true* si las contraseñas coinciden.

Más información:
* [Función password_hash](http://php.net/manual/es/function.password-hash.php)
* [Función password_verify](http://php.net/manual/es/function.password-verify.php)

###### 6.2 Aplicación a nuestro ejemplo

* Modifica desde phpMyAdmin el campo de contraseña de tu base de datos, para ampliarlo a 60 caracteres. Ten en cuenta que los desarrolladores advierten que quizá bcrypt acabe utiizando resúmenes de 255, así que si desarrollas aplicaciones con intención de que duren, es mejor utilizar este valor.
* En `alta.php`, localiza el código en el que preparas los campos que introducirás en la base de datos para el nuevo usuario. En lugar de incluir la contraseña, introduce su resumen:

```php
$passwordHash = password_hash($passwordForm, PASSWORD_DEFAULT);
```

* En la línea anterior, $passwordForm es el campo leído del formulario, y PASSWORD_DEFAULT indica el algoritmo a utilizar (por defecto bcrypt).
* Ahora en `login.php` modifica el código para utilizar `password_verify` en lugar de una función de comparación de String. Es muy importante el orden de los parámetros: primero irá el valor sin encriptar (leído del formulario) y luego el resumen (leído de la base de datos).
* Elimina desde phpMyAdmin los usuarios de tu base de datos y crea otros nuevos utilizando tu aplicación de alta. Observa que las contraseñas se almacenarán ya encriptadas, y comprueba que la aplicación funciona exactamente igual que antes.
