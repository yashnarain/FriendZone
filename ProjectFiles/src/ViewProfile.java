import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ViewProfile
 * <p>
 * Allows the user to view other profiles.
 * Called from find friends when the view profile button is selected.
 * The first and last names are displayed in bold on top.
 * This includes all the user fields username, email, contact info, hobbies, and about in the same order.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class ViewProfile extends JFrame {
    public Container content = getContentPane();
    public JLabel nameLabel = new JLabel("**Name Here**");
    public JTextArea fName = new JTextArea("username: ");
    public JTextArea aboutText = new JTextArea("About Me: I am eager to learn. I am determined.“" +
            "I never give up until I " + "get something right. I get on well with all kinds of people. I am eager to " +
            "learn. I am determined. " +
            "I never give up until I get something right. I get on well with all kinds of people.");
    public JTextArea hobbyText = new JTextArea("Hobbies: Sketching, Gaming");
    public JTextArea contactText = new JTextArea("Contact Info: abc@gmail.com");
    public JTextArea emailText = new JTextArea("Email: abc@gmail.com");

    public static JLabel about = new JLabel("About: ");
    public static JLabel hobby = new JLabel("Hobbies: ");
    public static JLabel email = new JLabel("Email: ");
    public static JLabel contact = new JLabel("Contact Info: ");
    public static JTextField uname = new JTextField();

    public BufferedReader reader;
    public PrintWriter writer;

    ViewProfile(Socket socket) throws IOException {
        serverConnectionInitializer(socket);
        setUserFields();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setUserFields() {
        String sendToServer = "viewOtherUsers " + FindFriends.username;
        try {
            writer.write(sendToServer);
            writer.println();
            writer.flush();

            String receivedFromServer = reader.readLine();

            String[] userFields = receivedFromServer.split("]");
            uname.setText(userFields[0].replaceAll("`", " "));
            this.fName.setText("USERNAME: ");
            this.nameLabel.setText(userFields[2].replaceAll("`", " ") + " " + userFields[3].replaceAll("`", " "));
            this.aboutText.setText(userFields[7].replaceAll("`", " "));
            this.hobbyText.setText(userFields[6].replaceAll("`", " "));
            this.contactText.setText(userFields[5].replaceAll("`", " "));
            this.emailText.setText(userFields[4].replaceAll("`", " "));
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
        Color color = Color.decode("#000d53");
        content.setBackground(color);
    }

    public void setLocationAndSize() {
        //Fonts
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
        Font newFont2 = new Font("Copperplate", Font.PLAIN, 11);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        Font newFont = new Font("Copperplate", Font.BOLD, 24);
        Font micHim = new Font("Microsoft Himalaya", Font.PLAIN, 13);

        //Labels
        nameLabel.setBounds(165, 40, 400, 25);
        nameLabel.setForeground(Color.decode("#eff0f4"));
        nameLabel.setFont(newFont);

        fName.setBounds(40, 102, 400, 100);
        fName.setForeground(Color.WHITE);
        fName.setWrapStyleWord(true);
        fName.setLineWrap(true);
        fName.setOpaque(false);
        fName.setFont(newFont1);

        about.setBounds(40, 400, 400, 100);
        about.setForeground(Color.WHITE);
        about.setOpaque(false);
        about.setFont(newFont1);

        hobby.setBounds(40, 295, 400, 100);
        hobby.setForeground(Color.WHITE);
        hobby.setOpaque(false);
        hobby.setFont(newFont1);

        email.setBounds(40, 140, 300, 50);
        email.setForeground(Color.WHITE);
        email.setOpaque(false);
        email.setFont(newFont1);

        contact.setBounds(40, 220, 300, 50);
        contact.setForeground(Color.WHITE);
        contact.setOpaque(false);
        contact.setFont(newFont1);

        //TextArea
        uname.setBounds(135, 95, 150, 30);
        uname.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        uname.setBackground(Color.decode("#0c1c65"));
        uname.setFont(userTFont);
//        uname.setCaretColor(Color.WHITE);


        emailText.setBounds(40, 180, 300, 30);
        emailText.setWrapStyleWord(true);
        emailText.setLineWrap(true);
        emailText.setOpaque(true);
        emailText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        emailText.setBackground(Color.decode("#0c1c65"));
        emailText.setFont(userTFont);


        aboutText.setBounds(40, 465, 400, 100);
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setOpaque(true);
        aboutText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        aboutText.setBackground(Color.decode("#0c1c65"));
        aboutText.setFont(userTFont);


        hobbyText.setBounds(40, 360, 300, 50);
        hobbyText.setWrapStyleWord(true);
        hobbyText.setLineWrap(true);
        hobbyText.setOpaque(true);
        hobbyText.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        hobbyText.setBackground(Color.decode("#0c1c65"));
        hobbyText.setFont(userTFont);

        contactText.setBounds(40, 260, 300, 50);
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
        content.add(nameLabel);
        content.add(aboutText);
        content.add(hobbyText);
        content.add(fName);
        content.add(contactText);
        content.add(emailText);
    }

    public static void main(String[] args) throws IOException {
        ViewProfile frame = new ViewProfile(LoginGUI.socket);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Profile");
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        UIManager uI = new UIManager();
        UIManager.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        UIManager.put("Panel.background", new ColorUIResource(0, 13, 83));
    }

}
