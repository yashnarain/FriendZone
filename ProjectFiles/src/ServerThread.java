import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * ServerThread
 * <p>
 * This class handles all the operations for a single client thread.
 * It reads in the command passed from the client and invokes the specific method
 * to perform the desired functionality.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class ServerThread extends Thread {
    private Socket clientSocket;
    private ServerInitializer serverInitializer;
    private PrintWriter pwc = null;
    private BufferedReader bfrc = null;
    private String usn;
    private int userIndex;
    public static List<User> users = new ArrayList<>();
    private static List<FriendRequest> fRequests = new ArrayList<>();
    private String fName;
    private String lName;
    private ArrayList<User> fList;
    private ArrayList<String> myFriends = new ArrayList<>();

    /**
     * readData
     * Reads the file given and creates user objects
     * <p>
     * File will be structured in this format:
     * <firstName> <lastName> <userName> <password> <email> <contact> <aboutMe>
     *
     * @param filename
     * @throws IOException
     */
    public static void readData(String filename) throws IOException {
        try {
            File f = new File(filename);
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            if (f.length() > 0) {
                String line = bfr.readLine();
                while (line != null && !line.equals("")) {
                    String[] info = line.split(" ");
                    String firstName = info[0].replaceAll("`", " "); //*****;
                    String lastName = info[1].replaceAll("`", " "); //*****;
                    String username = info[2].replaceAll("`", " "); //*****;
                    String password = info[3].replaceAll("`", " "); //*****;
                    String email = info[4].replaceAll("`", " "); //*****;
                    String contact = info[5].replaceAll("`", " "); //*****;
                    String hobbies = info[6].replaceAll("`", " "); //*****
                    String aboutMe = info[7].replaceAll("`", " "); //*****

                    if (users.size() == 0 || !checkIfExists(username)) {
                        User u = new User(firstName, lastName, username, password, email, contact, hobbies, aboutMe);
                        users.add(u);
                    }

                    line = bfr.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    } //end readData

    /**
     * Allows current user to view any other user's profile
     *
     * @param pw
     * @param split
     */
    public void handleViewOtherUserProfile(PrintWriter pw, String[] split) {
        try {
            File f = new File("UsersDetails.txt");
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            if (f.length() > 0) {
                String line = bfr.readLine();
                while (line != null && !line.equals("")) {
                    String[] info = line.split(" ");
                    String firstName = info[0];
                    String lastName = info[1];
                    String username = info[2];
                    String password = info[3];
                    String email = info[4];
                    String contact = info[5];
                    String hobbies = info[6];
                    String aboutMe = info[7];

                    if (username.equals(split[1])) {
                        String sendToClient = username + "]" + password + "]" + firstName + "]" + lastName + "]"
                                + email + "]" + contact + "]" + hobbies + "]" + aboutMe;
                        pw.println(sendToClient);
                        pw.flush();
                    }
                    line = bfr.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Communicates to the client to display the current user's profile
     *
     * @param pw
     */
    public void handleViewUserProfile(PrintWriter pw) {
        try {
            File f = new File("UsersDetails.txt");
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            if (f.length() > 0) {
                String line = bfr.readLine();
                while (line != null && !line.equals("")) {
                    String[] info = line.split(" ");
                    String firstName = info[0];
                    String lastName = info[1];
                    String username = info[2];
                    String password = info[3];
                    String email = info[4];
                    String contact = info[5];
                    String hobbies = info[6];
                    String aboutMe = info[7];

                    if (this.usn.equals(username)) {
                        String sendToClient = username + "]" + password + "]" + firstName + "]" + lastName + "]"
                                + email + "]" + contact + "]" + hobbies + "]" + aboutMe;
                        pw.println(sendToClient);
                        pw.flush();
                    }
                    line = bfr.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * readFriendList
     *
     * @param friendListFilename Reads the friends of every user and updates each user object in the Users arrayList
     *                           <p>
     *                           File will be structured in this format:
     *                           <Username> [<Friend1>, <Friend2>, <Friend3>, ...]
     */
    public void readFriendList(String friendListFilename) throws IOException {
        File f = new File(friendListFilename);
        BufferedReader bfr = new BufferedReader(new FileReader(f));

        this.fList = new ArrayList<>();

        String line = bfr.readLine();
        while (line != null && !line.equals("")) {
            String[] firstSplit = line.split(" ");
            String username = firstSplit[0];
            String friends = firstSplit[1].substring(1, firstSplit[1].length() - 1);
            String friendRequests = firstSplit[2].substring(1, firstSplit[2].length() - 1);
            int currentUserIndex = findUser(username);
            if (!friends.equals("")) {
                String[] friendUserNames = friends.split(",");
                ArrayList<User> friendList = new ArrayList<>();
                for (int i = 0; i < friendUserNames.length; i++) {
                    int currentFriendIndex = findUser(friendUserNames[i]);

                    if (currentFriendIndex != -1) {
                        friendList.add(users.get(currentFriendIndex));
                    }
                }
                users.get(currentUserIndex).setFriendList(friendList);
            } else {
                users.get(currentUserIndex).setFriendList(new ArrayList<>());
            }

            if (!friendRequests.equals("")) {
                String[] friendRequestNames = friendRequests.split(",");
                ArrayList<FriendRequest> friendRequestList = new ArrayList<>();
                for (int i = 0; i < friendRequestNames.length; i++) {
                    int currentRequestIndex = findUser(friendRequestNames[i]);

                    if (currentRequestIndex != -1) {
                        FriendRequest fReq = new FriendRequest(users.get(currentRequestIndex),
                                users.get(currentUserIndex));
                        friendRequestList.add(fReq);

                        this.fRequests.add(fReq);
                    }
                }

                users.get(currentUserIndex).setFriendRequests(friendRequestList);
            } else {
                users.get(currentUserIndex).setFriendRequests(new ArrayList<>());
            }

            line = bfr.readLine();
        }
    } //endFriendList

    /**
     * printInfoToFile
     *
     * @param userFilename
     * @param friendRequestFilename Prints the updated information (from the static users array) to the same file
     *                              The file will be structured the same ay as in the input file.
     */
    public static void printInfoToFile(String userFilename, String friendRequestFilename) {
        try {
            File f = new File(userFilename);
            FileOutputStream fos = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(fos);

            for (int i = 0; i < users.size(); i++) {
                String line = String.format("%s %s %s %s %s %s %s %s",
                        users.get(i).getFirstName().replaceAll(" ", "`"),
                        users.get(i).getLastName().replaceAll(" ", "`"),
                        users.get(i).getUsername().replaceAll(" ", "`"),
                        users.get(i).getPassword().replaceAll(" ", "`"),
                        users.get(i).getEmail().replaceAll(" ", "`"),
                        users.get(i).getContact().replaceAll(" ", "`"),
                        users.get(i).getHobbies().replaceAll(" ", "`"),
                        users.get(i).getAboutMe().replaceAll(" ", "`"));
                pw.println(line);
                pw.flush();
            }

            File f2 = new File(friendRequestFilename);
            FileOutputStream fos2 = new FileOutputStream(f2);
            PrintWriter pw2 = new PrintWriter(fos2);

            for (int i = 0; i < users.size(); i++) {
                String line = users.get(i).getUsername() + " [";
                if (users.get(i).getFriendList().size() == 0) {
                    line = line + "] [";
                } else {
                    for (int j = 0; j < users.get(i).getFriendList().size(); j++) {
                        if (users.get(i).getFriendList().size() == 1) {
                            line = line + users.get(i).getFriendList().get(j).getUsername() + "] [";
                        } else {
                            if (j == 0) {
                                line = line + users.get(i).getFriendList().get(j).getUsername();
                            } else if (j == users.get(i).getFriendList().size() - 1) {
                                line = line + "," + users.get(i).getFriendList().get(j).getUsername() + "] [";
                            } else {
                                line = line + "," + users.get(i).getFriendList().get(j).getUsername();
                            }
                        }
                    } //end for
                }

                if (users.get(i).getFriendRequests().size() == 0) {
                    line = line + "]";
                } else {
                    for (int k = 0; k < users.get(i).getFriendRequests().size(); k++) {
                        int pendingRequestSize = countPendingRequest(users.get(i).getFriendRequests());
                        if (pendingRequestSize == 0) {
                            line = line + "]";
                            break;
                        } else if (pendingRequestSize == 1) {
                            if (users.get(i).getFriendRequests().get(k).getStatus().equals("pending")) {
                                line = line + users.get(i).getFriendRequests().get(k).getUserFrom().getUsername() + "]";
                            }
                        } else {
                            if (users.get(i).getFriendRequests().get(k).getStatus().equals("pending")) {
                                if (k == 0) {
                                    line = line + users.get(i).getFriendRequests().get(k).getUserFrom().getUsername();
                                } else if (k == users.get(i).getFriendRequests().size() - 1) {
                                    line = line + "," +
                                            users.get(i).getFriendRequests().get(k).getUserFrom().getUsername() + "]";
                                } else {
                                    line = line + "," +
                                            users.get(i).getFriendRequests().get(k).getUserFrom().getUsername();
                                }
                            }
                        }
                    } //end for
                }

                pw2.println(line);
                pw2.flush();
            } //end for


        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    /**
     * Shows all the current user's friends.
     *
     * @param pw
     * @param friendListFilename
     * @throws IOException
     */
    public void viewAllFriends(PrintWriter pw, String friendListFilename) throws IOException {

        ArrayList<String> temp = serverInitializer.getViewFriendListUsers();
        temp.add(this.usn);
        serverInitializer.setViewFriendListUsers(temp);

        File f = new File(friendListFilename);
        BufferedReader bfr = new BufferedReader(new FileReader(f));

        String line = bfr.readLine();
        ArrayList<User> friendList = new ArrayList<>();
        while (line != null && !line.equals("")) {
            String[] firstSplit = line.split(" ");
            String username = firstSplit[0];
            String friends = firstSplit[1].substring(1, firstSplit[1].length() - 1);
            String friendRequests = firstSplit[2].substring(1, firstSplit[2].length() - 1);
            int currentUserIndex = findUser(username);
            if (username.equals(this.usn)) {
                if (!friends.equals("")) {
                    String[] friendUserNames = friends.split(",");

                    for (int i = 0; i < friendUserNames.length; i++) {
                        int currentFriendIndex = findUser(friendUserNames[i]);

                        if (currentFriendIndex != -1) {
                            friendList.add(users.get(currentFriendIndex));
                            //this.friendList.add(users.get(currentFriendIndex));
                        }
                    }
                }
            }
            line = bfr.readLine();
        }
        bfr.close();

        for (int i = 0; i < friendList.size(); i++) {
            if (!friendList.get(i).getUsername().equals(usn)) {
                pw.println(friendList.get(i).getFirstName().replaceAll(" ", "`") + " " +
                        friendList.get(i).getLastName().replaceAll(" ", "`"));
                pw.flush();

            }
        }
    }


    /**
     * Shows the user's pending incoming friend requests
     *
     * @param pw
     * @param friendListFilename
     * @throws IOException
     */
    public void viewMyRequests(PrintWriter pw, String friendListFilename) throws IOException {
        File f = new File(friendListFilename);
        BufferedReader bfr = new BufferedReader(new FileReader(f));

        String line = bfr.readLine();
        ArrayList<String> tempArr = new ArrayList<>();
        while (line != null && !line.equals("")) {
            String[] firstSplit = line.split(" ");
            String username = firstSplit[0];
            String friends = firstSplit[1].substring(1, firstSplit[1].length() - 1);
            String friendRequests = firstSplit[2].substring(1, firstSplit[2].length() - 1);
            int currentUserIndex = findUser(username);

            if (!friendRequests.equals("")) {
                String[] friendRequestNames = friendRequests.split(",");
                ArrayList<FriendRequest> friendRequestList = new ArrayList<>();
                for (int i = 0; i < friendRequestNames.length; i++) {
                    int currentRequestIndex = findUser(friendRequestNames[i]);


                    if (friendRequestNames[i].equals(this.usn)) {
                        tempArr.add(username);
                    }


                }
            }


            line = bfr.readLine();
        }
        bfr.close();
        myFriends = tempArr;


        for (int i = 0; i < myFriends.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).getUsername().equals(myFriends.get(i))) {
                    pw.println(users.get(j).getUsername() + "]" +
                            users.get(j).getFirstName().replaceAll(" ", "`") + " " +
                            users.get(j).getLastName().replaceAll(" ", "`"));
                    pw.flush();
                }
            }
        }
    }

    // Service methods

    /**
     * findUser
     * <p>
     * Searches all the users in the users ArrayList for the specific user and returns the index of that User.
     *
     * @param username
     * @return index of the user in the users arrayList
     */
    public static int findUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    } //end findUser

    public static boolean checkIfExists(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void printLoginMenu() {
        pwc.println("" +
                "Command list:\n" +
                "createProfile -- To create your profile!\n" +
                "delete -- To delete this account\n" +
                "sendRequestTo <username> -- To send a friend request to another account!\n" +
                "seeFriendRequests -- To see who all want to be your friend!\n" +
                "seeAll -- To see all users\n" +
                "seeOnline -- To see all the users who are currently online!\n" +
                "sendDM <username> <message> -- Send a disappearing message to one of your friends!\n" +
                "quit -- To close this application\n\n" +
                "****** -- Indicates a notification\n");
        pwc.flush();
    }

    /**
     * Counts the pending friend requests of the current user
     *
     * @param fr
     * @return
     */
    public static int countPendingRequest(ArrayList<FriendRequest> fr) {
        int count = 0;
        for (int i = 0; i < fr.size(); i++) {
            if (fr.get(i).getStatus().equals("pending")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Updates the user's friends' friend lists and deletes this user as a friend.
     * Deletes any requests sent by this user.
     *
     * @param username
     */
    public static void deleteFriendAndRequests(String username) {
        int index = -1;
        int indexi = -1;
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getFriendList().size(); j++) {
                if (users.get(i).getFriendList().get(j).getUsername().equals(username)) {
                    index = j;
                    indexi = i;
                    break;
                }
            } //end for j
        } //end for FriendList

        if (index != -1) {
            users.get(indexi).getFriendList().remove(index);
        }

        index = -1;
        indexi = -1;
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getFriendRequests().size(); j++) {
                if (users.get(i).getFriendRequests().get(j).getUserFrom().getUsername().equals(username)) {
                    index = j;
                    indexi = i;
                    break;
                }
            } //end for j
        } //end for FriendList

        if (index != -1) {
            users.get(indexi).getFriendRequests().remove(index);

        }


    }

    /**
     * Prints message to selected client.
     *
     * @param notification
     */
    private void send(String notification) {
        if (usn != null) {
            pwc.println(notification);
            pwc.flush();
        }
    }


    /**
     * Constructor:
     * <p>
     * Initializes a ServerThread object.
     *
     * @param serverInitializer
     * @param clientSocket
     */
    public ServerThread(ServerInitializer serverInitializer, Socket clientSocket) {
        this.serverInitializer = serverInitializer;
        this.clientSocket = clientSocket;
        this.usn = null;
        this.userIndex = -1;
    }


    /**
     * @return username of this object
     */
    public String getUsername() {
        return usn;
    }

    /**
     * Sets the username of this object
     *
     * @param username
     */
    public void setUsername(String username) {
        this.usn = username;
    }


    /**
     * The main run method
     */
    public void run() {
        try {
            readData("UsersDetails.txt");
            readFriendList("FriendList.txt");
            handleConnection(clientSocket);
//          handleFriendRequestReceiving(clientSocket);
        } catch (SocketException s) {
            quit();
        } catch (IOException e) {
            quit();
            e.printStackTrace();
        }
    }


    /**
     * Takes in a socket and reads the command passed by that connection.
     * Invoked the method that is associated with the command that is passed.
     *
     * @param socket
     * @throws IOException
     */
    public void handleConnection(Socket socket) throws IOException {

        try {
            bfrc = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.pwc = new PrintWriter(socket.getOutputStream());

//        synchronized (obj) {
            String line = bfrc.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                String cmd = split[0];
                if (cmd.equals("createAccount")) {
                    handleCreateAccount(pwc, split);
                } else if (cmd.equals("login")) {
                    handleLogin(pwc, split);
                } else if (cmd.equals("delete")) {
                    handleDelete(pwc, split);
                } else if (cmd.equals("seeAll")) {
                    handleAllUsers(pwc, split);
                } else if (cmd.equals("seeOnline")) {
                    handleOnlineUsers(pwc, split);
                } else if (cmd.equals("quit")) {
                    quit();
                    return;
                } else if (cmd.equals("seeUserProfile")) {
                    handleViewUserProfile(pwc);
                } else if (cmd.equals("sendRequestTo")) {
                    handleFriendRequestSending(pwc, split);
                } else if (cmd.equals("createProfile")) {
                    handleProfileCreation(pwc, bfrc);
                } else if (cmd.equals("sendDM")) {
                    pwc.println("Warning: Your message will only be sent if the user is also online");
                    pwc.flush();

                    pwc.println("Who do you want to send a disappearing message to?");
                    pwc.flush();
                    String userTo = bfrc.readLine();
                    int ind = findUser(userTo);
                    if (ind != -1) {
                        if (checkOnline(userTo)) {
                            pwc.println("What is your message?");
                            pwc.flush();
                            String message = bfrc.readLine();
                            handleDisappearingMsg(userTo, message);
                        } else {
                            pwc.println("This user is not online");
                            pwc.flush();
                        }
                    } else {
                        pwc.println("Invalid username");
                        pwc.flush();
                    }
                } else if (cmd.equals("startChat")) {
                    handleStartChat();
                } else if (cmd.equals("viewOtherUsers")) {
                    handleViewOtherUserProfile(pwc, split);

                } else if (cmd.equals("changePassword")) {
                    handleChangePassword(pwc, split);
                } else if (cmd.equals("seeFriendRequests")) {
                    this.userIndex = findUser(usn);
                    if (users.get(userIndex).getFriendRequests() != null) {
                        int size = countPendingRequest(users.get(userIndex).getFriendRequests());
                        if (size > 0) {
                            handleFriendRequestReceiving(pwc, bfrc, "FriendList.txt");
                        } else {
                           /* pw.println("You have no pending friend requests");
                            pw.flush();*/
                        }
                    }
                } else if (cmd.equals("closeFriendRequestReceiving")) {
                    closeFriendRequestReceiving(pwc);
                } else if (cmd.equals("viewAllFriends")) {
                    viewAllFriends(pwc, "FriendList.txt");
                } else if (cmd.equals("accept")) {
                    accept(pwc, bfrc, "FriendList.txt");
                } else if (cmd.equals("reject")) {
                    reject(pwc, bfrc, "FriendList.txt");
                } else if (cmd.equals("seeMyFriendRequests")) {
                    viewMyRequests(pwc, "FriendList.txt");
                } else if (cmd.equals("checkStatus")) {
                    checkStatus("FriendList.txt", bfrc, pwc);
                } else if (cmd.equals("addFriendRequest")) {
                    handleAddFriendRequest(bfrc);
                } else if (cmd.equals("rescind")) {
                    rescind(pwc);
                } else if (cmd.equals("checkOnline")) {
                    checkOnlineStatus(pwc, split);
                } else if (cmd.equals("checkIfTheUserExists")) {
                    checkIfTheUserExists(pwc, split);
                } else if (cmd.equals("closeFriendList")) {
                    closeFriendList(pwc);
                } else {
                    pwc.println("Unknown Command: " + cmd);
                    pwc.flush();
                }
                line = bfrc.readLine();
            }
            clientSocket.close();
//        } end synchronized
        } catch (SocketException s) {
            quit();
        }
    }

    /**
     * Sends the client information to exit the Requests tab.
     *
     * @param pw
     */
    public synchronized void closeFriendList(PrintWriter pw) {
        ArrayList<String> temp = serverInitializer.getViewFriendListUsers();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals(this.usn)) {
                temp.remove(i);
                break;
            }
        }
        serverInitializer.setViewFriendListUsers(temp);
        pw.println("stop");
        pw.flush();
    }


    /**
     * Checks if the user exists.
     *
     * @param pw
     * @param split
     */
    public void checkIfTheUserExists(PrintWriter pw, String[] split) {
        boolean userExists = false;
        try {
            File f = new File("UsersDetails.txt");
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            if (f.length() > 0) {
                String line = bfr.readLine();
                while (line != null && !line.equals("")) {
                    String[] info = line.split(" ");
                    String username = info[2];
                    if (username.equals(split[1])) {
                        userExists = true;
                    }
                    line = bfr.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userExists) {
            pw.println("Exists");
            pw.flush();
        } else {
            pw.println("Not");
            pw.flush();
        }
    }


    /**
     * Changes the password of this user.
     *
     * @param pw
     * @param split
     */
    private void handleChangePassword(PrintWriter pw, String[] split) {

        if (split[1].equals(users.get(userIndex).getPassword())) {
            users.get(userIndex).setPassword(split[2]);
            pw.println("Password successfully updated!");
            pw.flush();
            printInfoToFile("UsersDetails.txt", "FriendList.txt");
        } else {
            pw.println("Make sure you enter the correct old password");
            pw.flush();
        }

    }

    private void handleStartChat() {
        pwc.println("Warning: This feature will only work if the other user is also online!");
        pwc.println("Who do you want to chat with?");
        pwc.flush();
        String userTo = "";
        try {
            userTo = bfrc.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int userToIndex = findUser(userTo);


        if (userToIndex != -1) {
            users.get(userToIndex).getMessageReq().add(users.get(userIndex));
            List<ServerThread> clientList = serverInitializer.getClientList();
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getUsername().equals(userTo)) {
                    clientList.get(i).send(this.usn +
                            "wants to chat with you!\nUse command: viewChats to check");
                }
            } //end for
        }
    }


    public void openChat(String userTo) {
        pwc.println("sds");
        pwc.flush();
        String message = null;
        try {
            message = bfrc.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (message != null) {
            List<ServerThread> clientList = serverInitializer.getClientList();
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getUsername().equals(userTo)) {
                    if (!message.equals("exit")) {
                        clientList.get(i).send(">" + message);
                    } else {
                        clientList.get(i).send(this.usn +
                                " has exited the chat\nReturning to homepage...");
                        clientList.get(i).printLoginMenu();
                    }
                }
            }
            try {
                message = bfrc.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean checkOnline(String user) {
        int count = 0;
        List<ServerThread> clientList = serverInitializer.getClientList();
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getUsername().equals(user)) {
                count++;
            }
        }

        return !(count == 0);
    }

    private void handleDisappearingMsg(String userTo, String message) {
        List<ServerThread> clientList = serverInitializer.getClientList();
        int index = findUser(usn);
        String output = "From " + this.fName + " " + this.lName + "\n" + message;

        int count = 0;
        if (index != -1) {
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getUsername().equals(userTo)) {
                    clientList.get(i).send(output);
                    count++;
                }
            }

            if (count == 0) {
                pwc.println("Message could not be sent: This user is not online");
            }
        } else {
            pwc.println("This user does not exist");
            pwc.flush();
        }
    }

    /**
     * Check's the user's credentials before logging them in.
     *
     * @param pw
     * @param split
     * @throws IOException
     */
    public void handleLogin(PrintWriter pw, String[] split) throws IOException {

        boolean loginStatus = false;
        boolean userLoggedIn = false;

        if (split.length == 3) {
            String username = split[1];
            String password = split[2];
            try {
                Login l = new Login();
                if (l.checkCredentials(username, password)) {
                    this.setUsername(username);
                    userIndex = findUser(username);
                    this.fName = users.get(userIndex).getFirstName();
                    this.lName = users.get(userIndex).getLastName();
                    pw.println("Login successful");
                    pw.flush();
                } else {
                    pw.println("****** Error logging in! ******");
                    pw.flush();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Creates a new user object
     *
     * @param pw
     * @param split
     */
    private void handleCreateAccount(PrintWriter pw, String[] split) {


        if (split.length == 5) {
            String username = split[1];
            String password = split[2];
            String firstName = split[3].replaceAll("`", " ");
            String lastName = split[4].replaceAll("`", " ");
            String fileName = "UsersDetails.txt";

            boolean validUserName = true;

            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername())) {
                    validUserName = false;
                }
            }

            if (validUserName) {
                User u = new User(firstName, lastName, username, password);
//            u.writeUser(fileName);
                this.setUsername(username);
                users.add(u);
                printInfoToFile("UsersDetails.txt", "FriendList.txt");


                pw.println("Account created successfully!");
                pw.flush();
            } else {
                pw.println("This username is already taken. Please try again with a different username");
                pw.flush();
            }
        }

    }

    /**
     * Deletes this user's account.
     *
     * @param pw
     * @param split
     * @throws FileNotFoundException
     */
    public void handleDelete(PrintWriter pw, String[] split) throws FileNotFoundException {

        if (split[1].equals(users.get(userIndex).getPassword())) {


            if (findUser(usn) != -1) {
                deleteFriendAndRequests(usn);
//                Login l = new Login();
//                l.deleteAccount(username);
                users.remove(userIndex);
                printInfoToFile("UsersDetails.txt", "FriendList.txt");
                pw.println("Account deleted successfully");
                pw.flush();
            }

        } else {
            pw.println("Make sure you enter the correct password");
            pw.flush();
        }
    }

    /**
     * Writes all the users from the users ArrayList to the client.
     *
     * @param pw
     * @param split
     * @throws FileNotFoundException
     */
    public void handleAllUsers(PrintWriter pw, String[] split) throws FileNotFoundException {
        StringBuffer sbf = new StringBuffer();

        if (users.size() > 1) {
            for (int i = 0; i < users.size(); i++) {
                if (!users.get(i).getUsername().equals(this.usn)) {
                    if (i == users.size() - 1) {
                        sbf.append(users.get(i).getFirstName().replaceAll(" ", "`") +
                                " " + users.get(i).getUsername() + " " +
                                users.get(i).getLastName().replaceAll(" ", "`"));
                    } else {
                        sbf.append(users.get(i).getFirstName().replaceAll(" ", "`") +
                                " " + users.get(i).getUsername() + " " +
                                users.get(i).getLastName().replaceAll(" ", "`") + "]");
                    }
                }
            }
        } else {
            sbf.append("No users found");
        }

        pw.println(sbf.toString());
        pw.flush();
    }


    public void handleOnlineUsers(PrintWriter pw, String[] split) {

        if (split.length == 1) {
            List<ServerThread> clientList = serverInitializer.getClientList();
            for (int i = 0; i < clientList.size(); i++) {
                String onlineUsers = clientList.get(i).getUsername();
                String sendToClient = "";
                for (int k = 0; k < users.size(); k++) {
                    if (users.get(k).getUsername().equals(clientList.get(i).getUsername())) {
                        sendToClient = users.get(k).getFirstName() + " " + users.get(k).getLastName();
                        if (!usn.equals(clientList.get(i).getUsername())) {
//                            this.send(sendToClient);
                        }
                    }
                }
                for (int j = 0; j < users.get(userIndex).getFriendList().size(); j++) {

                    String checkUsn = users.get(userIndex).getFriendList().get(j).getUsername();
                    
                    if (checkUsn.equals(clientList.get(i).getUsername())) {
                        this.send(sendToClient);
                    }
                }
            }
        }
    }

    /**
     * Checks if a user is online or offline.
     *
     * @param pw
     * @param split
     */
    public void checkOnlineStatus(PrintWriter pw, String[] split) {
        String userSelected = split[1];
        int count = 0;
        List<ServerThread> clientList = serverInitializer.getClientList();
        for (int i = 0; i < clientList.size(); i++) {
            String onlineUser = clientList.get(i).getUsername();
            String sendToClient = "";
            if (onlineUser != null && onlineUser.equals(userSelected)) {
                sendToClient = "online";
                pw.println(sendToClient);
                pw.flush();
//                    this.send(sendToClient);
                count++;
                break;
            }
        }
        if (count == 0) {
//                this.send("offline");
            pw.println("offline");
            pw.flush();
        }
    }

    /**
     * Logs the user out and closes the connection.
     */
    public void quit() {

        ArrayList<ServerThread> clientList = serverInitializer.getClientList();
        int index = -1;
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i) != null && this.usn != null) {
                if (clientList.get(i).getUsername() != null && clientList.get(i).getUsername().equals(usn)) {
                    index = i;
                    //clientList.remove(i);
                    clientList.get(i).setUsername(null);
                }
            }
        }
        if (index != -1) {
            clientList.remove(index);
            serverInitializer.setClientList(clientList);
        }
    }

    /**
     * Finds the desired friend request in the friendRequests arraylist
     *
     * @param userFrom
     * @param userTo
     * @return index of this friend request in the friendrequests arraylist
     */
    public int findFriendRequests(String userFrom, String userTo) {

        int returnVal = -1;

        for (int i = 0; i < fRequests.size(); i++) {
            if (fRequests.get(i).getUserFrom().getUsername().equals(userFrom) &&
                    fRequests.get(i).getUserTo().getUsername().equals(userTo)) {
                returnVal = i;
            }
        }

        return returnVal;
    }

    /**
     * Creates the profile of this user.
     *
     * @param pw
     * @param bfr
     */
    private void handleProfileCreation(PrintWriter pw, BufferedReader bfr) {
        try {
            String firstName = bfr.readLine();

            String lastName = bfr.readLine();

            String email = bfr.readLine();


            String contact = bfr.readLine();


            String hobbies = bfr.readLine();


            String aboutMe = bfr.readLine();

            users.get(userIndex).setFirstName(firstName);
            users.get(userIndex).setLastName(lastName);
            users.get(userIndex).setEmail(email);
            users.get(userIndex).setContact(contact);
            users.get(userIndex).setHobbies(hobbies);
            users.get(userIndex).setAboutMe(aboutMe);
            pw.println("Profile information successfully updated!");
            pw.flush();
            printInfoToFile("UsersDetails.txt", "FriendList.txt");

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    /**
     * Checks the relationship status between two users. (if friends or not)
     *
     * @param friendListFilename
     * @param bfr
     * @param pw
     * @throws IOException
     */
    public void checkStatus(String friendListFilename, BufferedReader bfr, PrintWriter pw) throws IOException {

        String sentFromClient = bfr.readLine();
        String sendToClient = "Status:Send-Request";

        File f = new File(friendListFilename);
        BufferedReader bfr2 = new BufferedReader(new FileReader(f));

        this.fRequests = new ArrayList<>();
        this.fList = new ArrayList<>();

        String line = bfr2.readLine();
        while (line != null && !line.equals("")) {
            String[] firstSplit = line.split(" ");
            String username = firstSplit[0];
            String friends = firstSplit[1].substring(1, firstSplit[1].length() - 1);
            String friendRequests = firstSplit[2].substring(1, firstSplit[2].length() - 1);
            int currentUserIndex = findUser(username);
            if (!friends.equals("")) {
                String[] friendUserNames = friends.split(",");
                ArrayList<User> friendList = new ArrayList<>();
                for (int i = 0; i < friendUserNames.length; i++) {
                    int currentFriendIndex = findUser(friendUserNames[i]);

                    if (friendUserNames[i].equals(sentFromClient) && username.equals(this.usn)) {
                        sendToClient = "Status:Friends";
                    }
                }
            }

            if (!friendRequests.equals("")) {
                String[] friendRequestNames = friendRequests.split(",");
                ArrayList<FriendRequest> friendRequestList = new ArrayList<>();
                for (int i = 0; i < friendRequestNames.length; i++) {
                    int currentRequestIndex = findUser(friendRequestNames[i]);

                    if (friendRequestNames[i].equals(sentFromClient) && username.equals(this.usn)) {
                        sendToClient = sentFromClient + ":Pending-friend";
                    }
                    if (friendRequestNames[i].equals(this.usn) && username.equals(sentFromClient)) {
                        sendToClient = sentFromClient + ":Pending-you";
                    }
                }
            }

            line = bfr2.readLine();
        }

        bfr2.close();

        pw.println(sendToClient);
        pw.flush();
    }

    /**
     * Creates a friendRequest object and updates the receiving user's friend request arrayList.
     *
     * @param pw
     * @param info
     * @throws IOException
     */
    public void handleFriendRequestSending(PrintWriter pw, String[] info) throws IOException {


        String recipientUserName = "";
        if (info.length == 2) {
            recipientUserName = info[1];
        }
        int userToIndex = findUser(recipientUserName);

        String senderFirstName = "";
        String senderLastName = "";
        String senderUserName = "";

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(usn)) {
                senderFirstName = users.get(i).getFirstName();
                senderLastName = users.get(i).getLastName();
                senderUserName = users.get(i).getUsername();
            }
        }
        if (userIndex != -1) {
            FriendRequest fr = new FriendRequest(users.get(userIndex), users.get(userToIndex));
            users.get(userToIndex).getFriendRequests().add(fr);

            List<ServerThread> clientList = serverInitializer.getClientList();
            for (int i = 0; i < clientList.size(); i++) {
                String recipientMessage = "New-" + senderUserName;
                if (clientList.get(i).getUsername() != null) {
                    if (clientList.get(i).getUsername().equals(recipientUserName)) {
                        //clientList.get(i).send(recipientMessage);
                    }
                }
            }

            fRequests.add(fr);
            pw.println("Friend Request successfully sent to " + users.get(userToIndex).getFirstName() + "!");
            pw.flush();
            printInfoToFile("UsersDetails.txt", "FriendList.txt");
        } else {
            pw.println("User not found!");
            pw.flush();
        }
    }

    /**
     * Adds friend request to the user’s friend request arrayList and sends this
     * information to the client so the GUI can be updated.
     *
     * @param bfr
     * @throws IOException
     */
    public void handleAddFriendRequest(BufferedReader bfr) throws IOException {
        String userFrom = bfr.readLine();
        User usFrom = null;
        User usTo = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(userFrom)) {
                usFrom = users.get(i);
            }
            if (users.get(i).getUsername().equals(this.usn)) {
                usTo = users.get(i);
            }
        }
        FriendRequest fr = new FriendRequest(usFrom, usTo);
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getFriendRequests().size(); j++) {
            }
        }
        fRequests.add(fr);
    }

    /**
     * Sends the client information about their incoming friend requests.
     *
     * @param pw
     * @param bfr
     * @param friendListFilename
     * @throws IOException
     */
    public void handleFriendRequestReceiving(PrintWriter pw, BufferedReader bfr, String friendListFilename)
            throws IOException {

        File f = new File(friendListFilename);

        int size = users.get(userIndex).getFriendRequests().size();
        String display = (size > 1) ? "friend requests" : "friend request";
        String display2 = (size > 1) ? "them" : "it";

        final ArrayList<FriendRequest> friendRequests = users.get(userIndex).getFriendRequests();
        for (int i = 0; i < friendRequests.size(); i++) {
            if (friendRequests.get(i).getStatus().equals("pending")) {
                pw.println(friendRequests.get(i).getUserFrom().getUsername() + ":"
                        + friendRequests.get(i).getUserFrom().getFirstName().replaceAll(" ", "`") + " "
                        + friendRequests.get(i).getUserFrom().getLastName().replaceAll(" ", "`"));
                pw.flush();
            }
        }
    }

    /**
     * Sends the client information to exit the Requests tab.
     *
     * @param pw
     */
    public void closeFriendRequestReceiving(PrintWriter pw) {
        pw.println("stop");
        pw.flush();
    }


    /**
     * Accepts a friend request and adds both users to each other's friendList.
     *
     * @param pw
     * @param bfr
     * @param friendListFilename
     * @throws IOException
     */
    public synchronized void accept(PrintWriter pw, BufferedReader bfr, String friendListFilename) throws IOException {
        // Below code is just sample, implement with the JList you are using for pending requests.
        boolean rescinded = true;
        String userFrom = bfr.readLine();
        // Above code is just sample, implement with the JList you are using for pending requests.

        fRequests = new ArrayList<>();

        File f = new File(friendListFilename);
        BufferedReader bfr2 = new BufferedReader(new FileReader(f));

        ArrayList<FriendRequest> friendRequestList = new ArrayList<>();

        String line = bfr2.readLine();
        while (line != null && !line.equals("")) {
            String[] firstSplit = line.split(" ");
            String username = firstSplit[0];
            String friends = firstSplit[1].substring(1, firstSplit[1].length() - 1);
            String friendRequests = firstSplit[2].substring(1, firstSplit[2].length() - 1);
            int currentUserIndex = findUser(username);

            if (!friendRequests.equals("")) {
                String[] friendRequestNames = friendRequests.split(",");

                for (int i = 0; i < friendRequestNames.length; i++) {
                    int currentRequestIndex = findUser(friendRequestNames[i]);

                    if (currentRequestIndex != -1) {

                        FriendRequest fReq = new FriendRequest(users.get(currentRequestIndex),
                                users.get(currentUserIndex));
                        friendRequestList.add(fReq);
                        this.fRequests.add(fReq);
                    }
                }
            }

            line = bfr2.readLine();
        }
        bfr2.close();

        int userFromIndex = findUser(userFrom);

        int friendRequestIndex = -1;

        // int friendRequestIndex = findUser(userFrom);
        for (int i = 0; i < fRequests.size(); i++) {
            if (fRequests.get(i).getUserFrom().getUsername().equals(users.get(userFromIndex).getUsername())
                    && fRequests.get(i).getUserTo().getUsername().equals(users.get(userIndex).getUsername())) {
                friendRequestIndex = i;
                rescinded = false;
                break;
            }
        } //end for

        if (!rescinded) {
            fRequests.get(friendRequestIndex).accept();
            users.get(userIndex).getFriendList().add(fRequests.get(friendRequestIndex).getUserFrom());
            fRequests.get(friendRequestIndex).getUserFrom().getFriendList().add(users.get(userIndex));

            for (int i = 0; i < fRequests.get(friendRequestIndex).getUserTo().getFriendRequests().size(); i++) {
                
                User u = fRequests.get(friendRequestIndex).getUserTo();
                
                if (u.getFriendRequests().get(i).getUserTo().getUsername().equals(users.get(userIndex).getUsername())) {
                    fRequests.get(friendRequestIndex).getUserTo().getFriendRequests().remove(i);
                }
            }

            printInfoToFile("UsersDetails.txt", "FriendList.txt");

            pw.println("accepted");
            pw.flush();

            for (int i = 0; i < serverInitializer.getClientList().size(); i++) {
                for (int j = 0; j < serverInitializer.getViewFriendListUsers().size(); j++) {
                    if (serverInitializer.getClientList().get(i).getUsername() != null &&
                            serverInitializer.getViewFriendListUsers().get(j) != null) {
                        
                        String checkUsn = serverInitializer.getClientList().get(i).getUsername();
                        
                        if (checkUsn.equals(serverInitializer.getViewFriendListUsers().get(j))) {
                            serverInitializer.getClientList().get(i).send("Friend Added");
                            break;
                            //pw.flush();
                        }
                    }
                }
            }


            /**
             * After this implement some code, so that the list item is removed since the friend request is completed.
             * If you want, you can add this to the received friend requests list.
             */
        } else {
            pw.println("Friend request has been rescinded!");
            pw.flush();
        }


        //handleFriendRequestReceiving(pw,bfr);
    }

    /**
     * Rejects the specific friend request.
     *
     * @param pw
     * @param bfr
     * @param friendListFilename
     * @throws IOException
     */
    public synchronized void reject(PrintWriter pw, BufferedReader bfr, String friendListFilename) throws IOException {
        // Below code is just sample, implement with the JList you are using for pending requests.

        // Above code is just sample, implement with the JList you are using for pending requests.


        boolean rescinded = true;
        String userFrom = bfr.readLine();


        File f = new File(friendListFilename);
        BufferedReader bfr2 = new BufferedReader(new FileReader(f));

        this.fRequests = new ArrayList<>();

        String line = bfr2.readLine();
        while (line != null && !line.equals("")) {
            String[] firstSplit = line.split(" ");
            String username = firstSplit[0];
            String friends = firstSplit[1].substring(1, firstSplit[1].length() - 1);
            String friendRequests = firstSplit[2].substring(1, firstSplit[2].length() - 1);
            int currentUserIndex = findUser(username);

            if (!friendRequests.equals("")) {
                String[] friendRequestNames = friendRequests.split(",");
                ArrayList<FriendRequest> friendRequestList = new ArrayList<>();
                for (int i = 0; i < friendRequestNames.length; i++) {
                    int currentRequestIndex = findUser(friendRequestNames[i]);

                    if (currentRequestIndex != -1) {
                        FriendRequest fReq = new FriendRequest(users.get(currentRequestIndex),
                                users.get(currentUserIndex));
                        friendRequestList.add(fReq);
                        this.fRequests.add(fReq);
                    }
                }
            }

            line = bfr2.readLine();
        }
        bfr2.close();

        int userFromIndex = findUser(userFrom);
        int friendRequestIndex = -1;
        for (int i = 0; i < fRequests.size(); i++) {
            if (fRequests.get(i).getUserFrom() == users.get(userFromIndex)
                    && fRequests.get(i).getUserTo() == users.get(userIndex)) {
                friendRequestIndex = i;
                rescinded = false;
            }
        } //end for

        if (!rescinded) {

            fRequests.get(friendRequestIndex).reject();

            for (int i = 0; i < fRequests.get(friendRequestIndex).getUserTo().getFriendRequests().size(); i++) {
                
                User u = fRequests.get(friendRequestIndex).getUserTo();
                
                if (u.getFriendRequests().get(i).getUserTo().getUsername().equals(users.get(userIndex).getUsername())) {
                    fRequests.get(friendRequestIndex).getUserTo().getFriendRequests().remove(i);
                }
            }
            printInfoToFile("UsersDetails.txt", "FriendList.txt");
            /**
             * After this implement some code, so that the list item is removed since the friend request is completed.
             * If you want, you can add this to the received friend requests list.
             */
            pw.println("rejected");
            pw.flush();
        } else {
            pw.println("Friend request has been rescinded!");
            pw.flush();
        }

        //handleFriendRequestReceiving(pw,bfr);
    }

    /**
     * Rescinds a specific request.
     *
     * @param pw
     * @throws IOException
     */
    public synchronized void rescind(PrintWriter pw) throws IOException {
        // Below code is just sample, implement with the JList you are using for pending requests.

        // Above code is just sample, implement with the JList you are using for pending requests.

        boolean rescinded = true;

        String userTo = bfrc.readLine();

        int friendRequestIndex = findFriendRequests(usn, userTo);
        int userToIndex = findUser(userTo);
        int index = -1;
        if (userToIndex != -1) {
            for (int i = 0; i < users.get(userToIndex).getFriendRequests().size(); i++) {
                if (users.get(userToIndex).getFriendRequests().get(i).getUserFrom().getUsername().equals(usn)) {
                    index = i;
                    rescinded = false;
                }
            }
        }

        if (!rescinded) {
            if (index != -1) {
                users.get(userToIndex).getFriendRequests().remove(index);
                pw.println("cancelled");
                pw.flush();
            }

            printInfoToFile("UsersDetails.txt", "FriendList.txt");

        } else {

            boolean alreadyFriends = false;

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(usn)) {
                    ArrayList<User> friends = new ArrayList<>();
                    friends = users.get(i).getFriendList();
                    for (int j = 0; j < friends.size(); j++) {
                        if (friends.get(j).getUsername().equals(userTo)) {
                            alreadyFriends = true;
                        }
                    }
                }
            }

            if (alreadyFriends) {
                pw.println("cannot rescind request friends");
                pw.flush();
            } else {
                pw.println("cannot rescind request not friends");
                pw.flush();
            }
        }

        /**
         * After this implement some code, so that the list item is removed since the friend request is completed.
         * If you want, you can add this to the received friend requests list.
         */

    }
}
