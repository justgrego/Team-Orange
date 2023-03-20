import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Register {

    public static class RegistrationForm extends JDialog {
        private JTextField tfName;
        private JTextField tfEmail;
        private JTextField tfPhone;
        private JTextField tfAddress;
        private JPasswordField pfPassword;
        private JPasswordField pfConfirmPassword;
        private JButton btnRegister;
        private JButton btnCancel;
        public JPanel registerPanel;

        /**
         * Author Gregory Yi
         */
        RegistrationForm(GUI gui) {
            this.tfName = gui.getTfName();
            this.tfEmail = gui.getTfEmail();
            this.tfPhone = gui.getTfPhone();
            this.tfAddress = gui.getTfAddress();
            this.pfPassword = gui.getPfPassword();
            this.pfConfirmPassword = gui.getPfConfirmPassword();
            this.btnRegister = gui.getBtnRegister();
            this.btnCancel = gui.getBtnCancel();
            this.registerPanel = gui.getRegisterPanel();

            btnRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerUser();
                }
            });

            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gui.getRegisterPanel().setVisible(false);
                    gui.getStartPanel().setVisible(true);
                    dispose();
                }
            });

            setVisible(false);
            btnRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gui.getRegisterPanel().setVisible(false);
                    gui.getLoginPanel().setVisible(true);
                }
            });
        }

        /**
         * Author Gregory Yi
         */
        private void registerUser() {
            String name = tfName.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();
            String address = tfAddress.getText();
            String password = String.valueOf(pfPassword.getPassword());
            String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter all fields",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this,
                        "Confirm Password does not match",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            user = addUserToDatabase(name, email, phone, address, password);
            if (user != null) {
                JOptionPane.showMessageDialog(this,
                        "Successfully registered new user",
                        "Welcome!",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "Failed to register new user",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        public User user;

        /**
         * Author Gregory Yi
         */
        private User addUserToDatabase(String name, String email, String phone, String address, String password) {
            User user = null;
            final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
            final String USERNAME = "orange";
            final String PASSWORD = "!Team360";

            try{
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                // Connected to database successfully...

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO users (name, email, phone, address, password) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, phone);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, password);

                //Insert row into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {
                    user = new User();
                    user.name = name;
                    user.email = email;
                    user.phone = phone;
                    user.address = address;
                    user.password = password;
                }
                stmt.close();
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return user;
        }
    }
}
