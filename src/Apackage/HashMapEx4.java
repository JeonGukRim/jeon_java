package Apackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, Object>> memberList = new ArrayList<HashMap<String, Object>>();
		Scanner s = new Scanner(System.in);
		while (true) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.print("이름을 입력하세요 :");
			map.put("name", s.next());
			System.out.print("나이를 입력하세요 :");
			map.put("age", s.nextInt());
			System.out.print("주소을 입력하세요 :");
			map.put("address", s.next());
			memberList.add(map);
			System.out.print("계속(1)  종료(2)");
			if (s.nextInt() == 2) {
				break;
			}
		}
		System.out.println(memberList);
	}

}
