package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

//ȸ�������� ���� db����
public class DBsaveTime {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	
	
	public DBsaveTime(){  //������
		connect();
	}
	//�ش� ����̹��� Ŭ������ �̿��Ͽ� DB����(_conn)
	//DB�� ��ɾ ������ �� �ִ� ��ü ����(_stmt)
	void connect() {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
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
	public static void createCustomer(int time) {
		try {
			DBsaveTime ot=new DBsaveTime();
			//DBsignup info=new DBsignup();
			
			ot.Undate("INSERT INTO save_time(time)" + "VALUES(" + time+  ")");
			
			ot.select("SELECT * FROM save_time");
			ot.rs.beforeFirst();
			
		}//try
		catch(Exception e) {
			System.out.println("getString error:" + e);
		}
	}
	
}

