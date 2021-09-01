package juyeong;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import main.FilePath;

public class Student{
	public void display() {
		Scanner input = new Scanner(System.in);
		FilePath f = new FilePath();
		String path = f.path1;
		File filep;
		int num;
		StDTO st = new StDTO();
		ArrayList<StDTO> list = new ArrayList();
		while(true) {
			System.out.println("1.등록 2.검색 3.수정 4.삭제 5.나가기");
			System.out.print(">>>");
			num=input.nextInt();
			switch(num) {
			case 1:
				
				boolean bool = true;
				while(bool) {
					System.out.println("학번 입력: ");
					//st.setStNum(input.next());
					String stNum=input.next();
					st.setStNum(stNum);
					filep=new File(path+"/"+st.getStNum()+".txt");
					if(filep.isFile()) {
						System.out.println("이미 존재하는 학번 입니다.");
					}else {	 bool=false;  }
				}
				
				filep=new File(path+"/"+st.getStNum()+".txt");
				System.out.println("이름 입력: ");
				st.setName(input.next());
				System.out.println("나이 입력: ");
				st.setAge(input.nextInt());
				System.out.println("전공 입력: ");
				st.setMajor(input.next());
				System.out.println("저장이 완료되었습니다.");
				
					try {
						FileOutputStream fos = new FileOutputStream(filep);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						ObjectOutputStream oos = new ObjectOutputStream(bos);
			
						oos.writeObject(st); 
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				break;
			case 2:
				System.out.println("1.전체보기 2.학번으로 검색 3.뒤로가기");
				System.out.print(">>>");
				num=input.nextInt();
				switch(num) {
				case 1:
					System.out.println("미구현 기능입니다.");
					break;
				case 2:
					System.out.println("검색할 학번 입력: ");
					String stNum = input.next();
					filep=new File(path+"/"+stNum+".txt");
					if(filep.isFile()) {
						System.out.println("-----정보 불러오기-----");
						try {
							FileInputStream fis = new FileInputStream(filep);
							BufferedInputStream bis = new BufferedInputStream(fis);
							ObjectInputStream ois = new ObjectInputStream(bis);
							
							StDTO a = (StDTO)ois.readObject();
							System.out.println("학번: "+a.getStNum());
							System.out.println("이름: "+a.getName());
							System.out.println("전공: "+a.getMajor());
							System.out.println("나이: "+a.getAge());
						} catch (Exception e) {	
							//e.printStackTrace();
						}
					}else {
						System.out.println("입력하신 학번이 존재하지 않습니다.");
					}
					break;
				case 3:return;
				}
				break;
			case 3: 
				System.out.println("수정할 학번 입력: ");
				String stNum = input.next();
				filep=new File(path+"/"+stNum+".txt");
				if(filep.isFile()) {
					st.setStNum(stNum);
					System.out.println("이름 입력: ");
					st.setName(input.next());
					System.out.println("나이 입력: ");
					st.setAge(input.nextInt());
					System.out.println("전공 입력: ");
					st.setMajor(input.next());
					System.out.println("수정이 완료되었습니다.");
					try {
						FileOutputStream fos = new FileOutputStream(filep);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						ObjectOutputStream oos = new ObjectOutputStream(bos);
						
						oos.writeObject(st); 
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
				}else {
					System.out.println("입력하신 학번이 존재하지 않습니다.");
				}
				break;
			case 4:
				System.out.println("삭제할 학번을 입력하세요: ");
				String stNum1 = input.next();
				filep=new File(path+"/"+stNum1+".txt");
				if(filep.isFile()) {
					filep.delete();
					System.out.println("삭제가 완료되었습니다.");
				}else {
					System.out.println("입력하신 학번이 존재하지 않습니다.");
				}
				break;
			case 5: return;
			}
		}
	}
}
