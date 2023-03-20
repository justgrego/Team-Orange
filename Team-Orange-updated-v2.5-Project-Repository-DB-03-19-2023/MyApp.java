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
    private ProjectDirectory projectDirectory;


    // Constructor
    public MyApp() {
        gui = new GUI( null);
        about = new About();
        projectDirectory = new ProjectDirectory(null);

    }

    /**
     * Author Michael Tuskan and Ian Liston
     */
    public void runApplication() {

        // Main Homepage JFrame settings
        setContentPane(gui.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600, 600);
        setTitle("Homepage");

        // About Button Action Listener
        gui.getStartAboutButton().addActionListener(new aboutButtonListener());
        gui.getStartProfileButton().addActionListener(new profileButtonListener());
        gui.getAboutProfileButton().addActionListener(new aboutProfileButtonListener());
        gui.getProfileCheckBox().addActionListener(new profileCheckBoxListener());
        gui.getLoginButton().addActionListener(new loginRegLoginButtonListener());
        gui.getRegisterButton().addActionListener(new loginRegRegisterButtonListener());
        gui.getPasswordPasswordField().addActionListener(new profilePasswordEnter());
        gui.getProfileLoginButton().addActionListener(new profileLoginButtonListener());
//        dashboard.getHomepageButton().addActionListener(new homepageButtonListener());
    }

    public ProjectDirectory getProjectDirectory() {
        return projectDirectory;
    }

    public GUI getGui() {
        return gui;
    }

    /**
     * @Author Ian Liston, Gregory Yi
     */
    class profileLoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AuthenticateUser aUser = new AuthenticateUser(gui);
            String name = gui.getProfileNameTextField().getText();
            String password = String.valueOf(gui.getPasswordPasswordField().getPassword());
            user = aUser.getAuthenticatedUser(name, password);
            Dashboard.setCurrUserName(user.name);
            if (user != null) {
                gui.getProfileAlertTextPane().setText("Login Successful");
                gui.getProfileAlertTextPane().setVisible(true);
                setVisible(false);
//                dashboard.getExportName().setVisible(false); //TODO move to projectDirectory.java
//                dashboard.setCurrUser(user);
//                dashboard.setVisible(true);
//                ProjectDirectory.loadProjectsFromUser();

                //Load existing projects from user in database
                System.out.println(Dashboard.getCurrUserName());
                projectDirectory.addUserProjectNameToDb(Dashboard.getCurrUserName());
                //projectDirectory.connectToDatabaseAccessUserSpecificProjects();
                projectDirectory.setVisible(true);
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
    class profilePasswordEnter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AuthenticateUser aUser = new AuthenticateUser(gui);
            String email = gui.getProfileNameTextField().getText();
            String password = String.valueOf(gui.getPasswordPasswordField().getPassword());
            user = aUser.getAuthenticatedUser(email, password);
            if (user != null) {
                gui.getProfileAlertTextPane().setText("Login Successful");
                gui.getProfileAlertTextPane().setVisible(true);
            }
            else {
                gui.getProfileAlertTextPane().setText("Invalid");
                gui.getProfileAlertTextPane().setVisible(true);
            }
        }
    }

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



//    /**
//     * Author Michael Tuskan
//     */
//
//    class homepageButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            setVisible(true);
//            dashboard.setVisible(false);
//            gui.getProfileAlertTextPane().setVisible(false);
//        }
//    }

//    class exportButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            dashboard.getExportName().setVisible(true);
//        }
//    }


}