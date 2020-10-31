package Manager;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import database.DBTime;
import Manager.SignIn_Up;

public class Modal extends JFrame {
	Choice ch = new Choice();
	int result;
	ClientBackground client=new ClientBackground();
	public Modal(Window parent) {
		super("결재 창");
		
		setSize(600, 500);
		setLayout(null);
		
		JLabel time = new JLabel("-------------시간-------------");
		time.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		time.setSize(6000, 50);
		time.setLocation(0, 0);
		
		JLabel lb = new JLabel("원하는 시간대를 선택하세요.");
		lb.setFont(new Font("Hachoma", Font.PLAIN, 20));
		lb.setSize(300, 50);
		lb.setLocation(180,80);
		
		ch.addItem("1시간    1000천원");
		ch.addItem("2시간    2000천원");
		ch.addItem("3시간    3000천원");
		ch.addItem("4시간    4000천원");
		ch.addItem("5시간    5000천원");
		ch.setSize(100, 50);
		ch.setLocation(250,150);
		
		//getTime();
		JLabel payment = new JLabel("-------------결제-------------");
		payment.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		payment.setSize(6000, 50);
		payment.setLocation(0, 200);
		
		JLabel way = new JLabel("결제 방법을 선택해주세요.");
		way.setFont(new Font("Hachoma", Font.PLAIN, 20));
		way.setSize(300, 50);
		way.setLocation(180,260);
		
		Button card = new Button("카드");
		card.setFont(new Font("굴림", Font.PLAIN, 20));
		card.setBounds(160, 350, 80, 40);
		
		card.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBTime time = new DBTime();
				
					String t_time=ch.getSelectedItem();
						
					String DBConnection = "INSERT members VALUES("+ t_time + "')";
					
			
						
					DBTime.createCustomer(t_time);
					JOptionPane.showMessageDialog(null, "카드결제 되었습니다.");
					setVisible(true);
			}
			
			});
		
		Button cash = new Button("현금");
		cash.setFont(new Font("굴림", Font.PLAIN, 20));
		cash.setBounds(350, 350, 80, 40);
		
		cash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBTime time = new DBTime();
				
					String t_time=ch.getSelectedItem();
						
					String DBConnection = "INSERT members VALUES("+ t_time + "')";
					
			
						
					DBTime.createCustomer(t_time);
					result=JOptionPane.showConfirmDialog(null, "현금으로 결제하시겠습니까?","Comfirm",JOptionPane.YES_NO_OPTION);
					
					setVisible(true);
			}
			
			});
		
		
		
		client.setGui(this);
		client.connect();
		add(time);
		add(lb);
		add(ch);
		add(payment);
		add(way);
		add(card);
		add(cash);
	}
	public void getAnswer() {
		
	}
	public void getTime() {
		ShowSeat s=new ShowSeat();
		int tm=ch.getSelectedIndex();
		switch(tm) {
		case 0: s.setTime(1);  break;
		case 1: s.setTime(2);  break;
		case 2: s.setTime(3);  break;
		case 3: s.setTime(4);  break;
		case 4: s.setTime(5);  break;
		}
	}
}
