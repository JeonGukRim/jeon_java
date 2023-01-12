package NetworkPackage;

import java.awt.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class CalServerSwingEx extends JFrame {
	private JTextArea log = new JTextArea();
	public CalServerSwingEx() {
		super("계산 서버");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Container c = getContentPane();
		c.add(new JLabel("계산 서버 입니다"));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9998);
			socket = listener.accept();
			log.append("클라이언트 연결됨\n");
			new ServiceThread(socket).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		new ServerThread().start(); // 서비스 시작
	}
	
	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		public ServiceThread(Socket socket) { // 클라이언트와 통신할 소켓을 전달받음
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			while(true) {
				try {
					String first = in.readLine(); // 첫 수
					String operator = in.readLine(); // 첫 수
					String second = in.readLine(); // 둘째 수
					int a = Integer.parseInt(first); // 정수로 변환
					int b = Integer.parseInt(second); // 정수로 변환
					
					String resText = "";
					int res = 0;
					switch(operator) {
						case "+" : res = a + b; resText = Integer.toString(res); break;
						case "-" : res = a - b; resText = Integer.toString(res); break;
						case "*" : res = a * b; resText = Integer.toString(res); break;
						case "/" : 
							if(b == 0) resText = "0으로 나눌 수 없음";
							else {
								res = a / b;
								resText = Integer.toString(res); 
							}
							break;
						default:
							resText = "잘못된 연산";
					}
					
					out.write(resText+"\n");
					out.flush();
					log.append(first + operator + second + "=" + resText + "\n");
				} catch (IOException e) {
					log.append("연결 종료\n");
					System.out.println("연결 종료");
					return;
				}

			}
		}
	}
	public static void main(String[] args) {
		new CalServerSwingEx();
	}

}