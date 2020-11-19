package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import database.DBfooddelete;
import database.DBfoodlist;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class FoodExam extends JFrame {
	int count = 0;
	String showfood = "";
	int k;
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
	JTextArea need = new JTextArea("�䱸������ �ۼ����ּ���.", 7, 20);
	JTextArea ta = new JTextArea("", 0, 0);// ���� �Է��ϸ� �߾ӿ� ������ ��
	String seatNum;

	public FoodExam() {
		super("���İ��� â");
		setBounds(0, 0, 1300, 1000);
		setBackground(Color.black);

		// ��Ʈ
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// ����
		Panel panel = new Panel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setLayout(null);
		panel.setSize(0,500);
		// �迭 ���� �κ�
		

		// ��ư ���� �κ�
		for (int i = 0; i < menu.length; i++) {

			// ���� ��ư
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

			
			need.setBounds(600, 300, 350, 180);

			panel.add(bt[i]);
			panel.add(quantity[i]);
			panel.add(minus[i]);
			panel.add(plus[i]);
			panel.add(value[i]);
			panel.add(ok[i]);
			panel.add(need);
		}

		// �߾�
		
		ta.setText("    �¼���ȣ        ��ǰ��        �ܰ�        ����        �հ�        �䱸����\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// �Ʒ� ��ư2��
		Panel panel2 = new Panel();
		panel2.setBackground(new Color(128, 0, 128));

		JButton bt1 = new JButton("�ֹ�");
		JButton bt2 = new JButton("�ʱ�ȭ");
		panel2.add(bt1);
		panel2.add(bt2);

		// �ֹ���ư
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + "\n �ֹ��Ǿ����ϴ�. \n�̿����ּż� �����մϴ�.");
				
				for (int i = 0; i < menu.length; i++) {
					//DBfoodlist db=new DBfoodlist(seatNum, showfood, p, count, p * count, need.getText());
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					ta.setText("    �¼���ȣ        ��ǰ��        �ܰ�        ����        �հ�        �䱸����\n\n");

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
					seat[i].setEnabled(true);
					seat[i].setBackground(new Color(255, 255, 228, 255));
					DBfooddelete db=new DBfooddelete(seatNum);
					ta.setText("    �¼���ȣ        ��ǰ��        �ܰ�        ����        �հ�        �䱸����\n\n");

				}
			}
		});
		need.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				need.setText("");
			}
		});
		// ������Ʈ
		add(panel, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		setVisible(true);

		// �¼� ��ư
		int q = 600;
		for (k = 0; k < 6; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k + 1) + "��");
			l_seat[k].setBounds(13, 0, 30, 30);// x, y, w, h
			seat[k].setBounds(new Rectangle(q, 50, 50, 50));// x, y, w, h
			q += 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("����", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);

			seat[k].addActionListener(new ActionListener() {// ��ư�� ������
				// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<seat.length;i++) {
						if(e.getSource()==seat[i]) {
							seatNum = l_seat[i].getText();
							l_seat[i].setSize(30, 30);
			            	ta.append("      " + seatNum);
			            	
						}
					}

				}

			});

		}

		int s = 600;
		for (k = 6; k < 12; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k + 1) + "��");
			l_seat[k].setBounds(10, 0, 50, 50);// x, y, w, h
			seat[k].setBounds(new Rectangle(s, 115, 50, 50));// x, y, w, h
			s += 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("����", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
			
			seat[k].addActionListener(new ActionListener() {// ��ư�� ������
				// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<seat.length;i++) {
						if(e.getSource()==seat[i]) {
							seatNum = l_seat[i].getText();
			            	ta.append( "      " + seatNum);
			            	
						}
					}

				}

			});

		}

		int a = 660;
		for (k = 12; k < 16; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k + 1) + "��");
			l_seat[k].setBounds(10, 0, 50, 50);// x, y, w, h
			seat[k].setBounds(new Rectangle(a, 180, 50, 50));// x, y, w, h
			a += 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("����", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);
			
			seat[k].addActionListener(new ActionListener() {// ��ư�� ������
				// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<seat.length;i++) {
						if(e.getSource()==seat[i]) {
							seatNum = l_seat[i].getText();
			            	ta.append( "      " + seatNum);
						}
					}

				}

			});
		}

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
					ta.append("\t   " + showfood);
					ta.append("       " + price[j]);
					ta.append("        " + count); 
					ta.append("         " + price[j] * count);
					ta.append("��" + "         " + need.getText() + "\n");
					DBfoodlist db=new DBfoodlist();
					db.foodlist(seatNum, showfood, price[j], count, price[j]*count, need.getText());
					bt[j].setEnabled(true);
					minus[j].setEnabled(false);
					plus[j].setEnabled(false);
					quantity[j].setText("0");
					ok[j].setEnabled(false);
					need.setText("");
				
				}
			});

		}

	}

	// ����
	public static void main(String[] args) {
		new FoodExam();
	}
}