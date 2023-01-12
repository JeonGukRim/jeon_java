package Guipackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerEx extends JFrame {
	private JLabel[] keyMessage;

	public KeyListenerEx() {
		setTitle("KeyListener  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.addKeyListener(new MyKeyListener());

//		keyMessage = new JLabel[3];
//		keyMessage[0] = new JLabel(" getKeyCode() ");
//		keyMessage[1] = new JLabel(" getKeyChar() ");
//		keyMessage[2] = new JLabel(" getKeyText() ");
		
		
		keyMessage = new JLabel[1];
		keyMessage[0] = new JLabel(" Text ");

		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);  // 색상 넣기위한 문구
			keyMessage[i].setBackground(Color.YELLOW);
		}
		
		setSize(300, 150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();  // 자바의 키값
			char keyChar = e.getKeyChar(); //유니코드

//			keyMessage[0].setText(Integer.toString(keyCode));
//			keyMessage[1].setText(Character.toString(keyChar));
//			keyMessage[2].setText(e.getKeyText(keyCode));
			int x = keyMessage[0].getX();
			int y = keyMessage[0].getY();
			if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
				keyMessage[0].setLocation(x+15,y);
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()) {
				keyMessage[0].setLocation(x-15,y);
			}else if(KeyEvent.VK_UP == e.getKeyCode()) {
				keyMessage[0].setLocation(x,y-15);
			}
			else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
				keyMessage[0].setLocation(x, y + 15);
			}
//			else if((KeyEvent.VK_LEFT+KeyEvent.VK_DOWN) == e.getKeyCode()) {
//				keyMessage[0].setLocation(x-15,y+15);
//			}
			
			
			
			
			
//			else {
//				keyMessage[0].setBackground(Color.YELLOW);
//			}
			
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}

}
