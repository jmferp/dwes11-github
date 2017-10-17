###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P02 - Repaso: estructuras de control de flujo
#### Entrega de: *Jose Maria Fernandez*
----
#### 1. Descripción:

Vamos a instalar el Java Develompent Kit (JDK) y el entorno de desarrollo Eclipse. A continuación crearemos un proyecto Java en el que practicaremos las estructuras de control de flujo (tanto de selección como de iteración) a través de diferentes programas.

#### 2. Formato de entrega:

Completa este documento incluyendo tras cada apartado el código necesario para resolver el problema (sin incluir el método `main`, sólo el código correspondiente a la solución) y el resultado de una ejecución.

* Para el código utiliza bloques de código Markdown
* Para el resultado puedes utilizar también bloques, o bien incluir capturas de pantalla de Eclipse

#### 3. Trabajo a realizar:

Antes de comenzar, escribe tu / vuestros nombres en la cabecera de este documento

##### Parte 1: Configuración del espacio de trabajo en la máquina virtual de Windows 

1. Desinstala la versión actual de Java. Recuerda que normalmente cuando decimos que un ordenador "tiene instalado Java" lo que en realidad tiene instalado es el Java Runtime Environment (JRE).
2. Descarga la última versión del [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): Java 8 Update 144. Localiza la descarga en la web oficial, pero si lo deseas puedes descargar el archivo desde el FTP del instituto. **Utilizaremos esta versión de Java durante todo el curso. Es muy importante que tengas la misma en casa y no la actualices para evitar problemas al compartir proyectos posteriormente**.
3. Desde el menú de inicio, abre el panel de configuración de Java (`Configurar Java`). Recuerda: hablamos del JRE. El JDK no tiene ninguna aplicación gráfica
4. Comprueba que la versión es la esperada haciendo clic en el botón `Acerca de` en la pestaña `General`
5. En la pestaña `Actualizar` desmarca la casilla *Comprobar actualizaciones automáticamente*. Esto garantizará que todos tengamos la misma versión de Java a lo largo del curso.
6. Descarga la última versión de Eclipse, llamada Oxygen. Como más adelante desarrollaremos aplicaciones Java EE, no queremos el paquete básico de instalación: en la [web de descargas de Eclipse](http://www.eclipse.org/downloads/) debes hacer clic en *Download Packages* y escoger la edición para desarrolladores Java EE. Tienes el archivo disponible en el servidor FTP del instituto.
7. Descomprime el archivo de forma que la carpeta llamada `eclipse` (sin la versión) quede donde desees, por ejemplo en la raíz `C:\`
8. Crea un acceso directo al ejecutable de Eclipse en el escritorio y/o en la barra de tareas
9. Ejecuta Eclipse: la primera decisión será la ubicación de la carpeta de espacio de trabajo o *workspace*: puedes dejar la que viene por defecto o escoger otra a tu gusto
10. Inicialmente aparecerá la pantalla de bienvenida: desmarca la casilla para que no vuelva a aparecer en el futuro

#####Parte 2: Creación y organización de un proyecto

1. Crea un nuevo proyecto Java: `File` → `New` → `Project` → `Java Project`. El nombre es importante, puesto que seguiremos la misma nomenclatura durante todo el curso: *Número de práctica - Lenguaje utilizado - Título o descripción*, en este caso: *U0P02-Java-Control de flujo* 
2. Crea desde Eclipse una carpeta `doc` en la raíz del proyecto (junto a la carpeta `src`) y copia en ella el archivo de este enunciado (arrastra el archivo a la carpeta de Eclipse). A lo largo del curso seguiremos este esquema para agrupar cada proyecto con su correspondiente enunciado.
3. Indica que queremos editar los archivos Markdown con Typora: *clic secundario sobre el archivo → Open with → Other → Browse → Localizar el ejecutable de Typora en la carpeta de archivos de programa*. No olvides marcar la casilla para indicar que queremos utilizar este programa para abrir todos los archivos Markdown
4. Comprueba que al hacer doble clic sobre un archivo Markdown en Eclipse, se abre con Typora
5. Crea una clase *HolaMundo* con un código sencillo para probar que tu instalación de Java es correcta y puedes compilar y ejecutar programas en Java. 
6. Recuerda que dispones de plantillas de código para escribir rápidamente sentencias o bloques. Por ejemplo si escribes "sout" y pulsas Ctrl + Espacio, se escribirá `System.out.println();`. También hay plantillas para escribir un bloque if-else, while, try-catch... Consulta las plantillas en `Window` → `Preferences` → `Java` → `Editor` → `Templates`


#####Parte 3: Repaso de Java: estructuras de control de flujo

Crea un paquete llamado `ControlDeFlujo` y codifica en una o varias clases los siguientes programas:

1) Preguntar al usuario el día de la semana e indicar si es laborable o no. Resolver utilizando la estructura `switch`.

- *Código*:

```java
		import java.util.Scanner;

public class DiaSemana {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
		System.out.println("Introducir dia semana");
		int dia = sc.nextInt();
		switch(dia) {
		case 1: System.out.println("Laborable");
		break;
		case 2: System.out.println("Laborable");
		break;
		case 3: System.out.println("Laborable");
		break;
		case 4: System.out.println("Laborable");
		break;
		case 5: System.out.println("Laborable");
		break;
		case 6: System.out.println("No Laborable");
		break;
		case 7: System.out.println("No Laborable");
		break;
		}
	}

}
```

- *Ejecución*:

        Introducir dia semana
        6
        No Laborable
        -----------------------------------------------
        Introducir dia semana
        2
        Laborable

2) Pedir al usuario cinco cadenas de texto y generar una sola cadena uniéndolas todas. Escribir esa cadena por pantalla.

- *Código*:


```java
import java.util.Scanner;
public class CadenasTexto {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String cadena="";
	for(int i=1;i<=5;i++) {
		System.out.println("Introducir cadena de texto");
		String cad=sc.next();
		cadena=cadena+cad;
	}
	
