package GuiEx;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestEx5 extends JFrame {
	private JCheckBox cb[] = new JCheckBox[3];
	private String[] name = { "사과", "바나나", "체리" };
	private JLabel sumlabel;

	public TestEx5() {

		setTitle("과일 체크박스예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원 ,바나나 500원,체리 1000원"));
		itemList listener = new itemList();
		for (int i = 0; i < 3; i++) {
			cb[i] = new JCheckBox(name[i]);
			cb[i].setBorderPainted(true);
			c.add(cb[i]);
			cb[i].addItemListener(listener);
		}
		sumlabel = new JLabel("현재 0원 입니다");
		c.add(sumlabel);
		setSize(250, 500);
		setVisible(true);

	}

	class itemList implements ItemListener {
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub

			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == cb[0]) {
					sum += 100;
				} else if (e.getItem() == cb[1]) {
					sum += 500;
				} else {
					sum += 1000;
				}
			} else {
				if (e.getItem() == cb[0]) {
					sum -= 100;
				} else if (e.getItem() == cb[1]) {
					sum -= 500;
				} else {
					sum -= 1000;
				}
			}
			sumlabel.setText("현재" + sum + "원 입니다.");
		}

	}

	public static void main(String[] args) {
		new TestEx5();
	}
}
