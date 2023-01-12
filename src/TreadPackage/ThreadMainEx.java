package TreadPackage;

public class ThreadMainEx {

	public static void main (String [] args) {
		
		long id = Thread.currentThread().getId(); // 스래드 id열기
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority(); //스레드 우선순위 값 얻기
		Thread.State s =Thread.currentThread().getState(); //스래드 상태 값 얻기
		System.out.println("현재 스레드 이름 =" + name);
		System.out.println("현재 스레드 ID =" + id);
		System.out.println("현재 스레드 우선순위값 =" + priority);
		System.out.println("현재 스레드 상태 =" + s);
	}
}
