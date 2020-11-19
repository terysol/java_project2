package Manager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import database.DBnotmember;
import database.DBmember;


public class SignIn_Up {

	 JFrame frame;
	 JTextField T_Id;
	 JTextField T_Password;
	 JTextField T_NCardnumber;
	 JTextField T_SId;
	 JPasswordField PF_SPassword;
	 JTextField T_SName;
	
	JButton B_member = new JButton("회원");//회원
	JButton B_Nmember = new JButton("비회원");//비회원
	JLabel L_Id = new JLabel("아이디 : ");
	
	String member="";
	
	public SignIn_Up() {
		frame = new JFrame();
		frame.setTitle("메인화면");
		frame.setBounds(100, 100, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//창 가운데 정렬
		frame.setResizable(false);//창 크기 고정
		
		
		
		
		//==================================================
		
		
		
		final JPanel PNmember = new JPanel();//비회원 화면
		PNmember.setBackground(new Color(128,0,128));
		PNmember.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(PNmember);
		PNmember.setLayout(null);
		
		JLabel L_NLing = new JLabel("비회원 Login");
		L_NLing.setForeground(Color.WHITE);
		L_NLing.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		L_NLing.setBounds(557, 221, 318, 98);
		PNmember.add(L_NLing);
		
		JLabel L_NCardnumber = new JLabel("카드 번호 : ");
		L_NCardnumber.setForeground(Color.WHITE);
		L_NCardnumber.setBounds(484, 447, 204, 45);
		PNmember.add(L_NCardnumber);
		L_NCardnumber.setFont(new Font("굴림", Font.BOLD, 30));
		
		T_NCardnumber = new JTextField();
		T_NCardnumber.setFont(new Font("굴림", Font.PLAIN, 30));
		T_NCardnumber.setColumns(10);
		T_NCardnumber.setBounds(702, 449, 216, 41);
		PNmember.add(T_NCardnumber);
		
		JButton B_NLogin = new JButton("로그인");
		B_NLogin.setFont(new Font("굴림", Font.PLAIN, 20));
		B_NLogin.setBounds(654, 675, 105, 27);
		PNmember.add(B_NLogin);
		
		JButton B_NBack = new JButton("←");
		B_NBack.setFont(new Font("굴림", Font.BOLD, 50));
		B_NBack.setBounds(14, 908, 90, 45);
		PNmember.add(B_NBack);
		PNmember.setVisible(false);
		
		


		

		
		//==================================================
		
		
		
		final JPanel Pmember = new JPanel();//회원 화면
		Pmember.setBackground(new Color(128,0,128));
		Pmember.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Pmember);
		Pmember.setLayout(null);
		
		JLabel L_Login = new JLabel("회원 Login");
		L_Login.setForeground(Color.WHITE);
		L_Login.setBounds(601, 153, 264, 98);
		L_Login.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		Pmember.add(L_Login);
		
		
		L_Id.setForeground(Color.WHITE);
		L_Id.setBounds(527, 394, 132, 45);
		L_Id.setFont(new Font("굴림", Font.BOLD, 30));
		Pmember.add(L_Id);
		
		T_Id = new JTextField();
		T_Id.setBounds(673, 394, 216, 41);
		T_Id.setFont(new Font("굴림", Font.PLAIN, 30));
		Pmember.add(T_Id);
		T_Id.setColumns(10);
		
		JLabel L_Password = new JLabel("비밀번호 : ");
		L_Password.setForeground(Color.WHITE);
		L_Password.setBounds(527, 472, 170, 45);
		L_Password.setFont(new Font("굴림", Font.BOLD, 30));
		Pmember.add(L_Password);
		
		T_Password = new JPasswordField();
		T_Password.setBounds(700, 474, 216, 41);
		T_Password.setFont(new Font("굴림", Font.PLAIN, 30));
		T_Password.setColumns(10);
		Pmember.add(T_Password);
		
		JButton B_Login = new JButton("로그인");
		B_Login.setBounds(673, 793, 105, 27);
		B_Login.setFont(new Font("굴림", Font.PLAIN, 20));
		Pmember.add(B_Login);
		
		JButton B_Back = new JButton("←");
		B_Back.setFont(new Font("굴림", Font.BOLD, 50));
		B_Back.setBounds(14, 908, 90, 45);
		Pmember.add(B_Back);
		
		
		
		Pmember.setVisible(false);
		
	
		
		
		
		
		//==================================================        
		
		
		
		final JPanel Psignup = new JPanel();//회원가입 화면
		Psignup.setBackground(new Color(128,0,128));
		Psignup.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Psignup);
		Psignup.setLayout(null);
		
		JLabel L_Sinup = new JLabel("회원가입");
		L_Sinup.setForeground(Color.WHITE);
		L_Sinup.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		L_Sinup.setBounds(552, 195, 213, 98);
		Psignup.add(L_Sinup);
		
		JLabel L_SName = new JLabel("이름 : ");
		L_SName.setForeground(Color.WHITE);
		L_SName.setFont(new Font("굴림", Font.BOLD, 30));
		L_SName.setBounds(512, 382, 132, 45);
		Psignup.add(L_SName);
		
		T_SName = new JTextField();
		T_SName.setFont(new Font("굴림", Font.PLAIN, 30));
		T_SName.setColumns(10);
		T_SName.setBounds(636, 382, 216, 41);
		Psignup.add(T_SName);
		
