import javax.swing.*;

/**
 @Author: Ian Liston
 @Version 1.0
 Date  : 02/16/2023
**/

public class GUI {
    private JPanel mainPanel;
    private JButton startProfileButton;
    private JButton startAboutButton;
    private JPanel startPanel;
    private JPanel profilePanel;
    private JTextField profilePEmailTextField;
    private JTextField profileNameTextField;
    private JPanel aboutPanel;
    private JTextPane aboutTextPane;
    private JButton aboutProfileButton;

    // Main panel GUI method.
    public JPanel getMainPanel() {return mainPanel;}

    // Start page panel GUI methods.
    public JPanel getStartPanel() {return startPanel;}
    public JButton getStartAboutButton() {return startAboutButton;}
    public JButton getStartProfileButton() {return startProfileButton;}

    // Profile page panel GUI methods.
    public JPanel getProfilePanel() {return profilePanel;}
    public JTextField getProfileNameTextField() {return profileNameTextField;}
    public JTextField getProfilePEmailTextField() {return profilePEmailTextField;}

    // About page panel GUI methods
    public JPanel getAboutPanel() {return aboutPanel;}
    public JTextPane getAboutTextPane() {return aboutTextPane;}
    public JButton getAboutProfileButton() {return aboutProfileButton;}
}