import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Tuskan
 *
 * Dashboard Class
 */
public class Dashboard extends JDialog{
    private JPanel mainDashboardPanel;
    private JPanel dashboardPanel;
    private JPanel menuPanel;
    private JButton projectsButton;
    private JButton exportButton;
    private JButton importButton;
    private JButton homePageButton;
    private JPanel resourcesPanel;

    private JTextField exportFile;
    private JPanel exportName;
    private JButton FINISHButton;
    private User currUser;

    /**
     * Author Ian Liston
     */
    private JPanel toDoPanel;
    private JTextPane toDoListTextPane;
    private JPanel task1;
    private JPanel task2;
    private JPanel task3;
    private JPanel task4;
    private JPanel task5;
    private JPanel task6;
    private JPanel task7;
    private JPanel task8;
    private JPanel task9;
    private JPanel task10;
    private JPanel task11;
    private JButton task1Button;
    private JTextArea task1TextPane;
    private JButton task2Button;
    private JTextArea task2TextPane;
    private JButton task3Button;
    private JTextArea task3TextPane;
    private JButton task4Button;
    private JTextArea task4TextPane;
    private JButton task5Button;
    private JTextArea task5TextPane;
    private JButton task6Button;
    private JTextArea task6TextPane;
    private JButton task7Button;
    private JTextArea task7TextPane;
    private JButton task8Button;
    private JTextArea task8TextPane;
    private JButton task9Button;
    private JTextArea task9TextPane;
    private JButton task10Button;
    private JTextArea task10TextPane;
    private JButton task11Button;
    private JTextArea task11TextPane;
    private Queue<JTextArea> taskTextQue;
    private Queue<JPanel> taskPanelQue;
    private Queue<JButton> taskButtonQue;

    private JButton resourcePlusButton;
    private JButton toDoListPlusButton;
    private JButton taskWinPlusButton;
    private JTextField toDoLWinTextField;
    private JTextField toDoLWinDateField;
    private JPanel taskWinPanel;
    private JPanel taskDropPanel;

    private Project project;

    /**
     * Michael Tukson, Gregory Yi
     * @param parent
     */
    public Dashboard(JFrame parent) {
        super(parent);

        project = new Project();
        taskTextQue = new LinkedList<>();
        taskPanelQue = new LinkedList<>();
        taskButtonQue = new LinkedList<>();
        createTaskQueues();

        setTitle("Dashboard");
        setContentPane(mainDashboardPanel);
        setMinimumSize(new Dimension(1150, 800));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getExportName().setVisible(true);
                dashboardPanel.setVisible(false);
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
                if (currUser.export(fileName, currUser)) {
                    JOptionPane.showMessageDialog(dashboardPanel,
                            "Successfully exported file " + fileName,
                            "Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(dashboardPanel,
                            "Failed to create file, please try again",
                            "Failed",
                            JOptionPane.ERROR_MESSAGE);
                }

                System.out.println("Successful for " + currUser.getName());

                project.rePopulateTasks();

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
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
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
