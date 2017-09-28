package ControlDeFlujo;

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
