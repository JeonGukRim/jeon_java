package GuiEx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TestEx8 extends JFrame {
	private JMenuBar mb = new JMenuBar();
	private JMenu menu = new JMenu("메뉴");
	private JPanel jp = new JPanel();
	private JLabel jl = new JLabel("텍스트");

	public TestEx8() {

		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuItem clear = new JMenuItem("clear");
		menu.add(clear);
		mb.add(menu);
		setJMenuBar(mb);

		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jl.setVisible(false);
			}
		});

		c.add(jp, BorderLayout.NORTH);
		c.add(jl);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestEx8();
	}
}
