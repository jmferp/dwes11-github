package Figuras;

public class Principal {

	public static void main(String[] args) {
		Circunferencia cir1=new Circunferencia("Circulo 1",Color.Amarillo,4.8);
		Circunferencia cir2=new Circunferencia("Circulo 2",Color.Verde,1.5);
		Cuadrado cua1=new Cuadrado("Cuadrado",Color.Negro,4.2);
		Triangulo tri1=new Triangulo("Triangulo",Color.Rojo,8,15);
		
		/*System.out.println(tri1.toString());
		System.out.println(cir1.toString());
		System.out.println(cir2.toString());
		System.out.println(cua1.toString());*/

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

}
