package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class FoodExam {
	int count = 0;
	String showfood = "";
	String showseat = "";
	JButton seat[] = new JButton[16];
	JLabel[] l_seat = new JLabel[16];
	int k;
	

	public FoodExam() {

		// 디자인단
		// 프레임 설정단
		JFrame frame = new JFrame("음식 결제 창");
		frame.setBounds(0, 0, 1000, 1000);
		frame.setBackground(Color.black);

		// 폰트
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// 위쪽
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setLayout(null);
		

		// 배열 설정 부분
		String menu[] = { "탄산음료", "삼양라면", "짜파게티", "소떡소떡", "제육덮밥", "카레덮밥", "치킨너겟", "대창덮밥" };// 메뉴
		int price[] = { 1000, 2500, 3000, 3000, 4500, 5000, 5500, 9000 };// 메뉴가격
		JButton bt[] = new JButton[menu.length];// 햄버거 버튼 누른 후에 수량 입력할 수있게
		JTextField quantity[] = new JTextField[menu.length]; // 몇개 주문할건지
		JButton minus[] = new JButton[menu.length];// 수량 빼기
		JButton plus[] = new JButton[menu.length];// 수량 더하기
		JButton ok[] = new JButton[menu.length];// 먹을만큼 정했으면 확인 누르기
		JLabel value[] = new JLabel[menu.length];// ~~원
		JButton seat[] = new JButton[16];
		JLabel[] l_seat = new JLabel[16];
		
		

		// 버튼 설정 부분
		for (int i = 0; i < menu.length; i++) {

			// 햄버거 버튼
			bt[i] = new JButton(menu[i]);
			bt[i].setBackground(new Color(255, 255, 228, 255));
			if (i < 4) {
				bt[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}

			// 숫자 txt 버튼
			quantity[i] = new JTextField("0");
			quantity[i].setBackground(Color.white);// 수량 상자 색
			quantity[i].setEditable(false);
			quantity[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			

			// "-" 버튼
			minus[i] = new JButton("-");
			minus[i].setBounds(bt[i].getX(), quantity[i].getY(), 20, 20);
			minus[i].setFont(new Font("굴림", Font.BOLD, 5));
			minus[i].setEnabled(false);
			
			// "+" 버튼
			plus[i] = new JButton("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), quantity[i].getY(), 20, 20);
			plus[i].setFont(new Font("굴림", Font.BOLD, 7));
			plus[i].setEnabled(false);
			
			// 가격
			value[i] = new JLabel(price[i] + "원");
			value[i].setForeground(Color.WHITE);// 가격 글씨 색상
			value[i].setBounds(bt[i].getX() + 20, quantity[i].getY() - 25, 100, 20);

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), quantity[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);
			
			
			JTextArea ts = new JTextArea("요구사항을 작성해주세요.", 7, 20);
			ts.setBounds(600, 300, 350, 180);

			panel.add(bt[i]);
			panel.add(quantity[i]);
			panel.add(minus[i]);
			panel.add(plus[i]);
			panel.add(value[i]);
			panel.add(ok[i]);
			panel.add(ts);
		}
		
		//좌석 버튼
		int q = 600;
		for(k = 0; k<6; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k+1) + "번");
			l_seat[k].setBounds(13, 0, 50, 50);
			seat[k].setBounds(new Rectangle(q, 50, 50, 50));
			q+= 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("굴림", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
		}
		
		int s = 600;
		for(k = 6; k<12; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k+1) + "번");
			l_seat[k].setBounds(10, 0, 50, 50);
			seat[k].setBounds(new Rectangle(s, 115, 50, 50));//x, y, w, h
			s+= 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("굴림", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
		}
		
		int a = 660;
		for(k = 12; k<16; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k+1) + "번");
			l_seat[k].setBounds(10, 0, 50, 50);
			seat[k].setBounds(new Rectangle(a, 180, 50, 50));//x, y, w, h
			a+= 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("굴림", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
		}

		// 중앙
		JTextArea ta = new JTextArea("", 0, 0);// 수량 입력하면 중앙에 나오는 값
		ta.setText("     	    좌석번호        상품명        단가        수량        합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// 아래 버튼2개
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(128, 0, 128));

		JButton bt1 = new JButton("주문");
		JButton bt2 = new JButton("초기화");
		panel2.add(bt1);
		panel2.add(bt2);

		// 주문버튼
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + "총 금앱 : " + "\n 주문되었습니다. \n이용해주셔서 감사합니다.");
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					ta.setText("         좌석번호        상품명        단가        수량        합계\n\n");

				}
			}
		});

		// 초기화 버튼
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					ta.setText("         좌석번호        상품명        단가        수량        합계\n\n");

				}
			}
		});

		// 컴포넌트
		frame.add(panel, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);

		// 이벤트단
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// 햄버그 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});
			
			//좌석 버튼 이벤트
			seat[k].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					l_seat[k].setEnabled(true);
				}
			});

			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						quantity[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					quantity[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showfood = bt[j].getActionCommand();
					//showseat = seat[k].getActionCommand();
					ta.append("     " + l_seat[k] + "   " + showfood + "       " + price[j] + "        " + count + "         " + price[j] * count
							+ "원" + "\n");
					ok[j].setEnabled(false);
				}
			});

		}
		

	}

	// 메인
	public static void main(String[] args) {
		new FoodExam();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}