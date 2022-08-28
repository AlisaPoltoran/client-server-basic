import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.printf("New connection accepted. Port %d%n", clientSocket.getPort());

                out.println("What is your name?");

                String name = in.readLine();

                out.println("Are you child? (yes/no)");

                String reply = in.readLine();

                switch (reply) {
                    case ("yes"):
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                        break;
                    case ("no"):
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!",
                                name));
                        break;
                }
            }
        }
    }
}
