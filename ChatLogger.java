import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatLogger
{
    private static final String FILE_NAME = "chat_log.txt";

    public static synchronized void log(String sender, String message)
    {
        try(FileWriter writer = new FileWriter(FILE_NAME, true))
        {
            String time = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

            writer.write("[" + time + "] " + sender + " : " + message + "\n");
        }
        catch(IOException e)
        {
            System.out.println("Unable to write log.");
        }
    }
}