package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBsetId {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String jdbc_driver="com.mysql.cj.jdbc.Driver";
	String dbURL="jdbc:mysql://127.0.0.1:3306/member2?serverTimezone=UTC";
	String sql="SELECT * FROM emp";
	
	public DBsetId() {
		connect();
	}
	void connect() {
		try {
		Class.forName(jdbc_driver);
		conn=DriverManager.getConnection(dbURL,"root","mirim2");
//		stmt=conn.createStatement();
//		rs=stmt.executeQuery(sql);
		System.out.println("���Ἲ��!!!");
		}catch(Exception e) { 
			System.out.println("connection error : " + e);
		} 
	}
}
