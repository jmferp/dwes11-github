package ControlDeFlujo;

import java.util.Scanner;

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



