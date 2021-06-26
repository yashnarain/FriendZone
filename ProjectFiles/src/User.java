import java.util.ArrayList;

/**
 * This class stores the user details including first name,
 * last name, username, password, email, contact info,
 * hobbies and interests, about.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String hobbies;
    private String aboutMe;
    private String username;
    private String password;
    private ArrayList<User> friendList;
    private ArrayList<FriendRequest> friendRequests;
    private final ArrayList<User> messageReq;

    /**
     * Creating an Account Constructor
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     */

    /**
     * Constructor to initialize the values when creating account
     */
    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = "unknown";
        this.contact = "unknown";
        this.hobbies = "unknown";
        this.aboutMe = "unknown";
        this.friendList = new ArrayList<>();
        this.friendRequests = new ArrayList<>();
        this.messageReq = new ArrayList<>();
    }

    /**
     * Constructor to initialize the values when editing profile
     */
    public User(String firstName, String lastName, String username, String password, String email, String contact, 
                String hobbies, String aboutMe) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
        this.hobbies = hobbies;
        this.aboutMe = aboutMe;
        this.username = username;
        this.password = password;
        this.friendList = new ArrayList<>();
        this.friendRequests = new ArrayList<>();
        this.messageReq = new ArrayList<>();
    }

    /**
     * Checks if x > 0
     */
    public boolean checkX(int x) {
        return (x > 0);
    }


    /**
     * Returns the first name
     */
    public String getContact() {
        return contact;
    }

    /**
     * set the first name
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Returns the last name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the username
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set the lastname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * sets the hobbies
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * Returns the string getAboutMe
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * sets the string getAboutMe
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    /**
     * gets the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the FriendList
     */
    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }

    /**
     * returns the FriendList
     */
    public ArrayList<User> getFriendList() {
        return friendList;
    }

    /**
     * Sets the friend requests list
     */
    public void setFriendRequests(ArrayList<FriendRequest> friendRequests) {
        this.friendRequests = friendRequests;
    }

    /**
     * Gets the friend requests list
     */
    public ArrayList<FriendRequest> getFriendRequests() {
        return friendRequests;
    }

    /**
     * Gets the MessageReq
     */
    public ArrayList<User> getMessageReq() {
        return messageReq;
    }
}
