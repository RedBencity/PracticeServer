package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;

public class MessageSocket {

	public static ArrayList<Socket> sockets = new ArrayList<Socket>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(30000);
			while (true) {
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				new Thread(new MessageThread(socket)).start();

			}
		} catch (IOException e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
