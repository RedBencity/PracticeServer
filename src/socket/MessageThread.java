package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import Dao.DaoFactory;

import vo.Message;

public class MessageThread implements Runnable {
	Socket socket = null;
	OutputStream outputStream = null;

	public MessageThread(Socket socket) throws IOException {
		this.socket = socket;
		outputStream = socket.getOutputStream();
	}

	public void run() {
		try {
			String fileName = "d://Practice/message/message.xml";
			String messageString = "";
			Message message = new Message();
			message = DaoFactory.getMessageDao().getMessage(fileName);
			messageString = message.getId() + "@" + message.getTitle() + "@"
					+ message.getTime() + "@" + message.getContent();
			outputStream.write(messageString.getBytes("utf-8"));
			outputStream.close();
			this.socket.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MessageSocket.sockets.remove(socket);
		}
	}

}
