package Manager;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerServer {
	
	public static void main(String[] args) throws SQLException {
		ServerSocket serversocket=null;
		Socket socket=null;
		
		try {
			serversocket=new ServerSocket(7771);
			System.out.println("연결대기 중...");
			socket=new Socket();
			socket=serversocket.accept();
			System.out.println("성공");
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}


