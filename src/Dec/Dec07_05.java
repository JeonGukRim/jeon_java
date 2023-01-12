package Dec;

public class Dec07_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 5.배열의 개수만큼 * 찍기
		int array[] = { 3, 5, 2, 5, 1 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
