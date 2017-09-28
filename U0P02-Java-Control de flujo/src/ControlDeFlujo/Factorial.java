package ControlDeFlujo;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int op = -1;
		while (op<1){
			System.out.println("Introducir un numero para calcular factorial");
			try{
				op = sc.nextInt();
			}catch (Exception e){
				sc = new Scanner(System.in);
				op = -1;
			}
		}
		int num=op;
		int fact=1,aux;
		do {
			fact=fact*num;
			num=num-1;
		}while(num>0);
		
		System.out.println(fact);
		fact=1;
		num=op;
		while(num>0) {
			fact=fact*num;
			num=num-1;
		}
		System.out.println(fact);
		fact=1;
		num=op;
		for(int i=num;i>=1;i--) {
			fact=fact*i;
		}
		System.out.println(fact);
		
		sc.close();
	}
		
		
		

	}


