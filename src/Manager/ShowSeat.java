package Manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DBfood_list;

public class ShowSeat extends JFrame{
	JPanel left=new JPanel();
	JPanel right= new JPanel();
	Container c=getContentPane();
	JTable food=new JTable();
	JPanel [] seat=new JPanel[16];
	JLabel [] l_seat=new JLabel[16];
	JLabel hour = new JLabel("00 ��");
	JLabel minute = new JLabel("00 ��");
	JLabel second = new JLabel("00 ��");
	
	static int milliseconds = 550;
	static int seconds = 0;
	static int minutes = 0;
	static int hours = 0;
	static boolean state = true;
	
	String member="";
	public String getMember() {
		return member;
	}


	public void setMember(String member) {
		this.member = member;
	}


	// �¼� ����
	public ShowSeat() {
		setTitle("�¼� �����ֱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);

		// left �г�
		left.setBackground(new Color(128,0,128));
		left.setBounds(0, 0, 1350, 1000);
		c.add(left);
		left.setLayout(null);
				
		
		// right �г�
		right.setBackground(new Color(128,0,128));
		right.setBounds(0, 0, 2000,1000);
		c.add(right);
		right.setLayout(null);

		//���� �����ִ� table
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("�ڸ�");
		model.addColumn("����");
		model.addColumn("����");
		model.addColumn("�޸�");
		food.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"�ڸ�","����","����","�޸�"
				}
			));
		DBfood_list DB=new DBfood_list();
		String sql="SELECT * FROM food1";
		//String sql2="SELECT SEC_TO_TIME(sum(TIME_TO_SEC(time))) FROM test";
		try {
			DB.pstmt=DB.conn.prepareStatement(sql);
			DB.rs=DB.pstmt.executeQuery();
			//DB.rs=DB.stmt.executeQuery(sql2);
			while(DB.rs.next()) {
				model.addRow(new Object [] {
						DB.rs.getString("Seat"),
						DB.rs.getString("Food"),
						DB.rs.getString("Num"),
						DB.rs.getString("Memo")
				});
			}
			food.setModel(model);
		}catch(Exception e) {
			e.printStackTrace();
		}
		food.setModel(model);
		food.setModel(model);
		food.setBounds(1375,10, 530, 291);
		right.add(food);
		
		// �¼����� 1
		int j=90;
		for(int i=0;i<6;i++) {
			seat[i]=new JPanel();
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "��");
			l_seat[i].setBounds(65,-30,100,100);
			seat[i].setBounds(new Rectangle(j,130,160,180));
			j+=170;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		
		 //�¼� ����2
		int k=90;
		for(int i=6;i<12;i++) {
			seat[i]=new JPanel();
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "��");
			l_seat[i].setBounds(60,-30,100,100);
			seat[i].setBounds(new Rectangle(k,500,160,180));
			k+=170;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		
		// �¼� ����1
		int o=130;
		for(int i=12;i<16;i++) {
			seat[i]=new JPanel();
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "��");
			l_seat[i].setBounds(58,-30,100,100);
			seat[i].setBounds(new Rectangle(1150,o,160,180));
			o+=190;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		
		
		// ------------------------Ÿ�̸�----------------------------
		
		
//		hour.setBounds(20, 135, 60, 45);
//		hour.setForeground(Color.BLACK);
//		hour.setFont(new Font("����", Font.PLAIN, 15));
//		minute.setBounds(60,135,60,45);
//		minute.setForeground(Color.BLACK);
//		minute.setFont(new Font("����", Font.PLAIN, 15));
//		
//		second.setBounds(100,135, 95, 46);
//		second.setForeground(Color.BLACK);
//		second.setFont(new Font("����", Font.PLAIN, 15));
//		
		
		setVisible(true);	
	}
	
	
	public void getTimer() {
//		seconds=Integer.parseInt(Tsecond.getText());
//		minutes=Integer.parseInt(Tmin.getText());
//		hours=Integer.parseInt(Thour.getText());
		state = true;  //�����Ѵ�
		
		
		Thread t = new Thread() {
			public void run() {
				while(state){
					try {
						sleep(1);
						if(milliseconds<0) {
							milliseconds=550;
							seconds--;
						}if(seconds<0) {
							milliseconds=550;
							seconds=60;
							minutes--;
						}if(minutes<0) {
							milliseconds=550;
							seconds=60;
							minutes=60;
							hours--;
						}
						if(hours<=0 && minutes<=0 && seconds<=0 && milliseconds<=0) {
							milliseconds=0;
							seconds=0;
							minutes=0;
							hours=0;
							state=false;
						}
						milliseconds--;
								
						second.setText(seconds + "��");
						minute.setText(minutes + "��");
						hour.setText(hours + "��");
					} catch(Exception e) {	}
				    if(state==false) break;
				}  // while ��
			}  // run() ��
		};// Thread ��	
		
		t.start();
	}

	public void checkMember(String member) {
		// TODO Auto-generated method stub
		member=getMember();
		if(member.equals("ȸ��")) {
			seat[0].setBackground(new Color(255,228,225));
		}else {
			seat[0].setBackground(new Color(245,130,113));
		}
	}
}
