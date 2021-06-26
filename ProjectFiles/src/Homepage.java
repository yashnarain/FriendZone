import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

/**
 * The user descriptions can be changed using Edit profile.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class Homepage extends JFrame implements ActionListener {
    public Container content = getContentPane();
    public JButton listButton = new JButton("Friend List");
    public JButton findButton = new JButton("Find Friends");
    public JButton editButton = new JButton("Edit Profile");
    public JButton reqButton = new JButton("Requests");
    public JButton logButton = new JButton("Logout");
    public JButton deleteButton = new JButton("Delete Account");


    public static JLabel about = new JLabel("About: ");
    public static JLabel hobby = new JLabel("Hobbies: ");
    public static JLabel email = new JLabel("Email: ");
    public static JLabel contact = new JLabel("Contact Info: ");
    public static JTextArea fName = new JTextArea(" ");
    public static JLabel nameLabel = new JLabel(" ");
    public static JTextArea aboutText = new JTextArea(" ");
    public static JTextArea hobbyText = new JTextArea(" ");
    public static JTextArea contactText = new JTextArea(" ");
    public static JTextArea emailText = new JTextArea(" ");
    public static JFrame frame = new JFrame("Homepage");
    public static JTextField uname = new JTextField();

    //Fonts
    Font userFont = new Font("Copperplate", Font.PLAIN, 13);
    Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
    Font newFont2 = new Font("Copperplate", Font.PLAIN, 11);
    Font userTFont = new Font("Georgia", Font.PLAIN, 12);
    Font newFont = new Font("Copperplate", Font.BOLD, 24);

    public BufferedReader reader;
    public PrintWriter writer;


    public Homepage(Socket socket) throws IOException {
        serverConnectionInitializer(socket);
        setUserFields();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setUserFields() {
        String sendToServer = "seeUserProfile";
        try {
            writer.write(sendToServer);
            writer.println();
            writer.flush();

            String receivedFromServer = reader.readLine();
            String[] userFields = receivedFromServer.split("]");

            String contactField = (userFields[5].replaceAll("`", " ").equals("unknown")) ?
                    "Add you contact info in the profile window!" : userFields[5].replaceAll("`", " ");
            String emailField = (userFields[4].replaceAll("`", " ").equals("unknown")) ?
                    "Add your email info in the profile window!" : userFields[4].replaceAll("`", " ");
            String hobbiesField = (userFields[6].replaceAll("`", " ").equals("unknown")) ?
                    "We don't know your hobbies yet! Add them in the " +
                            "profile window!" : userFields[6].replaceAll("`", " ");
            String aboutField = (userFields[7].replaceAll("`", " ").equals("unknown")) ?
                    "We don't know anything about you yet! Tell us by updating your info in the " +
                            "profile window!" : userFields[7].replaceAll("`", " ");

            fName.setText("USERNAME: ");

            uname.setText(userFields[0].replaceAll("`", " "));
            nameLabel.setText(userFields[2].replaceAll("`", " ") + " " + userFields[3].replaceAll("`", " "));
            contactText.setText(contactField);
            hobbyText.setText(hobbiesField);
            emailText.setText(emailField);
            aboutText.setText(aboutField);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void serverConnectionInitializer(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    public void setLayoutManager() {
        content.setLayout(null);
    }

    public void setLocationAndSize() {

        //Buttons
        findButton.setBounds(550, 50, 140, 25);
        findButton.setFont(newFont1);
        findButton.setForeground(Color.decode("#FFFFFF"));
        findButton.setBackground(Color.decode("#133DCD"));
        findButton.setOpaque(true);
        findButton.setBorderPainted(false);

        listButton.setBounds(550, 150, 140, 25);
        listButton.setFont(newFont1);
        listButton.setForeground(Color.decode("#FFFFFF"));
        listButton.setBackground(Color.decode("#133DCD"));
        listButton.setOpaque(true);
        listButton.setBorderPainted(false);

        editButton.setBounds(550, 250, 140, 25);
        editButton.setFont(newFont1);
        editButton.setForeground(Color.decode("#FFFFFF"));
        editButton.setBackground(Color.decode("#133DCD"));
        editButton.setOpaque(true);
        editButton.setBorderPainted(false);

        reqButton.setBounds(550, 350, 140, 25);
        reqButton.setFont(newFont1);
        reqButton.setForeground(Color.decode("#FFFFFF"));
        reqButton.setBackground(Color.decode("#133DCD"));
        reqButton.setOpaque(true);
        reqButton.setBorderPainted(false);

        logButton.setBounds(550, 450, 140, 25);
        logButton.setFont(newFont1);
        logButton.setForeground(Color.decode("#FFFFFF"));
        logButton.setBackground(Color.decode("#133DCD"));
        logButton.setOpaque(true);
        logButton.setBorderPainted(false);

        deleteButton.setBounds(550, 550, 140, 25);
        deleteButton.setFont(newFont2);
        deleteButton.setForeground(Color.decode("#FFFFFF"));
        deleteButton.setBackground(Color.decode("#133DCD"));
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);


        //Labels
        nameLabel.setBounds(180, 60, 400, 25);
        nameLabel.setForeground(Color.decode("#eff0f4"));
        nameLabel.setFont(newFont);

        fName.setBounds(40, 122, 400, 100);
        fName.setForeground(Color.WHITE);
        fName.setWrapStyleWord(true);
        fName.setLineWrap(true);
        fName.setOpaque(false);
        fName.setFont(newFont1);

        about.setBounds(40, 420, 400, 100);
        about.setForeground(Color.WHITE);
        about.setOpaque(false);
        about.setFont(newFont1);

        hobby.setBounds(40, 315, 400, 100);
        hobby.setForeground(Color.WHITE);
        hobby.setOpaque(false);
        hobby.setFont(newFont1);

        email.setBounds(40, 160, 300, 50);
        email.setForeground(Color.WHITE);
        email.setOpaque(false);
        email.setFont(newFont1);

        contact.setBounds(40, 240, 300, 50);
        contact.setForeground(Color.WHITE);
        contact.setOpaque(false);
        contact.setFont(newFont1);

        //TextArea
        uname.setBounds(135, 115, 150, 30);
        uname.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        uname.setBackground(Color.decode("#0c1c65"));
        uname.setFont(userTFont);
//        uname.setCaretColor(Color.WHITE);


        emailText.setBounds(40, 200, 300, 30);
        emailText.setWrapStyleWord(true);
        emailText.setLineWrap(true);
        emailText.setOpaque(true);
        emailText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        emailText.setBackground(Color.decode("#0c1c65"));
        emailText.setFont(userTFont);


        aboutText.setBounds(40, 485, 400, 100);
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setOpaque(true);
        aboutText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        aboutText.setBackground(Color.decode("#0c1c65"));
        aboutText.setFont(userTFont);


        hobbyText.setBounds(40, 380, 300, 50);
        hobbyText.setWrapStyleWord(true);
        hobbyText.setLineWrap(true);
        hobbyText.setOpaque(true);
        hobbyText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        hobbyText.setBackground(Color.decode("#0c1c65"));
        hobbyText.setFont(userTFont);

        contactText.setBounds(40, 280, 300, 50);
        contactText.setWrapStyleWord(true);
        contactText.setLineWrap(true);
        contactText.setOpaque(true);
        contactText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        contactText.setBackground(Color.decode("#0c1c65"));
        contactText.setFont(userTFont);
    }

    public void addComponentsToContainer() {

        uname.setEditable(false);
        fName.setEditable(false);
        aboutText.setEditable(false);
        hobbyText.setEditable(false);
        contactText.setEditable(false);
        emailText.setEditable(false);

        content.add(email);
        content.add(contact);
        content.add(hobby);
        content.add(uname);
        content.add(about);
        content.add(listButton);
        content.add(findButton);
        content.add(editButton);
        content.add(reqButton);
        content.add(logButton);
        content.add(aboutText);
        content.add(nameLabel);
        content.add(fName);
        content.add(aboutText);
        content.add(hobbyText);
        content.add(contactText);
        content.add(emailText);
        content.add(deleteButton);
        content.setBackground(Color.decode("#000d53"));

    }

    public void addActionEvent() {
        listButton.addActionListener(this);
        findButton.addActionListener(this);
        editButton.addActionListener(this);
        reqButton.addActionListener(this);
        logButton.addActionListener(this);
        deleteButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == listButton) {
            try {
                FriendList.main(null);
                dispose();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        if (e.getSource() == findButton) {
            try {
                FindFriends.main(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == editButton) {
            try {
                EditProfile.main(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == reqButton) {
            try {
                FriendRequests.main(null);
                dispose();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == logButton) {
            String quit = "quit";

            writer.write(quit);
            writer.println();
            writer.flush();
            dispose();
            Welcome.logout = true;
            try {
                LoginGUI.socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            ThankYou.main(null);
        }

        if (e.getSource() == deleteButton) {


            JPanel panel = new JPanel();

            JLabel label = new JLabel("Enter your password to delete your account");
            label.setForeground(Color.decode("#eff0f4"));
            label.setFont(userFont);

            JPasswordField pass = new JPasswordField(10);
            pass.setForeground(Color.decode("#eff0f4"));
            pass.setBackground(Color.decode("#0c1c65"));
            pass.setFont(userTFont);
            pass.setCaretColor(Color.WHITE);


            panel.add(label);
            panel.add(pass);
            panel.setBackground(Color.decode("#000d53"));
            String[] options = new String[]{"OK", "Cancel"};
            int option = JOptionPane.showOptionDialog(null, panel, "Delete Account",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[1]);
            if (option == 0) // pressing OK button
            {
                pass.setBorder(BorderFactory.createLineBorder(Color.BLUE));

                if (String.valueOf(pass.getPassword()).length() == 0) {
                    pass.setBorder(BorderFactory.createLineBorder(Color.red));
                    JOptionPane.showMessageDialog(null, "Please enter your password to continue", "Change Password",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    char[] password = pass.getPassword();
                    writer.write("delete " + new String(password));
                    writer.println();
                    writer.flush();
                    try {
                        String response = reader.readLine();
                        JOptionPane.showMessageDialog(this, response);
                        if (response.equals("Account deleted successfully")) {
                            LoginGUI.socket.close();
                            LoginGUI.main(null);
                            dispose();
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }

    public void closingX(Homepage frameF) {
        frameF.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frameF,
                        "Are you sure you want to logout?", "Logout",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    writer.write("quit");
                    writer.println();
                    writer.flush();
                    try {
                        LoginGUI.socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    dispose();
                    ThankYou.main(null);
                } else {
                    try {
                        Homepage.main(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Homepage frameF = new Homepage(LoginGUI.socket);
        frameF.closingX(frameF);
        frameF.setTitle("Home");
        frameF.setSize(800, 700);
        frameF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameF.setLocationRelativeTo(null);
        frameF.setResizable(true);
        frameF.setVisible(true);
        frameF.setBackground(Color.decode("#000d53"));
        UIManager uI = new UIManager();
        UIManager.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        UIManager.put("Panel.background", new ColorUIResource(0, 13, 83));
    }
}
