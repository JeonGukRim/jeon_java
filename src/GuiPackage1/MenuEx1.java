package GuiPackage1;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuEx1 extends JFrame {
	private JMenu screenMenu;
	private MynewPanel panel = new MynewPanel();
	private Mylistener listener = new Mylistener();
	public MenuEx1() {
		setTitle("메뉴 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container c = getContentPane();
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
		panel.setVisible(false);
	}

	private void createMenu() {
		
		JMenuBar mb = new JMenuBar();
		screenMenu = new JMenu("Screen");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem hide = new JMenuItem("Hide");
		JMenuItem reshow = new JMenuItem("Reshow");
		load.addActionListener(listener);
		hide.addActionListener(listener);
		reshow.addActionListener(listener);
		screenMenu.add(load);
		screenMenu.add(hide);
		screenMenu.add(reshow);
		screenMenu.addSeparator(); // 분리선 삽입
		screenMenu.add(new JMenuItem("Exit"));

		mb.add(screenMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		setJMenuBar(mb);
	}
	class Mylistener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd =e.getActionCommand();
			if(cmd.equals("Load")) {
				panel.setVisible(true);
			}else if(cmd.equals("Hide")) {
				panel.setVisible(false);
			}else if(cmd.equals("Reshow")) {
				panel.setVisible(true);
			}
		}
		
	}
	class MynewPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}

	}

	public static void main(String[] args) {
		new MenuEx1();
	}
}