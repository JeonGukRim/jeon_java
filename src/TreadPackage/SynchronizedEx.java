package TreadPackage;

public class SynchronizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();
	}
}

class SharedBoard {
	private int sum = 0; // 집계판의 합

	synchronized public void add() { // synchronized 는 스레드 독점실행후 다른 스레드로 넘어간다
		int n = sum;
		Thread.yield();// 현재실행 중인 스레드 양보
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + ":" + sum);
	}

	public int getSum() {
		return sum;
	}
}

class StudentThread extends Thread {
	private SharedBoard board;

	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			board.add();
	}
}