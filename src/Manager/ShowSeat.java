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
			l_seat[i]=new JLabel((i+1) + "��");
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
			l_seat[i]=new JLabel((i+1) + "��");
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
			l_seat[i]=new JLabel((i+1) + "��");
			seat[i].setBounds(new Rectangle(1150,o,160,180));
			o+=190;
			seat[i].setBackground(new Color(255,228,225));
			l_seat[i].setFont(new Font("����",Font.BOLD,20));
			seat[i].add(l_seat[i]);
			left.add(seat[i]);
		}
		setVisible(true);	
	}
}
