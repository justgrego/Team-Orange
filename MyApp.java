import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MyApp Class
 * @Author Michael Tuskan and Ian Liston
 * @Version 2.0
 */

public class MyApp extends JFrame {
    private GUI gui;
    private About about;
    private User user;

    // Constructor
    public MyApp() {
        gui = new GUI();
        about = new About();
    }

    /**
     * Author Michael Tuskan and Ian Liston
     */
    public void runApplication() {

        // Main Homepage JFrame settings
        setContentPane(gui.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(500, 200);
        setSize(600, 600);
        setTitle("Iteration 1");

        // About Button Action Listener
        gui.getStartAboutButton().addActionListener(new aboutButtonListener());
        gui.getStartProfileButton().addActionListener(new profileButtonListener());
        gui.getAboutProfileButton().addActionListener(new aboutProfileButtonListener());
        gui.getProfileCheckBox().addActionListener(new profileCheckBoxListener());
        gui.getLoginButton().addActionListener(new loginRegLoginButtonListener());
        gui.getRegisterButton().addActionListener(new loginRegRegisterButtonListener());
       // gui.getPasswordPasswordField().addActionListener(new profilePasswordEnter());
        gui.getProfileLoginButton().addActionListener(new profileLoginButtonListener());
    }

    /**
     * @Author Ian Liston, Gregory Yi
     */
    class profileLoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AuthenticateUser aUser = new AuthenticateUser(gui);
            String email = gui.getProfileNameTextField().getText();
            String password = String.valueOf(gui.getPasswordPasswordField().getPassword());
            user = aUser.getAuthenticatedUser(email, password);
            if (user != null) {
                gui.getProfileAlertTextPane().setText("Login Successful");
                gui.getProfileAlertTextPane().setVisible(true);
                user.export();
            }
            else {
                gui.getProfileAlertTextPane().setText("Invalid");
                gui.getProfileAlertTextPane().setVisible(true);
            }
        }
    }

    /**
     * @Author Ian Liston
     */
    class loginRegRegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getLoginRegisterPanel().setVisible(false);
            Register.RegistrationForm myForm = new Register.RegistrationForm(gui);
            user = myForm.user;
            gui.getRegisterPanel().setVisible(true);
            if (user != null) {
                System.out.println("Successful registration of: " + user.name);
            }
            else {
                System.out.println("Registration canceled");
            }
            gui.getRegisterPanel().setVisible(true);
        }
    }

    /**
     * @Author Ian Liston, Gregory Yi
     */
    class loginRegLoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getLoginRegisterPanel().setVisible(false);
            gui.getLoginPanel().setVisible(true);
        }
    }

    /**
     * Author Ian Liston
     */
    class profileCheckBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(gui.getProfileCheckBox().isSelected())
                gui.getPasswordPasswordField().setEchoChar((char)0);
            else
                gui.getPasswordPasswordField().setEchoChar('*');
        }
    }

    /**
     * Author Ian Liston
     */
//    class profilePasswordEnter implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            AuthenticateUser aUser = new AuthenticateUser(gui);
//            String email = gui.getProfileNameTextField().getText();
//            String password = String.valueOf(gui.getPasswordPasswordField().getPassword());
//            user = aUser.getAuthenticatedUser(email, password);
//            if (user != null) {
//                gui.getProfileAlertTextPane().setText("Login Successful");
//                gui.getProfileAlertTextPane().setVisible(true);
//            }
//            else {
//                gui.getProfileAlertTextPane().setText("Invalid");
//                gui.getProfileAlertTextPane().setVisible(true);
//            }
//        }
//    }

    /**
     * Author Michael Tuskan and Ian Liston
     */
    class profileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getStartPanel().setVisible(false);
            gui.getLoginRegisterPanel().setVisible(true);
        }
    }

        /**
         * Author Michael Tuskan and Ian Liston
         */
    class aboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getStartPanel().setVisible(false);
            gui.getAboutTextPane().setText(about.displayString());
            gui.getAboutPanel().setVisible(true);
        }
    }

    /**
     * @Author Ian Liston
     */
    class aboutProfileButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getAboutPanel().setVisible(false);
            gui.getLoginRegisterPanel().setVisible(true);
        }
    }
}