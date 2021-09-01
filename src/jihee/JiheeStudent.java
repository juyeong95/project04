package jihee;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import main.FilePath;

public class JiheeStudent {

	JiheeStudentDTO j = new JiheeStudentDTO();
	Scanner sc = new Scanner(System.in);
	ArrayList<JiheeStudentDTO> list = new ArrayList<>();
	String name,stNum,add;
	int age;
	File filepath;
	
	
	public void start() {
		FilePath p = new FilePath();
		while(true) {
		System.out.println("1.등록하기  2.목록보기  3.검색하기");
		System.out.println("4.삭제하기  5.수정하기  6.종료");
		System.out.print(">>>");
		int num = sc.nextInt();
		switch(num) {
		case 1: 
			
			
			System.out.println("======(등록하기)======");
			boolean bool = true;
			while(bool) {
				System.out.print("학번입력: ");
				j.setStNum(sc.next());
				filepath = new File(p.path3 + "/" + j.getStNum() + ".txt");
				if(filepath.isFile()) {
					System.out.println("존재하는 학번입니다.");
				}else {
					bool = false;
				}
			}
			System.out.print("이름입력: ");
			j.setName(sc.next());
			System.out.print("주소입력: ");
			j.setAdd(sc.next());
			System.out.print("나이입력: ");
			j.setAge(sc.nextInt());
			
			
			try{
				FileOutputStream fos = new FileOutputStream(filepath);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				
				oos.writeObject(j);
				oos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 2: 
			System.out.println("=======(목록보기)=======");
			break;
		case 3:
			System.out.println("=======(검색하기)=======");
			System.out.print("학번입력: ");
			String stNum = sc.next();
			filepath = new File(p.path3 + "/" + stNum + ".txt");
			if(filepath.isFile()) {
				System.out.println("====(개인정보 불러오기)====");
				
				try {
				FileInputStream fis = new FileInputStream(filepath);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				JiheeStudentDTO a = (JiheeStudentDTO)ois.readObject();
				System.out.println("학번: " + a.getStNum());
				System.out.println("이름: " + a.getName());
				System.out.println("주소: " + a.getAdd());
				System.out.println("나이: " + a.getAge());
				System.out.println("=======================");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else {
				System.out.println("존재하는 학번이 없습니다.");
			}
			
			break;
		case 4:
			System.out.println("=======(삭제하기)=======");
			System.out.println("삭제 할 학번을 입력하세요.");			
			System.out.print("학번입력: ");
			String stNum1 = sc.next();
			filepath = new File(p.path3 + "/" + stNum1 + ".txt");
			if(filepath.isFile()) {
				System.out.println("==(아래 내용을 삭제 합니다)==");
				try {
					FileInputStream fis = new FileInputStream(filepath);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					JiheeStudentDTO a = (JiheeStudentDTO)ois.readObject();
					System.out.println("학번: " + a.getStNum());
					System.out.println("이름: " + a.getName());
					System.out.println("주소: " + a.getAdd());
					System.out.println("나이: " + a.getAge());
					System.out.println("=======================");
					
					ois.close();
					bis.close();
					fis.close();
					filepath.delete();
					}catch(Exception e) {
						e.printStackTrace();
					}
				
				
			}
			break;
		case 5: break;
		case 6: 
			System.out.println("========(종료)========");
			System.out.println("프로그램을 종료합니다.");
			System.out.println("=====================");
			return;
		}
		}
		
	}
}
