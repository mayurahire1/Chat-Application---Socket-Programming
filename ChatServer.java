import java.io.*;
import java.net.*;

class ChatServer
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Server application is running");

        ServerSocket ssobj = new ServerSocket(2100);

        System.out.println("Server is waiting at PORT 2100");

        Socket sobj = ssobj.accept();

        System.out.println("Client request gets accepted sucessfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("-----------------------------------------------------");
        System.out.println("-----------Marvellous Chat Server---------------------");
        System.out.println("-----------------------------------------------------");

        String str1 = null , str2 = null;

        while((str1 = bobj1.readLine()) != null )
        {
            System.out.println("Client Says: "+str1);
            System.out.println("Enter msg for client: ");

            str2 = bobj2.readLine();
            pobj.println(str2);
        }
        
        sobj.close();
        ssobj.close();
    }
}