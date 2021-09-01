package main;

import java.util.Scanner;
import jihee.JiheeStudent;

public class Main {
	public static void main(String[] args) {
		JiheeStudent ji = new JiheeStudent();
		Scanner input = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("1.이주영님 2.성기룡님 3.설지희님 4.서광훈님 5.송영관님 6.종료");
			num=input.nextInt();
			switch(num) {
			case 1: break;
			case 2: break;
			case 3: 
				ji.start();
				break;
			case 4: break;
			case 5: break;
			case 6: System.exit(0);
			}
		}
	}
}