import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Welcome
 * <p>
 * Greets the user with “Welcome to FriendZone”.
 * Allows the user to select one of three options shown using JButtons CreateAccount, Login, and Exit.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

class Welcome extends JFrame implements ActionListener {
    public Container container = getContentPane();
    public JButton loginButton = new JButton("Login");
    public JButton createAccountButton = new JButton("Create");
    public JButton exitButton = new JButton("Exit");
    public JLabel showPrompt = new JLabel("Welcome to FriendZone!");
    public JLabel selectLabel = new JLabel("Please select an option.");
    public static boolean logout = false;
    public JFrame frame = new JFrame("Welcome");

    Welcome() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        closingX();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        Color color = Color.decode("#000d53");
        container.setBackground(color);
    }

    public void setLocationAndSize() {
        //Fonts
        Font userFont = new Font("Copperplate", Font.PLAIN, 13);
        Font newFont1 = new Font("Copperplate", Font.PLAIN, 14);
        Font userTFont = new Font("Georgia", Font.PLAIN, 12);
        Font newFont = new Font("Copperplate", Font.BOLD, 24);

        showPrompt.setBounds(30, 50, 350, 50);
        showPrompt.setForeground(Color.decode("#eff0f4"));
        showPrompt.setFont(newFont);


//        selectLabel.setBounds(100, 100, 300, 90);

        loginButton.setBounds(200, 155, 150, 30);
        loginButton.setFont(newFont1);
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.setBackground(Color.decode("#133DCD"));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);

        createAccountButton.setBounds(30, 155, 150, 30);
        createAccountButton.setFont(newFont1);
        createAccountButton.setForeground(Color.decode("#FFFFFF"));
        createAccountButton.setBackground(Color.decode("#133DCD"));
        createAccountButton.setOpaque(true);
        createAccountButton.setBorderPainted(false);

        exitButton.setBounds(115, 225, 150, 30);
        exitButton.setFont(newFont1);
        exitButton.setForeground(Color.decode("#FFFFFF"));
        exitButton.setBackground(Color.decode("#133DCD"));
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);


    }

    public void addComponentsToContainer() {
        container.add(showPrompt);
        container.add(loginButton);
        container.add(selectLabel);
        container.add(createAccountButton);
        container.add(exitButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);
        exitButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            try {
                LoginGUI.main(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            dispose();
        }
        if (e.getSource() == createAccountButton) {
            //take to create account
            try {
                CreateAccount.main(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            dispose();
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
    }

    public void closingX() {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit this program?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    dispose();
                    ThankYou.main(null);
                }
            }
        });
    }

    public static void main(String[] a) throws IOException {
        Welcome frame = new Welcome();
        frame.setTitle("Welcome");
        frame.setBounds(10, 10, 370, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
