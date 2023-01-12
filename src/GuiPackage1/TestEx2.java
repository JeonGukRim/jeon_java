package GuiPackage1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestEx2 extends JFrame {
//	private String [] str = {"Java"};
	private JTextField jt = new JTextField(10);
	private JComboBox<String> jb = new JComboBox<String>();

	public TestEx2() {
		setTitle("콤보입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jt);
		jt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField t = (JTextField)e.getSource();
				jb.addItem(t.getText());
			}
		});
		
		c.add(jb);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main (String [] args) {
		new TestEx2();
	}
}
