import java.io.*;
import java.net.*;

public class ChatServer
{
    public static void main(String args[])
    {
        try
        {
            System.out.println("Server is Starting...");

            ServerSocket server = new ServerSocket(2100);

            System.out.println("Waiting for Client...");

            Socket socket = server.accept();

            System.out.println("Client Connected Successfully!");

            PrintStream out = new PrintStream(socket.getOutputStream());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            System.out.println("--------------------------------------------");
            System.out.println("        Chat Server");
            System.out.println("--------------------------------------------");

            ReadThread read = new ReadThread(in);
            WriteThread write = new WriteThread(out);

            read.start();
            write.start();

            read.join();
            write.join();

            socket.close();
            server.close();

            System.out.println("Server Closed.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}