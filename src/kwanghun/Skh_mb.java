package kwanghun;


import java.io.*;

import java.util.Scanner;

import main.FilePath;

public class Skh_mb {
	Scanner input = new Scanner(System.in);
	FilePath file = new FilePath();
	String stNum =null;
	String name = null;
	Student st = new Student();
	
	public void display() {
		while(true) {
		System.out.println("1.등록 2.학생검색 3.종료");
		int num = input.nextInt();
		
		switch(num) {
		
		case 1 : 
			
			
			
			System.out.println("학번을 입력하세요");
			stNum = input.next();
			
			
			System.out.println("이름을 입력하세요");
			name = input.next();
			
			st.setStNum(stNum);
			st.setName(name);
			fileout();
			filein();
			
			break;
		case 2 : 
			
			System.out.println("검색할 학번을 입력하세요");
			stNum = input.next();
			
			filein();
			
			break;
		case 3 : System.out.println("프로그램을 종료합니다."); return;
		
		}
	}
	}
	public void fileout() {
		
		
		try {
			File file01 = new File(file.path4+"/"+stNum+".txt");
			FileOutputStream fos = new FileOutputStream(file01);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(st);
			oos.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
public void filein() {
		
		
		try {
			File file01 = new File(file.path4+"/"+stNum+".txt");
			FileInputStream fis = new FileInputStream(file01);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			Student aa = (Student)ois.readObject();
			System.out.println("학번 " + aa.getStNum());
			System.out.println("이름 " + aa.getName());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
