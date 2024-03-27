 class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader input;
        private PrintWriter output;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                output = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String inputLine;
                while ((inputLine = input.readLine()) != null) {
                    lista.add("[Client]: " + inputLine);
                    lista.select(lista.getItemCount() - 1);
                    output.println("Server response: " + inputLine);
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
