package Manager;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Buy_Time implements ActionListener{

	private JFrame frame;
	private final JPanel panel = new JPanel();
	JButton []seat = new JButton[16];
	JLabel [] l_seat = new JLabel[16];
	
	

	public Buy_Time() {
		
		frame = new JFrame("좌석");
		frame.setBounds(100, 100, 1600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//창 가운데 정렬
		frame.setResizable(false);//창 크기 고정
		panel.setBounds(0, 0, 1600, 1000);
		panel.setBackground(new Color(128,0,128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		int j = 90;
		for(int i = 0; i<6; i++) {
			seat[i] = new JButton();
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "번");
			l_seat[i].setBounds(65, -30, 100, 100);
			seat[i].setBounds(new Rectangle(j, 185, 160, 180));//55, 185, 160, 180
			j+= 170;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("굴림", Font.BOLD, 20));
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}
		
		
		int k = 90;
		for( int i = 6; i<12; i++) {
			seat[i] = new JButton();
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "번");
			l_seat[i].setBounds(60, -30, 100, 100);
			seat[i].setBounds(new Rectangle(k, 570, 160, 180));//55, 570, 160, 180
			k+= 170;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("굴림", Font.BOLD, 20));
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}
		
		
		int o = 130;
		for(int i = 12; i<16; i++) {
			seat[i] = new JButton();
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "번");
			l_seat[i].setBounds(60, -30, 100, 100);
			seat[i].setBounds(new Rectangle(1200, o, 160, 180));//1167, 486, 160, 180
			o+= 190;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("굴림", Font.BOLD, 20));
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1600, 1000);
		frame.getContentPane().add(panel_1);
		frame.setVisible(true);
		
		JButton food = new JButton("음식");
		food.setFont(new Font("굴림", Font.BOLD, 40));
		food.setBounds(0, 0, 228, 73);
		panel.add(food);
		
		food.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FoodExam f=new FoodExam();
				f.setVisible(true);
			}
		});
		

	}
	public void change() {
		String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		int seatNum;
		try {
			Class.forName(jdbc_driver);
			System.out.println("Mysql client 데이터 베이스 연결 대기중...");
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
			String sql="select num from seat WHERE useable=1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			System.out.println("성공");
			while(rs.next()) {
				seatNum=rs.getInt("num");
				//System.out.println(seatNum);
				seat[seatNum-1].setEnabled(false);
				seat[seatNum-1].setText("사용중");
				seat[seatNum-1].setBackground(Color.LIGHT_GRAY);
			}
			
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Buy_Time b=new Buy_Time();
		Client client=new Client();
		client.setGui(b);
		b.change();
//		client.setGui(b);
//		client.connect();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<seat.length;i++) {
			if(e.getSource()==seat[i]) {
				Modal m =new Modal(i);
				m.setVisible(true);
				seat[i].setEnabled(false);
				seat[i].setText("사용중");
				seat[i].setBackground(Color.LIGHT_GRAY);
				//System.out.println(i);
				break;
				
			}
		}
		
		//m.setVisible(true);
	}
}


