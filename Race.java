import java.awt.*;
import javax.swing.*;

public class Team extends JButton implements Runnable{
	ImageIcon back=new ImageIcon("Images/backimg2.png");
	JPanel lane=new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(back.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};
	ImageIcon name;
	int x, y;
	static int rank1;
	static int rank2;
	
	public Team(ImageIcon name, int x, int y) {
		lane.setLayout(null);
		this.name=name;
		this.setIcon(name);
		this.setBackground(Color.pink);
		this.setOpaque(true);	//JButton에 설정한 디자인으로 적용 되도록.
		this.setBounds(x, y, 130, 200);
		lane.add(this);
	}
	
	public void run() {
		//Car가 달리는 부분
		for(int i=0; i<1000; i++) {
			//가로로 달리는 것
			x=i;
			//Car 움직이게 하는 부분
			this.setBounds(x, y, 130, 200);
			
			//Car마다 서로 다른 임의의 인터벌을 가진다.
			try {
				Thread.sleep((int)(Math.random()*20));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==250){
			    try{
		         Thread.sleep(1000);
		      } catch (InterruptedException e) {
		         e.printStackTrace();
		      }
		   }
		   if(i==500){
			    try{
		         Thread.sleep(1000);
		      } catch (InterruptedException e) {
		         e.printStackTrace();
		      }
		   }
		   if(i==750){
			    try{
		         Thread.sleep(1000);
		      } catch (InterruptedException e) {
		         e.printStackTrace();
		      }
		   }
		}
		  	
	   //Car 경기 종료
		rank1++;
		rank2=rank1;
		(lane.getGraphics()).drawString("*"+rank2+"등 종강!*", 800, 30);
	}
}
