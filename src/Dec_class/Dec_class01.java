package Dec_class;

public class Dec_class01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carclass car1 = new Carclass();
		car1.speed = 0;
		car1.maxspeed = 200;
		car1.color = "black";
		car1.kind = "소나타";
		int s = car1.getSpeed();			 //스피드
		int ms = car1.getMaxspeed();		//최대스피드
		String c = car1.getColor();			//색상
		System.out.println(s);
		System.out.println(ms);
		System.out.println(c);
//		while(car1.getSpeed() < 200 ) {		//200될때까지 스피드 업
			car1.speedUp();					//스피드 업
//		}
		s = car1.getSpeed();
		System.out.println(s);
		
		car1.speedUp(35);
		s = car1.getSpeed();
		System.out.println(s);

		car1.speedUp(1,1);
		s = car1.getSpeed();
		System.out.println(s);

		car1.speedUp(3.5);
		s = car1.getSpeed();
		System.out.println(s);
		
		
	}

}
