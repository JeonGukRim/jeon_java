package test1;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 程序的主窗体
 */
public class FrmMain extends JFrame {
 
	/*
	 * 初始的一些全局变量 1是否存活 2方向 3子弹数量 4飞机
	 */
	// 1是否存活
	public static boolean isRun = true;
	// 2方向
	public static boolean right, left, up, down;
	// 3子弹数量
	public static int num = 100;
	// 4飞机
	private JLabel plane;
 
	public FrmMain() {
		isRun=true;
		// 设置大小
		setSize(400, 600);
		// 设置居中
		setLocationRelativeTo(null);
		// 设置点关闭时，程序退出
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 得到内容面板
		final Container c = getContentPane();
		c.setBackground(Color.BLACK);
		// 设置标题
		setTitle("是男人就坚持20秒");
		// 设置绝对定位
		c.setLayout(null);
 
		// 添加标签
		final JLabel lblDesc = new JLabel("是男人就坚持20秒");
		lblDesc.setBounds(133, 175, 113, 31);
		lblDesc.setForeground(Color.WHITE);
		c.add(lblDesc);
 
		// 添加按钮
		final JButton btnStart = new JButton("开始");
		btnStart.setBounds(133, 210, 113, 31);
		c.add(btnStart);
 
		// 设置可见
		setVisible(true);
		//设置内容面板获取焦点
		c.setFocusable(true);
 
		/*
		 * 增加键盘事件
		 */
		c.addKeyListener(new KeyAdapter() {
			// 按下,具体实现，即为按钮把对应的方向设置为true
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left=true;
					break;
				case KeyEvent.VK_RIGHT:
					right=true;	
					break;
				case KeyEvent.VK_UP:
					up=true;
					break;
				case KeyEvent.VK_DOWN:
					down=true;
					break;
				}
			}
 
			// 释放，把当前方向再设置成false
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left=false;
					break;
				case KeyEvent.VK_RIGHT:
					right=false;	
					break;
				case KeyEvent.VK_UP:
					up=false;
					break;
				case KeyEvent.VK_DOWN:
					down=false;
					break;
				}
			}
		});
		/*
		 * 增加鼠标的点击事件
		 */
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//把当前标签和按钮隐藏
				btnStart.setVisible(false);
				lblDesc.setVisible(false);
				//飞机
				plane = new JLabel(new ImageIcon("images/sdf.jpg"));
				plane.setBounds(150, 400, 33, 33);
				c.add(plane);
				//刷新页面
				plane.updateUI();
				//飞机实现 移动
				new MoveThread(plane,c).start();
				
				//计时器
				new TimerThread(c).start();
				
				//子弹
				for(int i=0;i<num;i++){
					new BulletThread(c,plane,FrmMain.this).start();
				}
				
			}
		});
 
	}
 
	/*
	 * 程序的入口
	 */
	public static void main(String[] args) {
		// new 就是一个对象
		new FrmMain();
	}
	/*
	 * 飞机移动的线程类
	 */
	public class MoveThread extends Thread {
	 
		//飞行速度
		private int speed=5;
		//飞机
		private JLabel plane;
		//内容面板
		private Container c;
		
		public MoveThread(JLabel plane, Container c) {
			this.plane=plane;
			this.c=c;
		}
		
		/*
		 * 飞机运算的线程实现
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			while(FrmMain.isRun){
				if(FrmMain.left){
					//设置左飞机
					plane.setIcon(new ImageIcon("images/sdf.jpg"));
					//如果是超过左边边缘，x轴则设置为零
					if(plane.getX()-speed<0){
						plane.setLocation(0, plane.getY());
					}else{
						plane.setLocation(plane.getX()-speed, plane.getY());
					}
				}else if(FrmMain.right){
					//设置成右飞机	
					plane.setIcon(new ImageIcon("images/sdf.jpg"));
					//如果x轴+飞宽+移动大小超过内容面板，则设置最靠右(内容面板-飞机宽的x轴大小)
					if(plane.getX()+plane.getWidth()+speed>c.getWidth()){
						plane.setLocation(c.getWidth()-plane.getWidth(), plane.getY());
					}
					else{
						plane.setLocation(plane.getX()+speed, plane.getY());
					}
				}else if(FrmMain.up){
					//正飞机
					plane.setIcon(new ImageIcon("images/sdf.jpg"));
					//如果飞最上面，超过边界后，作的处理
					if(plane.getY()-speed<0){
						plane.setLocation(plane.getX(), 0);
					}
					else{
						plane.setLocation(plane.getX(), plane.getY()-speed);
					}
				}else if(FrmMain.down){
					//正飞机
					plane.setIcon(new ImageIcon("images/sdf.jpg"));
					//如果飞最下面，超过边界后，作的处理
					if(plane.getY()+speed+plane.getHeight()>c.getHeight()){
						plane.setLocation(plane.getX(), c.getHeight()-plane.getHeight());
					}else{
						plane.setLocation(plane.getX(), plane.getY()+speed);
					}
				}
				//在线程时，间隔50毫秒执行一回
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	/*
	 * 子弹线程
	 */
	public class BulletThread extends Thread {
	 
		// 内容面板
		private Container c;
		// 飞机
		private JLabel plane;
	 
		// 子弹
		private JLabel lblBullet;
		// x轴速度
		private int xSpeed;
		// y轴速度
		private int ySpeed;
		
		private FrmMain frmMain;
		public BulletThread(Container c, JLabel plane, FrmMain frmMain) {
			this.c = c;
			this.plane = plane;
			this.frmMain=frmMain;
	 
			// 随机类
			Random random = new Random();
			// 创建 子弹
			lblBullet = new JLabel(new ImageIcon("images/apple.jpg"));
			lblBullet.setLocation(random.nextInt(c.getWidth()), random.nextInt(c.getHeight()/2));
			// 随机x轴速度
			xSpeed = random.nextInt(5) + 1;
			// 随机y轴速度
			ySpeed = random.nextInt(5) + 1;
			c.add(lblBullet);
		}
	 
		// 张程实现
		@Override
		public void run() {
			while (FrmMain.isRun) {
	 
				//子弹超过上下左右边缘的处理
				if (lblBullet.getX() < 0 || lblBullet.getX() > c.getWidth()) {
					xSpeed = -xSpeed;
				}
				if (lblBullet.getY() < 0 || lblBullet.getY() > c.getHeight()) {
					ySpeed=-ySpeed;
				}
				lblBullet.setBounds(lblBullet.getX()+xSpeed, lblBullet.getY()+ySpeed, 12, 12);
				//判断子弹与飞机的交集
				if(lblBullet.getBounds().intersects(plane.getBounds())){
					//结束 
					FrmMain.isRun=false;
					//爆炸
					int x = plane.getX()-plane.getWidth();
					int y=  plane.getY()-plane.getHeight();
					//启动爆炸线程
					new ExplosionThread(x,y,c,plane,frmMain).start();
				}
				
				try {
					sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 计时线程
	 */
	public class TimerThread extends Thread {
	 
		//内容面板 
		private Container  c;
		public TimerThread(Container c) {
			this.c=c;
		}
		
		//线程实现 
		@Override
		public void run() {
			//1添加JLabel 00:
			JLabel lblTime = new JLabel("00:00");
			lblTime.setBounds(350, 0, 50, 20);
			lblTime.setForeground(Color.YELLOW);
			c.add(lblTime);
			lblTime.updateUI();
			//2获取当前时间
			long start = System.currentTimeMillis();
			//3刷新
			DecimalFormat df = new DecimalFormat("00");
			while(FrmMain.isRun){
				long x = System.currentTimeMillis()-start;
				int second= (int)(x/1000);
				int mSecond=(int)(x%1000/10); 
				lblTime.setText(df.format(second)+":"+df.format(mSecond));
				
				//休眠50毫秒
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 爆炸线程
	 */
	public class ExplosionThread extends Thread {
		private int x;
		private int y;
		private Container c;
		private JLabel plane;
	 
		//最先的窗体
		private FrmMain frmMain;
		public ExplosionThread(int x, int y, Container c, JLabel plane, FrmMain frmMain) {
			this.x=x;
			this.y=y;
			this.c=c;
			this.plane=plane;
			this.frmMain=frmMain;
		}
		
		//线程实现
		@Override
		public void run() {
			//爆炸的起始图片
			JLabel lblExplosion =new JLabel(new ImageIcon("images/back.jpg"));
			lblExplosion.setBounds(x, y, 128, 128);
			c.add(lblExplosion);
			plane.setVisible(false);
			//爆炸的动画图片
			for(int i=1;i<72;i++){
				lblExplosion.setIcon(new ImageIcon("images/back.jpg"));
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//提示消息
			JLabel lblEnd = new JLabel("Game Over");
			lblEnd.setForeground(Color.RED);
			lblEnd.setBounds(160, 200, 100, 50);
			c.add(lblEnd);
			//再来一局
			JButton btnAgain = new JButton("再来一局");
			btnAgain.setBounds(150, 250, 100, 50);
			c.add(btnAgain);
			
			lblEnd.updateUI();
			btnAgain.updateUI();
			
			//再来一局的事件
			btnAgain.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new FrmMain();
					frmMain.setVisible(false);
				}
			});
			
		}
	 
	}
}