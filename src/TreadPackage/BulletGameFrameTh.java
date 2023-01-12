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

public class BulletGameFrameTh extends JFrame {
	public BulletGameFrameTh() {
		setTitle("사격 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel1 p = new GamePanel1();
		setContentPane(p);
		setSize(300, 300);
		setResizable(false);
		setVisible(true);
		p.startGame();
	}

	public static void main(String[] args) {
		new BulletGameFrameTh();
	}
}

class GamePanel1 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TargetThread targetThread = null;
	private JLabel baseLabel = new JLabel();
	private JLabel bulletLabel = new JLabel();
	private JLabel targetLabel;

	public GamePanel1() {
		setLayout(null);

		baseLabel.setSize(40, 40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);

		ImageIcon img = new ImageIcon("images/chicken.jpg");
		targetLabel = new JLabel(img);
		targetLabel.setSize(img.getIconWidth(), img.getIconWidth());

		bulletLabel.setSize(10, 10);
		bulletLabel.setOpaque(true);
		bulletLabel.setBackground(Color.RED);

		add(targetLabel);
		add(baseLabel);
		add(bulletLabel);

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
		targetLabel.setLocation(0, 0);

		targetThread = new TargetThread(targetLabel);
		targetThread.start();

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
	}

	class TargetThread extends Thread {
		private JComponent target;

		public TargetThread(JComponent target) {
			this.target = target;
			target.setLocation(0, 0);
			target.getParent().repaint();
		}

		@Override
		public void run() {
			while (true) {
				int x = target.getX() + 5;
				int y = target.getY();
				if (x > target.getParent().getWidth())
					target.setLocation(0, 0);
				else
					target.setLocation(x, y);

				target.getParent().repaint();
				try {
					sleep(20);
				} catch (InterruptedException e) {
					// the case of hit by a bullet
					target.setLocation(0, 0);
					target.getParent().repaint();
					try {
						sleep(500); // 0.5초 기다린 후에 계속한다.
					} catch (InterruptedException e2) {
					}
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
