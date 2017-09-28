package ControlDeFlujo;

import java.util.Scanner;

public class NumerosAyB {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int a = -1;
		while ( (a<1)||(a>10) ){
			System.out.println("Introducir un numero entre 1 y 10");
			try{
				a = sc.nextInt();
			}catch (Exception e){
				sc = new Scanner(System.in);
				a = -1;
			}
		}
		int b = -1;
		while ( (b<1)||(b>10) ){
			System.out.println("Introducir un numero entre 1 y 10");
			try{
				b = sc.nextInt();
			}catch (Exception e){
				sc = new Scanner(System.in);
				b = -1;
			}
		}
		if(a<b) {
		while(a<=b) {
			System.out.println("*");
			a=a+1;
		}
		}else {
			while(b<=a) {
			System.out.println("*");
			b=b+1;
			}
		}
		sc.close();
	}

}
