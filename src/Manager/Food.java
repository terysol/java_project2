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
		super("음식");
		setLocation(600, 500);//창 가운데 정렬
		
		List list1 = new List(10, true);
		list1.add("탄산      1000원");
		list1.add("스무디   1000원");
		list1.add("햄버거   3000원");
		list1.add("소시지   3000원");
		list1.add("라면      3000원");
		list1.add("피자      6000원");
		list1.add("덮밥      6000원");
		list1.add("카레      5000원");
		list1.add("치킨      7000원");
		list1.add("초밥      10000원");
		
		JLabel payment = new JLabel("-------------결제-------------");
		payment.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		payment.setSize(6000, 50);
		payment.setLocation(0, 200);
		
//		JLabel way = new JLabel("결제 방법을 선택해주세요.");
//		way.setFont(new Font("Hachoma", Font.PLAIN, 20));
//		way.setSize(300, 50);
//		way.setLocation(180,260);
//		
//		Button card = new Button("카드");
//		card.setFont(new Font("굴림", Font.PLAIN, 20));
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
//					JOptionPane.showMessageDialog(null, "카드결제 되었습니다.");
//					SingnIn_Up.main(null);
//					setVisible(true);
//			}
//			
//			});	
//		Button cash = new Button("현금");
//		cash.setFont(new Font("굴림", Font.PLAIN, 20));
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
//					JOptionPane.showMessageDialog(null, "결제 되었습니다.");
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
