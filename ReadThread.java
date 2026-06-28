
import java.io.*;

public class ReadThread extends Thread {

    private BufferedReader reader;

    public ReadThread(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            String message;

            while ((message = reader.readLine()) != null) {
                System.out.println("\nFriend : " + message);

                ChatLogger.log("Friend", message);

                System.out.print("You : ");
            }
        } catch (Exception e) {
            System.out.println("\nConnection Closed.");
        }
    }
}