	System.out.println(cadena);

}
}
```

- *Ejecución*




```java
Introducir cadena de texto
practica 
Introducir cadena de texto
control
Introducir cadena de texto
flujo
Introducir cadena de texto
de 
Introducir cadena de texto
datos
practicacontrolflujodedatos
```





3) Ir pidiendo por teclado una serie de números enteros e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir por pantalla la suma de todos los números introducidos.

- *Código*:



```java
import java.util.Scanner;

public class SumaNumeros {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num,total=0;
	do {
		System.out.println("Introducir numeros hasta 50");
		num=sc.nextInt();
		total=num+total;
	}while(total<=50);
	System.out.println("La suma es "+total);
}
}
```



- *Ejecución*:

```java
Introducir numeros hasta 50
20
Introducir numeros hasta 50
15
Introducir numeros hasta 50
18
La suma es 53
```



4) Pedir al usuario un número. Si introduce un valor inválido (por ejemplo una letra), se le volverá a solicitar que introduzca el número. 

Cuando termines, añade a continuación una expansión de este problema: pedir al usuario un número entre el 1 y el 10, pidiéndolo de nuevo si lo introduce mal.

Observa que estos dos bloques de código pueden ser reutilizados en cualquier punto de tus futuros programas en el que desees leer un número.


- *Código*:

```java
import java.util.Scanner;

public class PedirNumero {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	boolean ok;
	do {
	ok=true;
	try {
	System.out.println("Introducir un numero");
	String num;
	int numero;
	num=sc.next();
	numero=Integer.parseInt(num);
	ok=false;
	}catch(NumberFormatException ex) {
		System.out.println("No es un numero");
	}
	}while(ok!=false);
	}
}

------------------------------------------------------------------------------
  
  import java.util.Scanner;

public class PedirNum1y10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int op = -1;
		while ( (op<1)||(op>10) ){
			System.out.println("Introducir un numero entre 1 y 10");
			try{
				op = sc.nextInt();
			}catch (Exception e){
				sc = new Scanner(System.in);
				op = -1;
			}
		}
		sc.close();

	}

}
```



- *Ejecución*:

```
Introducir un numero
g
No es un numero
Introducir un numero
i
No es un numero
Introducir un numero
5
-----------------------------------------------------------
Introducir un numero entre 1 y 10
50
Introducir un numero entre 1 y 10
j
Introducir un numero entre 1 y 10
3
```



5) Preguntar al usuario un número de mes (del 1 al 12) y preguntar si el año es bisiesto (sí o no). Escribir su número de días. Si los datos no están bien introducidos se volverán a pedir. Utilizar estructura `switch`.

- *Código*:

public class MesBisiesto {

```java
public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	int mes = -1;
	boolean bis;
	while ( (mes<1)||(mes>12) ){
		System.out.println("Introducir un numero de mes");
		try{
			mes = sc.nextInt();
		}catch (Exception e){
			sc = new Scanner(System.in);
			mes = -1;
		}
	}
	
	System.out.println("Introducir año para saber si es bisiesto");
	int anio=sc.nextInt();
	if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
		System.out.println(anio+" es bisiesto");
		bis=true;
	}else {
		System.out.println(anio+" no es bisiesto");
		bis=false;
	}
	if(bis==true) {
	switch(mes) {
	case 1:System.out.println("31");
		break;
	case 2:if(bis==true) {
			System.out.println("29");
		}else {
			System.out.println("28");
		}
		break;
	case 3:System.out.println("31");
		break;
	case 4:System.out.println("30");
		break;
	case 5:System.out.println("31");
		break;
	case 6:System.out.println("30");
		break;
	case 7:System.out.println("31");
		break;
	case 8:System.out.println("31");
		break;
	case 9:System.out.println("30");
		break;
	case 10:System.out.println("31");
		break;
	case 11:System.out.println("30");
		break;
	case 12:System.out.println("31");
		break;
	}
	}
	sc.close();

}
```
- *Ejecución*:

```java
Introducir un numero de mes
d
Introducir un numero de mes
15
Introducir un numero de mes
2
Introducir año para saber si es bisiesto
2012
2012 es bisiesto
29
```



6) Pedir al usuario dos números “a” y “b” entre el 1 y el 10. Mientras uno de ellos sea menor que el otro, escribir un símbolo “*” en la pantalla e incrementar en una unidad el número menor.

- *Código*:

public class NumerosAyB {

```java
public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	int a = -1;
	while ( (a<1)||(a>10) ){
		System.out.println("Introducir un numero entre 1 y 10");
		try{
			a = sc.nextInt();
		}catch (Exception e){
			sc = new Scanner(System.in);
			a = -1;
		}
	}
	int b = -1;
	while ( (b<1)||(b>10) ){
		System.out.println("Introducir un numero entre 1 y 10");
		try{
			b = sc.nextInt();
		}catch (Exception e){
			sc = new Scanner(System.in);
			b = -1;
		}
	}
	if(a<b) {
	while(a<=b) {
		System.out.println("*");
		a=a+1;
	}
	}else {
		while(b<=a) {
		System.out.println("*");
		b=b+1;
		}
	}
	sc.close();
}
```
- *Ejecución*:

```java
Introducir un numero entre 1 y 10
5
Introducir un numero entre 1 y 10
2
*
*
*
*
```



7) Pedir al usuario un número entero y calcular el factorial de dicho número usando la estructura “do-while”. Repetir el ejercicio usando la estructura “while”, y repetirlo una vez más usando la estructura “for”.

- *Código (las tres versiones seguidas)*:




```java
public class Factorial {
public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	int op = -1;
	while (op<1){
		System.out.println("Introducir un numero para calcular factorial");
		try{
			op = sc.nextInt();
		}catch (Exception e){
			sc = new Scanner(System.in);
			op = -1;
		}
	}
	int num=op;
	int fact=1,aux;
	do {
		fact=fact*num;
		num=num-1;
	}while(num>0);
	
