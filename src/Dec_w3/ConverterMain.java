package Dec_w3;

import java.util.Scanner;

abstract class Converter {
	Converter(){}
	abstract protected double convert(double src); // 추상 메소드

	abstract protected String getSrcString(); // 추상 메소드

	abstract protected String getDestString(); // 추상 메소드

	protected double ratio; // 비율

	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
		System.out.print(getSrcString() + "을 입력하세요>> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("변환 결과: " + res + getDestString() + "입니다");
		scanner.close();
	}
}

class Won2Dollar extends Converter {
	Won2Dollar() {
		}
	Won2Dollar(int ratio) {
		super.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return src / super.ratio;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "원";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "달러";
	}
}

class Km2Mile extends Converter {
	Km2Mile(double ratio) {
		super.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return src / super.ratio;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "Km";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "mile";
	}
}

public class ConverterMain {
	public static void main(String[] args) {
//		 TODO Auto-generated method stub

		// [3번] Converter 클래스를 상속받아 원화를 달러로 변환하는 Won2Dollar 클래스를 작성하라.
		// main() 메소드와 실행 결과는 다음과 같다

		Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원
		toDollar.run();

		// [4번] Converter 클래스를 상속받아 Km를 mile(마일)로 변환하는 Km2Mile 클래스를 작성하라,
		// main() 메소드와 실행 결과는 다음과 같다.
		Km2Mile toMile = new Km2Mile(1.6); // 1마일은 1.6km
		toMile.run();
	}
}
