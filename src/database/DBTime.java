package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

//ȸ�������� ���� db����
public class DBTime {
	java.sql.Connection conn;
	java.sql.Statement stmt;
	java.sql.ResultSet rs;
	PreparedStatement ps;
	
	
	public DBTime(){  //������
		connect();
	}
	//�ش� ����̹��� Ŭ������ �̿��Ͽ� DB����(_conn)
	//DB�� ��ɾ ������ �� �ִ� ��ü ����(_stmt)
	void connect() {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/member?serverTimezone=UTC";
		String dbID="root";
		String dbPW="6162";
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conn=java.sql.DriverManager.getConnection(dbinfor,dbID,dbPW);
		this.stmt=this.conn.createStatement();
	}catch(Exception e){
		System.out.println("connection error:" + e);
	}
}//connect()
	void Undate(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}catch(Exception e) {
			System.out.println("undate error : " + e);
		}
		
	}//undate()
	//������
	void select(String dbSelect) {
		try {
			this.rs=this.stmt.executeQuery(dbSelect);
		}catch(Exception e) {
			System.out.println("select error : " + e);
		}
	}//select()
	void close() {
		try {
			conn.close();
		}catch(Exception e){
			System.out.println("close error :" +e);
		}
	}
	public static void createCustomer(String t_time) {
		try {
			DBsignup ot=new DBsignup();
			//DBsignup info=new DBsignup();
			
			ot.Undate("INSERT INTO members (time)" + "VALUES('" + t_time +  "')");
			
			ot.select("SELECT * FROM times");
			ot.rs.beforeFirst();
			
		}//try
		catch(Exception e) {
			System.out.println("getString error:" + e);
		}
	}
	
}

