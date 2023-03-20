import javax.swing.*;
import java.awt.*;
/**
 * @author Michael Tuskan
 *
 * AddMaterial Class
 */
public class AddMaterial extends JDialog{
    private JPanel mainAddMaterialPanel;
    private JPanel addMaterialPanel;
    private JTextField materialTextField;
    private JTextField quantityTextField;
    private JLabel materialLabel;
    private JLabel quantityLabel;
    private JLabel materialTitleLabel;
    private JPanel materialOrangeTitlePanel;
    private JButton addMaterialToDataBaseButton;

    public AddMaterial(JFrame parent) {
        super(parent);
        setTitle("Resources Pop-Out Screen");
        setContentPane(mainAddMaterialPanel);
        setMinimumSize(new Dimension(300, 200));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    public JButton getAddMaterialButton() {
        return addMaterialToDataBaseButton;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public JTextField getMaterialTextField() {
        return materialTextField;
    }
}
