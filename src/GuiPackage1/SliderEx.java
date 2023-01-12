package GuiPackage1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderEx extends JFrame {

	public SliderEx() {
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		JLabel text = new JLabel("100");
		text.setOpaque(true);
		text.setBackground(Color.GREEN);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(50); // 50단위로 눈금표시
		slider.setMinorTickSpacing(10); // 최소 눈금 10

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				text.setText(Integer.toString(slider.getValue()));
				text.setFont(new Font("serif", Font.BOLD,slider.getValue()));
			}
		});
		c.add(slider);
		c.add(text);
		setSize(300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SliderEx();
	}

}
