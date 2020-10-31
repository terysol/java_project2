package Manager;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	ServerSocket serversocket;
	Socket socket;
	ShowSeat gui;
	
	public void setGui(ShowSeat gui) {
		this.gui = gui;
	}
	public void setting() {
		try {
			serversocket =new ServerSocket(4152);
			System.out.println("¥Î±‚¡ﬂ...");
			socket=serversocket.accept();
			gui.changeColor();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ServerBackground server=new ServerBackground();
		server.setting();
	}
}
