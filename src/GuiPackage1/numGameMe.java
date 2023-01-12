package GuiPackage1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class numGameMe extends JFrame {
	JLabel jr[] = new JLabel[10];
	int nextnum = 0;

	public numGameMe() {
		setTitle("숫자 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		Listener listener = new Listener();
		for (int i = 0; i < 10; i++) {
			jr[i] = new JLabel(i + "");
			jr[i].setFont(new Font("serif", Font.BOLD, 30));
			jr[i].setLocation((int) (Math.random() * 300), (int) (Math.random() * 300));
			jr[i].setSize(20, 20);
			jr[i].setOpaque(true);
			jr[i].setBackground(Color.YELLOW);
			c.add(jr[i]);
			jr[i].addMouseListener(listener);
		}

		setSize(400, 400);
		setVisible(true);

	}

	class Listener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			JLabel str = (JLabel) e.getSource();
			if (nextnum == Integer.parseInt(str.getText())) {
				str.setVisible(false);
				nextnum++;
			}
			if (nextnum == 10) {
				for (int i = 0; i < 10; i++) {
					jr[i].setVisible(true);
					jr[i].setLocation((int) (Math.random() * 300), (int) (Math.random() * 300));
				}
				nextnum = 0;
			}
		}
	}

	public static void main(String[] args) {
		new numGameMe();
	}
}
