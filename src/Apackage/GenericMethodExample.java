package Apackage;

public class GenericMethodExample {
	public static <T> GStack <T> reverse (GStack<T> a) {
		GStack <T> s = new GStack <T> ();
		while (true) {
			T tmp;
			tmp = a.pop();
			if (tmp == null) {
				break;
			} else {
				s.push(tmp);
			}

		}
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GStack<Double> gs = new GStack<Double>();

		for (int i = 0; i < 5; i++) {
			gs.push(new Double(i));
		}
		gs = reverse(gs);  //해당 작업없이 pop로 출력하면 FILO 됨 
		for (int i = 0; i < 5; i++) {
			System.out.println(gs.pop());
		}

	}
}
