import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient {

    public static void main(String[] args) {
        new DailyAdviceClient().go();
    }

    public void go() {
        InetSocketAddress address = new InetSocketAddress("localhost", 5000);
        try (SocketChannel channel = SocketChannel.open(address)) {
            Reader channelReader = Channels.newReader(channel, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(channelReader);
            String advice = reader.readLine();
            System.out.println("Today you should " + advice);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}