import java.io.*;

public class WriteThread extends Thread
{
    private PrintStream writer;
    private BufferedReader keyboard;

    public WriteThread(PrintStream writer)
    {
        this.writer = writer;
        keyboard = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run()
    {
        try
        {
            String message;

            while(true)
            {
                System.out.print("You : ");

                message = keyboard.readLine();

                writer.println(message);

                ChatLogger.log("You", message);

                if(message.equalsIgnoreCase("end"))
                {
                    break;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}