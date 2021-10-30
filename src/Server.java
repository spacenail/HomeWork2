import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Server(int port) {
        this.port = port;
        startServer();
    }

    private void startServer(){
        try {
            System.out.println("Starting server...");
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("...Done!");
            System.out.println("Waiting connection...");
            Socket accepted = serverSocket.accept();
            System.out.println("Connection is established");

            dataInputStream = new DataInputStream(accepted.getInputStream());
            dataOutputStream = new DataOutputStream(accepted.getOutputStream());

            new Thread(() -> {
                readMessage();
            })
                    .start();

            new Thread(() -> {
                writeMessage();
            })
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
        while (true){
            String inputMessage = null;
            try {
                inputMessage = dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("Message from Client: %s \n",inputMessage);
        }
    }

}
