package Manager;


import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import database.DBTime;
import Manager.SignIn_Up;

public class Modal extends JFrame {
	static JComboBox<String> ch=new JComboBox<String>();
	int result;
	ClientBackground client=new ClientBackground();
	
	public Modal() {
		super("���� â");
		
		setSize(400, 480);
		setLayout(null);
		setLocation(300,300);
		
		JLabel time = new JLabel("-------------�ð�-------------");
		time.setFont(new Font("HY����M", Font.PLAIN, 25));
		time.setLocation(100, 100);
		time.setBounds(66,10,1000,50);
		
		JLabel lb = new JLabel("���ϴ� �ð��븦 �����ϼ���.");
		lb.setFont(new Font("Hachoma", Font.PLAIN, 20));
		lb.setLocation(180,80);
		lb.setBounds(66,60,300,50);
		
		ch.addItem("1�ð�    1000õ��");
		ch.addItem("2�ð�    2000õ��");
		ch.addItem("3�ð�    3000õ��");
		ch.addItem("4�ð�    4000õ��");
		ch.addItem("5�ð�    5000õ��");
		ch.setBounds(130,130,130,40);
	
		//getTime();
		JLabel payment = new JLabel("-------------����-------------");
		payment.setFont(new Font("HY����M", Font.PLAIN, 25));
		payment.setLocation(0, 200);
		payment.setBounds(66,200,1000,50);
		
		JLabel way = new JLabel("���� ����� �������ּ���.");
		way.setFont(new Font("Hachoma", Font.PLAIN, 20));
		way.setLocation(180,260);
		way.setBounds(66,250,300,50);
		
		JButton card = new JButton("ī��");
		card.setFont(new Font("����", Font.PLAIN, 20));
		card.setBounds(55, 320, 80, 40);
		
		client.setGui(this);
		card.addActionListener(new ActionListener() {
		
		
			@Override
			public void actionPerformed(ActionEvent e) {
				DBTime time = new DBTime();
				
					String t_time=ch.getSelectedItem().toString();
						
					String DBConnection = "INSERT members VALUES("+ t_time + "')";
					
			
						
					DBTime.createCustomer(t_time);
					JOptionPane.showMessageDialog(null, "ī����� �Ǿ����ϴ�.");
					client.connect();
					setVisible(true);
			}
			
			});
		
		JButton cash = new JButton("����");
		cash.setFont(new Font("����", Font.PLAIN, 20));
		cash.setBounds(240, 320, 80, 40);
		
		cash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBTime time = new DBTime();
				
					String t_time=ch.getSelectedItem().toString();
						
					String DBConnection = "INSERT members VALUES("+ t_time + "')";
					
			
						
					DBTime.createCustomer(t_time);
					result=JOptionPane.showConfirmDialog(null, "�������� �����Ͻðڽ��ϱ�?","Comfirm",JOptionPane.YES_NO_OPTION);
					client.connect();
					setVisible(true);
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
	
}
