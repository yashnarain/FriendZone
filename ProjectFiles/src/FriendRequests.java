import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Find Friends lets the user see other user’s first and last name using a combo box.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class FriendRequests extends JFrame implements ActionListener {
    public JButton accept = new JButton("Accept");
    public JButton decline = new JButton("Decline");
    public JButton cancel = new JButton("Rescind");
    public JFrame frame = new JFrame("Requests");

    public BufferedReader reader;
    public PrintWriter writer;

    public ArrayList<String> friendsTemp = new ArrayList<>();
    public ArrayList<String> sentTemp = new ArrayList<>();
    public String username;

    private final AtomicBoolean running = new AtomicBoolean(true);
    public Thread t1;

    public String[] friend = {"friend1", "friend2", "friend3", "friend4", "friend5", "friend6",
        "friend7", "friend8", "friend9", "friend10", "friend11", "friend12",
        "friend13", "friend14", "friend15", "friend16", "friend17", "friend18",
        "friend19", "friend20", "friend21", "friend22", "friend23", "friend24",
        "friend25", "friend26", "friend27", "friend28", "friend29", "friend30"};

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> reclist = new JList<>(listModel);
    private DefaultListModel<String> listModel1 = new DefaultListModel<>();
    private JList<String> sentlist = new JList<>(listModel1);

    private static boolean continueRunning;

    /**
     * creates and adds components to the panel. Also sets bounds, font and color for all components
     */
    private void display() {
        //Fonts
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
        Font newFont2 = new Font("Copperplate", Font.PLAIN, 13);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        Font newFont = new Font("Copperplate", Font.BOLD, 24);
        Font micHim = new Font("Microsoft Himalaya", Font.PLAIN, 13);
        Font newFont3 = new Font("Copperplate", Font.PLAIN, 14);
        Font newFont4 = new Font("Copperplate", Font.BOLD, 18);


        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setBackground(Color.decode("#000d53"));

        JPanel panel1 = new JPanel();
        panel1.setBounds(60, 50, 150, 200);
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.decode("#000d53"));
        JScrollPane friendList = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        reclist.setBackground(Color.decode("#0c1c65"));
        reclist.setForeground(Color.WHITE);
        reclist.setFont(newFont2);

        friendList.setViewportView(reclist);
        panel1.add(friendList, BorderLayout.CENTER);
        frame.add(panel1);


        JPanel panel2 = new JPanel();

        panel2.setBounds(340, 50, 150, 200);
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.decode("#000d53"));

        JScrollPane sentReqList = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sentlist.setBackground(Color.decode("#0c1c65"));
        sentlist.setForeground(Color.WHITE);
        sentlist.setFont(newFont2);

        sentReqList.setViewportView(sentlist);
        panel2.add(sentReqList, BorderLayout.CENTER);
        frame.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 250, 600, 30);
        JLabel reqLabel = new JLabel("Received");
        reqLabel.setBounds(90, 10, 100, 25);
        reqLabel.setFont(newFont4);
        reqLabel.setForeground(Color.WHITE);


        JLabel sentLabel = new JLabel("Sent");
        sentLabel.setBounds(390, 10, 100, 25);
        sentLabel.setFont(newFont4);
        sentLabel.setForeground(Color.WHITE);

        accept = new JButton("Accept");
        accept.setBounds(20, 300, 100, 25);
        accept.addActionListener(this::actionPerformed);
        accept.setFont(userFont);
        accept.setForeground(Color.decode("#FFFFFF"));
        accept.setBackground(Color.decode("#133DCD"));
        accept.setOpaque(true);
        accept.setBorderPainted(false);


        decline = new JButton("Decline");
        decline.setBounds(150, 300, 100, 25);
        decline.addActionListener(this::actionPerformed);
        decline.setFont(userFont);
        decline.setForeground(Color.decode("#FFFFFF"));
        decline.setBackground(Color.decode("#133DCD"));
        decline.setOpaque(true);
        decline.setBorderPainted(false);

        cancel = new JButton("Cancel");
        cancel.setBounds(365, 300, 100, 25);
        cancel.addActionListener(this::actionPerformed);
        cancel.setFont(userFont);
        cancel.setForeground(Color.decode("#FFFFFF"));
        cancel.setBackground(Color.decode("#133DCD"));
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);

        panel3.add(accept);
        panel3.add(decline);
