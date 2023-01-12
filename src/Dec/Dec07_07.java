package Dec;

public class Dec07_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2차원 배열
//		int array[] = new int[2];
		int array2[][] = {{0,1,2},{3,4,5}};
//		int array2[][] = new int[2][3];  // 3개짜리 2줄  앞에꺼 행 두전째거 열
//		array2[][] = {0,1,2}{3,4,5};
		//{1,2,3}
		//{4,5,6}
		//0 -> 0,0
		//1 -> 0,1
		//2 -> 0,2  
		//3 -> 1,0
		//4 -> 1,1
		//5 -> 1,2          array2.length ->2   array2[0].length ->3  array2[1].length -> 3
		
		
		
		System.out.println(array2.length);
		System.out.println(array2[0].length);
		System.out.println(array2[1].length);
		for(int i = 0 ; i < array2.length ; i++  ) {
			for(int j = 0 ; j<array2[i].length; j++) {
			System.out.println(array2[i][j]);
			}
		}
		
		
		
		
	}

}
