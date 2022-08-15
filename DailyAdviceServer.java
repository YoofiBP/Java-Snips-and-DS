import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class DailyAdviceServer {

    public static void main(String[] args) {
        new DailyAdviceServer().go();
    }

    public void go() {
        InetSocketAddress address = new InetSocketAddress(5000);
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(address);
            while (serverChannel.isOpen()) {
                SocketChannel clientChannel = serverChannel.accept();
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
                writer.println("Discretion is the better part of valour");
                writer.close();
            }
        } catch (Exception e) {

        }
    }
}