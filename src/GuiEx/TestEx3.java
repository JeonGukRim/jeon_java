package GuiEx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestEx3 extends JFrame {

	private JButton creatBtn = new JButton("ceart");
	private JLabel jl2 = new JLabel();
	private MyDialog1 dialog;
	private JPanel jp = new JPanel();

	public TestEx3() {
		super("합산 디아로그 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog = new MyDialog1(this, "합산");

		Container c = getContentPane();
		jl2.setText(dialog.getSum() + "");
		jp.add(creatBtn);
		jp.add(jl2);
		c.add(jp, BorderLayout.CENTER);

		creatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});

		setSize(550, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestEx3();
	}
}

class MyDialog1 extends JDialog {
	private JButton addBtn = new JButton("Add");
	private JLabel jl = new JLabel("숫자 두개를 입력하세요");
	private JTextField tf1 = new JTextField(8);
	private JTextField tf2 = new JTextField(8);
	private int sum = 0;

	public MyDialog1(JFrame frame, String title) {
		super(frame, title, true);
		setLayout(new FlowLayout());
		add(addBtn);
		add(jl);
		add(tf1);
		add(tf2);
		setSize(700, 400);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = Integer.parseInt(tf1.getText()) + Integer.parseInt(tf2.getText());
				setVisible(false);
			}
		});
	}

	public int getSum() {
		return sum;
	}

}
