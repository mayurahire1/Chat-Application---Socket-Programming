import java.io.*;
import java.net.*;

public class ChatClient
{
    public static void main(String args[])
    {
        try
        {
            System.out.println("Client is Starting...");

            Socket socket = new Socket("localhost",2100);

            System.out.println("Connected to Server.");

            PrintStream out = new PrintStream(socket.getOutputStream());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            System.out.println("--------------------------------------------");
            System.out.println("        Chat Client");
            System.out.println("--------------------------------------------");

            ReadThread read = new ReadThread(in);
            WriteThread write = new WriteThread(out);

            read.start();
            write.start();

            read.join();
            write.join();

            socket.close();

            System.out.println("Client Closed.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}