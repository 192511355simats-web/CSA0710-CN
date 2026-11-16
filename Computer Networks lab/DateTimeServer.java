import java.net.*;
import java.util.*;

public class DNSServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("DNS Server waiting for client...");

        DatagramPacket packet =
            new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        String domain = new String(
            packet.getData(), 0, packet.getLength());

        String ip;

        if (domain.equals("google.com"))
            ip = "142.250.195.14";
        else if (domain.equals("facebook.com"))
            ip = "157.240.241.35";
        else if (domain.equals("example.com"))
            ip = "93.184.216.34";
        else
            ip = "Domain not found";

        byte[] response = ip.getBytes();

        DatagramPacket reply = new DatagramPacket(
            response,
            response.length,
            packet.getAddress(),
            packet.getPort());

        socket.send(reply);

        System.out.println("Domain: " + domain);
        System.out.println("IP Address: " + ip);

        socket.close();
    }
}