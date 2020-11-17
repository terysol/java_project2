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

		// �����δ�
		// ������ ������
		JFrame frame = new JFrame("���� ���� â");
		frame.setBounds(0, 0, 1000, 1000);
		frame.setBackground(Color.black);

		// ��Ʈ
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// ����
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setLayout(null);
		

		// �迭 ���� �κ�
		String menu[] = { "ź������", "�����", "¥�İ�Ƽ", "�Ҷ��Ҷ�", "��������", "ī������", "ġŲ�ʰ�", "��â����" };// �޴�
		int price[] = { 1000, 2500, 3000, 3000, 4500, 5000, 5500, 9000 };// �޴�����
		JButton bt[] = new JButton[menu.length];// �ܹ��� ��ư ���� �Ŀ� ���� �Է��� ���ְ�
		JTextField quantity[] = new JTextField[menu.length]; // � �ֹ��Ұ���
		JButton minus[] = new JButton[menu.length];// ���� ����
		JButton plus[] = new JButton[menu.length];// ���� ���ϱ�
		JButton ok[] = new JButton[menu.length];// ������ŭ �������� Ȯ�� ������
		JLabel value[] = new JLabel[menu.length];// ~~��
		JButton seat[] = new JButton[16];
		JLabel[] l_seat = new JLabel[16];
		
		

		// ��ư ���� �κ�
		for (int i = 0; i < menu.length; i++) {

			// �ܹ��� ��ư
			bt[i] = new JButton(menu[i]);
			bt[i].setBackground(new Color(255, 255, 228, 255));
			if (i < 4) {
				bt[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}

			// ���� txt ��ư
			quantity[i] = new JTextField("0");
			quantity[i].setBackground(Color.white);// ���� ���� ��
			quantity[i].setEditable(false);
			quantity[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			

			// "-" ��ư
			minus[i] = new JButton("-");
			minus[i].setBounds(bt[i].getX(), quantity[i].getY(), 20, 20);
			minus[i].setFont(new Font("����", Font.BOLD, 5));
			minus[i].setEnabled(false);
			
			// "+" ��ư
			plus[i] = new JButton("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), quantity[i].getY(), 20, 20);
			plus[i].setFont(new Font("����", Font.BOLD, 7));
			plus[i].setEnabled(false);
			
			// ����
			value[i] = new JLabel(price[i] + "��");
			value[i].setForeground(Color.WHITE);// ���� �۾� ����
			value[i].setBounds(bt[i].getX() + 20, quantity[i].getY() - 25, 100, 20);

			// Ȯ�� ��ư
			ok[i] = new JButton("Ȯ��");
			ok[i].setBounds(bt[i].getX(), quantity[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);
			
			
			JTextArea ts = new JTextArea("�䱸������ �ۼ����ּ���.", 7, 20);
			ts.setBounds(600, 300, 350, 180);

			panel.add(bt[i]);
			panel.add(quantity[i]);
			panel.add(minus[i]);
			panel.add(plus[i]);
			panel.add(value[i]);
			panel.add(ok[i]);
			panel.add(ts);
		}
		
		//�¼� ��ư
		int q = 600;
		for(k = 0; k<6; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k+1) + "��");
			l_seat[k].setBounds(13, 0, 50, 50);
			seat[k].setBounds(new Rectangle(q, 50, 50, 50));
			q+= 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("����", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
		}
		
		int s = 600;
		for(k = 6; k<12; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k+1) + "��");
			l_seat[k].setBounds(10, 0, 50, 50);
			seat[k].setBounds(new Rectangle(s, 115, 50, 50));//x, y, w, h
			s+= 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("����", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
		}
		
		int a = 660;
		for(k = 12; k<16; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k+1) + "��");
			l_seat[k].setBounds(10, 0, 50, 50);
			seat[k].setBounds(new Rectangle(a, 180, 50, 50));//x, y, w, h
			a+= 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("����", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
		}

		// �߾�
		JTextArea ta = new JTextArea("", 0, 0);// ���� �Է��ϸ� �߾ӿ� ������ ��
		ta.setText("     	    �¼���ȣ        ��ǰ��        �ܰ�        ����        �հ�\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// �Ʒ� ��ư2��
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(128, 0, 128));

		JButton bt1 = new JButton("�ֹ�");
		JButton bt2 = new JButton("�ʱ�ȭ");
		panel2.add(bt1);
		panel2.add(bt2);

		// �ֹ���ư
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + "�� �ݾ� : " + "\n �ֹ��Ǿ����ϴ�. \n�̿����ּż� �����մϴ�.");
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					ta.setText("         �¼���ȣ        ��ǰ��        �ܰ�        ����        �հ�\n\n");

				}
			}
		});

		// �ʱ�ȭ ��ư
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					ta.setText("         �¼���ȣ        ��ǰ��        �ܰ�        ����        �հ�\n\n");

				}
			}
		});

		// ������Ʈ
		frame.add(panel, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);

		// �̺�Ʈ��
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// �ܹ��� ��ư �̺�Ʈ
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
			
			//�¼� ��ư �̺�Ʈ
			seat[k].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					l_seat[k].setEnabled(true);
				}
			});

			// "-" ��ư �̺�Ʈ
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

			// "+" ��ư �̺�Ʈ
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

			// Ȯ�� ��ư �̺�Ʈ
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showfood = bt[j].getActionCommand();
					//showseat = seat[k].getActionCommand();
					ta.append("     " + l_seat[k] + "   " + showfood + "       " + price[j] + "        " + count + "         " + price[j] * count
							+ "��" + "\n");
					ok[j].setEnabled(false);
				}
			});

		}
		

	}

	// ����
	public static void main(String[] args) {
		new FoodExam();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}