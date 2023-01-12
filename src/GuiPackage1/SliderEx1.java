package GuiPackage1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderEx1 extends JFrame {
	public SliderEx1() {
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
//		c.setLayout(new FlowLayout());

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		JLabel text = new JLabel("Slider Test");
//		text.setHorizontalAlignment(JLabel.CENTER);
		text.setHorizontalAlignment(SwingConstants.CENTER);  //두가지 방법으로 레이아웃
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(10); // 숫자단위로 눈금표시
		slider.setMinorTickSpacing(1); // 최소 눈금 단위 설정

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
//				text.setText(Integer.toString(slider.getValue()));
				text.setFont(new Font("serif", Font.BOLD, slider.getValue()));
			}
		});
		c.add(slider,BorderLayout.NORTH);
		c.add(text,BorderLayout.CENTER);
		setSize(1000, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SliderEx1();
	}

}