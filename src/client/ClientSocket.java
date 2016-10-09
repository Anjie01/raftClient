package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocket {
	public Socket socket;

	public ClientSocket(Socket socket) {
		this.socket = socket;
	}

	public void write(String massage) throws IOException {
		byte[] massageByte = massage.getBytes();
		OutputStream output = socket.getOutputStream();
		output.write(massageByte);// ����
		output.flush();
	}

	public String read() throws IOException {
		byte[] buffer = new byte[1024*10];
		InputStream input = socket.getInputStream();
		int length =  input.read(buffer);// ����
		
		StringBuffer massageBuffer = new StringBuffer(1024 * 10);
		for (int i = 0; i < length; ++i) {
			massageBuffer.append((char) buffer[i]);
		}
		return massageBuffer.toString();// �õ���Ϣ
	}

	public void close() {
		try {
			this.socket.close();
		} catch (IOException e) {
			System.out.println("�Ѿ��Ͽ�����");
		}
	}
	
}
