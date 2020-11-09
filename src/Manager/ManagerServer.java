package Manager;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerServer {
	public static Connection connect() {
		String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		try {
			Class.forName(jdbc_driver);
			System.out.println("Mysql client 데이터 베이스 연결 대기중...");
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
			System.out.println("Mysql client 데이터 베이스 연결 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("jdbc 드라이버를 찾지 못했습니다.");
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn=connect();
		Statement stmt=conn.createStatement();
		ResultSet rs;
		ServerSocket serversocket=null;
		Socket socket=null;
		try {
			serversocket=new ServerSocket(7777);
			System.out.println("연결대기 중...");
			socket=new Socket();
			socket=serversocket.accept();
			String sql="select * from seat";
			rs=stmt.executeQuery(sql);
			System.out.println("성공");
			while(rs.next()) {
				// String message=rs.getString("message");
				// System.out.println(message);
			}
			
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


