import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    //declare variables

    Socket socket;
    int clientId;
    Database db;

    //Constructor
    public ClientHandler (Socket socket, int clientId, Database db) {
        //complete the constructor
        this.clientId = clientId;
        this.db = db;
        this.socket = socket;
    }

    public void run() {
        /*System.out.println("ClientHandler started...");
              Create I/O streams to read/write data, PrintWriter and BufferedReader
              Receive messages from the client and send replies, until the user types "stop"
                  System.out.println("Client sent the artist name " + clientMessage);
                  Request the number of titles from the db
                  Send reply to Client:
                  outToClient.println("Number of titles: " + titlesNum + " records found");

              System.out.println("Client " + clientId + " has disconnected");
              outToClient.println("Connection closed, Goodbye!");
              Close I/O streams and socket*/
        try{

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);
            String message;
            System.out.println("ClientHandler started...");

            while(!(message = inFromClient.readLine()).equals("stop")) {
                System.out.println("Client sent the artist name " + message);
                int titlesNum = db.getTitles(message);
                outToClient.println("Number of titles: " + titlesNum + " records found");
            }

            System.out.println("Client " + clientId + " has disconnected");
            outToClient.println("Connection closed, Goodbye!");

            inFromClient.close();
            outToClient.close();
            socket.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
