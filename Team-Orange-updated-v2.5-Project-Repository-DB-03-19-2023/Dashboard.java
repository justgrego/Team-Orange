import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.util.*;

/**
 * @author Michael Tuskan, Gregory Yi, Ian Liston
 *
 * Dashboard Class
 */
public class Dashboard extends ProjectDirectory{//extends JDialog{
    private JPanel mainDashboardPanel;
    private JPanel dashboardPanel;
    private JButton exportButton;
    private JButton importButton;
    private JButton homePageButton;
    private JPanel resourcesPanel;
    private JTextField exportFile;
    private JPanel exportName;
    private JButton FINISHButton;
    private JComboBox receiptComboBox;
    private JComboBox buildingMaterialsComboBox;
    private JComboBox plansComboBox;
    private JComboBox clientListComboBox;
    private JButton exportBackDashboardButton;
    private JButton addReceiptButton;
    private JButton addMaterialButton;
    private JButton addPlanButton;
    private JButton addClientButton;
    private JPanel toDoPanel;
    private JPanel taskDropPanel;
    private JPanel task1;
    private JButton task1Button;
    private JTextArea task1TextPane;
    private JPanel task2;
    private JButton task2Button;
    private JTextArea task2TextPane;
    private JPanel task3;
    private JButton task3Button;
    private JTextArea task3TextPane;
    private JPanel task4;
    private JButton task4Button;
    private JTextArea task4TextPane;
    private JPanel task5;
    private JButton task5Button;
    private JTextArea task5TextPane;
    private JPanel task6;
    private JButton task6Button;
    private JTextArea task6TextPane;
    private JPanel task7;
    private JButton task7Button;
    private JTextArea task7TextPane;
    private JPanel task8;
    private JButton task8Button;
    private JTextArea task8TextPane;
    private JPanel task9;
    private JButton task9Button;
    private JTextArea task9TextPane;
    private JPanel task10;
    private JButton task10Button;
    private JTextArea task10TextPane;
    private JPanel task11;
    private JButton task11Button;
    private JTextArea task11TextPane;
    private JTextPane toDoListTextPane;
    private JButton toDoListPlusButton;
    private JPanel taskWinPanel;
    private JButton taskWinPlusButton;
    private JTextField toDoLWinTextField;
    private JTextField toDoLWinDateField;
    private JPanel todoOrangeTitlePanel;
    private JTextPane ResourcesOrangeTitleLabel;
    private JPanel menuPanel;
    private JButton projectsButton;
    private JPanel REMOVEprojectPanel;
    private JButton deleteButton;
    private JComboBox projectJComboBox;
    private JButton createButton;
    private JButton viewReceiptButton;
    private JButton viewMaterialButton;
    private JButton viewPlanButton;
    private JButton viewClientButton;

    private static User currUser;
    private static Project project;
    private AddClient addClient;
    private AddMaterial addMaterial;
    private AddPlan addPlan;
    private AddReceipt addReceipt;
    private Resource resource;

    public static String getCurrUserName() {
        return currUserName;
    }

    public static void setCurrUserName(String currU) {
        currUserName = currU;
    }

    private static String currUserName;
    private Queue<JTextArea> taskTextQue;
    private Queue<JPanel> taskPanelQue;
    private Queue<JButton> taskButtonQue;

    private int dashboardFlag;


