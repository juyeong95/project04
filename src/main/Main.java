package main;

import java.util.Scanner;
import jihee.JiheeStudent;
import kwanghun.Skh_mb;
import juyeong.Student;


public class Main {
	public static void main(String[] args) {
		Student jy = new Student();
		JiheeStudent ji = new JiheeStudent();
		Scanner input = new Scanner(System.in);
		Skh_mb skh = new Skh_mb();
		int num;
		while(true) {
			System.out.println("1.이주영님 2.성기룡님 3.설지희님 4.서광훈님 5.송영관님 6.종료");
			num=input.nextInt();
			switch(num) {
			case 1:
				jy.display();
				break;
			case 2: 
				skh.display();
				break;
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