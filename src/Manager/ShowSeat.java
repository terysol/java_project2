package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import database.DBfooddelete;
import database.DBfoodlist;


public class ShowSeat extends JFrame{
	JPanel left=new JPanel();
	JPanel right= new JPanel();
	Container c=getContentPane();
	JTable food;
	JPanel [] seat=new JPanel[16];
	JLabel [] l_seat=new JLabel[16];
	JLabel []hour = new JLabel[16];
	JLabel []minute = new JLabel[16];
	JLabel[] second = new JLabel[16];
	JLabel [] use=new JLabel[16];
	JLabel []foodName=new JLabel[16];
	JButton success=new JButton("완료");
	
	String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
	String jdbc_driver="com.mysql.cj.jdbc.Driver";
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	String dbID="root";
	String dbPW="mirim2";
	
	int milliseconds = 550;
	int seconds = 0;
    int minutes = 0;
	int hours = 0;
	boolean state = true;
	
	int seatNum=0;

	public ShowSeat() {
		

		//음식 보여주는 table
		showTable();
		
		// 좌석가로 1
		manageSeat();
		setVisible(true);	
	}
	
	public void changeColor() {
		seat[seatNum-1].setBackground(new Color(10,250,90));
		use[seatNum-1].setText("사용중");
	}
	
	public void manageSeat() {
		setTitle("좌석 보여주기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);

		// left 패널
		left.setBackground(new Color(128,0,128));
		left.setBounds(0, 0, 1350, 1000);
		c.add(left);
		left.setLayout(null);
				
		
		// right 패널
		right.setBackground(new Color(128,0,128));
		right.setBounds(0, 0, 2000,1000);
		c.add(right);
		right.setLayout(null);
		
		// 좌석 가로1
		int j=90;
		for(int i=0;i<6;i++) {
			seat[i]=new JPanel();
			use[i]=new JLabel("비어있음");
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "번");
			l_seat[i].setBounds(65,-30,100,100);
			use[i].setBounds(50, 60, 70, 30);
			use[i].setFont(new Font("굴림",Font.BOLD,15));
			seat[i].setBounds(new Rectangle(j,130,160,180));
			j+=170;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("굴림",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			left.add(seat[i]);
		}
		
		 //좌석 가로2
		int k=90;
		for(int i=6;i<12;i++) {
			seat[i]=new JPanel();
			use[i]=new JLabel("비어있음");
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "번");
			l_seat[i].setBounds(60,-30,100,100);
			use[i].setBounds(50, 60, 70, 30);
			use[i].setFont(new Font("굴림",Font.BOLD,15));
			seat[i].setBounds(new Rectangle(k,500,160,180));
			k+=170;
			seat[i].setBackground(new Color(255,228,225));

			l_seat[i].setFont(new Font("굴림",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			left.add(seat[i]);
		}
		
		// 좌석 세로1
		int o=130;
		for(int i=12;i<16;i++) {
			seat[i]=new JPanel();
			use[i]=new JLabel("비어있음");
			seat[i].setLayout(null);
			l_seat[i]=new JLabel((i+1) + "번");
			l_seat[i].setBounds(58,-30,100,100);
			use[i].setBounds(50, 60, 70, 30);
			use[i].setFont(new Font("굴림",Font.BOLD,15));
			seat[i].setBounds(new Rectangle(1150,o,160,180));
			o+=190;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("굴림",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			left.add(seat[i]);
		}
		
		
		// ------------------------타이머----------------------------
		
		for(int i=0;i<hour.length;i++) {
			hour[i]=new JLabel("00시");
			hour[i].setBounds(20, 135, 60, 45);
			hour[i].setForeground(Color.BLACK);
			hour[i].setFont(new Font("굴림", Font.PLAIN, 15));
			
			minute[i]=new JLabel("00분");
			minute[i].setBounds(60,135,60,45);
			minute[i].setForeground(Color.BLACK);
			minute[i].setFont(new Font("굴림", Font.PLAIN, 15));
			
			second[i]=new JLabel("00초");
			second[i].setBounds(100,135, 95, 46);
			second[i].setForeground(Color.BLACK);
			second[i].setFont(new Font("굴림", Font.PLAIN, 15));
			
			//seat[i].add(hour[i]);  seat[i].add(minute[i]);   seat[i].add(second[i]);
		}		
	}
	
	public void startTimer() {
		state = true;  //시작한다
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
								
						second[seatNum-1].setText(seconds + "초");
						minute[seatNum-1].setText(minutes + "분");
						hour[seatNum-1].setText(hours + "시");
					} catch(Exception e) {	}
				    if(state==false) {
				    	seat[seatNum-1].setBackground(new Color(255,228,225));
				    	use[seatNum-1].setText("비어있음");
				    	break;
				    }
				}  // while 끝
			}  // run() 끝
		};// Thread 끝	
		t.start();
	}

	public void showTable() {
		JScrollPane jps = new JScrollPane(food);  
		String[] columns = {"좌석", "음식", "개수","요구 사항"};
        DefaultTableModel model=new DefaultTableModel(columns,0);
       try {
	            Class.forName(jdbc_driver);
	            conn=DriverManager.getConnection(dbURL,dbID,dbPW);
	            pstmt = conn.prepareStatement("SELECT SeatNum, FoodName, count, need FROM foodlist");
	            rs = pstmt.executeQuery();
	            

	            while (rs.next()) {
	                String seatNum = rs.getString("SeatNum");
	                String FoodName = rs.getString("FoodName");
	                String count = rs.getString("count");
	                String need=rs.getString("need");

		          
		           String[] data = {seatNum, FoodName, count,need};


	            	model.addRow(data);
	            };      
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
       	 food=new JTable(model);
	     food.setBounds(1355,20, 550,250);
		 right.add(food);
		 right.add(jps);
		 success.setBounds(1580, 300, 80, 40);
		 right.add(success);
		 success.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n=food.getSelectedRow();
				String data=(String) food.getValueAt(n, 0);
				System.out.println(data);
				DefaultTableModel tm=(DefaultTableModel)food.getModel();
				if(n>=0 && n<food.getRowCount()) {
					DBfooddelete db=new DBfooddelete(data);
					tm.removeRow(n);
				}
			}
		});
	}
	
	public void dbConnect() {
		String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		try {
			Class.forName(jdbc_driver);
			System.out.println("Mysql client 데이터 베이스 연결 대기중...");
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
			String sql="select * from seat WHERE useable=1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			System.out.println("성공");
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
		System.out.println("성공");
	}
}
