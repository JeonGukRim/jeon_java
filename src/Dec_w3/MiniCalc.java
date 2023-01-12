package Dec_w3;

public class MiniCalc implements Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double average(int[] a) {
		// TODO Auto-generated method stub
		int sum = 0 ;
		for(int i = 0 ; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum/a.length;
	}

	
	
	
	
}
