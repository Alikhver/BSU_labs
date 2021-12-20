import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestASClient {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 3345);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {

            System.out.println("Client connected to socket.");
            System.out.println();

            while (!socket.isOutputShutdown()) {

                while (true) {
                    if (inputStream.available() > 0) {
                        System.out.println(inputStream.readUTF());
                        break;
                    }
                }

                while (true) {
                    if (consoleReader.ready()) {
                        String clientCommand = consoleReader.readLine();

                        outputStream.writeUTF(clientCommand);
                        outputStream.flush();

                        if (clientCommand.equalsIgnoreCase("quit")) {
                            System.out.println("Client killed connections");
                            // TODO send exit message to server
                            break;
                        }
                        break;
                    }
                }

            }
            System.out.println("Closing connections & channels on clintSide - DONE.");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}