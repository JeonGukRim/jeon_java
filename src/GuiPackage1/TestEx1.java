package GuiPackage1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class TestEx1 extends JFrame {
	private JCheckBox jb1 = new JCheckBox("버튼 비활성화");
	private JCheckBox jb2 = new JCheckBox("버튼 숨기기");
	private JButton bt = new JButton("button");

	public TestEx1 () {
	setTitle("리스트 변경 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	jb1.addItemListener(new MyItemListener());
	jb2.addItemListener(new MyItemListener());
	c.add(jb1);
	c.add(jb2);
	c.add(bt);
	setSize(260,200);
	setVisible(true);
	}

	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == jb1) {
					bt.setEnabled(false);
				} else if (e.getItem() == jb2) {
					bt.setVisible(false);
				}
			}else {
				if (e.getItem() == jb1) {
					bt.setEnabled(true);
				} else if (e.getItem() == jb2) {
					bt.setVisible(true);
				}
			}
		}
	}
	public static void main (String [] args) {
		new TestEx1();
	}
}