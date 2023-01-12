package Guipackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
//드래그 동안 색상이 변하는 예제;
public class MouseListenerEx3 extends JFrame{
	JPanel contentPane = new JPanel(); 
	MouseListenerEx3(){
		setTitle("드래깅동안 YELLO"); 
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setBackground(Color.GREEN);
		contentPane.addMouseMotionListener(new MyMouseMotionAdapter());
		contentPane.addMouseListener(new MyMouseAdapter2());
		
		setSize(400,200);
		setVisible(true);
	}
		class MyMouseMotionAdapter extends MouseMotionAdapter{
			public void mouseDragged(MouseEvent e) {
				contentPane.setBackground(Color.YELLOW);
			}
		}
		class MyMouseAdapter2 extends MouseAdapter{
			public void mouseReleased(MouseEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerEx3();
	}

}
