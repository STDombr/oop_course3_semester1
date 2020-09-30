import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import Object.Cat;

public class Client {
    private Socket client;
    private  ObjectOutputStream out;
    public Client(String address, Integer port) throws IOException {
        try{
            client = new Socket(InetAddress.getByName(address), port);
            out = new ObjectOutputStream(client.getOutputStream());

        }catch (IOException x) {
            x.printStackTrace();
        }
    }

    public void run(Cat cat) throws IOException {
        try{
            out.writeObject(cat);
            out.flush();
            System.out.println("Operation successful!");
        } catch (IOException temp){
            temp.printStackTrace();
        } finally {
            client.close();
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Cat cat = new Cat("Hami", "Scottish fold", 2, "white");

        Client client = new Client("127.0.0.1", 6050);
        client.run(cat);
    }
}
