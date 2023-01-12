package Dec;

public class Dec05_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(int i = 9 ; i > 1 ; i--) {
//			System.out.println("=== " + i + "단 ===");
//			for(int j = 1 ; j < 10 ; j++) {
//				System.out.println (i + "*" + j + "=" + i*j);
//			}
//			System.out.println();
//		}
//		int a = 1;
//		while( a <= 10 ) {
//			System.out.println(a);
//			a++;
//		}
	
		int i = 2;
		while(i <= 9) {
		System.out.println("=== " + i + " 단 === ");
//			int j = 1;
//			while( j <= 9) {
//				System.out.println( i + "*" + j + "=" + i*j);
//			    j++;
//			}                                                       //while,while 로 작성된 구구단
		
			for(int j = 1 ; j <= 9 ; j++) {
			System.out.println(i + "*" + j + "=" + i*j);
			}														//while,for로 작성된 구구단
				
			i++;
			System.out.println();
		}
		
		
		
		
	}

}
