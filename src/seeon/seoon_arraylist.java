package seeon;

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

public class seoon_arraylist {
	public void arraylist() {
		Scanner sc = new Scanner(System.in);
		ArrayList<StDTO> list = new ArrayList<StDTO>();
		String name, major;
		int age, id = 0, phone;
		int num;
		int i =0;
		boolean flag;
		FilePath fp = new FilePath();
		File file;
		StDTO dto = new StDTO();
		String path = fp.path2;
		
		while(true) {
			System.out.println("=========학생 관리 프로그램========");
			System.out.println("1. 등록\n2. 확인\n3. 수정\n4. 삭제\n5. 종료");
			System.out.print(">>>>>>");
			num = sc.nextInt();

			switch(num) {
			case 1: 
				System.out.print("학생명 입력 : ");
				name = sc.next();
				System.out.print("학번 입력 : ");
				id = sc.nextInt();
				System.out.print("전공 입력 : ");
				major = sc.next();
				System.out.print("나이 입력 : ");
				age = sc.nextInt();	
				dto.setId(id);
				file = new File(path + "/" + dto.getId() + ".txt");
				if(file.isFile()) {
					System.out.println("이미 등록된 학번 입니다.");
				}else{
				dto.setName(name);
				dto.setId(id);
				dto.setMajor(major);
				dto.setAge(age);
				list.add(dto);
				try {
					FileOutputStream fos = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);
		
					oos.writeObject(dto); 
					oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				System.out.println("등록되었습니다.");
				}
				break;
			
			case 2:
				System.out.println("1. 전체 학생 보기\n2. 학번으로 찾기");
				num = sc.nextInt();
				
				switch(num) {
				case 1:
					for(i = 0; i < list.size(); i++) {
						System.out.println("----------------------");
						System.out.println("이름 : " + list.get(i).getName());
						System.out.println("학번 : " + list.get(i).getId());
						System.out.println("전공 : " + list.get(i).getMajor());
						System.out.println("나이 : " + list.get(i).getAge());
					}
					break;
					
				case 2:
					System.out.println("학번 입력 : ");
					id = sc.nextInt();
					file=new File(path + "/" + id+".txt");
					if(file.isFile()) {
						System.out.println("-----정보 불러오기-----");
						try {
							FileInputStream fis = new FileInputStream(file);
							BufferedInputStream bis = new BufferedInputStream(fis);
							ObjectInputStream ois = new ObjectInputStream(bis);
							
							StDTO stdto = (StDTO)ois.readObject();
							System.out.println("----------------------");
							System.out.println("이름: " + stdto.getName());
							System.out.println("학번: " + stdto.getId());
							System.out.println("전공: " + stdto.getMajor());
							System.out.println("나이: " + stdto.getAge());
						} catch (Exception e) {	
							//e.printStackTrace();
						}
					}break;
				}
				break;
				
			case 3:
				System.out.print("수정할 학생의 학번을 입력하세요 : ");
				id = sc.nextInt();
				file=new File(path + "/" + id + ".txt");
				if(file.isFile()) {
					dto.setId(id);
					System.out.println("이름 입력: ");
					dto.setName(sc.next());
					System.out.println("나이 입력: ");
					dto.setAge(sc.nextInt());
					System.out.println("전공 입력: ");
					dto.setMajor(sc.next());
					System.out.println("수정되었습니다.");
					try {
						FileOutputStream fos = new FileOutputStream(file);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						ObjectOutputStream oos = new ObjectOutputStream(bos);
						
						oos.writeObject(dto); 
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}break;
			
			case 4:
				System.out.print("삭제할 학생의 학번을 입력하세요 : ");
				id = sc.nextInt();
				file = new File(path + "/" + id + ".txt");
				if(file.isFile()) {
					file.delete();
					System.out.println("삭제되었습니다.");
				}else {
					System.out.println("요청 학생이 없습니다.");
				}
				break;
				
			case 5:
				seoon so = new seoon();
				so.seoon();
			}
		}
	}
}

