package Apackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx5 {

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
			System.out.print("자바점수 :");
			map.put("javascore", s.nextInt());
			System.out.print("파이썬 점수 :");
			map.put("pythonscore", s.nextInt());
			System.out.print("c언어 점수 :");
			map.put("cscore", s.nextInt());
			memberList.add(map);
			System.out.print("계속(1)  종료(2)");
			if (s.nextInt() == 2) {
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < memberList.size(); i++) {
			HashMap<String, Object> map2 = memberList.get(i);
			sum = (int) map2.get("cscore") + (int) map2.get("javascore") + (int) map2.get("pythonscore");
			// (int)memberList.get(i).get("cscore") 로 이렇게 작성해도같은 상황임
			if ((double) (sum / 3) >= 80) {
				map2.put("grade", "우수");
			// (int)memberList.get(i).put("grade", "우수")
			} else {
				map2.put("grade", "합격");
			}
		}
		System.out.println(memberList);
	}

}