    /**
     * Michael Tuskan, Gregory Yi, Ian Liston
     */
    public Dashboard(JFrame parent) {
        super(parent);

        //To-Do list queues
        taskTextQue = new LinkedList<>();
        taskPanelQue = new LinkedList<>();
        taskButtonQue = new LinkedList<>();
        dashboardFlag = 0;

        createTaskQueues();

        //Main Dashboard Panel Options
        setTitle("Dashboard");
        setContentPane(mainDashboardPanel);
        setMinimumSize(new Dimension(1250, 820));
        setModal(true);
        setLocationRelativeTo(parent); //(parent)
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        getProjectPanel().setVisible(false);
        getExportName().setVisible(false);

        //Resources Objects
        resource = new Resource(null);
        addClient = new AddClient(null);
        addMaterial = new AddMaterial(null);
        addPlan = new AddPlan(null);
        addReceipt = new AddReceipt(null);

        // Adding Resources - Listeners
        addClient.getAddClientButton().addActionListener(new addClientNameTextFieldListener());
        addMaterial.getAddMaterialButton().addActionListener(new addMaterialNameTextFieldListener());
        addReceipt.getAddReceiptButton().addActionListener(new addReceiptNameTextFieldListener());
        addPlan.getAddPlanButton().addActionListener(new addPlanNameTextFieldListener());
        resource.getRemoveButton().addActionListener(new removeResourceButtonListener());


        viewReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String receiptName = (String) receiptComboBox.getSelectedItem();
                String strTemp = "";
                for (int idx = 0; idx < project.getReceipts().length; idx++) {
                    if (receiptName.matches(project.getReceipts()[idx].getType())) {
                        strTemp += project.getReceipts()[idx].toString();
                        resource.setReceiptIndexForPostRemoval(idx);
                    }
                }
                resource.getResourceLabel().setText(strTemp);
                dashboardFlag++;
                resource.setVisible(true);
            }
        });
        viewMaterialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String materialType = (String) buildingMaterialsComboBox.getSelectedItem();
                String strTemp = "";
                for (int idx = 0; idx < project.getMaterials().length; idx++) {
                    if (materialType.matches(project.getMaterials()[idx].getMaterial())) {
                        strTemp += project.getMaterials()[idx].toString();
                        resource.setMaterialIndexForPostRemoval(idx);
                    }
                }
                resource.getResourceLabel().setText(strTemp);
                dashboardFlag++;
                resource.setVisible(true);
            }
        });
        viewPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String planFileName = (String) plansComboBox.getSelectedItem();
                String strTemp = "";
                for (int idx = 0; idx < project.getPlans().length; idx++) {
                    if (planFileName.matches(project.getPlans()[idx].getName())) {
                        strTemp += project.getPlans()[idx].toString();
                        resource.setPlanIndexForPostRemoval(idx);
                    }
                }
                resource.getResourceLabel().setText(strTemp);
                dashboardFlag++;
                resource.setVisible(true);
            }
        });
        viewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientName = (String) clientListComboBox.getSelectedItem();
                String strTemp = "";
                for (int idx = 0; idx < project.getClients().length; idx++) {
                    if (clientName.matches(project.getClients()[idx].getName())) {
                        strTemp += project.getClients()[idx].toString();
                        resource.setClientIndexForPostRemoval(idx);
                    }
                }
                resource.getResourceLabel().setText(strTemp);
                dashboardFlag++;
                resource.setVisible(true);
            }
        });

        /** @author Michael Tuskan */
        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient.setVisible(true);

            }
        });

        /** @author Michael Tuskan */
        addMaterialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMaterial.setVisible(true);

            }
        });

        /** @author Michael Tuskan */
        addReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReceipt.setVisible(true);
            }
        });

        /** @author Michael Tuskan */
        addPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPlan.setVisible(true);
            }
        });


        exportBackDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.setVisible(true);
                exportName.setVisible(false);
            }
        });

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getExportName().setVisible(true);
                dashboardPanel.setVisible(false);
            }
        });

        /** @author Michael Tuskan */
        projectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                getProjectPanel().setVisible(true);
                setVisible(false);


            }
        });

        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myPath = ".";
                File selected = null;
                JFileChooser JFile = new JFileChooser(new File(myPath));
                int returnVal = JFile.showOpenDialog(null);
                if (returnVal == JFile.APPROVE_OPTION) {
                    selected = JFile.getSelectedFile();
                }
                String filePath = selected.getAbsolutePath();

                if(currUser.importData(filePath, currUser)){
                    JOptionPane.showMessageDialog(dashboardPanel,
                            "Successfully exported file " + filePath,
                            "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(dashboardPanel,
                            "Failed to create file, please try again",
                            "Failed",
                            JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        FINISHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = exportFile.getText();
                String message = currUser.export(fileName, currUser);
                if (message.contains("Successfully")) {
                    JOptionPane.showMessageDialog(dashboardPanel,
                            message,
                            "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(dashboardPanel,
                            message,
                            "Failed",
                            JOptionPane.ERROR_MESSAGE);
                }

                System.out.println("Successful for " + currUser.getName());
                getExportName().setVisible(false);
                dashboardPanel.setVisible(true);

            }
        });

        /**
         * Author Ian Liston
         */
        // Creates round boarder of task bars {
        task1.setBorder(new RoundedBorder(10));
        task2.setBorder(new RoundedBorder(10));
        task3.setBorder(new RoundedBorder(10));
        task4.setBorder(new RoundedBorder(10));
        task5.setBorder(new RoundedBorder(10));
        task6.setBorder(new RoundedBorder(10));
        task7.setBorder(new RoundedBorder(10));
        task8.setBorder(new RoundedBorder(10));
        task9.setBorder(new RoundedBorder(10));
        task10.setBorder(new RoundedBorder(10));
        task11.setBorder(new RoundedBorder(10));
        // }

        /**
         * Author Ian Liston
         */
        // The To-Do-List plus button action listener opens the new task bar window
        toDoListPlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskDropPanel.setVisible(false);
                taskWinPanel.setVisible(true);
            }
        });

        /**
         * Author Ian Liston
         */
        // New task popup window plus button. This Window adds a new task to the to-dolist.
        taskWinPlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!taskPanelQue.isEmpty()) {
                    Task task = new Task(toDoLWinTextField.getText(), toDoLWinDateField.getText(), taskPanelQue.remove(),
                            taskButtonQue.remove(), taskTextQue.remove(), project);
                    project.addTask(task);
                }
                project.rePopulateTasks();
                taskWinPanel.setVisible(false);
                taskDropPanel.setVisible(true);

            }
        });

        homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
    }

    //ADD RESOURCES/TO-DO-LIST TO SQL DATABASE
    //TODO Recent add Sql stuff
    public static void addToDb(String column, String data) {
        final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
        final String USERNAME = "orange";
        final String PASSWORD = "!Team360";
        String p = project.getProjectName();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + currUserName + p + " (" + column + ") " +
                    "VALUES ('" + data + "')";
            System.out.println("INSERT INTO " + currUserName + p + " (" + column + ") " +
                    "VALUES (" + data + ")");
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /** @author Michael Tuskan */
    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return this.project;
    }

    public static void setCurrUser(User theUser) {
        currUser = theUser;
    }

    public User getCurrUser() {
        return currUser;
    }

    public JButton getHomepageButton() {
        return homePageButton;
    }

    public JPanel getExportName() {
        return exportName;
    }

    public JPanel getProjectPanel(){return REMOVEprojectPanel;} //TODO remove
    public JPanel getMainDashboardPanel() {
        return mainDashboardPanel;
    }


    /** @author Michael Tuskan */
    public void setReceiptJComboBox(Receipt receipt) {
        receiptComboBox.addItem(receipt.getType());
        resource.setVisible(false);
    }

    /** @author Michael Tuskan */
    public void setMaterialJComboBox(Material material) {
        buildingMaterialsComboBox.addItem(material.getMaterial());
        resource.setVisible(false);
    }

    /** @author Michael Tuskan */
    public void setPlanJComboBox(Plan plan) {
        plansComboBox.addItem(plan.getName());
        resource.setVisible(false);
    }

    /** @author Michael Tuskan */
    public void setClientJComboBox(Client client) {
        clientListComboBox.addItem(client.getName());
        resource.setVisible(false);
    }

    /** @author Michael Tuskan */
    public void removeReceiptJComboBox(int compareIndex) {
        for (int idx = 0; idx < receiptComboBox.getItemCount(); idx++) {
            if (idx == compareIndex) {
                receiptComboBox.removeItemAt(idx);
            }
        }

    }

    /** @author Michael Tuskan */
    public void removeMaterialJComboBox(int compareIndex) {
        for (int idx = 0; idx < buildingMaterialsComboBox.getItemCount(); idx++) {
            if (idx == compareIndex) {
                buildingMaterialsComboBox.removeItemAt(idx);
            }
        }

    }

    /** @author Michael Tuskan */
    public void removePlanJComboBox(int compareIndex) {
        for (int idx = 0; idx < plansComboBox.getItemCount(); idx++) {
            if (idx == compareIndex) {
                plansComboBox.removeItemAt(idx);
            }
        }

    }

    /** @author Michael Tuskan */
    public void removeClientJComboBox(int compareIndex) {
        for (int idx = 0; idx < clientListComboBox.getItemCount(); idx++) {
            if (idx == compareIndex) {
                clientListComboBox.removeItemAt(idx);
            }
        }

    }

    /** @author Michael Tuskan */
    class addClientNameTextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = new Client(addClient.getNametTextField().getText(),
                                       addClient.getCompanyTextField().getText()
                                     , addClient.getContactTextField().getText());
            project.addClient(client);
            addToDb("clients", client.toStringForDb());
            setClientJComboBox(client);
            resource.setVisible(false);

        }
    }

    /** @author Michael Tuskan */
    class addMaterialNameTextFieldListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Material material = new Material(addMaterial.getMaterialTextField().getText(),
                           Integer.parseInt(addMaterial.getQuantityTextField().getText()));
            project.addMaterials(material);
            addToDb("materials", material.toStringForDb());
            setMaterialJComboBox(material);
            resource.setVisible(false);

        }
    }

    /** @author Michael Tuskan */
    class addReceiptNameTextFieldListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Receipt receipt = new Receipt(Integer.parseInt(addReceipt.getQuantityTextField().getText()),
                                  addReceipt.getTypeTextField().getText(),
                                  Double.parseDouble(addReceipt.getPriceTextField().getText()));
            project.addReceipt(receipt);
            addToDb("receipts", receipt.toStringForDb());
            setReceiptJComboBox(receipt);
            resource.setVisible(false);

        }
    }


    /** @author Michael Tuskan */
    class addPlanNameTextFieldListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File newFile = new File("src/" +addPlan.getFilePathTextField().getText());
            Plan plan = new Plan(addPlan.getFileNameTextField().getText(),newFile);
            project.addPlan(plan);
            addToDb("plan", plan.toStringForDb());
            setPlanJComboBox(plan);
            resource.setVisible(false);
        }
    }


    //Connect to the Database to get Dashboard data
    //TODO mySQL recent add by Michael
    public boolean connectToDatabase(String userName, String projectName) {
        boolean hasProject = false;
        final String DB_URL = "jdbc:mysql://teamorange.mysql.database.azure.com /login?serverTimezone=UTC";
        final String USERNAME = "orange";
        final String PASSWORD = "!Team360";
//        String p = project.getProjectName();

        try{

            //Second, connect to the database and create the table "users" if cot created
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * "
                            //"receipts, clients, materials, plan" //id,
                            + "FROM "
                            + userName + projectName);
                            //+ getCurrUserName() + getProject().getProjectName()); // getProject().getProjectName()

            while (resultSet.next()) {

                if (!(resultSet.getString("receipts").matches("-1"))) {
                    String[] strReceipts = resultSet.getString("receipts").split(",");
                    Receipt receipt = new Receipt(Integer.valueOf(strReceipts[1]),strReceipts[0],Double.valueOf(strReceipts[2]));
//                    project.addReceipt(receipt);
//                    project.getDashboard().setReceiptJComboBox(receipt);
                    getProject().addReceipt(receipt);
                    setReceiptJComboBox(receipt);
                }

                if (!(resultSet.getString("clients").matches("-1"))) {
                    String[] strClients = resultSet.getString("clients").split(",");
                    Client client = new Client(strClients[0], strClients[1],strClients[2]);
//                    project.addClient(client);
//                    project.getDashboard().setClientJComboBox(client);
                    getProject().addClient(client);
                    setClientJComboBox(client);
                }

                if (!(resultSet.getString("materials").matches("-1"))) {
                    String[] strMaterials = resultSet.getString("materials").split(",");
                    Material material = new Material(strMaterials[0], Integer.valueOf(strMaterials[1]));
//                    project.addMaterials(material);
//                    project.getDashboard().setMaterialJComboBox(material);
                    getProject().addMaterials(material);
                    setMaterialJComboBox(material);
                }


                if (!(resultSet.getString("plan").matches("-1"))) {
                    String[] strPlans = resultSet.getString("plan").split(",");
                    File file = new File(strPlans[1]);
                    Plan plan = new Plan(strPlans[0], file);
//                    project.addPlan(plan);
//                    project.getDashboard().setPlanJComboBox(plan);
                    getProject().addPlan(plan);
                    setPlanJComboBox(plan);
                }

                if (!(resultSet.getString("todo").matches("-1"))) {
                    //TODO Ian, populate your To-Do-List data from the SQL database here...
                }

            }
            statement.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return hasProject;
    }

    /** @author Michael Tuskan */
    class removeResourceButtonListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(resource.getResourceLabel().getText().contains("Client List:")) {
                project.removeClient(resource.getClientIndexForPostRemoval());
                removeClientJComboBox(resource.getClientIndexForPostRemoval());
            }
            if (resource.getResourceLabel().getText().contains("Receipt:")) {
                project.removeReceipt(resource.getReceiptIndexForPostRemoval());
                removeReceiptJComboBox(resource.getReceiptIndexForPostRemoval());
            }
            if (resource.getResourceLabel().getText().contains("Building Material:")) {
                project.removeMaterial(resource.getMaterialIndexForPostRemoval());
                removeMaterialJComboBox(resource.getMaterialIndexForPostRemoval());
            }
            if (resource.getResourceLabel().getText().contains("Plan:")){
                project.removePlan(resource.getPlanIndexForPostRemoval());
                removePlanJComboBox(resource.getPlanIndexForPostRemoval());
            }
            resource.setVisible(false);

        }
    }


    /**
     * Author Ian Liston
     */
    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }

    /** @author Ian Liston */
    private void createTaskQueues(){
        this.taskTextQue.add(task1TextPane);
        this.taskTextQue.add(task2TextPane);
        this.taskTextQue.add(task3TextPane);
        this.taskTextQue.add(task4TextPane);
        this.taskTextQue.add(task5TextPane);
        this.taskTextQue.add(task6TextPane);
        this.taskTextQue.add(task7TextPane);
        this.taskTextQue.add(task8TextPane);
        this.taskTextQue.add(task9TextPane);
        this.taskTextQue.add(task10TextPane);
        this.taskTextQue.add(task11TextPane);

        this.taskPanelQue.add(task1);
        this.taskPanelQue.add(task2);
        this.taskPanelQue.add(task3);
        this.taskPanelQue.add(task4);
        this.taskPanelQue.add(task5);
        this.taskPanelQue.add(task6);
        this.taskPanelQue.add(task7);
        this.taskPanelQue.add(task8);
        this.taskPanelQue.add(task9);
        this.taskPanelQue.add(task10);
        this.taskPanelQue.add(task11);

        this.taskButtonQue.add(task1Button);
        this.taskButtonQue.add(task2Button);
        this.taskButtonQue.add(task3Button);
        this.taskButtonQue.add(task4Button);
        this.taskButtonQue.add(task5Button);
        this.taskButtonQue.add(task6Button);
        this.taskButtonQue.add(task7Button);
        this.taskButtonQue.add(task8Button);
        this.taskButtonQue.add(task9Button);
        this.taskButtonQue.add(task10Button);
        this.taskButtonQue.add(task11Button);
    }


}
