package ControlDeFlujo;

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
