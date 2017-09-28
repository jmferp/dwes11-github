package ControlDeFlujo;

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
		sc.close();
	}
	
}
