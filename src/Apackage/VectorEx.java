package Apackage;

import java.util.Iterator;
import java.util.Vector;

public class VectorEx {
	public static void main (String[] args) {
		//정수 값만 다루는 제네릭 백터 생성
		Vector<Integer> v = new Vector <Integer> ();
		
		v.add(5);
		v.add(4);
		v.add(-1);
		//백터 중간에 삽입하기 
		v.add(2,100);   //4와 -1사이에 정수 100삽입
		
		System.out.println("백테 내의 요소 객체 수 :" +v.size());
		System.out.println("백터의 현재 용량 :" +v.capacity());
		
		//모든 요소 정수 철력하기
		for(int i = 0 ; i< v.size() ; i++) {
			int n = v.get(i);
			System.out.println(n);
		}
		
		
		//Iterator를 이용한 모든 정수 출력하기
		
		Iterator<Integer> it= v.iterator();
		while(it.hasNext()) {
			int n =it.next();
			System.out.print(n);
		}
		int sum = 0;
		it = v.iterator(); //Iterator 객체 얻기;
		while(it.hasNext()) {
			int n = it.next();
			sum += n;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
