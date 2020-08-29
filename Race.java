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
		this.setOpaque(true);	//JButton�� ������ ���������� ���� �ǵ���.
		this.setBounds(x, y, 130, 200);
		lane.add(this);
	}
	
	public void run() {
		//Car�� �޸��� �κ�
		for(int i=0; i<1000; i++) {
			//���η� �޸��� ��
			x=i;
			//Car �����̰� �ϴ� �κ�
			this.setBounds(x, y, 130, 200);
			
			//Car���� ���� �ٸ� ������ ���͹��� ������.
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
		  	
	   //Car ��� ����
		rank1++;
		rank2=rank1;
		(lane.getGraphics()).drawString("*"+rank2+"�� ����!*", 800, 30);
	}
}
