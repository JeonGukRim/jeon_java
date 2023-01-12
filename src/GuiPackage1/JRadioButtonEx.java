package GuiPackage1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonEx extends JFrame {
	public JRadioButtonEx() {
	setTitle("레디오 버튼 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
//	c.setLayout(new FlowLayout());
	c.setLayout(new BorderLayout());
	
	ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
	ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
	JPanel panel1 = new JPanel();
	ButtonGroup g = new ButtonGroup();
	JRadioButton apple = new JRadioButton("사과");
	JRadioButton pear = new JRadioButton("배",true);
	JRadioButton cherry = new JRadioButton("체리",cherryIcon);
	
	cherry.setBorderPainted(true);
	cherry.setSelectedIcon(selectedCherryIcon);

	JPanel panel2 = new JPanel();
	ButtonGroup g1 = new ButtonGroup();
	JRadioButton kiwi = new JRadioButton("키위");
	JRadioButton banana = new JRadioButton("바나나",true);
	JRadioButton orange = new JRadioButton("오렌지");
	
	g.add(apple);
	g.add(pear);
	g.add(cherry);
	g1.add(kiwi);
	g1.add(banana);
	g1.add(orange);
	panel1.add(kiwi);
	panel1.add(pear);
	panel1.add(cherry);
	c.add(panel1,BorderLayout.NORTH);
	panel2.add(apple);
	panel2.add(banana);
	panel2.add(orange);
	c.add(panel2,BorderLayout.SOUTH);
	setSize(250,500);
	setVisible(true);
	
	}
	public static void main (String [] args) {
		new  JRadioButtonEx ();
	}
}
