package GuiPackage1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamblingGameFrame extends JFrame{
	public GamblingGameFrame() {
		super("Open Challenge 10"); // 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new GamePanel()); 

		setSize(300,200);
		setVisible(true);
		
		getContentPane().setFocusable(true);
		getContentPane().requestFocus(); 
		
	}
	
	class GamePanel extends JPanel {
		private JLabel [] label = new JLabel [3]; 
		private JLabel result = new JLabel("시작합니다."); 
		
		public GamePanel() {
			setLayout(null); 
			
			for(int i=0; i<label.length; i++) {
				label[i] = new JLabel("0"); 
				label[i].setSize(60, 30); 
				label[i].setLocation(30+80*i, 50); 
				label[i].setHorizontalAlignment(JLabel.CENTER); 
				label[i].setOpaque(true); 
				label[i].setBackground(Color.MAGENTA); 
				label[i].setForeground(Color.YELLOW); 		
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30)); 	
				add(label[i]); 
			}
			
			result.setSize(200, 20);
			result.setLocation(100, 120);
			add(result);
			
			addKeyListener(new KeyAdapter() { 
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == '\n') { 
						int x1 = (int)(Math.random()*5) + 1; 
						label[0].setText(Integer.toString(x1));
						int x2 = (int)(Math.random()*5) + 1;
						label[1].setText(Integer.toString(x2));
						int x3 = (int)(Math.random()*5) + 1;
						label[2].setText(Integer.toString(x3));
						
						if(x1 == x2 && x2 == x3) // 3 수가 같은지 비교
							result.setText("축하합니다!!");
						else
							result.setText("아쉽군요");
					}
				}
			});

		}
	}
	
	static public void main(String[] arg) {
		new GamblingGameFrame();
	}
}
