# The FriendZone App
 
## About
Friendzone is one-of-a-kind Java application that allows endless number of users to interact and connect with each other. Users can create their accounts and can find other people of similar interests by viewing their profiles. The users can also customize their own profiles and make them attractive by including their hobbies, interests, and tell everyone about themselves. Furthermore, in this application, users can send requests to other people and connect with them, increasing their reach and widening their social circle. And you can come in and go out at your leisure – the application will remember until you delete your account. Hence, we urge you to use our FriendZone App.
 
## Presentation
https://drive.google.com/file/d/1xN-zu3-1tyjinTf8ApgFrb_xW4ZdhUGX/view?usp=sharing  
**Download the video for better experience**

## Contributors
1. Yash Narain Agarwal
2. Karnika Soni
3. Krishna Tej Bhat
4. Sachintha Imindhu
5. Saisravani Kuchibhotla

## Application Images

![alt text](images/Screenshot%202020-12-06%20at%202.34.01%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.35.36%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.38.13%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.40.00%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.40.33%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.40.50%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.41.12%20PM.png)
![alt text](images/Screenshot%202020-12-06%20at%202.41.33%20PM.png)

## Instructions to run the application

- **Initial Port Number:** 4242  
- **Initial Address:** localhost

### Step 1
- Open IntelliJ and properly clone the repository. Check all files are loaded into their specific directories.
 
### Step 2
- Run the `Server.java` class.

### Step 3
- Edit the configurations of the `Welcome.java` Class to allow **Parallel Run**

### Step 4
- Run the `Welcome.java` class. Each run starts an independent client.

### Step 5
- Enjoy the App and interact real-time with all your friends. Thank you!

## Class & File Documentation
### GUI Structure
All the GUI classes are divided into several separate methods  and the ones below are common for most GUI classes.    
- `setLayoutManager()`     
	- this method is called from constructor to set the layout of the frame’s JPanel to null and change the background color using .decode() method of Color class.  
- `setLocationAndSize() `  
	- this method is called from constructor to set the location of various components like JButton, JLabel, comboBox, JTextArea, JList, etc. This method is responsible for the structure of GUI.  
