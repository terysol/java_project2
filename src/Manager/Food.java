package Manager;

import java.awt.Button;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import database.DBTime;

public class Food extends JFrame{
	public Food() {
		super("����");
		setLocation(600, 500);//â ��� ����
		
		List list1 = new List(10, true);
		list1.add("ź��      1000��");
		list1.add("������   1000��");
		list1.add("�ܹ���   3000��");
		list1.add("�ҽ���   3000��");
		list1.add("���      3000��");
		list1.add("����      6000��");
		list1.add("����      6000��");
		list1.add("ī��      5000��");
		list1.add("ġŲ      7000��");
		list1.add("�ʹ�      10000��");
		
		JLabel payment = new JLabel("-------------����-------------");
		payment.setFont(new Font("HY����M", Font.PLAIN, 25));
		payment.setSize(6000, 50);
		payment.setLocation(0, 200);
		
//		JLabel way = new JLabel("���� ����� �������ּ���.");
//		way.setFont(new Font("Hachoma", Font.PLAIN, 20));
//		way.setSize(300, 50);
//		way.setLocation(180,260);
//		
//		Button card = new Button("ī��");
//		card.setFont(new Font("����", Font.PLAIN, 20));
//		card.setBounds(160, 350, 80, 40);
//		
//		card.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DBTime time = new DBTime();
//				
//					String t_time=list1.getSelectedItem();
//						
//					String DBConnection = "INSERT members VALUES("+ t_time + "')";
//					
//			
//						
//					DBTime.createCustomer(t_time);
//					JOptionPane.showMessageDialog(null, "ī����� �Ǿ����ϴ�.");
//					SingnIn_Up.main(null);
//					setVisible(true);
//			}
//			
//			});	
//		Button cash = new Button("����");
//		cash.setFont(new Font("����", Font.PLAIN, 20));
//		cash.setBounds(350, 350, 80, 40);
//		
//		cash.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DBTime time = new DBTime();
//				
//					String t_time=list1.getSelectedItem();
//						
//					String DBConnection = "INSERT members VALUES("+ t_time + "')";
//					
//			
//						
//					DBTime.createCustomer(t_time);
//					JOptionPane.showMessageDialog(null, "���� �Ǿ����ϴ�.");
//					SingnIn_Up.main(null);
//					setVisible(true);
//			}
//			
//			});
		
		add(list1);
		add(payment);
		//add(card);
		//add(cash);
		
		setSize(600, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Food();

	}//main

}
