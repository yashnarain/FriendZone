import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * The user descriptions can be changed using Edit profile.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class EditProfile extends JFrame implements ActionListener {
    public Container container = getContentPane();
    public JLabel fLabel = new JLabel("First Name");
    public JTextField fText = new JTextField(20);
    public JLabel sLabel = new JLabel("Last Name");
    public JTextField sText = new JTextField(20);
    public JLabel uLabel = new JLabel("Email");
    public JTextField uText = new JTextField(20);
    public JLabel contactInfo = new JLabel("Contact");
    public JTextField cText = new JTextField();
    public JLabel hobbies = new JLabel("Hobbies");
    public JTextField hText = new JTextField();
    public JLabel aboutMe = new JLabel("About Me");

    public JTextField aText = new JTextField();
    public JButton saveButton = new JButton("Save Changes");

    public JButton passButton = new JButton("Change Password");

    public JButton deleteButton = new JButton("Delete Profile");

    public BufferedReader reader;
    public PrintWriter writer;

    /**
     * Constructor to initialize the values
     */
    EditProfile(Socket socket) throws IOException {
        serverConnectionInitializer(socket);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
     */
    public void serverConnectionInitializer(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
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
        //Fonts
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 12);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);

        fLabel.setBounds(10, 20, 80, 25);
        fLabel.setForeground(Color.decode("#eff0f4"));
        fLabel.setFont(userFont);

        fText.setBounds(100, 20, 140, 25);
        fText.setForeground(Color.decode("#eff0f4"));
        fText.setBackground(Color.decode("#0c1c65"));
        fText.setFont(userTFont);
        fText.setCaretColor(Color.WHITE);

        sLabel.setBounds(10, 60, 80, 25);
        sLabel.setForeground(Color.decode("#eff0f4"));
        sLabel.setFont(userFont);

        sText.setBounds(100, 60, 140, 25);
        sText.setForeground(Color.decode("#eff0f4"));
        sText.setBackground(Color.decode("#0c1c65"));
        sText.setFont(userTFont);
        sText.setCaretColor(Color.WHITE);

        uLabel.setBounds(10, 100, 80, 25);
        uLabel.setForeground(Color.decode("#eff0f4"));
        uLabel.setFont(userFont);

        hobbies.setBounds(10, 180, 80, 25);
        hobbies.setForeground(Color.decode("#eff0f4"));
        hobbies.setFont(userFont);

        hText.setBounds(100, 180, 400, 25);
        hText.setForeground(Color.decode("#eff0f4"));
        hText.setBackground(Color.decode("#0c1c65"));
        hText.setFont(userTFont);
        hText.setCaretColor(Color.WHITE);

        aboutMe.setBounds(10, 220, 80, 25);
        aboutMe.setForeground(Color.decode("#eff0f4"));
        aboutMe.setFont(userFont);

        aText.setBounds(100, 220, 400, 25);
        aText.setForeground(Color.decode("#eff0f4"));
        aText.setBackground(Color.decode("#0c1c65"));
        aText.setFont(userTFont);
        aText.setCaretColor(Color.WHITE);

        passButton.setBounds(320, 260, 160, 25);
        passButton.setFont(newFont1);
        passButton.setForeground(Color.decode("#FFFFFF"));
        passButton.setBackground(Color.decode("#133DCD"));
        passButton.setOpaque(true);
        passButton.setBorderPainted(false);

        saveButton.setBounds(120, 260, 130, 25);
        saveButton.setFont(newFont1);
        saveButton.setForeground(Color.decode("#FFFFFF"));
        saveButton.setBackground(Color.decode("#133DCD"));
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);

        cText.setBounds(100, 140, 400, 25);
        cText.setForeground(Color.decode("#eff0f4"));
        cText.setBackground(Color.decode("#0c1c65"));
        cText.setFont(userTFont);
        cText.setCaretColor(Color.WHITE);

        uText.setBounds(100, 100, 140, 25);
        uText.setForeground(Color.decode("#eff0f4"));
        uText.setBackground(Color.decode("#0c1c65"));
        uText.setFont(userTFont);
        uText.setCaretColor(Color.WHITE);

        deleteButton.setBounds(220, 310, 140, 25);
        deleteButton.setFont(newFont1);
        deleteButton.setForeground(Color.decode("#FFFFFF"));
        deleteButton.setBackground(Color.decode("#133DCD"));
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);

        contactInfo.setBounds(10, 140, 80, 25);
        contactInfo.setForeground(Color.decode("#eff0f4"));
        contactInfo.setFont(userFont);
    }

    /**
     * adds all components to the container
     */
    public void addComponentsToContainer() {
        container.add(fLabel);
        container.add(fText);
        container.add(sLabel);
        container.add(sText);
        container.add(passButton);
        container.add(saveButton);
        container.add(cText);
        container.add(contactInfo);
        container.add(aText);
        container.add(aboutMe);
        container.add(uLabel);
        container.add(uText);
        container.add(contactInfo);
        container.add(hobbies);
        container.add(passButton);
        container.add(hText);
        container.add(deleteButton);
    }

    /**
     * adds actionlisteners to the buttons
     */
    public void addActionEvent() {
        saveButton.addActionListener(this);
        passButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    /**
     * creates the JFrame
     */
    public static void main(String[] args) throws IOException {
        EditProfile frame = new EditProfile(LoginGUI.socket);
        frame.setTitle("Edit Profile");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        UIManager uI = new UIManager();
        uI.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        uI.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        uI.put("Panel.background", new ColorUIResource(0, 13, 83));

    }

    /**
     * assigns actions to be performed on clicking each button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String firstName = fText.getText();
            String lastName = sText.getText();
            String email = uText.getText();
            String contact = cText.getText();
            String h = hText.getText();
            String about = aText.getText();
            String username = Homepage.uname.getText();
//            String[] nameSplit = Homepage.nameLabel.getText().split(" ");

            if (fText.getText().length() == 0) {

                try {
                    BufferedReader bfr = new BufferedReader(new FileReader(new File("UsersDetails.txt")));

                    String line = bfr.readLine();
                    while (line != null) {

                        String[] info = line.split(" ");
                        if (info[2].equals(username)) {
                            firstName = info[0].replaceAll("`", " ");
//                            lastName = info[1].replaceAll("`", " ");
                        }

                        line = bfr.readLine();

                    }

                    bfr.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (sText.getText().length() == 0) {
                try {
                    BufferedReader bfr = new BufferedReader(new FileReader(new File("UsersDetails.txt")));

                    String line = bfr.readLine();
                    while (line != null) {

                        String[] info = line.split(" ");
                        if (info[2].equals(username)) {
//                            firstName = info[0].replaceAll("`", " ");
                            lastName = info[1].replaceAll("`", " ");
                        }

                        line = bfr.readLine();

                    }

                    bfr.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (uText.getText().length() == 0) {
//                String[] temp = Homepage.emailText.getText().split(": ");
                email = Homepage.emailText.getText();
                if (email.equals("Add your email info in the profile window!")) {
                    email = "unknown";
                }
            }
            if (cText.getText().length() == 0) {
                contact = Homepage.contactText.getText();
                if (contact.equals("Add you contact info in the profile window!")) {
                    contact = "unknown";
                }
            }
            if (hText.getText().length() == 0) {
                h = Homepage.hobbyText.getText();
                if (hobbies.equals("We don't know your hobbies yet! Add them in the profile window!")) {
                    h = "unknown";
                }
            }
            if (aText.getText().length() == 0) {
                about = Homepage.aboutText.getText();
                if (about.equals("We don't know anything about you yet! Tell us by updating your info in the " +
                        "profile " +
                        "window!")) {
                    about = "unknown";
                }
            }

            writer.write("createProfile");
            writer.println();
            writer.write(firstName);
            writer.println();
            writer.write(lastName);
            writer.println();
            writer.write(email);
            writer.println();
            writer.write(contact);
            writer.println();
            writer.write(h);
            writer.println();
            writer.write(about);
            writer.println();
            writer.flush();

            try {
                String response = reader.readLine();
                JOptionPane.showMessageDialog(this, response);
                if (response.equals("Profile information successfully updated!")) {
                    String contact1 = (contact.equals("unknown")) ?
                            "Add you contact info in the profile window!" : contact;
                    String email1 = (email.equals("unknown")) ?
                            "Add your email info in the profile window!" : email;
                    String hobbies1 = (hobbies.equals("unknown")) ?
                            "We don't know your hobbies yet! Add them in the profile window!" : h;
                    String about1 = (about.equals("unknown")) ?
                            "We don't know anything about you yet! Tell us by updating your info in the profile " +
                                    "window!"
                            : about;

                    Homepage.nameLabel.setText(firstName + " " + lastName);
                    Homepage.contactText.setText(contact1);
                    Homepage.hobbyText.setText(hobbies1);
                    Homepage.aboutText.setText(about1);
                    Homepage.emailText.setText(email1);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == passButton) {
            try {
                ChangePassword.main(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == deleteButton) {

            String firstName = fText.getText();
            String lastName = sText.getText();
            String email = uText.getText();
            String contact = cText.getText();
            String h = hText.getText();
            String about = aText.getText();

            String[] nameSplit = Homepage.nameLabel.getText().split(" ");
            email = "unknown";
            contact = "unknown";
            h = "unknown";
            about = "unknown";
            String username = Homepage.uname.getText();

            try {
                BufferedReader bfr = new BufferedReader(new FileReader(new File("UsersDetails.txt")));

                String line = bfr.readLine();
                while (line != null) {

                    String[] info = line.split(" ");
                    if (info[2].equals(username)) {
                        firstName = info[0].replaceAll("`", " ");
                        lastName = info[1].replaceAll("`", " ");
                    }

                    line = bfr.readLine();

                }

                bfr.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            writer.write("createProfile");
            writer.println();
            writer.write(firstName);
            writer.println();
            writer.write(lastName);
            writer.println();
            writer.write(email);
            writer.println();
            writer.write(contact);
            writer.println();
            writer.write(h);
            writer.println();
            writer.write(about);
            writer.println();
            writer.flush();

            try {
                String response = reader.readLine();
                JOptionPane.showMessageDialog(this, "Profile information successfully deleted!");
                if (response.equals("Profile information successfully updated!")) {
                    Homepage.nameLabel.setText(firstName + " " + lastName);
                    Homepage.contactText.setText("Add you contact info in the profile window!");
                    Homepage.hobbyText.setText("We don't know your hobbies yet! Add them in the profile window!");
                    Homepage.aboutText.setText("We don't know anything about you yet! Tell us by updating your info " +
                            "in the profile window!");
                    Homepage.emailText.setText("Add your email info in the profile window!");
                    fText.setText("");
                    cText.setText("");
                    uText.setText("");
                    hText.setText("");
                    aText.setText("");
                    sText.setText("");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
