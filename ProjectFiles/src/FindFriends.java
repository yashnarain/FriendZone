import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The requests are used to view sent and received friend requests.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class FindFriends extends JFrame implements ActionListener {
    public Container container = getContentPane();

    public JButton sendRequestButton = new JButton("Send Request");

    public JButton viewProfileButton = new JButton("View Profile");

    public static String username = "";

    private JFrame frame = new JFrame("Find Friends");

    public final static JComboBox COMBO_BOX = new JComboBox(new Object[] {"A", "B", "C", "D", "E", "F", "G", "H", "I",
        "J", "K", "L", "M", "N", "O", "Q", "R", "S"});
    //shows if online or offline

    public JLabel showPrompt = new JLabel("Select any user from the drop down.");

    public JTextArea showStatus = new JTextArea();

    public JLabel label = new JLabel("");

    public BufferedReader reader;
    public PrintWriter writer;

    public String[] toDisplayInCombo;

    public static String[] users;

    boolean noUsersFound = false;

    /**
     * Constructor to initialize the values
     */
    FindFriends(Socket socket) throws IOException {
        serverConnectionInitializer(socket);
        loadFriendsToComboBox(socket);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        if (!noUsersFound) {
            comboBoxListener();
            checkStatus();
            checkOnlineS();
        }
    }

    /**
     * sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
     */
    public void serverConnectionInitializer(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    /**
     * displays the list of users in the combo box
     */
    public void loadFriendsToComboBox(Socket socket) throws IOException {

        String sendToServer = "seeAll";
        writer.write(sendToServer);
        writer.println();
        writer.flush();
        String receivedFromServer;
        try {
            receivedFromServer = reader.readLine();

            if (receivedFromServer.equals("No users found")) {
                toDisplayInCombo = new String[1];
                toDisplayInCombo[0] = "No other users found!";
                noUsersFound = true;
            } else {

                if (receivedFromServer.contains("]")) {

                    users = receivedFromServer.split("]");
                } else {
                    users = new String[1];
                    users[0] = receivedFromServer;
                }
                toDisplayInCombo = new String[users.length];


                for (int i = 0; i < users.length; i++) {
                    String[] usersSplit = users[i].split(" ");
                    toDisplayInCombo[i] = usersSplit[0].replaceAll("`", " ") + " " +
                            usersSplit[2].replaceAll("`", " ");
                }
            }

            COMBO_BOX.setModel(new DefaultComboBoxModel(toDisplayInCombo));

            return;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * sets the layout to null
     */
    public void setLayoutManager() {
        container.setLayout(null);
        Color color = Color.decode("#000d53");
        container.setBackground(color);
    }

    /**
     * sets location, size, background color and font of the components
     */
    public void setLocationAndSize() {
        COMBO_BOX.setBounds(50, 150, 300, 30);
        COMBO_BOX.setMaximumRowCount(15);
        showPrompt.setBounds(50, 50, 600, 90);
        showStatus.setBounds(400, 150, 150, 50);
        sendRequestButton.setBounds(400, 150, 150, 40);
        viewProfileButton.setBounds(400, 250, 150, 30);
//        onlineStatusButton.setBounds(400, 350, 150, 30);
        label.setBounds(400, 350, 150, 30);

    }

    /**
     * adds all components to the container
     */
    public void addComponentsToContainer() {
        //Fonts
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
        Font newFont2 = new Font("Copperplate", Font.PLAIN, 13);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        Font newFont = new Font("Copperplate", Font.BOLD, 24);
        Font micHim = new Font("Microsoft Himalaya", Font.PLAIN, 13);
        Font newFont3 = new Font("Copperplate", Font.PLAIN, 14);

        showStatus.setEditable(false);

//        comboBox.setBackground(Color.decode("#0c1c65"));
        COMBO_BOX.setForeground(Color.BLACK);
        COMBO_BOX.setFont(newFont2);

        label.setFont(newFont3);
        label.setBackground(Color.decode("#0c1c65"));
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        sendRequestButton.setFont(userFont);
        sendRequestButton.setForeground(Color.decode("#FFFFFF"));
        sendRequestButton.setBackground(Color.decode("#133DCD"));
        sendRequestButton.setOpaque(true);
        sendRequestButton.setBorderPainted(false);

        viewProfileButton.setFont(userFont);
        viewProfileButton.setForeground(Color.decode("#FFFFFF"));
        viewProfileButton.setBackground(Color.decode("#133DCD"));
        viewProfileButton.setOpaque(true);
        viewProfileButton.setBorderPainted(false);

        showStatus.setFont(newFont3);
        showStatus.setForeground(Color.WHITE);
        showStatus.setBackground(Color.decode("#0c1c65"));
        showStatus.setOpaque(true);
        showStatus.setLineWrap(true);
        showStatus.setWrapStyleWord(true);
        showStatus.setAlignmentX(10);

        showPrompt.setForeground(Color.WHITE);
        showPrompt.setFont(newFont);

        container.add(showPrompt);
        container.add(sendRequestButton);
        container.add(viewProfileButton);
//        container.add(onlineStatusButton);
        container.add(COMBO_BOX);
        container.add(showStatus);
        container.add(label);
        label.setVisible(false);
        showStatus.setVisible(false);
    }

    /**
     * adds actionlisteners to the buttons
     */
    public void addActionEvent() {
        sendRequestButton.addActionListener(this);
        viewProfileButton.addActionListener(this);
//        onlineStatusButton.addActionListener(this);
        COMBO_BOX.addActionListener(this);
    }

    /**
     * sets the label to online/offline depending on the user’s status
     */
    public void checkOnlineS() {
        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                String[] usersSplit = users[i].split(" ");
                if (COMBO_BOX.getSelectedItem().toString().equals(usersSplit[0].replaceAll("`", " ")
                        + " " + usersSplit[2].replaceAll("`", " "))) {
                    username = usersSplit[1];
                }
            }
        }
        writer.write("checkOnline " + username + "\n");
        writer.flush();
        String status = null;
        try {
            status = reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        if (status.equals("online")) {
            label.setForeground(Color.GREEN);
        } else {
            label.setForeground(Color.RED);
        }

        label.setText(status);
        label.setVisible(true);
    }

    /**
     * adds an item listener to the combo box
     */
    public void comboBoxListener() {
        COMBO_BOX.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    checkStatus();
                    checkOnlineS();
                }
            }
        });
    }

    /**
     * repaints the GUI
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == sendRequestButton) {
            //send req to server
            if (!noUsersFound) {
                for (int i = 0; i < users.length; i++) {
                    String[] usersSplit = users[i].split(" ");
                    if (COMBO_BOX.getSelectedItem().toString().equals(usersSplit[0].replaceAll("`", " ")
                            + " " + usersSplit[2].replaceAll("`", " "))) {
                        username = usersSplit[1];
                    }
                }

                writer.write("checkIfTheUserExists " + username);
                writer.println();
                writer.flush();

                String response = "";
                try {
                    response = reader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                if (response.equals("Exists")) {

                    String sendToServer = "sendRequestTo " + username;
                    writer.write(sendToServer);
                    writer.println();
                    writer.flush();

                    try {
                        String receivedFromServer = reader.readLine();
                        JOptionPane.showMessageDialog(this, receivedFromServer);
                        if (!noUsersFound) {
                            checkStatus();
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {
                    try {
                        JOptionPane.showMessageDialog(null,
                                "The user you selected doesn't exist anymore",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        loadFriendsToComboBox(LoginGUI.socket);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "No User Found! Try Again!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == viewProfileButton) {
            if (!noUsersFound) {
                // call the profile of user clicked on
                for (int i = 0; i < users.length; i++) {
                    String[] usersSplit = users[i].split(" ");
                    if (COMBO_BOX.getSelectedItem().toString().equals(usersSplit[0].replaceAll("`", " ")
                            + " " + usersSplit[2].replaceAll("`", " "))) {
                        username = usersSplit[1];
                    }
                }

                writer.write("checkIfTheUserExists " + username);
                writer.println();
                writer.flush();

                String response = "";
                try {
                    response = reader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                if (response.equals("Exists")) {
                    try {
                        ViewProfile.main(null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {
                    try {
                        JOptionPane.showMessageDialog(null,
                                "The user you selected doesn't exist anymore",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        loadFriendsToComboBox(LoginGUI.socket);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No User Found! Try Again!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * creates the JFrame
     */
    public static void main(String[] args) throws IOException {
        FindFriends frame = null;
        try {
            frame = new FindFriends(LoginGUI.socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setBounds(10, 10, 620, 500);
        frame.setTitle("Find Friends");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        UIManager uI = new UIManager();
        uI.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        uI.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        uI.put("Panel.background", new ColorUIResource(0, 13, 83));
    }


    /**
     * checks the online/offline status of a user
     */
    public void checkStatus() {
        String sendToServer = "checkStatus";
        writer.write(sendToServer);
        writer.println();
        writer.flush();

        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                String[] usersSplit = users[i].split(" ");
                if (COMBO_BOX.getSelectedItem().toString().equals(usersSplit[0].replaceAll("`", " ") +
                        " " + usersSplit[2].replaceAll("`", " "))) {
                    username = usersSplit[1];
                }
            }
        }

        writer.write(username);
        writer.println();
        writer.flush();

        try {
            String received = reader.readLine();
            if (received.contains(":")) {
                String[] statusSplit = received.split(":");
                if (statusSplit[1].equals("Friends")) {
                    showStatus.setText("You are friends with " + COMBO_BOX.getSelectedItem().toString());
                    sendRequestButton.setVisible(false);
                    showStatus.setVisible(true);
                } else if (statusSplit[1].equals("Pending-friend")) {
                    showStatus.setText("You have a pending request from " + COMBO_BOX.getSelectedItem().toString());
                    sendRequestButton.setVisible(false);
                    showStatus.setVisible(true);
                } else if (statusSplit[1].equals("Pending-you")) {
                    showStatus.setText("You have already sent a request to " + COMBO_BOX.getSelectedItem().toString());
                    sendRequestButton.setVisible(false);
                    showStatus.setVisible(true);
                } else if (statusSplit[1].equals("Send-Request")) {
                    sendRequestButton.setVisible(true);
                    showStatus.setVisible(false);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
