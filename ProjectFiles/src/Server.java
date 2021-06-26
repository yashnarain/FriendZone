import java.io.IOException;

/**
 * Server
 *
 * The main server class that controls all the client connections.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class Server extends Thread {
    public static void main(String[] args) throws IOException {

        int port = 4242;
        ServerInitializer serverInitializer = new ServerInitializer(port);
        serverInitializer.start();

        if (Welcome.logout) {
            return;
        }
    }
}
