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
 * Allows the logged in user to change their password.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */
public class ChangePassword extends JFrame implements ActionListener {
    private Container content = getContentPane();
    private JLabel oLabel = new JLabel("Old password");
    private JLabel fLabel = new JLabel("New Password");
    private JLabel sLabel = new JLabel("Confirm Password");
    private JPasswordField ojp = new JPasswordField();
    private JPasswordField njp = new JPasswordField();
    private JPasswordField cjp = new JPasswordField();
    private JButton passButton = new JButton("Update Password");
    private BufferedReader reader;
    private PrintWriter writer;

    /**
     * Constructor to initialize the values when ChangePassword account
     */
    ChangePassword(Socket socket) throws IOException {
        serverConnectionInitializer(socket);
        setLayoutManager();
        setLocationAndSize();
        addComponentstoPanel();
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
        content.setLayout(null);
    }

    /**
     * sets location, size, background color and font of the components
     */
    public void setLocationAndSize() {
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        Font user1Font = new Font("Copperplate", Font.PLAIN, 12);
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 12);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        Font newFont = new Font("Copperplate", Font.BOLD, 14);


        ojp.setBounds(140, 20, 140, 25);
        ojp.setForeground(Color.decode("#eff0f4"));
        ojp.setBackground(Color.decode("#0c1c65"));
        ojp.setFont(userTFont);
        ojp.setCaretColor(Color.WHITE);

        oLabel.setBounds(10, 20, 120, 25);
        oLabel.setForeground(Color.decode("#eff0f4"));
        oLabel.setFont(userFont);

        fLabel.setBounds(10, 60, 120, 25);
        fLabel.setForeground(Color.decode("#eff0f4"));
        fLabel.setFont(userFont);

        njp.setBounds(140, 60, 140, 25);
        njp.setForeground(Color.decode("#eff0f4"));
        njp.setBackground(Color.decode("#0c1c65"));
        njp.setFont(userTFont);
        njp.setCaretColor(Color.WHITE);

        sLabel.setBounds(10, 100, 120, 25);
        sLabel.setForeground(Color.decode("#eff0f4"));
        sLabel.setFont(user1Font);

        cjp.setBounds(140, 100, 140, 25);
        cjp.setForeground(Color.decode("#eff0f4"));
        cjp.setBackground(Color.decode("#0c1c65"));
        cjp.setFont(userTFont);
        cjp.setCaretColor(Color.WHITE);

        passButton.setBounds(60, 140, 175, 25);
        passButton.setFont(newFont1);
        passButton.setForeground(Color.decode("#FFFFFF"));
        passButton.setBackground(Color.decode("#133DCD"));
        passButton.setOpaque(true);
        passButton.setBorderPainted(false);
    }

    /**
     * adds all components to the content pane
     */

    public void addComponentstoPanel() {
        content.add(oLabel);
        content.add(ojp);
        content.add(fLabel);
        content.add(njp);
        content.add(sLabel);
        content.add(cjp);
        content.add(passButton);
        content.setBackground(Color.decode("#000d53"));
    }

    /**
     * adds action listeners to the buttons
     */

    public void addActionEvent() {
        passButton.addActionListener(this);
    }

    /**
     * assigns actions to be performed on clicking each button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == passButton) {

            String errorMessage = "";
            njp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            cjp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            ojp.setBorder(BorderFactory.createLineBorder(Color.BLUE));

            if (String.valueOf(njp.getPassword()).length() == 0 || String.valueOf(cjp.getPassword()).length() == 0 ||
                    String.valueOf(ojp.getPassword()).length() == 0) {
                errorMessage = "Make sure you fill all the fields";

                if (String.valueOf(njp.getPassword()).length() == 0) {
                    njp.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (String.valueOf(cjp.getPassword()).length() == 0) {
                    cjp.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if (String.valueOf(ojp.getPassword()).length() == 0) {
                    ojp.setBorder(BorderFactory.createLineBorder(Color.red));
                }

                JOptionPane.showMessageDialog(null, errorMessage, "Change Password",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                if (String.valueOf(njp.getPassword()).equals(String.valueOf(cjp.getPassword()))) {
                    writer.write("changePassword " + String.valueOf(ojp.getPassword()) + " " +
                            String.valueOf(njp.getPassword()) + " " + String.valueOf(cjp.getPassword()));
                    writer.println();
                    writer.flush();
                    try {
                        String response = reader.readLine();
                        JOptionPane.showMessageDialog(null, response,
                                "Password", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Make sure your new password and the confirm password matches!",
                            "Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * creates the JFrame
     */
    public static void main(String[] args) throws IOException {
        ChangePassword frame = new ChangePassword(LoginGUI.socket);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 220);
        frame.setTitle("Password");
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
