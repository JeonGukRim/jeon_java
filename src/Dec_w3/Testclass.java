package Dec_w3;

public class Testclass {

	int a;


	public  int cal(int x , int y ,String s) {
		if(s.equals("+")) {
			a = x+y;
		}else if(s.equals("-")){
			a = x-y;
		}else if(s.equals("*")){
			a = x*y;
		}else if(s.equals("/")){
			a = x/y;
		}
		return this.a;
	}

}
