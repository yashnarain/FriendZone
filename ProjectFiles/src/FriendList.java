import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The requests are used to view sent and received friend requests.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class FriendList extends JFrame {

    public BufferedReader reader;
    public PrintWriter writer;

    public Socket flSocket;
    public JFrame frame = new JFrame("List My Friends");
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> list = new JList<>(listModel);
    public Thread t1;
    boolean runAgain = false;

    /**
     * creates and adds components to the panel. Also sets bounds, font and color for all components
     */
    private void display() {
        //Fonts

        Font newFont2 = new Font("Copperplate", Font.PLAIN, 13);
        frame.setSize(300, 450);
        list.setBackground(Color.decode("#0c1c65"));
        list.setForeground(Color.WHITE);
        list.setFont(newFont2);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBounds(0, 0, 300, 300);
        List<String> myList = new ArrayList<>(40);
        for (int index = 0; index < 40; index++) {
            myList.add("(" + (index + 1) + ") List Item ");
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panel1.add(scrollPane);
        frame.add(panel1);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 10, 10));
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 300, 300, 450);
//        panel.add(goBack);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Constructor initialize the FriendList
     */
    public FriendList() throws IOException {

        flSocket = LoginGUI.socket;
        serverConnectionInitializer(flSocket);
        display();
        loadFriends();
        closingX();

    }

    /**
     * adds friends to listModel
     */
    public void loadFriends() {
        writer.write("viewAllFriends");
        writer.println();
        writer.flush();

        t1 = new Thread(new Runnable() {

            public synchronized void run() {
                listModel.clear();
                while (true) {
                    try {
                        String output = reader.readLine();
                        if (output.equals("stop"))
                            break;

                        if (output.equals("Friend Added")) {
                            runAgain = true;
                            break;
                        } else {

                            ArrayList<String> friends = new ArrayList<>();
                            friends.add(output.replaceAll("`", " "));
                            for (int i = 0; i < friends.size(); i++) {
                                listModel.addElement(friends.get(i));
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (runAgain) {
                    loadFriends();
                    list.ensureIndexIsVisible(listModel.getSize());
                }
            }
        });

        t1.start();

    }

    /**
     * closes the dialog
     */
    public void closingX() {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                runAgain = false;
                writer.write("closeFriendList");
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
     * sets the reader to a new BufferedReader and the writer to a new PrintWriter, also creates a socket for each
     */
    public void serverConnectionInitializer(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    /**
     * creates the JFrame
     */
    public static void main(String[] args) throws IOException {
        FriendList fl = new FriendList();
        UIManager uI = new UIManager();
        UIManager.put("OptionPane.background", new ColorUIResource(0, 13, 83));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Copperplate", Font.BOLD, 14)));
        UIManager.put("Panel.background", new ColorUIResource(0, 13, 83));
    }


}
