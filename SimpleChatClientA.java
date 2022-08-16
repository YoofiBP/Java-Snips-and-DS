import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

import javax.swing.*;
import java.awt.*;

public class SimpleChatClientA {
    private PrintWriter writer;
    private JTextField outgoing;

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

    void go() {
        setUpNetworking();

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        JFrame frame = new JFrame("Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void sendMessage() {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    void readMessages() {

    }

    private void setUpNetworking() {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 5000));
            writer = new PrintWriter(Channels.newWriter(socketChannel, StandardCharsets.UTF_8));
            System.out.println("Network established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}