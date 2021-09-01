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
		System.out.println("1.등록 2.학생검색 3.수정 4.삭제 5.종료");
		int num = input.nextInt();
		
		switch(num) {
		
		case 1 : 
			
			while(true) {
			
			System.out.println("학번을 입력하세요");
			stNum = input.next();
			File file01 = new File(file.path4+"/"+stNum+".txt");
			if(file01.isFile()) {
				System.out.println("이미 등록된 학번입니다.");
			} else {
				break;
			}
			}
			
			
			
			System.out.println("이름을 입력하세요");
			name = input.next();
			
			st.setStNum(stNum);
			st.setName(name);
			fileout();
			System.out.println("저장되었습니다.");
			
			break;
		case 2 : 
			
			System.out.println("검색할 학번을 입력하세요");
			stNum = input.next();
			File file01 = new File(file.path4+"/"+stNum+".txt");
			if(file01.isFile()) {
				
				filein();
				
			} else {
				System.out.println("등록되지 않은 학번입니다.");
			}
			
			
			break;
			
		case 3 :
			
			System.out.println("검색할 학번을 입력하세요");
			stNum = input.next();
			file01 = new File(file.path4+"/"+stNum+".txt");
			if(file01.isFile()) {
				System.out.println("이름을 입력하세요");
				name = input.next();
				
				st.setStNum(stNum);
				st.setName(name);
				fileout();
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("등록되지 않은 학번입니다.");
			}
			break;
		case 4 :
			System.out.println("삭제할 학번을 입력하세요");
			stNum = input.next();
			file01 = new File(file.path4+"/"+stNum+".txt");
			if(file01.isFile()) {
				
				file01.delete();
				System.out.println(stNum+" 삭제되었습니다.");
			} else {
				System.out.println("등록되지 않은 학번입니다.");
			}
			
			break;
		case 5 : System.out.println("프로그램을 종료합니다."); return;
		
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
