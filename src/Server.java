import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Server(int port) {
        startServer(port);
    }

    private void startServer(int port){
        try {
            System.out.println("Starting server...");
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("...Done!");
            System.out.println("Waiting connection...");
            Socket accepted = serverSocket.accept();
            System.out.println("Connection established");

            dataInputStream = new DataInputStream(accepted.getInputStream());
            dataOutputStream = new DataOutputStream(accepted.getOutputStream());

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
                System.out.println(str);

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
                System.out.printf("Message from Client: %s \n", inputMessage);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
