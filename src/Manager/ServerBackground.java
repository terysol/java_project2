package Manager;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	ServerSocket serversocket;
	Socket socket;
	ShowSeat gui;
	int hours;
	
	public void setGui(ShowSeat gui) {
		this.gui = gui;
	}
	public void setting() {
		try {
			serversocket =new ServerSocket(4152);
			System.out.println("¥Î±‚¡ﬂ...");
			socket=serversocket.accept();
			
			//gui.changeColor();
//			int num=Modal.ch.getSelectedIndex();
//			gui.setHours(num+1);
			//System.out.println(Modal.t);
			//System.out.println(ShowSeat.hours);
			//System.out.println(ShowSeat.hours);
			
			//gui.startTimer();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ServerBackground server=new ServerBackground();
		server.setting();
	}
//	public void getTime(int hours) {
//		this.hours=hours;
//	}
	
}
