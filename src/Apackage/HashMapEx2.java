package Apackage;

import java.util.HashMap;
import java.util.Scanner;

class Student{
	int id;
	String tel;
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
}

public class HashMapEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Student> map = new HashMap<String,Student>();
		
		map.put("황기태", new Student(1,"010-1234-4567"));
		map.put("이재운", new Student(2,"010-1111-2234"));
		map.put("김남윤", new Student(3,"010-0114-4565"));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("검색할 이름 :");
			String name = scanner.next();
			if(name.equals("exit")) {
				break;
			}
				Student student =map.get(name);
				if(student == null) {
					System.out.println(name+"은 없는 사람입니다.");
//				}else {
//					System.out.println("id"+ student.getid() + ", 전화" + student.gettel());
//				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
