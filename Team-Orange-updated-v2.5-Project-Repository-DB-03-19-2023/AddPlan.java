import javax.swing.*;
import java.awt.*;
/**
 * @author Michael Tuskan
 *
 * AddPlan Class
 */
public class AddPlan extends JDialog {

    private JPanel mainAddPlanPanel;
    private JPanel AddPlanPanel;
    private JTextField fileNameTextField;
    private JTextField filePathTextField;
    private JLabel FileNameLabel;
    private JLabel FilePathLabel;
    private JLabel planTitleLabel;
    private JButton addPlanToDataBaseButton;

    public AddPlan(JFrame parent) {
        super(parent);
        setTitle("Resources Pop-Out Screen");
        setContentPane(mainAddPlanPanel);
        setMinimumSize(new Dimension(300, 200));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    public JButton getAddPlanButton() {
        return addPlanToDataBaseButton;
    }

    public JTextField getFileNameTextField() {
        return fileNameTextField;
    }

    public JTextField getFilePathTextField() {
        return filePathTextField;
    }

}
