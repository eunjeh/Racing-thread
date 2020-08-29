import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamTest extends JFrame{
	JPanel contentPane;
	JPanel menuPanel;
	JPanel hwPanel;
	JPanel centerPanel;
	JButton startBt, stopBt, pauseBt, suspendBt, resumeBt;
	Thread[] ths;
	
	Team[] team=new Team[] {
			new Team(new ImageIcon("Images/st1.png"), 0, 10),
			new Team(new ImageIcon("Images/st2.png"), 0, 10),
			new Team(new ImageIcon("Images/st3.png"), 0, 10),
	};
	
	public TeamTest() {
		super("Team Thread");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1400, 700);

		//Car�� ������ŭ Thread ��ü �����
		ths=new Thread[team.length];
		
		contentPane=new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);	//JFrame�� �г� ���̱�
		
		menuPanel=new JPanel();		//���� aside �г�
		//1�� 4�� 5���� ���� ��ġ
		menuPanel.setLayout(new GridLayout(1, 4));	
		startBt=new JButton(new ImageIcon("Images/start.png"));
		menuPanel.add(startBt);
		
		hwPanel=new JPanel();		//��� �޴��г�
		hwPanel.add(new JLabel(new ImageIcon("Images/TeamHW.png")));

		centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(team.length, 1, 5, 5));
		
		contentPane.add("West", menuPanel);
		contentPane.add("North", hwPanel);
		contentPane.add("Center", centerPanel);
		
		startBt.addActionListener(new ActionListener() {	//3�� ��� ���� class
			public void actionPerformed(ActionEvent e) {
				//����忡 ���ΰ� Car�� ��ġ�ϰ� ���� ����
				for(int i=0; i<team.length; i++) {
					centerPanel.add(team[i].lane);
				}
				centerPanel.updateUI();
				Team.rank1=0;
				game_play();
			}
		});
	}
	
	public void game_play() {
		makeThread();
		for(int i=0; i<team.length; i++) {
			ths[i].start();
		}
	}
	
	public void makeThread() {
		for(int i=0; i<team.length; i++) {
			//cars[i]=Runnable��
			ths[i]=new Thread(team[i]);
		}
	}
}

