package Manager;

import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	Socket socket;
	Modal gui;
	int hours;
	
	public void setGui(Modal gui) {
		this.gui = gui;
	}
	public void connect() {
		try {
			socket=new Socket("127.0.0.1",4152);
			System.out.println("¼­¹ö¿¬°áµÊ.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ClientBackground client =new ClientBackground();
		client.connect();
	}
//	public void getTime(int hours) {
//		this.hours=hours;
//	}
	
	
}
