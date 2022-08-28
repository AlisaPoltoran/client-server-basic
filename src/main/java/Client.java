import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String response = in.readLine();
            System.out.println(response);

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);

            String response2 = in.readLine();
            System.out.println(response2);
            String answer = scanner.nextLine();
            out.println(answer);

            String response3 = in.readLine();

            System.out.println(response3);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
