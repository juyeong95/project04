package main;

import java.util.Scanner;

import seeon.seoon;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("1.이주영님 2.성기룡님 3.설지희님 4.서광훈님 5.송영관님 6.종료");
			num=input.nextInt();
			seoon so = new seoon();
			switch(num) {
			case 1: break;
			case 2: so.seoon(); break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: System.exit(0);
			}
		}
	}
}