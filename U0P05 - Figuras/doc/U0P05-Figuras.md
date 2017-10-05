##### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P05 - Figuras
#### Entrega de: *Jose Maria Fernandez Parra*
----

#### 1. Descripción:

Vamos a utilizar el enfoque orientado a objetos para solucionar un problema trigonométrico, repasando conceptos como clases y objetos, herencia y polimorfismo, colecciones, o JavaDoc.

#### 2. Formato de entrega:

Incluye al final de este documento el código de las clases que hayas programado, así como el resultado de ejecución.

Puedes utilizar bloques de código Markdown o capturas de Eclipse.

#### 3. Trabajo a realizar:

#### Parte 1: Clases y objetos

Crea un paquete llamado `figuras` y codifica las clases Cuadrado, Triangulo y Circunferencia. Incluye en todas un método para imprimir sus datos. Después codifica una clase *Problema* que calcule el área y el perímetro de la siguiente figura:

![](U0P05-1.png "...")

##### Código de la clase Cuadrado:

```java
public class Cuadrado {
	private double lado;

	public Cuadrado(double lado) {
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double area(){
		return this.getLado()*this.getLado();
	}
	
	public double perimetro() {
		return this.getLado()*4;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
}
```

##### Código de la clase Triángulo:



```java
public class Triangulo {
    private double base;
    private double altura;

    public Triangulo(double base,double altura) {
        this.base=base;
        this.altura=altura;
    }

    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double area() {
        return this.getBase()*this.getAltura()/2;
    }
    @Override
    public String toString() {
        return "Triangulo [base=" + base + ", altura=" + altura + "]";
    }
}
```


##### Código de la clase Circunferencia:




```java
public class Circunferencia {
private double radio;
public Circunferencia(double radio) {
	this.radio=radio;
}

public double getRadio() {
	return radio;
}

public void setRadio(double radio) {
	this.radio = radio;
}

@Override
public String toString() {
	return "Circunferencia [radio=" + radio + "]";
}
}
```




##### Código del método main en la clase Problema:


​		

```java
public static void main(String[] args) {
	Circunferencia cir1=new Circunferencia(4.8);
	Circunferencia cir2=new Circunferencia(1.5);
	Cuadrado cua1=new Cuadrado(4.2);
	Triangulo tri1=new Triangulo(8,15);
	
	System.out.println("El area es "+area(cir1,cir2,cua1,tri1));
	System.out.println("El perimetro es "+perimetro(cir1,cir2,cua1,tri1));
		
}

public static double area(Circunferencia cir1,Circunferencia cir2,Cuadrado cua1,Triangulo tri1) {
	double aCir1=(Math.PI*Math.pow(cir1.getRadio(), 2))/2;
	double aCir2=(Math.PI*Math.pow(cir2.getRadio(), 2))*3/4;
	double aCua1=cua1.getLado()*cua1.getLado();
	double aTri1=(tri1.getAltura()*tri1.getBase())/2;
	return aCir1+aCir2+aCua1+aTri1;
}

public static double perimetro(Circunferencia cir1,Circunferencia cir2,Cuadrado cua1,Triangulo tri1) {
	double pCir1=Math.PI*cir1.getRadio();
	double pCir2=(2*Math.PI*cir2.getRadio()*3)/4;
	double pCua1=cua1.getLado()*3;
	double pTri1=(tri1.getBase()-cir2.getRadio())+(tri1.getAltura()-cir2.getRadio()-cua1.getLado())+(Math.sqrt(Math.pow(tri1.getBase(), 2)+(Math.pow(tri1.getAltura(), 2)))-cir1.getRadio()*2);
	return pCir1+pCir2+pCua1+pTri1; 
}
```


##### Ejecución del método main:

```java
El area es 119.13258497228719
El perimetro es 57.94822820780804
```



#### Parte 2: Herencia

Queremos que todas las figuras tengan un título y un color. Para el color puedes utilizar un tipo enumerado Color con al menos cinco valores.

1. Define una clase Figura con estos nuevos atributos
- Haz que nuestras clases de figuras hereden dichos atributos
- ¿Crees que la clase Figura debería ser abstracta? ¿Y los métodos de calcular áreas y perímetros? Si es así haz las modificaciones necesarias
- Utilizando la *reescritura*, haz que de cada figura se impriman en pantalla tanto sus atributos heredados (color y título) como los propios de esa figura particular.
- Crea una clase Principal con un método main en el que instancies diferentes figuras por este procedimiento y escribas sus datos por pantalla.

##### Código de la clase Figura:

```java
public abstract class Figura {
private String titulo;
private Color color;

public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}

@Override
	public String toString() {
		return "Figura [titulo=" + titulo + ", color=" + color + "]";
	}
	public abstract double area();
	public abstract double perimetro();
}
```

##### Código de la clase Cuadrado una vez modificada:


