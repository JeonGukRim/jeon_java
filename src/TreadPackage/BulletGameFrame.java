package TreadPackage;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BulletGameFrame extends JFrame {
	public BulletGameFrame() {
		setTitle("사격 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300, 300);
		setLocation(150, 100);
		setResizable(false);
		setVisible(true);
		p.startGame();

	}

	public static void main(String[] args) {
		new BulletGameFrame();
		
	}
}

class GamePanel extends JPanel {
	private JLabel baseLabel = new JLabel();
	private JLabel bulletLabel = new JLabel();
	private ImageIcon icon = new ImageIcon("images/chicken.jpg");
	private JLabel chicken = new JLabel(icon);

	public GamePanel() {
		setLayout(null);

		baseLabel.setSize(40, 40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);

		bulletLabel.setSize(10, 10);
		bulletLabel.setOpaque(true);
		bulletLabel.setBackground(Color.RED);
		chiCkenThread chickenthread = new chiCkenThread(chicken);
		chicken.setSize(40, 40);

		add(chicken);
		add(baseLabel);
		add(bulletLabel);
		chickenthread.start();
		// 이 패널에 마우스를 클릭하면 baseLabel이 키 입력을 받을 수 있도록 포커스를 강제 지정
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				baseLabel.setFocusable(true);
				baseLabel.requestFocus(); // 키보드 입력을 받도록 포커스 강제 지정
			}
		});
		
	}

	public void startGame() {
		baseLabel.setLocation(this.getWidth() / 2 - 20, this.getHeight() - 40);
		bulletLabel.setLocation(this.getWidth() / 2 - 5, this.getHeight() - 50);

		baseLabel.setFocusable(true);
		baseLabel.requestFocus(); // 키보드 입력을 받도록 포커스 강제 지정
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread bulletThread = null;

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					if (bulletThread == null || !bulletThread.isAlive()) {
						bulletThread = new BulletThread(bulletLabel);
						bulletThread.start();
					}
				}
			}
		});
		if((chicken.getY()+40) == bulletLabel.getY()) {
			System.out.println("맞췄습니다");
		}
	}

	class chiCkenThread extends Thread {
		private JComponent chicken;

		public chiCkenThread(JComponent chicken) {
			this.chicken = chicken;
		}

		@Override
		public void run() {
			while (true) {
				int cx = chicken.getX() + 5;
				int cy = chicken.getY();

				if (cx > 300) {
					cx = 0;
				}
				chicken.setLocation(cx, cy);
				chicken.getParent().repaint();
				try {
					sleep(20);
				} catch (InterruptedException e) {
				}
			}
		}

	}

	class BulletThread extends Thread {
		private JComponent bullet;

		public BulletThread(JComponent bullet) {
			this.bullet = bullet;
		}

		@Override
		public void run() {
			while (true) {
				int x = bullet.getX();
				int y = bullet.getY() - 5;

				if (y < 0) {
					bullet.setLocation(bullet.getParent().getWidth() / 2 - 5, bullet.getParent().getHeight() - 50);
					bullet.getParent().repaint();
					return; // thread ends
				}
				bullet.setLocation(x, y);
				bullet.getParent().repaint();
				try {
					sleep(20);
				} catch (InterruptedException e) {
				}
			}
		}

	}
}
