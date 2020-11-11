package Manager;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.DBmember;

public class Buy_Time implements ActionListener{

	private JFrame frame;
	private final JPanel panel = new JPanel();
	JButton []seat = new JButton[16];
	JLabel [] l_seat = new JLabel[16];
	

	public Buy_Time() {
		frame = new JFrame("ÁÂ¼®");
		frame.setBounds(100, 100, 1600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//Ã¢ °¡¿îµ¥ Á¤·Ä
		frame.setResizable(false);//Ã¢ Å©±â °íÁ¤
		panel.setBounds(0, 0, 1600, 1000);
		panel.setBackground(new Color(128,0,128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		int j = 90;
		for(int i = 0; i<6; i++) {
			seat[i] = new JButton();
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "¹ø");
			l_seat[i].setBounds(65, -30, 100, 100);
			seat[i].setBounds(new Rectangle(j, 185, 160, 180));//55, 185, 160, 180
			j+= 170;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("±¼¸²", Font.BOLD, 20));
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}
		
		
		int k = 90;
		for( int i = 6; i<12; i++) {
			seat[i] = new JButton();
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "¹ø");
			l_seat[i].setBounds(60, -30, 100, 100);
			seat[i].setBounds(new Rectangle(k, 570, 160, 180));//55, 570, 160, 180
			k+= 170;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("±¼¸²", Font.BOLD, 20));
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}
		
		
		int o = 130;
		for(int i = 12; i<16; i++) {
			seat[i] = new JButton();
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "¹ø");
			l_seat[i].setBounds(60, -30, 100, 100);
			seat[i].setBounds(new Rectangle(1200, o, 160, 180));//1167, 486, 160, 180
			o+= 190;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("±¼¸²", Font.BOLD, 20));
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1600, 1000);
		frame.getContentPane().add(panel_1);
		frame.setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new Buy_Time();
		Socket socket=null;
		try {
			socket=new Socket("127.0.0.1",7778);
			System.out.println("¿¬°á¼º°ø");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<seat.length;i++) {
			if(e.getSource()==seat[i]) {
				Modal m =new Modal(i);
				m.setVisible(true);
				seat[i].setEnabled(false);
				//System.out.println(i);
				break;
				
			}
		}
		
		//m.setVisible(true);
	}
}


