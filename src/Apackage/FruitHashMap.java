package Apackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FruitHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <HashMap<String,Object>> fruitarray = new ArrayList <HashMap<String,Object>>();
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			HashMap<String,Object> map = new HashMap<String,Object>();
			System.out.print("과일종류를 입력하세요 >>");
			map.put("kind",s.next());
			System.out.print("과일 색상을 입력하세요 >>");
			map.put("color",s.next());
			System.out.print("원산지를 입력하세요 >>");
			map.put("county",s.next());
			System.out.print("가격을 입력하세요 >>");
			map.put("price",s.nextInt());
			fruitarray.add(map);
			System.out.println("추가 (1)   종료(2)");
			if(s.nextInt() == 2) {
				break;
			}
		}
		
		for(int i = 0 ; i< fruitarray.size(); i++) {
//			HashMap<String,Object> map2 = fruitarray.get(i);
			if("아시아".equals(fruitarray.get(i).get("county")) ) {
				fruitarray.get(i).put("saleRate",10);
				fruitarray.get(i).put("price2",(int)fruitarray.get(i).get("price")/(int)fruitarray.get(i).get("saleRate"));
			}else if("남미".equals(fruitarray.get(i).get("county"))) {
				fruitarray.get(i).put("saleRate",20);
				fruitarray.get(i).put("price2",(int)fruitarray.get(i).get("price")/(int)fruitarray.get(i).get("saleRate"));
			}
		}
		
		
		System.out.println(fruitarray);
		
		
		
		
		
		
	}

}