		JLabel L_SId = new JLabel("아이디 : ");
		L_SId.setForeground(Color.WHITE);
		L_SId.setFont(new Font("굴림", Font.BOLD, 30));
		L_SId.setBounds(512, 471, 132, 45);
		Psignup.add(L_SId);
		
		T_SId = new JTextField();
		T_SId.setFont(new Font("굴림", Font.PLAIN, 30));
		T_SId.setColumns(10);
		T_SId.setBounds(658, 471, 216, 41);
		Psignup.add(T_SId);
		
		JLabel L_SPassword = new JLabel("비밀번호 : ");
		L_SPassword.setForeground(Color.WHITE);
		L_SPassword.setFont(new Font("굴림", Font.BOLD, 30));
		L_SPassword.setBounds(512, 557, 170, 45);
		Psignup.add(L_SPassword);
		
		PF_SPassword = new JPasswordField();
		PF_SPassword.setFont(new Font("굴림", Font.PLAIN, 30));
		PF_SPassword.setColumns(10);
		PF_SPassword.setBounds(684, 559, 216, 41);
		Psignup.add(PF_SPassword);
		
		JButton B_signup = new JButton("회원가입");
		B_signup.setFont(new Font("굴림", Font.PLAIN, 20));
		B_signup.setBounds(609, 765, 132, 27);
		Psignup.add(B_signup);
		
		JButton B_SBack = new JButton("←");
		B_SBack.setFont(new Font("굴림", Font.BOLD, 50));
		B_SBack.setBounds(14, 908, 90, 45);
		Psignup.add(B_SBack);
		
		JButton bnt_DoubleCheck = new JButton("중복확인");
		bnt_DoubleCheck.setBounds(894, 471, 90, 41);
		Psignup.add(bnt_DoubleCheck);
		Psignup.setVisible(false);
		//아이디 중복확인
		bnt_DoubleCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBmember db = new DBmember();
				 if( db.checkid(T_SId.getText()) ){ //중복아니다.(사용가능)
	                  //messageBox(this, T_SId.getText()+"는 사용가능합니다.");
	                  JOptionPane.showMessageDialog(null, T_SId.getText()+"는 사용가능합니다.");
	              }else{ //중복이다.
	                  JOptionPane.showMessageDialog(null, T_SId.getText()+"는 중복입니다.");
	                 
	                  T_SId.setText("");//text박스지우기
	                  T_SId.requestFocus();//커서놓기
	              }
			}


			
		});
		
		
		
		
		//==================================================  
		
		
		
		
		
		final JPanel Pmain = new JPanel();//첫화면
		Pmain.setBackground(new Color(128,0,128));
		Pmain.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Pmain);
		Pmain.setLayout(null);
		
		JLabel L_PCroom = new JLabel("PC방");
		L_PCroom.setForeground(Color.WHITE);
		L_PCroom.setBounds(644, 145, 127, 134);
		Pmain.add(L_PCroom);
		L_PCroom.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		
		
		B_member.setBounds(456, 508, 189, 73);
		Pmain.add(B_member);
		B_member.setFont(new Font("굴림", Font.BOLD, 40));
		
		
		B_Nmember.setBounds(736, 508, 181, 73);
		Pmain.add(B_Nmember);
		B_Nmember.setFont(new Font("굴림", Font.BOLD, 40));
		
		JButton B_SignUp = new JButton("회원가입");//회원가입
		B_SignUp.setFont(new Font("굴림", Font.BOLD, 40));
		B_SignUp.setBounds(595, 704, 228, 73);
		Pmain.add(B_SignUp);
		frame.add(Pmain);
		frame.setVisible(true);
		
		
		
		
		//==================================================  

		
		
		
		B_member.addActionListener(new ActionListener() {//메인 => 회원
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmember.setVisible(true);
				Pmain.setVisible(false);
				
				
			}
		});
		
		
		B_Back.addActionListener(new ActionListener() {//회원 => 메인
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				Pmember.setVisible(false);
			}
		});
		
		
		
		B_Nmember.addActionListener(new ActionListener() {//메인 => 비회원
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PNmember.setVisible(true);
				Pmain.setVisible(false);
				//s.setVisible(false);
				//s.setMember("비회원");
			}
		});
			
		
		B_NBack.addActionListener(new ActionListener() {//비회원 => 메인
			
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
				member="비회원";
				DBnotmember db=new DBnotmember(member, cardNum);
				Buy_Time b=new Buy_Time();
				b.change();
				frame.setVisible(false);
			}
		});
		
		B_Login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "로그인 되었습니다.");	
				Buy_Time b=new Buy_Time();
				b.change();
				frame.setVisible(false);
								
			}
		});
		

		
		B_SignUp.addActionListener(new ActionListener() {//메인 => 회원가입
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Psignup.setVisible(true);
				Pmain.setVisible(false);
			}
		});
		
		B_SBack.addActionListener(new ActionListener() {//회원가입 => 메인
			
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
			
		member="회원";
		DBmember db=new DBmember();
		db.insert(member, t_SId, t_Password, t_SName);	
		
		//DBsignup.createCustomer(t_SName, t_SId, t_Password);
		JOptionPane.showMessageDialog(null, "회원가입 되었습니다. 로그인 해주세요.");
		Pmember.setVisible(true);
		Psignup.setVisible(false);
			
		}
	});	
	}
	public static void main(String[] args) {
		SignIn_Up s=new SignIn_Up();
	}

}

