package Manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	JLabel []hour = new JLabel[16];
	JLabel []minute = new JLabel[16];
	JLabel[] second = new JLabel[16];
	JLabel [] use=new JLabel[16];
	JLabel []foodName=new JLabel[16];
	
	ServerBackground server=new ServerBackground();
	
	String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
	String jdbc_driver="com.mysql.cj.jdbc.Driver";
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
	int milliseconds = 550;
	int seconds = 0;
    int minutes = 0;
	int hours = 0;
	boolean state = true;
	
	int seatNum=0;
	

	
	// �¼� ����
	public ShowSeat() {
		

		//���� �����ִ� table
		showTable();
		
		// �¼����� 1
		manageSeat();
		setVisible(true);	
	}
	public void changeColor() {
		seat[seatNum-1].setBackground(new Color(10,250,90));
		use[seatNum-1].setText("�����");
	}
	public void manageSeat() {
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
		
		// �¼� ����1
		int j=90;
		for(int i=0;i<6;i++) {
			seat[i]=new JPanel();
			use[i]=new JLabel("�������");
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "��");
			l_seat[i].setBounds(65,-30,100,100);
			use[i].setBounds(50, 60, 70, 30);
			use[i].setFont(new Font("����",Font.BOLD,15));
			seat[i].setBounds(new Rectangle(j,130,160,180));
			j+=170;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			left.add(seat[i]);
		}
		
		 //�¼� ����2
		int k=90;
		for(int i=6;i<12;i++) {
			seat[i]=new JPanel();
			use[i]=new JLabel("�������");
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "��");
			l_seat[i].setBounds(60,-30,100,100);
			use[i].setBounds(50, 60, 70, 30);
			use[i].setFont(new Font("����",Font.BOLD,15));
			seat[i].setBounds(new Rectangle(k,500,160,180));
			k+=170;
			seat[i].setBackground(new Color(255,228,225));

			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			left.add(seat[i]);
		}
		
		// �¼� ����1
		int o=130;
		for(int i=12;i<16;i++) {
			seat[i]=new JPanel();
			use[i]=new JLabel("�������");
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "��");
			l_seat[i].setBounds(58,-30,100,100);
			use[i].setBounds(50, 60, 70, 30);
			use[i].setFont(new Font("����",Font.BOLD,15));
			seat[i].setBounds(new Rectangle(1150,o,160,180));
			o+=190;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			left.add(seat[i]);
		}
		
		
		// ------------------------Ÿ�̸�----------------------------
		
		for(int i=0;i<hour.length;i++) {
			hour[i]=new JLabel("00��");
			hour[i].setBounds(20, 135, 60, 45);
			hour[i].setForeground(Color.BLACK);
			hour[i].setFont(new Font("����", Font.PLAIN, 15));
			
			minute[i]=new JLabel("00��");
			minute[i].setBounds(60,135,60,45);
			minute[i].setForeground(Color.BLACK);
			minute[i].setFont(new Font("����", Font.PLAIN, 15));
			
			second[i]=new JLabel("00��");
			second[i].setBounds(100,135, 95, 46);
			second[i].setForeground(Color.BLACK);
			second[i].setFont(new Font("����", Font.PLAIN, 15));
			
			//seat[i].add(hour[i]);  seat[i].add(minute[i]);   seat[i].add(second[i]);
		}		
	}
	
	public void startTimer() {
		state = true;  //�����Ѵ�
		Thread t = new Thread() {
			public void run() {
				while(state){
					try {
						sleep(2);
						if(milliseconds<0) {
							milliseconds=550;
							seconds--;
						}if(seconds<0) {
							milliseconds=550;
							seconds=59;
							minutes--;
						}if(minutes<0) {
							milliseconds=550;
							seconds=59;
							minutes=59;
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
								
						second[seatNum-1].setText(seconds + "��");
						minute[seatNum-1].setText(minutes + "��");
						hour[seatNum-1].setText(hours + "��");
					} catch(Exception e) {	}
				    if(state==false) {
				    	seat[seatNum-1].setBackground(new Color(255,228,225));
				    	use[seatNum-1].setText("�������");
				    	break;
				    }
				}  // while ��
			}  // run() ��
		};// Thread ��	
		t.start();
	}

	public void showTable() {
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
	}
	
	public void dbConnect() {
		String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		try {
			Class.forName(jdbc_driver);
			System.out.println("Mysql client ������ ���̽� ���� �����...");
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
			String sql="select * from seat WHERE useable=1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			System.out.println("����");
			while(rs.next()) {
				seatNum=rs.getInt("num");
				changeColor();
				//hours=rs.getInt("time");
				//startTimer();
				
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ShowSeat s=new ShowSeat();
		Server server=new Server();
		//ServerSocket serversocket=null;
		s.dbConnect();
		server.setGui(s);
		server.setting();
		System.out.println("����");
	}
}