	System.out.println(fact);
	fact=1;
	num=op;
	while(num>0) {
		fact=fact*num;
		num=num-1;
	}
	System.out.println(fact);
	fact=1;
	num=op;
	for(int i=num;i>=1;i--) {
		fact=fact*i;
	}
	System.out.println(fact);
	
	sc.close();
}
}
```



- *Ejecución*:

```java
Introducir un numero para calcular factorial
5
120
120
120
```



8) Basándote en la estructura `do-while`, diseña un menú de dos niveles, es decir: en un primer momento se pedirá escoger entre varias opciones, y en cada una de ellas se pedirá de nuevo escoger entre un nuevo conjunto. La temática es libre (cálculo de áreas, enciclopedia, etc). Es importante que tu programa reaccione correctamente ante entradas erróneas del usuario, y que en todos los menús haya una opción para volver.

  Ten en cuenta que codificar un menú correctamente no es trivial, conviene que pienses lo que vas a hacer antes de empezar a codificar.



```java
public class Menu2niveles {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int x1,x2;
	do {
		System.out.println("Figuras");
		System.out.println("1:Cuadrado");
		System.out.println("2:Rectangulo");
		System.out.println("3:Salir");
		x1=sc.nextInt();
		switch (x1) {
		case 1:
			do {
				System.out.println("Introduce:");
				System.out.println("1:Area");
				System.out.println("2:Perimetro");
				System.out.println("3:Volver");
				x2=sc.nextInt();
				switch (x2) {
				case 1:
					System.out.println("Introducir lado");
					int lado=sc.nextInt();
					System.out.println(lado*lado);
					break;
				case 2:
					System.out.println("Introducir lado");
					lado=sc.nextInt();
					System.out.println(lado*4);
					break;
				}
			}while(x2!=3);
			break;
		case 2:
			do {
				System.out.println("Introduce:");
				System.out.println("1:Area");
				System.out.println("2:Perimetro");
				System.out.println("3:Volver");
				x2=sc.nextInt();
				switch (x2) {
				case 1:
					System.out.println("Introducir base");
					int base=sc.nextInt();
					System.out.println("Introducir altura");
					int altura=sc.nextInt();
					System.out.println(base*altura);
					break;
				case 2:
					System.out.println("Introducir base");
					base=sc.nextInt();
					System.out.println("Introducir altura");
					altura=sc.nextInt();
					System.out.println(base*2+altura*2);
					break;
				}
			}while(x2!=3);
			break;
		}
	}while(x1!=3);
}
}
```


```java
Figuras
1:Cuadrado
2:Rectangulo
3:Salir
1
Introduce:
1:Area
2:Perimetro
3:Volver
1
Introducir lado
4
16
Introduce:
1:Area
2:Perimetro
3:Volver
3
Figuras
1:Cuadrado
2:Rectangulo
3:Salir
3
```



9) (opcional) Inventa un problema sencillo sobre estructuras de control de flujo. Resuélvelo para comprobar que el nivel de dificultad es adecuado y comparte el enunciado con tu compañer@ de al lado. Incluye aquí tanto tu enunciado como la solución.

- *Enunciado*:

- *Código de la solución*

- *Ejecución*:

10) (opcional) Resuelve el problema que tu compañer@ plantee.

- *Enunciado de tu compañer@:*

- *Código de la solución*

- *Ejecución*:
