import javax.swing.*;
import java.awt.*;

/**
 * ThankYou
 *
 * Thanks the user with a message “Thank You for using FriendZone”. Shows that the program has come to an end.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class ThankYou {
    public JWindow window = new JWindow();

    public static void main(String[] args) {
        new ThankYou();
    }

    public ThankYou() {
        window.getContentPane().setBackground(Color.decode("#000d53"));
        JLabel jl = new JLabel("Thank You for using FriendZone!", SwingConstants.CENTER);
        jl.setForeground(Color.WHITE);
        jl.setFont(new Font("copperplate", Font.BOLD, 15));
        window.getContentPane().add(jl);
        window.setBounds(500, 150, 300, 200);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
        window.setLocation(x, y);
        window.setVisible(true);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(3000);
                return null;
            }

            protected void done() {
                window.dispose();
            }
        };

        worker.execute();
    }
}
