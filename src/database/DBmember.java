package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBmember {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs;
	
	public DBmember(String member, String id, String password, String name) {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dbinfor,dbID,dbPW);
			
			String sql="INSERT INTO User (member,id,password,name) VALUES (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, name);
			pstmt.executeUpdate();
			
			conn.close();
			
		}catch(Exception e){
			System.out.println("connection error:" + e);
		}
	}
}
