package database;

import java.sql.*;
public class DBfood_list {
	public Connection conn=null;
	public PreparedStatement pstmt=null;
	public ResultSet rs=null;
	String jdbc_driver="com.mysql.cj.jdbc.Driver";
	String dbURL="jdbc:mysql://127.0.0.1:3306/food_list?serverTimezone=UTC";
	String sql="SELECT * FROM emp";
	
	public DBfood_list() {
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
