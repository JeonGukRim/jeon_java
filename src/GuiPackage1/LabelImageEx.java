package GuiPackage1;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelImageEx extends JFrame {
	public LabelImageEx() {
		setTitle("레이블예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel textLabel = new JLabel("사랑합니다");

		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);

		ImageIcon normallcon = new ImageIcon("images/normalIcon.gif");
		JLabel label = new JLabel("보고 싶으면 전화하세요", normallcon, SwingConstants.CENTER);//수평정렬 값
		
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);
		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelImageEx();
	}
}
