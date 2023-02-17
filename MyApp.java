import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * MyApp Class
 * @Author Michael Tuskan and Ian Liston
 * @Version 2.0
 */

public class MyApp extends JFrame {
    GUI gui;
    About about;

    // Constructor
    public MyApp() throws IOException {
        gui = new GUI();
        about = new About();
    }

    // Author: Michael Tuskan and Ian Liston
    public void runApplication() throws IOException {

        // Main Homepage JFrame settings
        setContentPane(gui.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(500, 200);
        setSize(500, 500);
        setTitle("Iteration 1");

        // About Button Action Listener
        gui.getStartAboutButton().addActionListener(new aboutButtonListener());
        gui.getStartProfileButton().addActionListener(new profileButtonListener());
        gui.getAboutProfileButton().addActionListener(new aboutProfileButtonListener());
    }

    // Author: Michael Tuskan and Ian Liston
    class profileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getStartPanel().setVisible(false);
            gui.getProfilePanel().setVisible(true);
        }
    }

    // Author: Michael Tuskan and Ian Liston
    class aboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getStartPanel().setVisible(false);
            gui.getAboutTextPane().setText(about.displayString());
            gui.getAboutPanel().setVisible(true);
        }
    }

    // Author: Ian Liston
    class aboutProfileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getAboutPanel().setVisible(false);
            gui.getProfilePanel().setVisible(true);
        }
    }
}