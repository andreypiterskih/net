import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable {
    static private ServerSocket server;
    static private Socket connection;
    static private ObjectOutputStream output;
    static private ObjectInputStream input;

    @Override
    public void run() {
        try {
            server = new ServerSocket(5678, 10);
            while (true) {
                connection = server.accept();
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                output.writeObject("Вы прислали: "+(String)input.readObject());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
        } catch (HeadlessException e) {
        } catch (ClassNotFoundException e) {}
    }
}
