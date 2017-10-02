package Figuras;

public class Problema {

	public static void main(String[] args) {
		
		Circunferencia cir1=new Circunferencia(4.8);
		Circunferencia cir2=new Circunferencia(1.5);
		Cuadrado cua1=new Cuadrado(4.2);
		Triangulo tri1=new Triangulo(8,15);
		
		System.out.println(area(cir1,cir2,cua1,tri1));
		
		
	}
	
	public static double area(Circunferencia cir1,Circunferencia cir2,Cuadrado cua1,Triangulo tri1) {
		double aCir1=(Math.PI*Math.pow(cir1.getRadio(), 2))/2;
		double aCir2=(Math.PI*Math.pow(cir2.getRadio(), 2))*3/4;
		double aCua1=cua1.getLado()*cua1.getLado();
		double aTri1=(tri1.getAltura()*tri1.getBase())/2;
		return aCir1+aCir2+aCua1+aTri1;
	}
	
	//public static double perimetro(Circunferencia cir1,Circunferencia cir2,Cuadrado cua1,Triangulo tri1) {
		
	//}
	

}
