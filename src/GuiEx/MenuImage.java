package GuiEx;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuImage extends JFrame {
	private JLabel imgLabel = new JLabel(); // 빈 이미지를 가진 레이블
	public MenuImage() {
		setTitle("Menu");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER); 
		setSize(250,220); 
		setVisible(true);
	}
	
	private void createMenu() { 
		JMenuBar mb = new JMenuBar(); 
		JMenuItem [] menuItem = new JMenuItem [4];
		String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
		JMenu screenMenu = new JMenu("Screen");
		
		MenuActionListener listener = new MenuActionListener(); 
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(listener); 
			screenMenu.add(menuItem[i]); 
		}
		mb.add(screenMenu); 
		setJMenuBar(mb); 
	}
	
	class MenuActionListener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); 
			switch(cmd) { 
			case "Load" : 
				if(imgLabel.getIcon() != null) 
					return; 
				imgLabel.setIcon(new ImageIcon("images/back.jpg")); 
				break;
			case "Hide" :		
				imgLabel.setVisible(false); 
				break;
			case "ReShow" : 
				imgLabel.setVisible(true); 
				break;
			case "Exit" : 
				System.exit(0); 
				break;
		}
		}
	}
	public static void main(String [] args) {
		new MenuImage();
	}
}