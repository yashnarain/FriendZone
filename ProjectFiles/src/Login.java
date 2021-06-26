import java.io.*;
import java.util.ArrayList;

/**
 * Allows the logged in user to change their password.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class Login extends Thread {

    private final ArrayList<User> users; // The list of users who have created accounts already
    private final String userFilename = "UsersDetails.txt"; // The name of the file which stores user data

    /**
     * Reads the data from the UsersDetails.txt file and stores it as user objects in the users arraylist
     */

    public Login() throws FileNotFoundException {
        this.users = new ArrayList<>();
        File f = new File(userFilename);
        FileReader fr1 = new FileReader(f);
        BufferedReader bfr1 = new BufferedReader(fr1);
        try {
            String line = bfr1.readLine();
            while (line != null) {
                String[] splitUser = line.split(" ");
                if (splitUser[0] != null || splitUser[1] != null || splitUser[2] != null || splitUser[3] != null) {
                    User u = new User(splitUser[0],
                            splitUser[1].replaceAll("`", " "),
                            splitUser[2].replaceAll("`", " "),
                            splitUser[3].replaceAll("`", " "),
                            splitUser[4].replaceAll("`", " "),
                            splitUser[5].replaceAll("`", " "),
                            splitUser[6].replaceAll("`", " "),
                            splitUser[7].replaceAll("`", " "));
                    users.add(u);
                }
                line = bfr1.readLine();
            }

            bfr1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks if the username and password entered at login are correct or not and returns a boolean
     */
    public boolean checkCredentials(String userName, String password) {

        boolean userValidated = false;
        for (User u : users) {
            if (u.getUsername().equals(userName) && u.getPassword().equals(password)) {
                userValidated = true;
                break;
            }
        }
        return userValidated;
    }

    /**
     * Deletes accounts
     */
    public boolean deleteAccount(String userName) {
        boolean successfullyDeleted = false;
        int indexToBeRemoved = 0;

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(userFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getUsername().equals(userName)) {
                indexToBeRemoved = 1;
                successfullyDeleted = true;
            } else {
                pw.println(u.getFirstName() + " " + u.getLastName() + " " + u.getUsername() + " " + u.getPassword() +
                       " " + u.getEmail() + " " + u.getContact() + " " + u.getHobbies() + " " + u.getAboutMe());
            }

        }
        pw.close();

        users.remove(indexToBeRemoved);

        return successfullyDeleted;
    }

    /**
     * lists all users
     */
    public ArrayList<User> listAllUsers(String userName) {
        ArrayList<User> allUsersList = users;
        int indexToBeRemoved = 0;
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getUsername().equals(userName)) {
                indexToBeRemoved = i;
            }
        }
        allUsersList.remove(indexToBeRemoved);
        return allUsersList;
    }

}
