import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Socket socket = new Socket("localhost",8888);
            System.out.println("Connection established");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
           new Thread(() ->
           {
               try {
                   while (true) {
                       System.out.println(in.readUTF());
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }).start();
           while (true){
               out.writeUTF(reader.readLine());
           }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
