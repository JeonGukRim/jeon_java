package Apackage;

public class StringEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String(" C#");
		String b = new String(",c++ ");
		
		System.out.println(a + "의 길이는 " + a.length());
		System.out.println(a.contains("#")); //포함하고 있는지 판단;
		
		a = a.concat(b);
		System.out.println(a);
		
		a=a.trim();
		System.out.println(a);
		
		a=a.replace("C#","Java"); //문자열 대치   앞에 값을 뒤에꺼로 교환한다는뜻
		System.out.println(a);
		
		String s[] =a.split(","); //문자열 분리
		for(int i = 0; i<s.length ; i ++) {
			System.out.println("분리된 문자열" + i + ": " + s[i]);
		}
		
		a = a.substring(5); //인덱스 5부터 끝까지 서브 스티링 리턴 /시작과 끝으로 표현한느 방법 (2,6)
		System.out.println(a);
		
		
		char c = a.charAt(2); //인덱스 2의 문자 리턴
		System.out.println(c);
		
		
		
	}

}
