package GuiEx;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ToolTipManager;

public class ToolBarEx extends JFrame {
	private Container contentPane;
	
	public ToolBarEx() {
		setTitle("툴바 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400,200);
		setVisible(true);
	}
	
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("Kitae Menu"); 
		toolBar.setBackground(Color.LIGHT_GRAY);
		
//		toolBar.add(new JButton("New"));
		JButton newBtn = new JButton("NEW");
		newBtn.setToolTipText("파일을 생성합니다");
		toolBar.add(newBtn);
//		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));
		openBtn.setToolTipText("파일을 엽니다");  //팁을 알려줌
		toolBar.add(openBtn);
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		
		/*-------------------------------------------------------------------*/	
		///툴팁 매니저 예제;
		ToolTipManager m =ToolTipManager.sharedInstance();
		m.setInitialDelay(0); // 마우스가 근접했을때 몇초후에 나타나는 시간
		m.setDismissDelay(1000); //팁 출력 유지 시간
		m.setEnabled(false); //툴팁 보이지 않게 함;
		/*-------------------------------------------------------------------*/		
		
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
	}
	
	public static void main(String [] args) {
		new ToolBarEx();
	}
}