package Manager;

import java.net.ServerSocket;
import java.net.Socket;

public class BuyTimeServer {
	public static void main(String[] args) {
		ServerSocket serversocket=null;
		Socket socket=null;
		try {
			serversocket=new ServerSocket(7778);
			System.out.println("������ ��...");
			socket=new Socket();
			socket=serversocket.accept();
			System.out.println("����");
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
