import java.net.*;
import java.io.*;

public class DateTimeClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        String message = in.readLine();

        System.out.println("Server: " + message);

        socket.close();
    }
}