- `addComponentsToContainer()`      
	- this method is called from constructor to add various components to the main JPanel of Jframe (called container or content depending on the class using the .add() method.  
- `addActionEvent()`  
	- this method is called from constructor to add Action Listeners for each user susceptible control like clicking on buttons, typing in text Area, and other user generated inputs.   
- `actionPerformed (ActionEvent e) `      
	- this method checks for the source of the input and performs a necessary action responding to it. Covered more down. 

### ChangePassword
- Allows the logged in user to change their password. User can update their password by selecting change password and confirming the new password by retyping it in the confirm password JTextField. It will display a JOptionPane success message if the password is updated successfully and an error message if the required fields are missing, the incorrect old password is put, mismatch between new password and confirm password.
	- **Method Description**  
		- `public void serverConnectionInitializer(Socket socket) throws: IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
		- `public void setLayoutManager()`
			- sets the layout to null
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentstoPanel()`
			- adds all components to the content pane
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `public static void main(String[] args) throws: IOException`
			- creates the JFrame  
	- **Testing Description** 
		- **Valid input**
			- The user enters the current password in the first label, followed by the password they want to change it to in the next label. The new password is entered again correctly in the last label. Clicking update password changes the user’s password to the new one and the user can logout and login using it. If the current password is “a” and the new password is “b”, entering “a”, “b” and “b” and clicking on change password will update the password.

		- **Invalid input**
			- If the user enters their current password incorrectly, a dialog that says “Make sure you enter your old password correctly” pops up. If the password in the confirm password label does not match the new password, a dialog that says “make sure your new password and confirmed password matched” pops up. If any field is left blank, an error message prompting the user to fill all fields shows up and the blank label is highlighted in red. Entering only “a”, “b” will show an error dialog.

### CreateAccount
- Prompts the user for firstname, lastname, username and password. Provides 4 options for user to select from, in form of JButtons reset, create, exit, and back. The exit and back buttons have their usual meaning, reset button sets all the text fields which are entered by user to blank or empty strings. The show password checkbox allows user to hid (replace with “\*”) or show their password. The create account button shows a JOptionPane success message if the account is created successfully and an error message if the username is taken or the required fields are missing.

	- **Method Description**
		- `public void serverConnectionInitializer() throws: IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
		- `public void setLayoutManager()`
			- sets the layout to null
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `public void closingX(CreateAccount frame)`
			- prompts a JOptionPane to close the dialog
		- `public static void main(String[] args) throws: IOException`
			- creates the JFrame
	- **Testing Description**
		- **Valid input**
			- The user enters the first name, last name, username and password of their choice. Clicking the create button creates an account with the entered credentials. The user is able to login using these credentials. Clicking on reset clears all text fields. Clicking on the checkbox below password text field shows the characters of the password, they are hidden otherwise. A valid input would be first name – “John”, last name – “Doe”,
		Username – “JDoe” and password - “jd123”.

		- **Invalid input**
			- If any field is left blank an error dialog pops up on clicking create account and the blank field(s) are highlighted in red. Invalid input would be first name – “John”, last name – “Doe”, and leaving the rest blank.

### EditProfile
- The user descriptions can be changed using Edit profile. Provides 3 options for user to select from, in form of JButtons save changes, change password, and delete profile. It includes all the required user fields username, email, contact info, hobbies, and about in the same order. User can select save changes after finishing and the changes are reflected in homepage. User can also update their password by selecting change password and confirming the new password. User can also delete their profile. This will revert all changes and set back to the default text on homepage.
	- **Method Description**
		- `public void serverConnectionInitializer(Socket socket) throws: IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
		- `public void setLayoutManager()`
			- sets the layout to null
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public static void main(String[] args) throws: IOException`
			- creates the JFrame
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
	- **Testing Description**
		- **Valid input**
			- The user can enter information in the first name, last name, email, contact, hobbies and about me fields. Clicking save changes will immediately update this information in real time. 

		- **Invalid input**
			- There is no invalid input for this GUI since the user is free to enter descriptions of their choice. 

### FindFriends
- FindFriends lets the user see other user’s first and last name using a combo box. User can select one person form this drop down menu and then select send request, view profile and see if the selected person is online or offline. The view profile allows the user to view others profile in the same structure as their profile. Send request sends a friend request that can be accepted or declined to the selected user in real time. The green online indicates the user is online and the red title shows offline.
	- **Method Description**
		- `public void serverConnectionInitializer(Socket socket) throws: IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
		- `public void loadFriendsToComboBox(Socket socket) throws: IOException`
			- displays the list of users in the combo box
		- `public void setLayoutManager()`
			- sets the layout to null
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public void checkOnlineS()`
			- sets the label to online/offline depending on the user’s status
		- `public void comboBoxListener()`
			- adds an item listener to the combo box
		- `public Runnable createGui()`
			- repaints the GUI
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `public static void main(String[] args) throws: IOException`
			- creates the JFrame
		- `public void checkStatus()`
			- checks the online/offline status of a user
	- **Testing Description**
		- **Valid input**
			- Clicking any user from the drop-down menu and clicking send request sends a friend request to that user. Clicking view profile displays the selected user’s profile. A label displays the status of the selected user – shows if they are online/offline.

		- **Invalid input**
			- Attempting to send a request to a user multiple times will display a label “You have already sent a request to x” in place of the send request button. If there are no other users in the application, clicking view profile will shows an error message – “No user found! Try again!”.


### FriendList
- The friend list displays all the connected friends in a JList. This list only contains the existing friends or connected users. This does not include any users that have yet to accept the friend request. It has a scroll Pane to ensure that all friends of the user are viewable even if the maximum threshold value of 40 friends is reached.
	- **Method Description**
		- `private void display()`
			- creates and adds components to the panel. Also sets bounds, font and color for all components
		- `public void loadFriends()`
			- adds friends to listModel
		- `public void closingX()`
			- closes the dialog
		- `public void serverConnectionInitializer(Socket socket) throws IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
		- `public static void main(String[] args) throws: IOException`
			- creates the JFrame
		- `public FriendList()`
			- Creates a FriendList object by setting flSocket to LoginGUI.socket, and calling serverConnectionInitializer, display, loadFriends and closingX.

	- **Testing Description**
		- There is no input taken in this GUI as it is display-only. It displays the complete friend list of the user, i.e., people who have accepted requests sent to them.	
		
### FriendRequests
- The requests are used to view sent and received friend requests. The window is divided into two main JPanels to show Received and Sent requests. The received requests sre the ones sent to the user. The user can select them and then select one of two options available Accept or Decline.  Once the user accepts, the user and the selected person become friends automatically, or if declined no connection take place. The user can view their already sent friend requests in the sent panel, where they have the option to cancel it. If the user is selected and the operation of cancelling, accepting and declining is a success a JOptionPane success message appears or an error message appears if no user is selected, mismatch between selected operation and the related Jbuttons. An example of this is when the user selects a sent request and tries to accept their own request.
	- **Method Description**
		- `private void display()`
			- creates and adds components to the panel. Also sets bounds, font and color for all components
		- `public static void main(String[] args) throws IOException`
			- creates the JFrame
		- `public void serverConnectionInitializer() throws IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
		- `public synchronized void run()`
			- updated the friends ArrayList accordingly
		- `public void closingX()`
			- closes the dialog
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `FriendRequests()`
			- creates a FriendRequests object by calling display, and a run method inside it.
	- **Testing Description**
		- **Valid input**
			- Selecting a user from the received list and clicking accept adds them to the user’s friend list. Clicking decline ensures that the two users are not friends. Choosing a user from the sent list and clicking cancel rescinds the friend request. Accepting, declining and rescinding removes the users from the received/sent lists.

		- **Invalid input**
			- If user1 rescinds user2’s request before user2 accepts it, if user2 tries to accept it an error dialog saying “This friend request has been rescinded by the sender” pops up.


### Homepage
- Shows the user their profile up to date. The main window displays the user information username, email, contact info, hobbies, and about in the same order. The title displays the first and last name in Bold. Provides 6 options for user to select from, in form of JButtons Find Friends, Friend List, Edit Profile, Requests, Logout and Delete Account. Find Friends lets the user see other user’s first and last name using a combo box. The friend list displays all the connected friends. The user descriptions can be changed using Edit profile. The requests are used to view sent and received friend requests. The delete account removes the user from FriendZone.
	- **Method Description**
		- `public void setUserFields()`
			- sets contact info, hobbies, email and about me fields to the input from user
		- `public void serverConnectionInitializer() throws IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
		- `public void setLayoutManager()`
			- sets the layout to null
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `public void closingX()`
			- closes the dialog
		- `public static void main(String[] args) throws IOException`
			- creates the JFrame
		- `public Homepage(Socket socket)`
			- Creates a Homepage object by calling serverConnectionInitializer, setLayoutManager, setLocationAndSize, addComponentstoContainer, addActionEvent and setUserFields.
	- **Testing Description**
		- **Valid input**
			- Clicking on any button on the right – Find Friends, Friend List, Edit Profile, Requests, Logout, Delete Account is a valid operation. The buttons are fully functional even if there are no other users on the application yet or if a profile has not been edited yet.

		- **Invalid input**
			- Since this GUI does not take any input, there is no case for invalid input.

### LoginGUI
- Prompts the user for username and password. Provides 4 options for user to select from, in form of JButtons reset, create, exit, and back. The exit and back buttons have their usual meaning, reset button sets all the text fields which are entered by user to blank or empty strings. The show password checkbox allows user to hid (replace with “\*”) or show their password. The login button shows a JOptionPane success message if the login is success with valid credentials or an error message if the required fields are invalid or missing.
	- **Method Description**
		- `public void serverConnectionInitializer() throws IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
		- `public void setLayoutManager()`
			- sets the layout to null
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `public static void main(String[] args) throws IOException`
			- creates the JFrame
		- `LoginGUI()`
			- creates a LoginGUI object by calling serverConnectionInitializer, setLayoutManager, setLocationAndSize, addComponentstoContainer and addActionEvent.
	- **Testing Description**
		- **Valid input**
			- Entering a username and password with which the user created their account, and clicking login takes the user to the home page. As in the create account GUI, the checkbox below the password field can be clicked to display the characters. Clicking on back takes the user to the welcome page and clicking on exit exits the program on confirmation. If a user created their account using username “JDoe” and password “jd123”, entering them in the fields will successfully log in the user.
		- **Invalid input**
			- Leaving either field blank and clicking login will prompt the user to fill all text fields. The blank text fields are highlighted in red. An example of invalid input is entering only “JDoe” in the username field and clicking login. Additionally, entering a username and password that are incorrect, i.e., an account has never been created with those credentials, shows an error dialog saying “Invalid username or password”.

### ThankYou
- Thanks the user with a message “Thank You for using FriendZone”. Shows that the program has come to an end.
	- **Method Description**
		- `public static void main(String[] args) throws IOException`
			- creates the JFrame
		- `protected Void doInBackground()`
			- puts the thread to sleep 
		- `protected void done()`
			- disposes the window
		- `public ThankYou()`
			- Creates a ThankYou object by creating a frame and by calling doInBackground and done
	- **Testing Description**
		- This GUI is display only and shows when the user logs out of the application.

### ViewProfile
- Allows the user to view other profiles. Called from find friends when the view profile button is selected. The first and last names are displayed in bold on top. This includes all the user fields username, email, contact info, hobbies, and about in the same order. 
	- **Method Description**
		- `public void setUserFields()`
			- sets contact info, hobbies, email and about me fields to the input from user
		- `public void serverConnectionInitializer(Socket socket) throws IOException`
			- sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
		- `public void setLayoutManager()`
			- sets the layout to null and background of container
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public static void main(String[] args) throws IOException`
			- creates the JFrame
		- `ViewProfile(Socket socket)`
			- Creates a ViewProfile object by calling serverConnectionInitializer, setLayoutManager, setLocationAndSize, addComponentstoContainer, addActionEvent and setUserFields.

	- **Testing Description**
		- This is a display-only GUI that displays the profile of a selected user.

### Welcome
- Greets the user with “Welcome to FriendZone”. Allows the user to select one of three options shown using JButtons CreateAccount, Login, and Exit.
	- **Method Description**
		- `public void setLayoutManager()`
			- sets the layout to null and background of container
		- `public void setLocationAndSize()`
			- sets location, size, background color and font of the components 
		- `public void addComponentsToContainer()`
			- adds all components to the container
		- `public void addActionEvent()`
			- adds actionlisteners to the buttons
		- `public void actionPerformed(ActionEvent e)`
			- assigns actions to be performed on clicking each button
		- `public void closingX()`
			- closes the dialog
		- `public static void main(String[] args) throws IOException`
			- creates the JFrame
		- `Welcome()`
			- Creates a Welcome object by calling setLayoutManager, setLocationAndSize, addComponentstoContainer, addActionEvent and closingX.

	- **Testing Description**
		- **Valid input**
			- Clicking the “Create” button lets the user create an account, clicking the “Login” button prompts the user to login with existing credentials, and clicking “Exit” exits the application on confirmation.

		- **Invalid input**
			- There is no text input taken in from the user for this GUI and clicking on any button is valid. Therefore, there is no invalid input.


### Manual Testing Documentation for Client-Server classes

	- We have included JUnit tests for return type, modifiers, and class existence.   

	- We are filtering the user input through the GUIs itself and therefore other methods will never receive invalid input. Therefore, the manual testing for the methods in ServerThread methods are documented.
	
	- All invalid user input is being filtered by the GUI itself, so there will be no case where invalid input can infiltrate the ServerThread class.
		- Logging in with invalid credentials will result in an error JOptionPane prompting the user to enter their correct credentials.
		- Logging in/ Creating an account when required fields are left empty will result in a JOptionPane pop-up prompting the user to enter all the details.
		- If a user tries creating an account with a username that has already been taken, then a pop-up message dialog will prompt the user to choose a different username.
		- Change password 
			- Checks are in place to validate the correct old password before the password has been updated. 
			- Checks are also in place to validate if both “new password” and “confirm password” fields have the same input from the user.
			- If the fields are empty, a message dialog will pop up to prompt the user to enter all the details.
		- Friend Requests
			- If a user tries rescinding a friend request that has already been accepted or declined by the receiving user, a message will be displayed informing the current user that the friend request has already been accepted or declined, depending on the situation.
			- If a user tries accepting or declining a friend request that had just been rescinded by the user who had sent that request, a message will be displayed informing the current user that the friend request had just been rescinded.
		- Delete Account
			- If a user deletes their account, and suppose another user is viewing their profile, an error message will pop up informing this other user that the current user’s account has been deleted, and subsequently the find friend’s drop down will be updated.
			- If a user deletes their account, all the current user’s friends’ friend lists will be updated, and any friend request sent by this user will be deleted.


### User
- This class stores the user details including first name, last name, username, password, email, contact info, hobbies and interests, about. Everytime a user creates an account a user object is created and it can be accessed across all the classes in different methods to do the required functionality.  
	- **Method Description**  
		- `User(String firstName, String lastName, String username, String password)`  
			- Constructor to initialize the values when creating account  
		- `User(String firstName, String lastName, String username, String password, String email, String contact, String hobbies, String aboutMe)`  
			- Constructor to initialize the values when editing profile  
		- `checkX(int x)`  
			- Checks if x > 0  
		- `getFirstName()`  
			- Returns the first name  
		- `getLastName()`   
			- Returns the last name   
		- `getUsername()`  
			- Returns the username  
		- `getPassword()`  
			- Returns the password  
		- `getEmail()`  
			- Returns the email  
		- `getContact()`  
			- Returns the contact  
		- `getHobbies()`  
			- Returns the hobbies  
		- `getAboutMe()`  
			- Returns the about me  
		- `getFriendList()`  
			- Returns the friend list  
		- `getFriendRequests()`  
			- Returns the friend requests list  
		- `setFirstName()`  
			- Sets the first name  
		- `setLastName()`  
			- Sets the last name  
		- `setUsername()`  
			- Sets the username  
		- `setPassword()`  
			- Sets the password  
		- `setEmail()`  
			- Sets the email  
		- `setContact()`  
			- Sets the contact  
		- `setHobbies()`  
			- Sets the hobbies  
		- `setAboutMe()`  
			- Sets the about me   
		- `setFriendList()`  
			- Sets the friend list  
		- `setFriendRequests()`  
			- Sets the friend requests list 

### Login
- This methods reads the file  `UsersDetails.txt` and line-by-line and creates an arraylist of user objects for each line with the information that is stored in the line.  
	- **Method Description**   
		- `Login()`  
			- Reads the data from the `UsersDetails.txt` file and stores it as user objects in the users arraylist  
		- `checkCredentials(String userName, String password)`  
			- Checks if the username and password entered at login are correct or not and returns a boolean  

### FriendRequest
- This class creates a FriendRequest object that stores the information about the userFrom, userTo, requestStatus, requestAnswer.   
	- **Method Description**   
		- `getUserFrom()`  
			- Returns the user who sent the request  
		- `getUserTo()`   
			- Returns the user who received the request  
		- `getStatus()`   
			- Returns the status of the request – Pending, Accepted, Rejected   
		- `setStatus(String status)`   
			- Sets the status of the request – Pending, Accepted, Rejected      
		- `accept()`  
			- Changes the status and the acceptOrReject value to 1   
		- `reject()`   
			- Changes the status and the acceptOrReject value to 0   
### Server
- The Server class is the head class among the three – `Server`, `ServerInitializer`, `ServerThread`. It starts the main server for the application by calling the `ServerInitializer` class at `Port 4242`.       

### ServerInitializer
- This class handles collection of different server threads for communication. It creates a thread for each client and adds the thread to a `clientList` arraylist. This allows the client to have an independent function thread.  
	- **Method Description**    
		- `getClientList()`  
			- Returns the clientList arraylist containing all the clients  
		- `getViewFriendListUsers()`  
			- Returns the list of users currently on currently viewing a user’s FriendList  
		- `setViewFriendListUsers()`  
			- Sets the list of users currently on currently viewing a user’s FriendList  
		- `ServerInitializer(int port)`  
			- Initializes the port number  

### ServerThread
- This class handles all the operations for a single client thread. It reads in the command passed from the client and invokes the specific method to perform the desired functionality.  
	- **Method Description**  
		- `readData(String filename)  throws IO Exception`  
			- Read the data from the UsersDetails.txt file. Creates a users ArrayList containing all the information read from the file.  
		- `readFriendList(String filename) throws IO Exception`  
			- Read the data from the FriendList.txt file.  Adds the friends and friend requests to the respective users in the users ArrayList.  
		- `handleConnection(Socket socket) throws IO Exception`  
			- Takes in a socket and reads the command passed by that connection. Invoked the method that is associated with the command that is passed.  
		- `handleCreateAccount(PrintWriter pw, String[] split)`  
			- Reads the command string passed  by the client and creates a user object. Updated the UsersDetails.txt file  
		- `handleLogin(PrintWriter pw, String[] split)`  
			- Takes in the command passed by the client and checks the credentials before logging the user (client) in.  
		- `handleDelete(PrintWriter pw, String[] split)`  
			- Reads the command from the client and removes the user from the users ArrayList. Updates the information in the files.
		- `handleAllUsers(PrintWriter pw, String[] split)`   
			- Writes all the users from the users ArrayList to the client.  
		- `quit()`   
			- Removes the client from the clientList and closes the connection between the client and server.  
		- `handleViewUserProfile(PrintWriter pw)`  
			- Sends the user’s profile to the client.  
		- `handleFriendRequestSending(PrintWriter pw, String[] info)`  
			- Takes a String Array with the user who is supposed to receive the friend request, and sends a friend request from the current user to the specified user. 
		- `handleProfileCreation(PrintWriter pw, BufferedReader bfr)`  
			- Reads in the profile information from the client, adds it into the current user object’s fields and updates the UsersDetails.txt file.  
		- `handleViewOtherUserProfile(PrintWriter pw, String[] split)`  
			- Takes a String Array containing the desired user’s username and sends the client information of that user’s profile information.  
		- `handleChangePassword(PrintWriter pw, String[] split)`  
			- Takes a String Array containing the user’s password, validates it and then updates the new password as desired. Updates the information to the files.   
		- `handleFriendRequestReceiving(PrintWriter pw, BufferedReader bfr, String friendListFilename)`  
			- Sends the client information about their incoming friend requests.  
		- `closeFriendRequestReceiving(PrintWriter pw)`  
			- Sends the client information to exit the Requests tab.  
		- `viewAllFriends(PrintWriter pw, String friendListFilename)`  
			- Sends the client information about all the friends of the current user.  
		- `accept(PrintWriter pw, BufferedReader bfr, String friendListFilename)`  
			- Accepts the selected friend request, and adds both users to each other’s friend lists.  
		- `reject(PrintWriter pw, BufferedReader bfr, String friendListFilename)`  
			- Rejects the selected friend request, and removes the friend request from the receiving user’s friendRequests ArrayList.  
		- `viewMyRequests(PrintWriter pw, String friendListFilename)`  
			- Sends the client information about the user’s pending received friend requests.  
		- `checkStatus(String friendListFilename, BufferedReader bfr, PrintWriter pw) throws IOException`  
			- Checks the relationship between two users (if they are friends or not) and sends the information to the client.  
		- `handleAddFriendRequest(BufferedReader bfr)`  
			- Adds friend request to the user’s friend request arrayList and sends this information to the client so the GUI can be updated.  
		- `rescind(PrintWriter pw)`  
			- Cancels the friend request being sent by the current user to another user.  
		- `checkOnlineStatus(PrintWriter pw, String[] split)`  
			- Checks if a specific user is online or offline.  
		- `checkIfTheUserExists(PrintWriter pw, String[] split)`  
			- Checks if the specific user exists.  
		- `closeFriendList(PrintWriter pw)`  
			- Sends the client a command to exit from the user’s friendList.

### FriendList.txt
- This file stores the information about each user's friendlists and incoming friend requests in the format: `<username> [friends] [requests]` in a new line. It gets updated whenever a user accepts, rejects, or rescinds a request or deletes his/her account.  
### UsersDetails.txt
- This file stores the information about each user's credentials and profile fields in the format: `<first name> <last name> <username> <password> <email> <contact> <hobbies> <aboutMe>` in a new line. It gets updated whenever a user edits the profile, deletes it, changes the password, or deletes the account.

## Instructions to run the application

- **Initial Port Number:** 4242  
- **Initial Address:** localhost

### Step 1
- Open IntelliJ and properly clone the repository. Check all files are loaded into their specific directories.
 
### Step 2
- Run the `Server.java` class.

### Step 3
- Edit the configurations of the `Welcome.java` Class to allow **Parallel Run**

### Step 4
- Run the `Welcome.java` class. Each run starts an independent client.

### Step 5
- Enjoy the App and interact real-time with all your friends. Thank you!

## Buttons 
	
|       Button        | Function |
| :-----------------: | :--------: |
|   Create Account    | Opens the Create Account window allowing you to enter the valid input and create your FriendZone account |
|       Login         | Opens the Login window allowing you to enter your credentials and login to your account, popping up your homepage |
|       Reset         | Clears all the current text fields in the window to blank |
|       Back          | Takes you back to the previous window |
|       Exit          | Exits the application on confirming |
|    Find Friends     | Opens a window containing a drop-down with a list of all the app users |
|    Send Request     | Allows you to send a request to any app user except those you have already sent or are friends with |
|    View Profile     | Allows you to view the profile of any other user |
|    Friend List      | Opens a window showing the current FriendList|
|     Requests        | Opens a window showing your sent and received friend requests |
|      Cancel         | Allows you to cancel any sent friend request which has not been already accepted or declined |
|      Accept         | Adds the sender to your friendlist and vice-versa |
|      Decline        | Rejects the friend request |
|    Edit Profile     | Opens a window where you can modify all your profile content except username and password |
|    Save Changes     | Saves your changes to the Profile to reflect on homepage |
|   Delete Profile    | Deletes your current content to the default welcome input |
|   Change Password   | Opens a window where you can change your password with the correct input and validation |
|      Logout         | Signs you out of your account and closes the application |
|      Delete         | Opens a window to confirm you password. On successful validation, removes your account and your entire history from the database |
