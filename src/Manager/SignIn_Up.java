package Manager;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Manager.ShowSeat;
import database.DBnotmember;
import database.DBmember;


public class SignIn_Up {

	private JFrame frame;
	private JTextField T_Id;
	private JTextField T_Password;
	private JTextField T_NCardnumber;
	private JTextField T_SId;
	private JPasswordField PF_SPassword;
	private JTextField T_SName;
	
	JButton B_member = new JButton("ȸ��");//ȸ��
	JButton B_Nmember = new JButton("��ȸ��");//��ȸ��
	JLabel L_Id = new JLabel("���̵� : ");
	//ShowSeat s=new ShowSeat();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName(jdbc_driver);
			String dbURL="jdbc:mysql://127.0.0.1:3306/member2?serverTimezone=UTC";
					
			//�ش� ����̹��� Ŭ������ �̿��Ͽ� DB����
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
					
			//DB�� ��ɾ �����ϴ� ��ü�� ����
			stmt = conn.createStatement();
					
			//��Ʈ�������� ���ڿ��� �о���̴� Ŭ����
			java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
			java.io.BufferedReader in = new java.io.BufferedReader(isr);
					
			System.out.println("���� ����");
					
				
				}catch(ClassNotFoundException e) {
					System.out.println("����̹� �ε� ����");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn_Up window = new SignIn_Up();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn_Up() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("����ȭ��");
		frame.setBounds(100, 100, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//â ��� ����
		frame.setResizable(false);//â ũ�� ����
		
		
		
		
		//==================================================
		
		
		
		final JPanel PNmember = new JPanel();//��ȸ�� ȭ��
		PNmember.setBackground(new Color(128,0,128));
		PNmember.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(PNmember);
		PNmember.setLayout(null);
		
		JLabel L_NLing = new JLabel("��ȸ�� Login");
		L_NLing.setForeground(Color.WHITE);
		L_NLing.setFont(new Font("HY����M", Font.PLAIN, 50));
		L_NLing.setBounds(557, 221, 318, 98);
		PNmember.add(L_NLing);
		
		JLabel L_NCardnumber = new JLabel("ī�� ��ȣ : ");
		L_NCardnumber.setForeground(Color.WHITE);
		L_NCardnumber.setBounds(484, 447, 204, 45);
		PNmember.add(L_NCardnumber);
		L_NCardnumber.setFont(new Font("����", Font.BOLD, 30));
		
		T_NCardnumber = new JTextField();
		T_NCardnumber.setFont(new Font("����", Font.PLAIN, 30));
		T_NCardnumber.setColumns(10);
		T_NCardnumber.setBounds(702, 449, 216, 41);
		PNmember.add(T_NCardnumber);
		
		JButton B_NLogin = new JButton("�α���");
		B_NLogin.setFont(new Font("����", Font.PLAIN, 20));
		B_NLogin.setBounds(654, 675, 105, 27);
		PNmember.add(B_NLogin);
		
		JButton B_NBack = new JButton("��");
		B_NBack.setFont(new Font("����", Font.BOLD, 50));
		B_NBack.setBounds(14, 908, 90, 45);
		PNmember.add(B_NBack);
		PNmember.setVisible(false);
		
		


		

		
		//==================================================
		
		
		
		final JPanel Pmember = new JPanel();//ȸ�� ȭ��
		Pmember.setBackground(new Color(128,0,128));
		Pmember.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Pmember);
		Pmember.setLayout(null);
		
		JLabel L_Login = new JLabel("ȸ�� Login");
		L_Login.setForeground(Color.WHITE);
		L_Login.setBounds(601, 153, 264, 98);
		L_Login.setFont(new Font("HY����M", Font.PLAIN, 50));
		Pmember.add(L_Login);
		
		
		L_Id.setForeground(Color.WHITE);
		L_Id.setBounds(527, 394, 132, 45);
		L_Id.setFont(new Font("����", Font.BOLD, 30));
		Pmember.add(L_Id);
		
		T_Id = new JTextField();
		T_Id.setBounds(673, 394, 216, 41);
		T_Id.setFont(new Font("����", Font.PLAIN, 30));
		Pmember.add(T_Id);
		T_Id.setColumns(10);
		
		JLabel L_Password = new JLabel("��й�ȣ : ");
		L_Password.setForeground(Color.WHITE);
		L_Password.setBounds(527, 472, 170, 45);
		L_Password.setFont(new Font("����", Font.BOLD, 30));
		Pmember.add(L_Password);
		
		T_Password = new JPasswordField();
		T_Password.setBounds(700, 474, 216, 41);
		T_Password.setFont(new Font("����", Font.PLAIN, 30));
		T_Password.setColumns(10);
		Pmember.add(T_Password);
		
		JButton B_Login = new JButton("�α���");
		B_Login.setBounds(673, 793, 105, 27);
		B_Login.setFont(new Font("����", Font.PLAIN, 20));
		Pmember.add(B_Login);
		
		JButton B_Back = new JButton("��");
		B_Back.setFont(new Font("����", Font.BOLD, 50));
		B_Back.setBounds(14, 908, 90, 45);
		Pmember.add(B_Back);
		
		
		
		Pmember.setVisible(false);
		
	
		
		
		
		
		//==================================================        
		
		
		
		final JPanel Psignup = new JPanel();//ȸ������ ȭ��
		Psignup.setBackground(new Color(128,0,128));
		Psignup.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Psignup);
		Psignup.setLayout(null);
		
		JLabel L_Sinup = new JLabel("ȸ������");
		L_Sinup.setForeground(Color.WHITE);
		L_Sinup.setFont(new Font("HY����M", Font.PLAIN, 50));
		L_Sinup.setBounds(552, 195, 213, 98);
		Psignup.add(L_Sinup);
		
		JLabel L_SName = new JLabel("�̸� : ");
		L_SName.setForeground(Color.WHITE);
		L_SName.setFont(new Font("����", Font.BOLD, 30));
		L_SName.setBounds(512, 382, 132, 45);
		Psignup.add(L_SName);
		
		T_SName = new JTextField();
		T_SName.setFont(new Font("����", Font.PLAIN, 30));
		T_SName.setColumns(10);
		T_SName.setBounds(636, 382, 216, 41);
		Psignup.add(T_SName);
		
		JLabel L_SId = new JLabel("���̵� : ");
		L_SId.setForeground(Color.WHITE);
		L_SId.setFont(new Font("����", Font.BOLD, 30));
		L_SId.setBounds(512, 471, 132, 45);
		Psignup.add(L_SId);
		
		T_SId = new JTextField();
		T_SId.setFont(new Font("����", Font.PLAIN, 30));
		T_SId.setColumns(10);
		T_SId.setBounds(658, 471, 216, 41);
		Psignup.add(T_SId);
		
		JLabel L_SPassword = new JLabel("��й�ȣ : ");
		L_SPassword.setForeground(Color.WHITE);
		L_SPassword.setFont(new Font("����", Font.BOLD, 30));
		L_SPassword.setBounds(512, 557, 170, 45);
		Psignup.add(L_SPassword);
		
		PF_SPassword = new JPasswordField();
		PF_SPassword.setFont(new Font("����", Font.PLAIN, 30));
		PF_SPassword.setColumns(10);
		PF_SPassword.setBounds(684, 559, 216, 41);
		Psignup.add(PF_SPassword);
		
		JButton B_signup = new JButton("ȸ������");
		B_signup.setFont(new Font("����", Font.PLAIN, 20));
		B_signup.setBounds(609, 765, 132, 27);
		Psignup.add(B_signup);
		
		JButton B_SBack = new JButton("��");
		B_SBack.setFont(new Font("����", Font.BOLD, 50));
		B_SBack.setBounds(14, 908, 90, 45);
		Psignup.add(B_SBack);
		
		JButton bnt_DoubleCheck = new JButton("�ߺ�Ȯ��");
		bnt_DoubleCheck.setBounds(894, 471, 90, 41);
		Psignup.add(bnt_DoubleCheck);
		Psignup.setVisible(false);
		
		
		
		
		
		//==================================================  
		
		
		
		
		
		final JPanel Pmain = new JPanel();//ùȭ��
		Pmain.setBackground(new Color(128,0,128));
		Pmain.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Pmain);
		Pmain.setLayout(null);
		
		JLabel L_PCroom = new JLabel("PC��");
		L_PCroom.setForeground(Color.WHITE);
		L_PCroom.setBounds(644, 145, 127, 134);
		Pmain.add(L_PCroom);
		L_PCroom.setFont(new Font("HY����M", Font.PLAIN, 50));
		
		
		B_member.setBounds(456, 508, 189, 73);
		Pmain.add(B_member);
		B_member.setFont(new Font("����", Font.BOLD, 40));
		
		
		B_Nmember.setBounds(736, 508, 181, 73);
		Pmain.add(B_Nmember);
		B_Nmember.setFont(new Font("����", Font.BOLD, 40));
		
		JButton B_SignUp = new JButton("ȸ������");//ȸ������
		B_SignUp.setFont(new Font("����", Font.BOLD, 40));
		B_SignUp.setBounds(595, 704, 228, 73);
		Pmain.add(B_SignUp);
		
		
		
		
		//==================================================  

		
		
		
		B_member.addActionListener(new ActionListener() {//���� => ȸ��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmember.setVisible(true);
				Pmain.setVisible(false);
				
				
			}
		});
		
		
		B_Back.addActionListener(new ActionListener() {//ȸ�� => ����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				Pmember.setVisible(false);
			}
		});
		
		
		
		B_Nmember.addActionListener(new ActionListener() {//���� => ��ȸ��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PNmember.setVisible(true);
				Pmain.setVisible(false);
				//s.setVisible(false);
				//s.setMember("��ȸ��");
			}
		});
			
		
		B_NBack.addActionListener(new ActionListener() {//��ȸ�� => ����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				PNmember.setVisible(false);
			}
		});
		B_NLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cardNum=T_NCardnumber.getText();
				DBnotmember db=new DBnotmember("��ȸ��", cardNum);
				Buy_Time b=new Buy_Time();
				frame.setVisible(false);
			}
		});
		
		B_Login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�.");	
				Buy_Time b=new Buy_Time();
				frame.setVisible(false);
								
			}
		});
		

		
		B_SignUp.addActionListener(new ActionListener() {//���� => ȸ������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Psignup.setVisible(true);
				Pmain.setVisible(false);
			}
		});
		
		B_SBack.addActionListener(new ActionListener() {//ȸ������ => ����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				Psignup.setVisible(false);
			}
		});
		

		
		

		
		
	B_signup.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Hashtable loginUsers = new Hashtable();
		String t_SName=T_SName.getText();
		String t_SId=T_SId.getText();
		String t_Password=PF_SPassword.getPassword().toString();
			
		DBmember db=new DBmember("ȸ��", t_SId, t_Password, t_SName);
			
		//DBsignup.createCustomer(t_SName, t_SId, t_Password);
		JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�. �α��� ���ּ���.");
		Pmember.setVisible(true);
		Psignup.setVisible(false);
			
		}
	});	
	}
}

