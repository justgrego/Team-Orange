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
    private final AboutScreen aboutScreen;
    private final ProfileScreen profileScreen;
    private final JPanel centerPanel;

    // Constructor
    public MyApp() throws IOException {
        aboutScreen = new AboutScreen();
        profileScreen = new ProfileScreen();
        centerPanel = new JPanel();

    }

    public void runApplication() throws IOException {
        // Main Homepage JFrame settings
        getContentPane().setBackground(Color.ORANGE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(600, 600);
        setSize(500, 500);
        setTitle("Iteration 1");

        // Call Panel Methods onto HomePage (main JFrame)
        centerPanelMethod();

        // About Button Action Listener
        aboutScreen.getAboutButton().addActionListener(new aboutButtonListener());
        profileScreen.getProfileButton().addActionListener(new profileButtonListener());
    }

    public void centerPanelMethod() throws IOException {
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(255, 176, 129));
        centerPanel.add(aboutScreen.aboutScreenButtonAndJPanel(), BorderLayout.CENTER);
        centerPanel.add(profileScreen.profileScreenButtonAndJPanel(), BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }


    class aboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aboutScreen.openAboutScreen();

        }
    }

    class profileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            profileScreen.openProfileScreen();

        }
    }
}