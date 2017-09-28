package ControlDeFlujo;

import java.util.Scanner;

public class MesBisiesto {

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
	

}
