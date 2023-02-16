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
        gui.getAboutProfileButton().addActionListener(new aboutProfileButtonListener());
    }


    class profileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getStartPanel().setVisible(false);
            gui.getProfilePanel().setVisible(true);
        }
    }

    class aboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getStartPanel().setVisible(false);
            gui.getAboutPanel().setVisible(true);
        }
    }

    class aboutProfileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            About about = new About();
            gui.getAboutPanel().setVisible(false);
            gui.getAboutTextPane().setText(about.displayString());
            gui.getProfilePanel().setVisible(true);
        }
    }
}