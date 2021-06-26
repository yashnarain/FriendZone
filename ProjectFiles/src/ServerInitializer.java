import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * ServerInitializer
 *
 * This class handles collection of different server threads for communication!
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class ServerInitializer extends Thread {
    public int port;
    public ArrayList<ServerThread> clientList = new ArrayList<>();

    public ArrayList<ServerThread> getClientList() {
        return clientList;
    }
    public void setClientList(ArrayList<ServerThread> clientList) {
        this.clientList = clientList;
    }

    public ArrayList<String> viewFriendListUsers = new ArrayList<>();

    public ArrayList<String> getViewFriendListUsers() {
        return viewFriendListUsers;
    }
    public void setViewFriendListUsers(ArrayList<String> viewFriendListUsers) {
        this.viewFriendListUsers = viewFriendListUsers;
    }

    public ServerInitializer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            if (Welcome.logout) {
                return;
            }
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(this, socket); //serverThread constructor
                clientList.add(serverThread);
                serverThread.start(); //the thread starts every time a new connection comes
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}
