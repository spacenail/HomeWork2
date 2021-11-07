import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

    public class ChatServer {

        private final ServerSocket socket;
        private final AuthenticationService authenticationService;
        private final Set<ClientHandler> loggedClients;

        public ChatServer() {
            try {
                authenticationService = new AuthenticationService();
                loggedClients = new HashSet<>();
                this.socket = new ServerSocket(8888); //запуск сервера на порту 8888. Singleton?

                while (true) { // бесконечное ожидание новых клиентов
                    System.out.println("Waiting for a new connection...");
                    Socket client = socket.accept();
                    System.out.println("Client accepted.");
                    new Thread(() -> new ClientHandler(client, this)).start(); // для каждого клиента отдельный процесс
                }
            } catch (IOException e) {
                throw new RuntimeException("Something went wrong during connection establishing.", e);
            }
        }

        // метод используется в многопоточном режиме метода performAuthentication(),
        // поэтому добавляем synchronized
        public synchronized AuthenticationService getAuthenticationService() {
            return authenticationService;
        }

        // метод используется в многопоточном режиме метода performAuthentication(),
        // поэтому добавляем synchronized
        public synchronized void addClient(ClientHandler client) {
            loggedClients.add(client);
        }

        // метод используется в многопоточном режиме,
        // поэтому добавляем synchronized
        public synchronized void removeUsername(ClientHandler client) {
            loggedClients.remove(client);
        }

         //проверка на совпадение переданного имени пользователя с уже залогиннеными
        public boolean isUsernameOccupied(String username) {
//        for (String loggedUsername : loggedUsernames) {
//            if (loggedUsernames.equals(username)) {
//                return true;
//            }
//        }
//        return false;

            return loggedClients.stream()
                    .anyMatch(c -> c.getName().equals(username));
        }

        public void broadcastMessage(String message) {
            loggedClients.forEach(ch -> ch.sendMessage(message));
        }

        // если переданный пользователь залогинен отправялем ему переданное сообщение.
        public boolean personalMessage(String recipient, String message){
            if(isUsernameOccupied(recipient)){

                loggedClients.stream()
                        .filter(client -> client.equals(recipient))
                        .forEach(client -> client.sendMessage(message));

                /*
                for(ClientHandler c:loggedClients){
                    if(c.getName().equals(recipient)){
                        c.sendMessage(message);
                    }
                }
                 */
            return true;
            }else {
                return false;
            }
        }


    }