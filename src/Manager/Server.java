package Manager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket serversocket=null;
	Socket socket=null;
	ShowSeat gui;
	
	
	public final void setGui(ShowSeat gui) {
		this.gui = gui;
	}


	public void setting() {
		try {
			serversocket=new  ServerSocket(7775);
			System.out.println("�����...");
			socket=serversocket.accept();
			gui.dbConnect();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
