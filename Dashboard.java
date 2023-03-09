import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
    private JPanel taskOne;
    private JPanel taskTwo;
    private JPanel taskThree;
    private JPanel taskFour;
    private JPanel taskFive;
    private JPanel taskSix;
    private JPanel taskSeven;
    private JPanel taskEight;
    private JPanel taskNine;
    private JPanel taskTen;
    private JPanel taskEleven;
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
        setTitle("Dashboard");
        setContentPane(mainDashboardPanel);
        setMinimumSize(new Dimension(1150, 800));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        project = new Project();
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
                getExportName().setVisible(false);
                dashboardPanel.setVisible(true);

            }
        });

        /**
         * Author Ian Liston
         */
        // Creates round boarder of task bars {
        taskOne.setBorder(new RoundedBorder(10));
        taskTwo.setBorder(new RoundedBorder(10));
        taskThree.setBorder(new RoundedBorder(10));
        taskFour.setBorder(new RoundedBorder(10));
        taskFive.setBorder(new RoundedBorder(10));
        taskSix.setBorder(new RoundedBorder(10));
        taskSeven.setBorder(new RoundedBorder(10));
        taskEight.setBorder(new RoundedBorder(10));
        taskNine.setBorder(new RoundedBorder(10));
        taskTen.setBorder(new RoundedBorder(10));
        taskEleven.setBorder(new RoundedBorder(10));
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
        // New task popup window.
        taskWinPlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task(toDoLWinTextField.getText(),toDoLWinDateField.getText());
                project.addTask(task);
                taskWinPanel.setVisible(false);
                taskDropPanel.setVisible(true);
                // Re-populate task bars here!!!!
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
}
