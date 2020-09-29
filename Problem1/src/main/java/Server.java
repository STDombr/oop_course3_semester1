import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Object.Cat;

public class Server {
    ServerSocket server;
    ObjectInputStream in;
    Socket client;
    Cat cat;

    Server(Integer port) throws IOException {
        server = new ServerSocket(port);
    }

    public void run() throws IOException {
        client = server.accept();
        in = new ObjectInputStream(client.getInputStream());

        try{
            cat = (Cat) in.readObject();
            cat.print();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        in.close();
        server.close();
        client.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(6050);
        server.run();
    }
}