//        panel3.add(back);
        panel3.add(cancel);
        panel3.add(reqLabel);
        Color color = Color.decode("#000d53");
        panel3.setBackground(color);
        panel3.add(sentLabel);
        // frame.add(pendingOrAccepted);
        frame.add(panel3);


        frame.setVisible(true);


    }

    /**
     * Constructor to initialize the values
     */
    FriendRequests() throws IOException {

        display();
        continueRunning = true;

        try {
            serverConnectionInitializer();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        writer.write("seeFriendRequests");
        writer.println();
        writer.flush();

        writer.write("seeMyFriendRequests");
        writer.println();
        writer.flush();

        t1 = new Thread(new Runnable() {

            public synchronized void run() {

                listModel.clear();
                listModel1.clear();

                while (true) {
                    try {
                        String output;
                        output = reader.readLine();
                        if (output.equals("stop")) break;
                        if (output.contains(":")) {
                            ArrayList<String> friends = new ArrayList<>();
                            String[] serverResponseSplit = output.split(":");

                            friends.add(serverResponseSplit[1].replaceAll("`", " "));

                            friendsTemp.add(output);
                            for (int i = 0; i < friends.size(); i++) {
                                listModel.addElement(friends.get(i));
                            }
                        } else if (output.contains("]")) {
                            ArrayList<String> friends = new ArrayList<>();
                            String[] serverResponseSplit = output.split("]");
                            friends.add(serverResponseSplit[1].replaceAll("`", " "));
                            sentTemp.add(output);
                            for (int i = 0; i < friends.size(); i++) {
                                listModel1.addElement(friends.get(i));
                            }
                        } else if (output.contains("Friend request has been rescinded!")) {
                            listModel.remove(reclist.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "This friend request has been " +
                                    "rescinded by the sender!", "Error", JOptionPane.ERROR_MESSAGE);

                        } else if (output.contains("accepted")) {
                            listModel.remove(reclist.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "Friend Request Accepted!",
                                    "Accept", JOptionPane.INFORMATION_MESSAGE);

                        } else if (output.contains("rejected")) {
                            listModel.remove(reclist.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "Friend Request Declined!",
                                    "Decline", JOptionPane.INFORMATION_MESSAGE);
                        } else if (output.contains("cancelled")) {
                            listModel1.remove(sentlist.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "Friend Request Cancelled!",
                                    "Cancel", JOptionPane.INFORMATION_MESSAGE);
                        } else if (output.contains("cannot rescind request friends")) {
                            listModel1.remove(sentlist.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "This friend request has been " +
                                    "accepted by the receiver", "Decline", JOptionPane.ERROR_MESSAGE);
                        } else if (output.contains("cannot rescind request not friends")) {
                            listModel1.remove(sentlist.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "This friend request has been " +
                                    "declined by the receiver", "Decline", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        t1.start();
        closingX();

    }

    /**
     * creates the JFrame
     */
    public static void main(String[] args) throws IOException {
        FriendRequests f = new FriendRequests();
        UIManager uI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        UI.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        UI.put("Panel.background", new ColorUIResource(0, 13, 83));
    }

    /**
     * sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
     */
    public void serverConnectionInitializer() throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(LoginGUI.socket.getInputStream()));
        this.writer = new PrintWriter(LoginGUI.socket.getOutputStream());
    }

    /**
     * closes the dialog
     */
    public void closingX() {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                writer.write("closeFriendRequestReceiving");
                writer.println();
                writer.flush();
                dispose();
                try {
                    Homepage.main(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * assigns actions to be performed on clicking each button
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == accept) {
            String userSelected = null;
            userSelected = reclist.getSelectedValue();
            if (userSelected != null) {
                for (int i = 0; i < friendsTemp.size(); i++) {
                    String[] friendsTempSplit = friendsTemp.get(i).split(":");
                    if (friendsTempSplit[1].replaceAll("`", " ").equals(userSelected)) {
                        username = friendsTempSplit[0];
                    }
                }

                int indexToRemove = reclist.getSelectedIndex();


                // code for accepting

                //String userFrom = (String) reclist.getSelectedValue();
                writer.write("accept");
                writer.println();
                writer.flush();
                writer.write(username);
                writer.println();
                writer.flush();


            } else {
                JOptionPane.showMessageDialog(null, "No Request Selected! Try Again!",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == decline) {
            String userSelected = null;
            userSelected = reclist.getSelectedValue();
            // code for declining
            if (userSelected != null) {
                for (int i = 0; i < friendsTemp.size(); i++) {
                    String[] friendsTempSplit = friendsTemp.get(i).split(":");
                    if (friendsTempSplit[1].replaceAll("`", " ").equals(userSelected)) {
                        username = friendsTempSplit[0];
                    }
                }

                int indexToRemove = reclist.getSelectedIndex();

                //String userFrom = (String) reclist.getSelectedValue();
                writer.write("reject");
                writer.println();
                writer.flush();
                writer.write(username);
                writer.println();
                writer.flush();

            } else {
                JOptionPane.showMessageDialog(null, "No Request Selected! Try Again!",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == cancel) {
            String userSelected = null;
            userSelected = sentlist.getSelectedValue();
            if (userSelected != null) {
                for (int i = 0; i < sentTemp.size(); i++) {
                    String[] sentTempSplit = sentTemp.get(i).split("]");
                    if (sentTempSplit[1].replaceAll("`", " ").equals(userSelected)) {
                        username = sentTempSplit[0];
                    }
                }
                int indexToRemove = sentlist.getSelectedIndex();

                //String userFrom = (String) reclist.getSelectedValue();
                writer.write("rescind");
                writer.println();
                writer.flush();
                writer.write(username);
                writer.println();
                writer.flush();

            } else {
                JOptionPane.showMessageDialog(null, "No Request Selected! Try Again!",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
