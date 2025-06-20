import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            // Read and write messages in a loop
            String userMsg, serverReply;
            while (true) {
                System.out.print("You: ");
                userMsg = console.readLine();
                output.println(userMsg);

                if (userMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Chat ended by client.");
                    break;
                }

                serverReply = input.readLine();
                System.out.println("Server: " + serverReply);
            }

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
