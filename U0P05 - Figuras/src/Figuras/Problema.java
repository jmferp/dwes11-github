package Figuras;

public class Problema {

	public static void main(String[] args) {
		
		Circunferencia cir1=new Circunferencia("Circulo 1",Color.Amarillo,4.8);
		Circunferencia cir2=new Circunferencia("Circulo 2",Color.Verde,1.5);
		Cuadrado cua1=new Cuadrado("Cuadrado",Color.Negro,4.2);
		Triangulo tri1=new Triangulo("Triangulo",Color.Rojo,8,15);
		
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
	

}
