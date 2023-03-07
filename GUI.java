import javax.swing.*;
import java.awt.*;


/**
 @Author Ian Liston, Gregory Yi
 @Version 1.0
 Date  : 02/16/2023
**/

public class GUI extends JDialog {
    private JPanel mainPanel;
    private JButton startProfileButton;
    private JButton startAboutButton;
    private JPanel startPanel;

    private JPanel loginPanel;
    private JTextField profileNameTextField;


    private JPanel aboutPanel;
    private JTextPane aboutTextPane;
    private JButton aboutProfileButton;
    private JPasswordField passwordPasswordField;


    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    public JPanel registerPanel;

    private JButton loginButton;
    private JButton registerButton;
    private JPanel loginRegisterPanel;
    private JTextPane profileAlertTextPane;
    private JCheckBox ProfileCheckBox;
    private JButton profileLoginButton;




    // loginRegistrationPanel methods
    public JPanel getLoginRegisterPanel() {return loginRegisterPanel;}
    public JButton getLoginButton() {return loginButton;}
    public JButton getRegisterButton() {return registerButton;}

    // Register panel methods
    public JTextField getTfName() {return tfName;}
    public JTextField getTfEmail() {return tfEmail;}
    public JTextField getTfPhone() {return tfPhone;}
    public JTextField getTfAddress() {return tfAddress;}
    public JPasswordField getPfPassword() {return pfPassword;}
    public JPasswordField getPfConfirmPassword() {return pfConfirmPassword;}
    public JButton getBtnRegister() {return btnRegister;}
    public JButton getBtnCancel() {return btnCancel;}
    public JPanel getRegisterPanel() {return registerPanel;}

    // Main panel GUI method.
    public JPanel getMainPanel() {return mainPanel;}

    // Start page panel GUI methods.
    public JPanel getStartPanel() {return startPanel;}
    public JButton getStartAboutButton() {return startAboutButton;}
    public JButton getStartProfileButton() {return startProfileButton;}


    // Profile page panel GUI methods.
    public JPanel getLoginPanel() {return loginPanel;}
    public JPasswordField getPasswordPasswordField() {return passwordPasswordField;}
    public JTextField getProfileNameTextField() {return profileNameTextField;}
    public JCheckBox getProfileCheckBox() {return ProfileCheckBox;}
    public JTextPane getProfileAlertTextPane() {return profileAlertTextPane;}
    public JButton getProfileLoginButton() {return profileLoginButton;}

    // About page panel GUI methods
    public JPanel getAboutPanel() {return aboutPanel;}
    public JTextPane getAboutTextPane() {return aboutTextPane;}
    public JButton getAboutProfileButton() {return aboutProfileButton;}

    public GUI(JFrame parent) {
        super(parent);
        setTitle("Homepage");
        setContentPane(mainPanel);
        //setMinimumSize(new Dimension(1150, 900));
        //setModal(true);
        //setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}