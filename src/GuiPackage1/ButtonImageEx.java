package GuiPackage1;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ButtonImageEx extends JFrame {

	public ButtonImageEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
//		c.setLayout(new FlowLayout());

		ImageIcon normalicon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rollovericon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedicon = new ImageIcon("images/pressedIcon.gif");

		JButton btn = new JButton("call~~", normalicon);
		btn.setPressedIcon(pressedicon);
		btn.setRolloverIcon(rollovericon);
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		btn.setVerticalAlignment(SwingConstants.TOP);
		
		c.add(btn);
		setSize(250, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonImageEx();
	}

}
