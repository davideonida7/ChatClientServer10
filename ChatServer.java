import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatServer extends JFrame {
    private List lista;

    public ChatServer() {
        super("Chat Server");
        setSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel(new BorderLayout());
        pan.setBackground(new Color(50, 100, 255));

        JPanel panLista = new JPanel(new BorderLayout());
        panLista.setBackground(new Color(50, 100, 255));
        lista = new List();
        lista.setBackground(Color.lightGray);
        panLista.add(new JLabel("Chat", JLabel.CENTER), BorderLayout.NORTH);
        panLista.add(lista, BorderLayout.CENTER);

        pan.add(panLista, BorderLayout.CENTER);

        getContentPane().add(pan);
        setVisible(true);

        startServer();
    }

    private void startServer() {
        new Thread(new ServerThread()).start();
    }
