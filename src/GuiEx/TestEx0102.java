package GuiEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestEx0102 extends JFrame {
	private JTextField tf = new JTextField(10);
//	private String num = "";
	
	public TestEx0102() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JLabel jl1 = new JLabel("Panel1");

		JLabel jl2 = new JLabel("Panel2");
		JLabel jl3 = new JLabel("Panel3");

		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp1.setBackground(Color.LIGHT_GRAY);
		jp2.setBackground(Color.PINK);
		jp3.setBackground(Color.LIGHT_GRAY);

//		jp1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));

		jp1.add(jl1);
		jp1.add(tf);
		jp3.add(jl3);
		JButton[] jb = new JButton[9];
		jp2.setLayout(new GridLayout(3, 3, 5, 5));
		for (int i = 1; i <= 9; i++) {
			jb[i - 1] = new JButton(i + "");
			jb[i - 1].addActionListener(new TestAction());
			jp2.add(jb[i - 1]);

		}

		c.add(jp1, BorderLayout.NORTH);
		c.add(jp2, BorderLayout.CENTER);
		c.add(jp3, BorderLayout.SOUTH);
		setSize(500, 500);
		setVisible(true);

	}

	class TestAction implements ActionListener {
		String num = "";
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			JButton j = (JButton) e.getSource();
//			JButton tf1 = (JButton) e.getSource();
//			num += tf1.getText() ;
			
			num = tf.getText()+e.getActionCommand();
			
			
			tf.setText(num);
			
			
			
			
//			System.out.println(j.getText());
//			System.out.println(e.getActionCommand());
		}

	}

	public static void main(String[] args) {
		new TestEx0102();
	}
}
