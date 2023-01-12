package GuiPackage1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TestEx3 extends JFrame {
	JPanel p_north = new JPanel();
	JPanel p_center = new JPanel();
	JTextField moneyText = new JTextField(10);
	JButton btn = new JButton("계산");
	JLabel[] la = new JLabel[8];
	JTextField[] moneyTextArray = new JTextField[8];
	String[] str = { "오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원" };
	int[] moneyArray = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };

	TestEx3() {
		this.setTitle("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JLabel la1 = new JLabel("금액");
		la1.setFont(new Font("serif", Font.BOLD, 15));
		p_north.add(la1);
		p_north.add(moneyText);
		p_north.add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton jb = (JButton) e.getSource();
				String str = jb.getText();
				int getnum;
				getnum = Integer.parseInt(moneyText.getText());
				if (str.equals("계산")) {
					for (int i = 0; i < moneyText.getText().length(); i++) {
						if(getnum/moneyArray[i] > 0 ) {
//							moneyTextArray[i] =(getnum/moneyArray[i]);
						}
					}
				}

			}
		});

		p_center.setLayout(new GridLayout(8, 2));
		for (int i = 0; i < str.length; i++) {
			la[i] = new JLabel(str[i]);
			la[i].setFont(new Font("serif", Font.BOLD, 15));
			la[i].setHorizontalAlignment(JLabel.CENTER);
			moneyTextArray[i] = new JTextField(5);
			p_center.add(la[i]);
			p_center.add(moneyTextArray[i]);
		}

		p_north.setBackground(Color.CYAN);
		p_center.setBackground(Color.CYAN);
		this.add(p_north, BorderLayout.NORTH);
		this.add(p_center, BorderLayout.CENTER);
		this.setSize(400, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestEx3();
	}
}
