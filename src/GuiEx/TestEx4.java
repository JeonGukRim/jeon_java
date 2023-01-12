package GuiEx;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestEx4 extends JFrame {
	private int sum = 0;

	public TestEx4() {

		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("JButton");
		JLabel jl = new JLabel();
		c.setLayout(new FlowLayout());
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jl.setText((sum++) + "");
			}

		});
		c.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {

				c.setBackground(Color.GREEN);
			}

			public void mouseExited(MouseEvent e) {
				c.setBackground(Color.CYAN);
			}

		});
		
		c.addMouseWheelListener(new MouseAdapter() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				c.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
						(int) (Math.random() * 256)));
			}
		});

		c.add(btn);
		c.add(jl);
		setFocusable(true);
		requestFocus();
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestEx4();
	}
}
