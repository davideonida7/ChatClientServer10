public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatServer();
            }
        });

        for (int i = 0; i < 10; i++) {
            final int clientId = i;
            new Thread(new Runnable() {
                public void run() {
                    new ChatClient(clientId).start();
                }
            }).start();
        }
    }
}
