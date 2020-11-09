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
import database.DBsaveTime;
import Manager.SignIn_Up;

public class Modal extends JFrame {
	static JComboBox<String> ch=new JComboBox<String>();
	int result;
	ClientBackground client=new ClientBackground();
	int t=0;
	
	
	
	public int getT() {
		return t;
	}



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
		
		ch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t=(ch.getSelectedIndex()+1);
				System.out.println(t);
				
			}
		});
		
		card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t=setTime();
						
				DBsaveTime.createCustomer(t);
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
				
					t=setTime();
					System.out.println(t);
					DBsaveTime.createCustomer(t);
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
