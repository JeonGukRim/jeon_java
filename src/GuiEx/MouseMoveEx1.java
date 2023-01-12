package GuiEx;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseMoveEx1 extends JFrame {
	public MouseMoveEx1(){
		setTitle("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/apple.jpg"); 
		JLabel imageLabel = new JLabel(icon); 
		
		imageLabel.setSize(icon.getIconHeight(), icon.getIconWidth());
		imageLabel.setLocation(100,100);
		
		MyMouseListener ml = new MyMouseListener();
		imageLabel.addMouseListener(ml);
		imageLabel.addMouseMotionListener(ml);

		c.add(imageLabel); 
		setSize(300,300);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		private Point startP = null; 
		
		@Override
		public void mousePressed(MouseEvent e) {
			startP = e.getPoint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point endP = e.getPoint();
			JLabel la = (JLabel)(e.getSource());
			Point p = la.getLocation();
//			la.setLocation(endP.x , endP.y);
			la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
//			repaint();  
		}	
	}
	
	static public void main(String[] args) {
		new MouseMoveEx1();
	}
}
