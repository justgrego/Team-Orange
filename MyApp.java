import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * MyApp Class
 * @Version Michael Tuskan
 */
public class MyApp extends JFrame {
    GUI gui;
    // Constructor
    public MyApp() throws IOException {
        gui = new GUI();
    }

    public void runApplication() throws IOException {
        // Main Homepage JFrame settings
        setContentPane(gui.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(600, 600);
        setSize(500, 500);
        setTitle("Iteration 1");


        // About Button Action Listener
        gui.getStartAboutButton().addActionListener(new aboutButtonListener());
        gui.getStartProfileButton().addActionListener(new profileButtonListener());
    }



    class aboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //aboutScreen.openAboutScreen();
        }
    }

    class profileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //profileScreen.openProfileScreen();

        }
    }
}