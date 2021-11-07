import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientHandler {

    private final Socket socket;
    private final ChatServer server;
    private final DataInputStream in;
    private final DataOutputStream out;
    private String name;

    public ClientHandler(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            throw new RuntimeException("Something went wring during a client connection establishing.");
        }

        doAuthentication();
        listenMessages();
    }

    public String getName() {
        return name;
    }

    private void doAuthentication() {
        try {
            performAuthentication();
        } catch (IOException ex) {
            throw new RuntimeException("Something went wring during a client authentication.");
        }
    }

    private void performAuthentication() throws IOException {
        while (true) {
            out.writeUTF("Please log In...");
            String inboundMessage = in.readUTF();
            if (inboundMessage.startsWith("-auth")) {
                // valid request sample: -auth l1 p1
                String[] credentials = inboundMessage.split("\\s");
                // при использовании ключевого слова -auth разбор полученной строки на логин и пароль


                // Если при авторизации нового пользователя логин и пароль совпадают -
                // проверка на занятость такого логина, если занят - выдается сообщение подключаемому клиенту
                // и повторяется в бесконечном цикле. Если совпадений нет, то добавляем в список клиентом и
                // сообщаем радостную весть всем остальным клиентам и выходим из цикла.
                AtomicBoolean isSuccess = new AtomicBoolean(false);
                server.getAuthenticationService()
                        .findUsernameByLoginAndPassword(credentials[1], credentials[2])
                        .ifPresentOrElse(
                                username -> {
                                    if (!server.isUsernameOccupied(username)) {
                                        try {
                                            out.writeUTF("Welcome!");
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        server.broadcastMessage(String.format("User[%s] is logged in", username));
                                        name = username;
                                        server.addClient(this);
                                        isSuccess.set(true);
                                    } else {
                                        sendMessage("Current username is already occupied.");
                                    }
                                },
                                () -> sendMessage("Bad credentials.")
                        );

                if (isSuccess.get()) break;
            }
        }
    }

    public void sendMessage(String outboundMessage) {
        try {
            out.writeUTF(outboundMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
2. * Реализовать личные сообщения, если клиент пишет «/w nick3 Привет», то только клиенту
 с ником nick3 должно прийти сообщение «Привет»
 */
    public void readMessage() {
        try {
            String inboundMessage = in.readUTF();
            // формат персонального сообщения /w user2 здарова друг!
            if (inboundMessage.startsWith("/w")) {
                String[] splitInboundMessage = inboundMessage.split("\\s",3);

                if(!server.personalMessage(splitInboundMessage[1],splitInboundMessage[2])){
                    out.writeUTF("Указанный пользователь не найден");
                }
            } else {
                server.broadcastMessage(inboundMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenMessages() {
        while (true) {
            readMessage();
        }
    }
}
