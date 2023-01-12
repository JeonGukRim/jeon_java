package Guipackage;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SubstringEx1 extends JFrame{
	JLabel label; 
	String text = "JavaTest";
	SubstringEx1(){
		setTitle("Left 키로 문자열 바꾸기 예제"); 
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label= new JLabel("JavaTest");
		label.setFont(new Font("serif", Font.BOLD, 30));
		label.addKeyListener(new MyKeyAdapter());
		
		label.setSize(200,50);
		add(label);
		setSize(400,200);
		setVisible(true);
		label.requestFocus();
		// 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정
	}
	class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(KeyEvent.VK_LEFT == e.getKeyCode()) {
				text = text.substring(1)+text.substring(0, 1);
				label.setText(text);
			} else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				text = text.substring(text.length()-1) + text.substring(0, text.length()-1);
				label.setText(text); 
			}
		}
	}

	public static void main(String[] args) {
		new SubstringEx1();
	}
	
}
