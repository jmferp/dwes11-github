package ControlDeFlujo;

import java.util.Scanner;

public class PedirNum1y10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int op = -1;
		while ( (op<1)||(op>10) ){
			System.out.println("Introducir un numero entre 1 y 10");
			try{
				op = sc.nextInt();
			}catch (Exception e){
				sc = new Scanner(System.in);
				op = -1;
			}
		}
		sc.close();

	}

}
