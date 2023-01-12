package Apackage;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<HashMap<String,Object>> memberList
		=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("이름", "홍길동");
		map.put("나이", 30);
		map.put("자바점수", 90);
		memberList.add(map);  // memberList.add(0,map);
		
		HashMap<String,Object> map2 = new HashMap<String,Object>();
		map2.put("이름", "김철수");
		map2.put("나이", 30);
		map2.put("자바점수", 90);
		memberList.add(map2);  // memberList.add(1,map2);

		for(int i = 0 ; i<memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
		
		for(int i = 0 ; i<memberList.size(); i++) {
			HashMap<String,Object> map3 = memberList.get(i);
			if("홍길동".equals(map3.get("name"))) {
				System.out.println(map3.get("age"));
			}
			System.out.println(memberList.get(i));
		}
		
		
		
		
		
		
	}

}
