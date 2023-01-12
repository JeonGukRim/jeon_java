package Dec_class;

public class Carclass {  				//public은 공용으로 사용가능하다는뜻 privte은 비밀사항;
	public int speed;
	public int maxspeed;
	public String color;
	public String kind;
	
	
	// 받는 값이 없이 실행될땐 이부분은 생략 가능하지만 입력값을 받고 실행되면 다음 객체 생성시 기본 메소드가 없으면 에러 생김;
	//*************************  *********************************** 
	
	public Carclass () {}  //기본생성자
	// 호출 예시 Carclass c = new Carclass("red","소나타")
	public Carclass(String color,String kind){               //클래스명이랑 똑같은 메소드 반환 타입이 필요없고 무조건 한번 실행되는 메소드
		this.color = color;    //this는 class내 위에 처음선언한 변수를 의미함 this 없는 color는 메소드내에 선언한 변수
		this.kind = kind;  
		System.out.println("자동차가 생성되였습니다");  //미리 문구 입력하거나 변수 초기화 할때 사용함;
	}
//************************* 메소드 오버로딩 *********************************** 
	public void speedUp(int sp) {       		// ( int sp) 객체에서 입력을 할때 값을 받을수 있는 공간임; 
		if (speed < 200) {						//호출 형식 c.speedUp(30);				
			speed += sp;   						// 밖에서 입력받은 sp값으로 메소드 실행됨;  
		}
	}
	public void speedUp(double sp) {       		//  호출 형식 c.speedUp(30.1)
		
		if (speed < 200) {
			speed += sp;
		 
		}
	}
	public void speedUp(int sp,int sp1) {       // 호출 형식 c.speedUp(30,20)
		
		if (speed < 200) {
			speed += sp+sp1;
		 
		}
	}
	public void speedUp() {       				// () 호출 형식 c.speedUp();
		
		if (speed < 200) {
			speed += 10;
		 
		}
	}
//***********************************************************************
	public int getSpeed() {
		return speed;
	}

	public int getMaxspeed() {
		return maxspeed ;
	}

	public String getColor() {
		return color;
	}

}
