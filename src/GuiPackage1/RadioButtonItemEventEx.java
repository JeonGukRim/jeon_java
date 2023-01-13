package GuiPackage1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RadioButtonItemEventEx extends JFrame {
	private JRadioButton [] radio = new JRadioButton[3];
	private String [] text = {"사과","배","체리"};
	private ImageIcon [] image = {new ImageIcon("images/apple.PNG"),
			new ImageIcon("images/pear.jpg"),new ImageIcon("images/cherry.jpg")};
	private JLabel imageLabel = new JLabel();
//	private ImageIcon image2 = new ImageIcon("images/33.png");
//	private ImageIcon image3 = new ImageIcon("images/33-1.png");
	public RadioButtonItemEventEx () {
	setTitle("레디오 버튼 아이템 이벤트 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
	JPanel radioPanel = new JPanel();
	radioPanel.setBackground(Color.GRAY);
	ButtonGroup g = new ButtonGroup();
	
	for(int i = 0 ; i<radio.length ; i++) {
		radio[i] = new JRadioButton(text[i]);
		g.add(radio[i]);
		radioPanel.add(radio[i]);
		radio[i].addItemListener(new MyItemListener());
	}
//	radio[0].setIcon(image2);
//	radio[0].setSelectedIcon(image3);
	
	radio[2].setSelected(true);
	c.add(radioPanel,BorderLayout.NORTH);
	c.add(imageLabel,BorderLayout.CENTER);
	imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	setSize(250,200);
	setVisible(true);
	}
	class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange() == ItemEvent.DESELECTED) {
				return;
			}
			if(radio[0].isSelected()) {
				imageLabel.setIcon(image[0]);
			}else if(radio[1].isSelected()) {
				imageLabel.setIcon(image[1]);
			}else {
				imageLabel.setIcon(image[2]);
			}
		}
		
	}
	
	public static void main (String [] args) {
		new RadioButtonItemEventEx();
	}
	
}
