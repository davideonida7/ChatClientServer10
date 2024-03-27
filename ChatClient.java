import java.io.*;
import java.net.*;

public class ChatClient {
    private int id;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ChatClient(int id) {
        this.id = id;
    }

    public void start() {
        try {
            socket = new Socket("localhost", 6789);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello from Client " + id);

            String response;
            while ((response = input.readLine()) != null) {
                System.out.println("[Client " + id + "]: " + response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
