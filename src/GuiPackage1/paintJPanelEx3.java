package GuiPackage1;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx3 extends JFrame {
	private MyPanel panel = new MyPanel();
	public paintJPanelEx3 () {
	setTitle("JPanel 의 paintComponent() 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setContentPane(panel);
	setSize(500,2020);
	setVisible(true);
	}
	class MyPanel extends JPanel{
		// 이미지 그리기
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage(); //이미지 객체
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// x,y,z,h    x,y 좌표에서 시작하여 z,h에서 끝남 선그리기
			//도형그리기
			g.setColor(Color.RED);
//			g.drawLine(20, 20, 40, 40); 
//			g.fillOval(20, 60, 80, 80);  //원그리기 fill 채움원
//			g.drawRect(20,150,80,80); //사각형 
//			g.drawRoundRect(20,240,120,80,40,60); // 타원에 작원으로 깍는 수치
//			g.drawArc(20, 350,80,80,90,270);// x,y 위치 ,z,h 사이즈 ,k,j 역시침으로 k도수부터 시작하여 j만큼 채움
//			int [] x = {230,190,230,270};
//			int [] y = {40,120,200,120};
//			g.drawPolygon(x,y,4); //점을 대응해서 찍고 선으로 이어주는 
			
			g.fillArc(20,350,80,80,0,270);
//			int [] x = {50,20,50,100};
//			int [] y = {500,550,600,550};
//			g.fillPolygon(x,y,4);
			
			
			// 이미지 그리기
						      //위치  //this란 이미지가 다 그려졌다는 신호;null넣으면 그림이 안그려져도 그냥 진행한다는뜻
//			g.drawImage(img, 20, 20,this);
//			
//			g.drawImage(img, 20,350,100,100,this); //이미지를 특정 사이즈로 저장
//			
////			g.drawImage(img, 0,0,getWidth(),getHeight(),this); //패널크기에 맞춰서 출력
//			
//			g.drawImage(img,20,500,200,700,100,0,150,150,this);
//			//원본이미지의 50,0 에서 150,150 사각형 부분을 jpanel의 20,500에서 200,700영역에 그리기
//			
//			//클리핑 영역 이미지 특정 부분만 출력; int x ,int y, int w , int h
//			g.setClip(100,750,150,880); 
//			g.clipRect(90,800,100,900);// 클립의 영역에 새로 클립영역을 추가한 교집합
//			g.drawImage(img, 0,710,this);
//			g.setColor(Color.YELLOW);
//			g.setFont(new Font("Arial",Font.ITALIC,40));
//			g.drawString("Go Gator!!",10,800);
		}
	}
	public static void main (String[] args) {
		new paintJPanelEx3();
	}
}
