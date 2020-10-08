package database;

import java.sql.*;
public class DBconnect {
	public static void main(String[] args) {
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName(jdbc_driver);
			String dbURL="jdbc:mysql://127.0.0.1:3306/scott2?serverTimezone=UTC";
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
			System.out.println("���� ����");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}catch(Exception e) {
			System.out.println(e.toString());
			System.out.println("���� ����");
		}finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
	 }
	}
	
}
