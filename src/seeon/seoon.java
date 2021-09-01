package seeon;

import java.util.Scanner;

public class seoon {
	public void seoon() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. ArrayList 2. HashMap\n다른 숫자키:돌아가기");
		System.out.print(">>>>>>");
		int num  = sc.nextInt();
		seoon_arraylist sa = new seoon_arraylist();
		seoon_hashmap sh = new seoon_hashmap();
		
		switch(num) {
		case 1:
			sa.arraylist();
			break;
		case 2:
			sh.hashmap();
			break;
		default:
			System.out.println("돌아가기.");
		}
	}
}
