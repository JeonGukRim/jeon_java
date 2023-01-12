package Apackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			HashMap<String,Integer> javaScore = new HashMap<String,Integer>();
			
			//5개의 정수 저장
			javaScore.put("김성동",97);
			javaScore.put("황기태",88);
			javaScore.put("김남윤",98);
			javaScore.put("이재윤",70);
			javaScore.put("한원선",99);
			System.out.println("HashMap의 요소 개수" + javaScore.size());
			
			//모든 사람의 정수 출력.
			//javaScore에 들어 있는 모든 (key.value) 쌍출력
			//ㅏkey 문자열을 가진 집합 set 컬렉션 리턴
			Set<String> keys = javaScore.keySet();
			//key 문자열을 순서대로 접근할수 있는 itartor 리턴
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String name = it.next();
				int score = javaScore.get(name);
				System.out.println(name + "," + score);
			}
			
			
			
			
	}

}
