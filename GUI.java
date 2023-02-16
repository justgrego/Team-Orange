import javax.swing.*;

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

    public JPanel getMainPanel() {return mainPanel;}
    public JPanel getStartPanel() {return startPanel;}
    public JButton getStartAboutButton() {return startAboutButton;}
    public JButton getStartProfileButton() {return startProfileButton;}

    public JPanel getProfilePanel() {return profilePanel;}
    public JTextField getProfileNameTextField() {return profileNameTextField;}
    public JTextField getProfilePEmailTextField() {return profilePEmailTextField;}

    public JPanel getAboutPanel() {return aboutPanel;}
    public JTextPane getAboutTextPane() {return aboutTextPane;}

    public JButton getAboutProfileButton() {return aboutProfileButton;}
}