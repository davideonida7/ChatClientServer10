public class Main {
    public static void main(String[] args) {
        // Avvio del server
        Thread serverThread = new Thread(() -> {
            ChatServer server = new ChatServer();
            server.start();
        });
        serverThread.start();

        // Avvio dei client
        for (int i = 0; i < 10; i++) {
            final int clientId = i;
            Thread clientThread = new Thread(() -> {
                ChatClient client = new ChatClient();
                client.start();
            });
            clientThread.start();
        }
    }
}
