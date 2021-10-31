import java.io.*;
import java.net.Socket;

public class Client {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Client(String host, int port) {
        connect(host, port);
    }

    private void connect(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connection established");

            new Thread(() -> readMessage())
                    .start();

            new Thread(() -> writeMessage())
                    .start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeMessage() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
        while (true) {
            String str = reader.readLine();
            dataOutputStream.writeUTF(str);

            if (str.equals("exit")) {
                break;
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessage() {
        try {
            while (true){
                String inputMessage = dataInputStream.readUTF();
                if(inputMessage.equals("exit")){
                    break;
                } else {
                    System.out.printf("Message from Server: %s \n", inputMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}