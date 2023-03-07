import javax.swing.*;
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
    private JLabel menuLabel;
    private JLabel menuLogoLabel;
    private JButton projectsButton;
    private JButton exportButton;
    private JButton importButton;
    private JButton homePageButton;
    private JPanel resourcesPanel;
    private JLabel resourcesLabel;

    private JPanel toDoPanel;
    private JLabel toDoLabel;
    private JTextField textField1;
    private JTextField exportFile;
    private JPanel exportName;
    private JButton FINISHButton;
    private static User currUser;

    /**
     * Michael Tukson, Gregory Yi
     * @param parent
     */
    public Dashboard(JFrame parent) {
        super(parent);
        setTitle("Dashboard");
        setContentPane(mainDashboardPanel);
        setMinimumSize(new Dimension(1150, 900));
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
                getExportName().setVisible(false);
                dashboardPanel.setVisible(true);

            }
        });
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
}
