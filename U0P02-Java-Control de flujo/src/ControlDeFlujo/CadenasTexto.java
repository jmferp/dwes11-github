package ControlDeFlujo;

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
