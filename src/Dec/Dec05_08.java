package Dec;

import java.util.ArrayList;

public class Dec05_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Hello");
		a.add("JAVA");
		a.add("C++");
		a.add("C#");
//		a.add(0,"c--");  // 0번 인덱스에 c-- 를 교체 원위치에 데이터는 밑으로 밀림
		a.remove(2);
		a.clear();
//		System.out.println(a.get(0));
//		System.out.println(a.get(1));
//		System.out.println(a.get(2));
//		System.out.println(a.get(3));
//		System.out.println(a.size()); 
//		a.set(0, "바나나");
		for(int i = 0 ; i < a.size() ; i++) {
			
			System.out.println(a.get(i));
		}
		
		
		
		
		
		
		
		
	}

}
