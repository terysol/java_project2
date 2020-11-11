package Manager;


import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import database.DBsave;
import Manager.SignIn_Up;

public class Modal extends JFrame {
	static JComboBox<String> ch=new JComboBox<String>();
	int result;
	ClientBackground client=new ClientBackground();
	int t=0;
	
	
	
	public int getT() {
		return t;
	}



	public Modal(int seatNum) {
		super("결재 창");
		
		setSize(400, 480);
		setLayout(null);
		setLocation(300,300);
		
		JLabel time = new JLabel("-------------시간-------------");
		time.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		time.setLocation(100, 100);
		time.setBounds(66,10,1000,50);
		
		JLabel lb = new JLabel("원하는 시간대를 선택하세요.");
		lb.setFont(new Font("Hachoma", Font.PLAIN, 20));
		lb.setLocation(180,80);
		lb.setBounds(66,60,300,50);
		
		ch.addItem("1시간    1000천원");
		ch.addItem("2시간    2000천원");
		ch.addItem("3시간    3000천원");
		ch.addItem("4시간    4000천원");
		ch.addItem("5시간    5000천원");
		ch.setBounds(130,130,130,40);
	
		//getTime();
		JLabel payment = new JLabel("-------------결제-------------");
		payment.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		payment.setLocation(0, 200);
		payment.setBounds(66,200,1000,50);
		
		JLabel way = new JLabel("결제 방법을 선택해주세요.");
		way.setFont(new Font("Hachoma", Font.PLAIN, 20));
		way.setLocation(180,260);
		way.setBounds(66,250,300,50);
		
		JButton card = new JButton("카드");
		card.setFont(new Font("굴림", Font.PLAIN, 20));
		card.setBounds(55, 320, 80, 40);
		
		
		System.out.println(seatNum);
		
		ch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t=(ch.getSelectedIndex()+1);
				System.out.println(t);
				
			}
		});
		
		String sql="select num from seat";
		
		
		card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t=setTime();
				JOptionPane.showMessageDialog(null, "카드결제 되었습니다.");
				DBsave db=new DBsave(seatNum+1, t, 1);
				
				setVisible(false);
			}
			
			});
		
		JButton cash = new JButton("현금");
		cash.setFont(new Font("굴림", Font.PLAIN, 20));
		cash.setBounds(240, 320, 80, 40);
		
		cash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					t=setTime();
					result=JOptionPane.showConfirmDialog(null, "현금으로 결제하시겠습니까?","Comfirm",JOptionPane.YES_NO_OPTION);
					DBsave db=new DBsave(seatNum+1, t, 1);
					setVisible(false);
			}
			
			});
		add(time);
		add(lb);
		add(ch);
		add(payment);
		add(way);
		add(card);
		add(cash);
	}
	public int setTime() {
		t=ch.getSelectedIndex();
		switch(t) {
		case 0: t=1; break;
		case 1: t=2; break;
		case 2: t=3; break;
		case 3: t=4; break;
		case 4: t=5; break;
		}
		return t;
	}
}
