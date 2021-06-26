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
import java.net.Socket;

/**
 * Prompts the user for firstname, lastname, username and password to CreateAccount.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class CreateAccount extends JFrame implements ActionListener {

    private Container container = getContentPane();
    private JLabel userLabel = new JLabel("Username");
    private JLabel firstnameLabel = new JLabel("Firstname");
    private JLabel lastnameLabel = new JLabel("Lastname");

    private JTextField userTextField = new JTextField();
    private JTextField firstnameField = new JTextField();
    private JTextField lastnameField = new JTextField();
    private JButton loginButton = new JButton("CREATE");
    private JButton resetButton = new JButton("RESET");
    private JButton exitButton = new JButton("EXIT");
    private JButton backButton = new JButton("BACK");

    private JLabel passwordLabel = new JLabel("Password");
    private JPasswordField passwordField = new JPasswordField();
    private JCheckBox showPassword = new JCheckBox("Show Password");

    private JLabel showPrompt = new JLabel("Please enter the details for a New Account.");

    public JFrame f = new JFrame("Create Account");

    public PrintWriter writer;
    public BufferedReader reader;
    public Socket socket;

    /**
     * Constructor to initialize the values
     */
    CreateAccount() throws IOException {
        serverConnectionInitializer();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each.
     */
    public void serverConnectionInitializer() throws IOException {
        this.socket = new Socket("localhost", 4242);
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
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        Font newFont = new Font("Copperplate", Font.BOLD, 14);

        showPrompt.setBounds(40, 5, 350, 90);
        showPrompt.setForeground(Color.decode("#eff0f4"));
        showPrompt.setFont(newFont);

        firstnameLabel.setBounds(75, 90, 100, 30);
        firstnameLabel.setForeground(Color.decode("#eff0f4"));
        firstnameLabel.setFont(userFont);

        lastnameLabel.setBounds(75, 160, 100, 30);
        lastnameLabel.setForeground(Color.decode("#eff0f4"));
//        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        lastnameLabel.setFont(userFont);

        userLabel.setBounds(75, 230, 100, 30);
        userLabel.setForeground(Color.decode("#eff0f4"));
        userLabel.setFont(userFont);

        passwordLabel.setBounds(75, 300, 100, 30);
        passwordLabel.setForeground(Color.decode("#eff0f4"));
//        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        passwordLabel.setFont(userFont);

        firstnameField.setBounds(175, 90, 150, 30);
        firstnameField.setForeground(Color.decode("#eff0f4"));
        firstnameField.setBackground(Color.decode("#0c1c65"));
        firstnameField.setFont(userTFont);
        firstnameField.setCaretColor(Color.WHITE);


        userTextField.setBounds(175, 230, 150, 30);
        userTextField.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        userTextField.setBackground(Color.decode("#0c1c65"));
        userTextField.setFont(userTFont);
        userTextField.setCaretColor(Color.WHITE);


        lastnameField.setBounds(175, 160, 150, 30);
        lastnameField.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        lastnameField.setBackground(Color.decode("#0c1c65"));
        lastnameField.setFont(userTFont);
        lastnameField.setCaretColor(Color.WHITE);

        passwordField.setBounds(175, 300, 150, 30);
        passwordField.setForeground(Color.decode("#eff0f4"));
//        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        passwordField.setBackground(Color.decode("#0c1c65"));
        passwordField.setFont(userTFont);
        passwordField.setCaretColor(Color.WHITE);

        showPassword.setBounds(175, 330, 150, 30);
        showPassword.setForeground(Color.decode("#eff0f4"));
        showPassword.setFont(userFont);


        loginButton.setBounds(225, 400, 100, 30);
        loginButton.setFont(newFont1);
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.setBackground(Color.decode("#133DCD"));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);

        resetButton.setBounds(75, 400, 100, 30);
        resetButton.setFont(newFont1);
        resetButton.setForeground(Color.decode("#FFFFFF"));
        resetButton.setBackground(Color.decode("#133DCD"));
        resetButton.setOpaque(true);
        resetButton.setBorderPainted(false);

        exitButton.setBounds(75, 450, 100, 30);
        exitButton.setFont(newFont1);
        exitButton.setForeground(Color.decode("#FFFFFF"));
        exitButton.setBackground(Color.decode("#133DCD"));
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);

        backButton.setBounds(225, 450, 100, 30);
        backButton.setFont(newFont1);
        backButton.setForeground(Color.decode("#FFFFFF"));
        backButton.setBackground(Color.decode("#133DCD"));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
    }

    /**
     * adds all components to the container
     */
    public void addComponentsToContainer() {
        container.add(showPrompt);
        container.add(userLabel);
        container.add(firstnameLabel);
        container.add(lastnameLabel);
        container.add(userTextField);
        container.add(firstnameField);
        container.add(lastnameField);
        container.add(loginButton);
        container.add(resetButton);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(showPassword);
        container.add(exitButton);
        container.add(backButton);
    }

    /**
     * adds action listeners to the buttons
     */
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    /**
     * assigns actions to be performed on clicking each button
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String usernameText;
            String firstnameText;
            String lastnameText;
            String passwordText;
            String errorMessage = "";

            userTextField.setBorder(BorderFactory.createLineBorder(Color.blue));
            firstnameField.setBorder(BorderFactory.createLineBorder(Color.blue));
            lastnameField.setBorder(BorderFactory.createLineBorder(Color.blue));
            passwordField.setBorder(BorderFactory.createLineBorder(Color.blue));

            if (userTextField.getText().length() == 0 || firstnameField.getText().length() == 0 ||
                    lastnameField.getText().length() == 0 ||
                    String.valueOf(passwordField.getPassword()).length() == 0) {
                errorMessage = "Make sure you fill all the fields";

                if (userTextField.getText().length() == 0) {
                    userTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (firstnameField.getText().length() == 0) {
                    firstnameField.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (lastnameField.getText().length() == 0) {
                    lastnameField.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (String.valueOf(passwordField.getPassword()).length() == 0) {
                    passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                }

                JOptionPane.showMessageDialog(null, errorMessage, "Create Account",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                usernameText = userTextField.getText();
                firstnameText = firstnameField.getText().replaceAll(" ", "`");
                lastnameText = lastnameField.getText().replaceAll(" ", "`");
                passwordText = String.valueOf(passwordField.getPassword());
                // do some checking

                String response = "createAccount " + usernameText + " " + passwordText + " " + firstnameText +
                        " " + lastnameText;

                writer.write(response);
                writer.println();
                writer.flush();

                String s1 = null;
                try {
                    s1 = reader.readLine();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                if (s1.equals("Account created successfully!")) {
                    try {
                        JOptionPane.showMessageDialog(this, s1);
                        socket.close();
                        LoginGUI.main(null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, s1);
                }

            }
        }

        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            firstnameField.setText("");
            lastnameField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        if (e.getSource() == exitButton) {
            if (JOptionPane.showConfirmDialog(f,
                    "Are you sure you want to exit this program?", "Close Window?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                dispose();

                ThankYou.main(null);

            }
        }
        if (e.getSource() == backButton) {
            dispose();
            try {
                Welcome.main(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * prompts a JOptionPane to close the dialog
     */
    public void closingX(CreateAccount frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    writer.write("quit");
                    writer.println();
                    writer.flush();
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dispose();
                    ThankYou.main(null);
                }
            }
        });
    }

    /**
     * creates the JFrame
     */
    public static void main(String[] a) throws IOException {
        CreateAccount frame = new CreateAccount();
        frame.closingX(frame);
        frame.setTitle("Create Account");
        frame.setBounds(10, 10, 420, 570);
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
}

