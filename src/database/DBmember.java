package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBmember {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String jdbc_driver="com.mysql.cj.jdbc.Driver";
	String dbURL="jdbc:mysql://127.0.0.1:3306/member2?serverTimezone=UTC";
	String sql="SELECT * FROM joinMember2";
		
	public DBmember() {
			connect();
	}
	void connect() {
		try {
		Class.forName(jdbc_driver);
		conn=DriverManager.getConnection(dbURL,"root","mirim2");
//		stmt=conn.createStatement();
//		rs=stmt.executeQuery(sql);
		System.out.println("연결성공!");
		}catch(Exception e) { 
			System.out.println("connection error : " + e);
		} 
	}
}
