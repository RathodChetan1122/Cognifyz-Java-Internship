import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            // Read and write messages in a loop
            String clientMsg, serverMsg;
            while ((clientMsg = input.readLine()) != null) {
                System.out.println("Client: " + clientMsg);

                System.out.print("You: ");
                serverMsg = console.readLine();
                output.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Chat ended by server.");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
