import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        String message = in.readLine();

        System.out.println("Client: " + message);

        // Send the same message back
        out.println(message);

        socket.close();
        serverSocket.close();
    }
}