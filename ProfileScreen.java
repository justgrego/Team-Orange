import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ProfileScreen Class
 * @Version Michael Tuskan
 */
public class ProfileScreen {
    JButton profileButton;
    JTextField nameDisplay;
    JTextField emailDisplay;
    ArrayList<User> user;
    public ProfileScreen()  throws IOException {
        profileButton = new JButton("Profile");
        nameDisplay = new JTextField(0);
        emailDisplay = new JTextField(0);
        user = new ArrayList<User>();
    }
    public JPanel profileScreenButtonAndJPanel() {
        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridBagLayout());
        aboutPanel.setBackground(new Color(255,176,129));
        profileButton.setForeground(new Color(101,96, 93));
        profileButton.setBackground(new Color(255,224, 205));
        aboutPanel.add(profileButton, profileScreenSpacing());
        return aboutPanel;
    }

    public JButton getProfileButton() { return profileButton; }

    public GridBagConstraints profileScreenSpacing() {
        GridBagConstraints spacing = new GridBagConstraints();
        spacing.insets = new Insets(120, 5, 0, 5);
        spacing.weightx = 1;
        spacing.weighty = .25;
        spacing.ipady = 15;
        spacing.ipadx = 45;
        return spacing;
    }

    public GridBagConstraints nameAndEmailScreenSpacing() {
        GridBagConstraints spacing = new GridBagConstraints();
        //spacing.insets = new Insets(120, 5, 0, 5);
        spacing.weightx = 1;
        spacing.weighty = .25;
        spacing.ipady = 15;
        spacing.ipadx = 150;
        return spacing;
    }

    public void openProfileScreen() {
        //Jfame About Screen
        JFrame aboutScreen = new JFrame();
        aboutScreen.getContentPane().setBackground(new Color(255,176,129));
        aboutScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aboutScreen.setPreferredSize(new Dimension(600,600));
        aboutScreen.pack();
        aboutScreen.setLocationRelativeTo(null);
        aboutScreen.setLocation(600,600);
        aboutScreen.setSize(500,500);
        aboutScreen.setVisible(true);

        // JPanel overlay for Name and Email Display
        JPanel nameAndEmailJTextField = new JPanel();
        nameAndEmailJTextField.setLayout(new GridBagLayout());
        nameAndEmailJTextField.setBackground(new Color(255,176,129));
        aboutScreen.add(nameAndEmailJTextField, BorderLayout.CENTER);

        // Load in Display for Name and Email
        nameDisplayJTextField();
        emailDisplayJTextField();

        //add name Display to JPanel //NEED TO FIX //TODO
        JLabel nameLabel = new JLabel("                           " +
                                           "User name                            " +
                "                                           Email");
        aboutScreen.add(nameLabel, BorderLayout.NORTH);
        nameAndEmailJTextField.add(nameDisplayJTextField(), nameAndEmailScreenSpacing());
        nameDisplayJTextField().setForeground(new Color(101,96, 93));
        nameAndEmailJTextField.setBackground(new Color(255,224, 205));

        //add email display to JPanel
//        JLabel emailLabel = new JLabel("Email");
//        aboutScreen.add(emailLabel, BorderLayout.WEST);
        nameAndEmailJTextField.add(emailDisplayJTextField(), nameAndEmailScreenSpacing());
        nameDisplayJTextField().setForeground(new Color(101,96, 93));
        nameAndEmailJTextField.setBackground(new Color(255,224, 205));

        //Name Display - Action Listener
        nameDisplay.addActionListener(new nameDisplayListener());

        //Email Display - Action Listener
        emailDisplay.addActionListener(new emailDisplayListener());
    }


    public JTextField nameDisplayJTextField() {
        Font font = nameDisplay.getFont().deriveFont(Font.PLAIN, 15f);
        nameDisplay.setFont(font);
        nameDisplay.setEnabled(true);
        return nameDisplay;
    }

    public JTextField emailDisplayJTextField() {
        Font font = emailDisplay.getFont().deriveFont(Font.PLAIN, 15f);
        emailDisplay.setFont(font);
        emailDisplay.setEnabled(true);
        return emailDisplay;
    }

    class nameDisplayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nameFieldValue = nameDisplay.getText();
            //user.add(nameFieldValue); //TODO

        }
    }

    class emailDisplayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String emailFieldValue = emailDisplay.getText();
            //user.add(nameFieldValue); //TODO

        }
    }
}
