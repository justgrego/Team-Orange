import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * User Class
 * @Author Gregory Yi, JD
 * @Version 2.0
 */
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String name;
    public String email;
    public String phone;
    public String address;
    public String password;
    /**
     * Author Gregory Yi, JD
     */
    public void export() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
        final String USERNAME = "orange";
        final String PASSWORD = "!Team360";
        String name = "";
        String email = "";
        String phone = "";
        String address = "";
        try {
            String sql = "SELECT * FROM users WHERE name = '" + this.getName() + "'";
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                name = rs.getString("name");
                email = rs.getString("email");
                phone = rs.getString("phone");
                address = rs.getString("address");
                System.out.println( name
                        + "\t\t" + email + "\t\t" + phone + "\t\t" + address);
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            String tname = "Name: " + name;
            String temail = "Email: " + email;
            String taddress = "Name: " + address;
            String tphone = "Email: " + phone;

            myWriter.write(tname + "\n");
            myWriter.write(temail + "\n");
            myWriter.write(taddress + "\n");
            myWriter.write(tphone + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}