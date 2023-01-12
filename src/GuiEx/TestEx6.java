package GuiEx;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestEx6 extends JFrame {
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7,20);
	private JScrollPane js;
	public TestEx6() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		js = new JScrollPane(ta);
		c.add(new JLabel("텍스트를 입력하세요 "));
		c.add(tf);
		c.add(js);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			JTextField text = (JTextField)e.getSource();
			ta.append(text.getText()+"\n");
				text.setText("");
			}
		});
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main (String [] args) {
	 new TestEx6();
	}
}
