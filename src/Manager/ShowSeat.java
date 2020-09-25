package Manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowSeat extends JFrame{
	JPanel left=new JPanel();
	JPanel right= new JPanel();
	Container c=getContentPane();
	JTable food=new JTable();
	JPanel [] seat=new JPanel[16];
	JLabel [] l_seat=new JLabel[16];
	
	// 좌석 선언
	
	
	public ShowSeat() {
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
		
		//음식 보여주는 table
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("자리");
		model.addColumn("음식");
		model.addColumn("개수");
		model.addColumn("메모");
		food.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"자리","음식","개수","메모"
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
		
		// 좌석가로 1
		int j=90;
		for(int i=0;i<6;i++) {
			seat[i]=new JPanel();
			l_seat[i]=new JLabel((i+1) + "번");
			seat[i].setBounds(new Rectangle(j,130,160,180));
			j+=170;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("굴림",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		
		 //좌석 가로2
		int k=90;
		for(int i=6;i<12;i++) {
			seat[i]=new JPanel();
			l_seat[i]=new JLabel((i+1) + "번");
			seat[i].setBounds(new Rectangle(k,500,160,180));
			k+=170;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("굴림",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		
		// 좌석 세로1
		int o=130;
		for(int i=12;i<16;i++) {
			seat[i]=new JPanel();
			l_seat[i]=new JLabel((i+1) + "번");
			seat[i].setBounds(new Rectangle(1150,o,160,180));
			o+=190;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("굴림",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		setVisible(true);	
	}
}
