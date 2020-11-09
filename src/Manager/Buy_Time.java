package Manager;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.DBsignup;

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
			
			seat[i].addActionListener(new ActionListener() {
	            // 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Modal m = new Modal();
	                m.setVisible(true);
	                
	            }
	            
	        });
		}
		
		int k = 90;
		for(int i = 6; i<12; i++) {
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
			
			seat[i].addActionListener(new ActionListener() {
	            // 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Modal m = new Modal();
	                m.setVisible(true);
	            }
	            
	        });
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
			
			seat[i].addActionListener(new ActionListener() {
	            // 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Modal m = new Modal();
	                m.setVisible(true);
	                
	            }
	            
	        });
		}			
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1600, 1000);
		frame.getContentPane().add(panel_1);
		frame.setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new Buy_Time();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


