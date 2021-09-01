package seeon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class seoon_hashmap {
	public void hashmap() {
		HashMap<Integer, StDTO> map = new HashMap<Integer, StDTO>();
		Scanner sc = new Scanner(System.in);
		int id = 0, age, num;
		String name, major;
		
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
				
				StDTO dto = new StDTO();
					
				if(map.containsKey(id)) {
					System.out.println("이미 존재하는 학번입니다 다시 입력하세요.");
					}
				else {
					dto.setName(name);
					dto.setId(id);
					dto.setMajor(major);
					dto.setAge(age);
					map.put(id, dto);
					System.out.println("등록되었습니다.");
				}
				break;
				
			case 2:
				System.out.println("1. 전체 학생 보기\n2. 학번으로 찾기");
				num = sc.nextInt();

				switch(num) {
				case 1:
					Iterator<Integer> it = map.keySet().iterator();
					while(it.hasNext()) {
						StDTO st = map.get(it.next());
						System.out.println("----------------------");
						System.out.println("이름 : " + st.getName());
						System.out.println("학번 : " + st.getId());
						System.out.println("전공 : " + st.getMajor());
						System.out.println("나이 : " + st.getAge());
						}
					break;
					
				case 2:
					System.out.println("학번 입력 : ");
					id = sc.nextInt();
					System.out.println("----------------------");
					System.out.println("이름 : " + map.get(id).getName());
					System.out.println("학번 : " + map.get(id).getId());
					System.out.println("전공 : " + map.get(id).getMajor());
					System.out.println("나이 : " + map.get(id).getAge());
					break;
				}
				break;
					
			case 3:
				System.out.print("수정할 학생의 학번을 입력하세요 : ");
				id = sc.nextInt();
				System.out.print("학생명 입력 : ");
				map.get(id).setName(sc.next());
				System.out.print("전공 입력 : ");
				map.get(id).setMajor(sc.next());
				System.out.print("나이 입력 : ");
				map.get(id).setAge(sc.nextInt());	
				System.out.println("수정되었습니다.");
				break;
				
			case 4:
				System.out.print("삭제할 학생의 학번을 입력하세요 : ");
				id = sc.nextInt();
				map.remove(id);
				System.out.println("삭제되었습니다.");
				break;
				
			case 5:
				seoon so = new seoon();
				so.seoon();
			}
		}
	}
}

