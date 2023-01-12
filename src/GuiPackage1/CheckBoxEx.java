package GuiPackage1;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
public class CheckBoxEx extends JFrame {
	
	public CheckBoxEx() {
	setTitle("체크 박스 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	
	ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
	ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
	
	
	JCheckBox apple = new JCheckBox("사과");
	JCheckBox pear = new JCheckBox("배",true);
	JCheckBox cherry = new JCheckBox("체리",cherryIcon);
	cherry.setBorderPainted(true);// 눌림효과가 있음
	cherry.setSelectedIcon(selectedCherryIcon);//체크후 이미지 
	c.add(apple);
	c.add(pear);
	c.add(cherry);
	setSize(400,200);
	setVisible(true);
	}
	
	public static void main (String [] args) {
		new CheckBoxEx();
	}
}