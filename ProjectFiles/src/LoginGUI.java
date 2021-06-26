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
 * LoginGUI
 *
 * Prompts the user for username and password. Provides 4 options for user to select from,
 * in form of JButtons reset, create, exit, and back. The exit and back buttons have their
 * usual meaning, reset button sets all the text fields which are entered by user to blank or empty strings.
 * The show password checkbox allows user to hid (replace with “*”) or show their password.
 * The login button shows a JOptionPane success message if the login is success with valid credentials
 * or an error message if the required fields are invalid or missing.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 *
 */
class LoginGUI extends JFrame implements ActionListener {
    private final Container container = getContentPane();
    private final JLabel userLabel = new JLabel("Username");

    private final JTextField userTextField = new JTextField();

    private final JButton loginButton = new JButton("LOGIN");
    private final JButton resetButton = new JButton("RESET");
    private final JButton exitButton = new JButton("EXIT");
    private final JButton backButton = new JButton("BACK");

    private final JLabel passwordLabel = new JLabel("Password");
    private final JPasswordField passwordField = new JPasswordField();
    private final JCheckBox showPassword = new JCheckBox("Show Password");

    private final JLabel showPrompt = new JLabel("Enter the details for an Existing Account.");

    private final JFrame frame = new JFrame("Login");

    private BufferedReader reader;
    private PrintWriter writer;
    public static Socket socket;
    public static String usn;


    LoginGUI() throws IOException {

        serverConnectionInitializer();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void serverConnectionInitializer() throws IOException {
        socket = new Socket("localhost", 4242);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    public void setLayoutManager() {
        container.setLayout(null);
        Color color = Color.decode("#000d53");
        container.setBackground(color);
    }

    public void setLocationAndSize() {
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
        showPrompt.setBounds(40, 50, 350, 90);
        showPrompt.setForeground(Color.decode("#eff0f4"));
        Font newFont = new Font("Copperplate", Font.BOLD, 14);
        showPrompt.setFont(newFont);

        userLabel.setBounds(75, 150, 100, 30);
        userLabel.setForeground(Color.decode("#eff0f4"));
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        userLabel.setFont(userFont);

        userTextField.setBounds(175, 150, 150, 30);
        userTextField.setForeground(Color.decode("#eff0f4"));
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        userTextField.setBackground(Color.decode("#0c1c65"));
        userTextField.setFont(userTFont);
        userTextField.setCaretColor(Color.WHITE);

        loginButton.setBounds(225, 320, 100, 30);
        loginButton.setFont(newFont1);
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.setBackground(Color.decode("#133DCD"));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);

        resetButton.setBounds(75, 320, 100, 30);
        resetButton.setFont(newFont1);
        resetButton.setForeground(Color.decode("#FFFFFF"));
        resetButton.setBackground(Color.decode("#133DCD"));
        resetButton.setOpaque(true);
        resetButton.setBorderPainted(false);

        exitButton.setBounds(75, 370, 100, 30);
        exitButton.setFont(newFont1);
        exitButton.setForeground(Color.decode("#FFFFFF"));
        exitButton.setBackground(Color.decode("#133DCD"));
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);

        backButton.setBounds(225, 370, 100, 30);
        backButton.setFont(newFont1);
        backButton.setForeground(Color.decode("#FFFFFF"));
        backButton.setBackground(Color.decode("#133DCD"));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
//        backButton.setBackground(Color.RED);
//        backButton.set

        passwordLabel.setBounds(75, 220, 100, 30);
        passwordLabel.setForeground(Color.decode("#eff0f4"));
//        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        passwordLabel.setFont(userFont);

        passwordField.setBounds(175, 220, 150, 30);
        passwordField.setForeground(Color.decode("#eff0f4"));
        passwordField.setBackground(Color.decode("#0c1c65"));
        passwordField.setFont(userTFont);
        passwordField.setCaretColor(Color.WHITE);


        showPassword.setBounds(175, 250, 150, 30);
        showPassword.setForeground(Color.decode("#eff0f4"));
        showPassword.setFont(userFont);
    }

    public void addComponentsToContainer() {
        container.add(showPrompt);
        container.add(userLabel);
        container.add(userTextField);
        container.add(passwordLabel);
        container.add(loginButton);
        container.add(resetButton);
        container.add(passwordField);
        container.add(showPassword);
        container.add(exitButton);
        container.add(backButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        exitButton.addActionListener(this);
        backButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            String usernameText;
            String passwordText;

            String errorMessage = "";
            if (userTextField.getText().length() == 0 && String.valueOf(passwordField.getPassword()).length() == 0) {
                errorMessage = "Username & Password Cannot be Empty";
                JOptionPane.showMessageDialog(null, errorMessage, "Login",
                        JOptionPane.ERROR_MESSAGE);
                userTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
            } else if (userTextField.getText().length() == 0) {
                errorMessage = "Username Cannot be Empty";
                JOptionPane.showMessageDialog(null, errorMessage, "Login",
                        JOptionPane.ERROR_MESSAGE);
                userTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                passwordField.setBorder(BorderFactory.createLineBorder(Color.blue));
            } else if (String.valueOf(passwordField.getPassword()).length() == 0) {
                errorMessage = "Password cannot be empty";
                JOptionPane.showMessageDialog(null, errorMessage, "Login",
                        JOptionPane.ERROR_MESSAGE);
                passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                userTextField.setBorder(BorderFactory.createLineBorder(Color.blue));
            } else {

                usernameText = userTextField.getText();
                passwordText = String.valueOf(passwordField.getPassword());

                String response = "login " + usernameText + " " + passwordText;

                writer.write(response);
                writer.println();
                writer.flush(); // ensure data is sent to the server

                String s1 = null;
                try {
                    s1 = reader.readLine();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                if (s1.equals("Login successful")) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    usn = userTextField.getText();
                    dispose();
                    try {
                        Homepage.main(null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else if (s1.equals("You're already logged in on another window!")) {
                    JOptionPane.showMessageDialog(this, s1);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
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
            if (JOptionPane.showConfirmDialog(frame,
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
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    public static void main(String[] a) throws IOException {
        LoginGUI frame = new LoginGUI();
        //frame.closingX(frame);
        frame.setTitle("Login");
        frame.setBounds(10, 10, 400, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        UIManager uI = new UIManager();
        UIManager.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        UIManager.put("Panel.background", new ColorUIResource(0, 13, 83));
    }

}
