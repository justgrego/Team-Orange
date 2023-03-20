import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 * Author Gregory Yi
 */
public class AuthenticateUser extends JDialog {

    /**
     * Author Gregory Yi
     */
    public AuthenticateUser(GUI gui) {
        gui.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = gui.getProfileNameTextField().getText();
                String password = String.valueOf(gui.getPasswordPasswordField().getPassword());
                user = getAuthenticatedUser(name, password);
                if (user != null)
                    gui.getProfileAlertTextPane().setText("Successfully logged in");
                else
                    gui.getProfileAlertTextPane().setText("Name or Password Invalid");
            }
        });
        boolean hasRegistredUsers = connectToDatabase();
    }

    /**
     * Author Gregory Yi
     */
    private boolean connectToDatabase() {
        boolean hasRegistredUsers = false;
        final String MYSQL_SERVER_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /";
        final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
        final String USERNAME = "orange";
        final String PASSWORD = "!Team360";

        try{
            //First, connect to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(200) NOT NULL,"
                    + "email VARCHAR(200) NOT NULL UNIQUE,"
                    + "phone VARCHAR(200),"
                    + "address VARCHAR(200),"
                    + "password VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);

            //check if we have users in the table users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }
            }
            statement.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }
    public User user;

    /**
     * Author Gregory Yi
     */
    public User getAuthenticatedUser(String name, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
        final String USERNAME = "orange";
        final String PASSWORD = "!Team360";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE name=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
