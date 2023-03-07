import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

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
    public boolean export(String theFile, User user) {
        String name = user.getName();
        String email = user.getEmail();
        String phone = user.getPhone();
        String address = user.getAddress();
        String password = user.getPassword();
        try {
            File myObj = new File(theFile);
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
            FileWriter myWriter = new FileWriter(theFile);
            String tname = "Name: " + name;
            String temail = "Email: " + email;
            String taddress = "Address: " + address;
            String tphone = "Phone: " + phone;
            String tpassword = "Password: " + password;
            myWriter.write(tname + "\n");
            myWriter.write(temail + "\n");
            myWriter.write(taddress + "\n");
            myWriter.write(tphone + "\n");
            myWriter.write(tpassword + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean importData(String filePath, User user){
        File file = new File(filePath);
        String[][] storage = new String[10][10];
        String[] line;
        int index = 0;
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                 line = sc.nextLine().split(":");
                 storage[index] = line;
                 index++;
                 System.out.print(Arrays.toString(line));
            }
            final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
            final String USERNAME = "orange";
            final String PASSWORD = "!Team360";

            String sql = "UPDATE users SET name = '" + storage[0][1].trim() + "', email = '" + storage[1][1].trim() + "', address = '"
                    + storage[2][1].trim() + "', phone ='" + storage[3][1].trim() + "', password = '" + storage[4][1].trim()
                    + "' WHERE name = '" + this.getName() + "'";
            this.setName(storage[0][1].trim());
            this.setEmail(storage[1][1].trim());
            this.setAddress(storage[2][1].trim());
            this.setPassword(storage[4][1].trim());
            this.setPhone(storage[3][1].trim());
            Dashboard.setCurrUser(this);
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                // Connected to database successfully...
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }


        return true;
    }

}