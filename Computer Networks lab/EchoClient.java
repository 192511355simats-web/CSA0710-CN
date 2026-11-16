import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        Scanner sc = new Scanner(System.in);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        // Send message to server
        out.println(message);

        // Receive echoed message
        String reply = in.readLine();

        System.out.println("Server Echo: " + reply);

        socket.close();
        sc.close();
    }
}