```java
public class Cuadrado extends Figura {
private double lado;
public Cuadrado(String titulo,Color color,double lado) {
	super.setTitulo(titulo);
	super.setColor(color);
	this.lado=lado;
}

public double getLado() {
	return lado;
}

public void setLado(double lado) {
	this.lado = lado;
}

public double area(){
	return this.getLado()*this.getLado();
}

public double perimetro() {
	return this.getLado()*4;
}

@Override
public String toString() {
	return "Cuadrado [lado=" + lado + ", getTitulo()=" + getTitulo() + ", getColor()=" + getColor() + "]";
}
```
##### Código del método main en la clase Principal:

```java
public static void main(String[] args) {
	Circunferencia cir1=new Circunferencia("Circulo 1",Color.Amarillo,4.8);
	Circunferencia cir2=new Circunferencia("Circulo 2",Color.Verde,1.5);
	Cuadrado cua1=new Cuadrado("Cuadrado",Color.Negro,4.2);
	Triangulo tri1=new Triangulo("Triangulo",Color.Rojo,8,15);
	
	System.out.println(tri1.toString());
	System.out.println(cir1.toString());
	System.out.println(cir2.toString());
	System.out.println(cua1.toString());

}
```
##### Ejecución del método main:

```java
Triangulo [base=8.0, altura=15.0, getTitulo()=Triangulo, getColor()=Rojo]
Circunferencia [radio=4.8, getTitulo()=Circulo 1, getColor()=Amarillo]
Circunferencia [radio=1.5, getTitulo()=Circulo 2, getColor()=Verde]
Cuadrado [lado=4.2, getTitulo()=Cuadrado, getColor()=Negro]
```



#### Parte 3: Colecciones

1. Codifica una clase GestorFiguras con un único atributo (un ArrayList de figuras) y los siguientes métodos, teniendo cuidado de documentar con código JavaDoc:
  - **constructor**: no recibirá ningún valor pero inicializará el ArrayList
  - **añadirFigura**: recibirá un objeto de la clase Figura y lo añadirá a la lista siempre que no tenga el mismo título
  - **eliminarFigura**: eliminará una figura a partir de su título
  - **mostrarFiguras**: escribirá por pantalla de forma ordenada los datos de todas las figuras del gestor
  - **calcularSumatorioAreas**: escribirá la suma de las áreas de todas las figuras

2. Modifica el método main de la clase Principal para crear un gestor de figuras y hacer pruebas con él: añadir alguna, eliminarla, imprimirlas... 

##### Código de la clase GestorFiguras:


```java
public class GestorFiguras{
private ArrayList<Figura> arFig;

public GestorFiguras() {
	this.arFig= new ArrayList<Figura>();
}

public void anadirFigura(Figura fig) {
	boolean enc=false;
	for(int i=0;i<arFig.size();i++) {
		if(arFig.get(i).getTitulo().equalsIgnoreCase(fig.getTitulo())) {
			enc=true;
		}
	}
	if(!enc) {
	arFig.add(fig);
	}
}

public void eliminarFigura(String tit) {
	for(int i=0;i<arFig.size();i++) {
		if(arFig.get(i).getTitulo().equalsIgnoreCase(tit)) {
			arFig.remove(i);
		}
	}
}

public void mostrarFiguras() {
	for(int i=0;i<arFig.size();i++) {
		System.out.println(arFig.get(i).toString());;
	}
	
}

public double calcularSumatorioAreas(){
	double suma=0;
	for(int i=0;i<arFig.size();i++) {
		suma=suma+(arFig.get(i).area());
	}
	return suma;
}
```
##### Código del método main en la clase Principal:



```java
public static void main(String[] args) {
	Circunferencia cir1=new Circunferencia("Circulo 1",Color.Amarillo,4.8);
	Circunferencia cir2=new Circunferencia("Circulo 2",Color.Verde,1.5);
	Cuadrado cua1=new Cuadrado("Cuadrado",Color.Negro,4.2);
	Triangulo tri1=new Triangulo("Triangulo",Color.Rojo,8,15);

	GestorFiguras gestor=new GestorFiguras();
	gestor.anadirFigura(cir1);
	gestor.anadirFigura(cir2);
	gestor.anadirFigura(cua1);
	gestor.anadirFigura(tri1);
	System.out.println("Mostrar todas las figuras");
	gestor.mostrarFiguras();
	gestor.eliminarFigura("Circulo 2");
	System.out.println("Eliminando circulo 2");
	gestor.mostrarFiguras();
	System.out.println("Sumatorio areas "+gestor.calcularSumatorioAreas());
}
```


##### Ejecución del método main:

```java
Mostrar todas las figuras
Circunferencia [radio=4.8, getTitulo()=Circulo 1, getColor()=Amarillo]
Circunferencia [radio=1.5, getTitulo()=Circulo 2, getColor()=Verde]
Cuadrado [lado=4.2, getTitulo()=Cuadrado, getColor()=Negro]
Triangulo [base=8.0, altura=15.0, getTitulo()=Triangulo, getColor()=Rojo]
Eliminando circulo 2
Circunferencia [radio=4.8, getTitulo()=Circulo 1, getColor()=Amarillo]
Cuadrado [lado=4.2, getTitulo()=Cuadrado, getColor()=Negro]
Triangulo [base=8.0, altura=15.0, getTitulo()=Triangulo, getColor()=Rojo]
Sumatorio areas 150.02229473870884
```

