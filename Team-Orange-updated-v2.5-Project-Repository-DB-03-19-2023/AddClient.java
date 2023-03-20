import javax.swing.*;
import java.awt.*;

/**
 * @author Michael Tuskan
 *
 * AddClient Class
 */
public class AddClient extends JDialog{
    private JPanel mainAddClientPanel;
    private JPanel addClientPanel;
    private JTextField companyTextField;
    private JTextField contactTextField;
    private JButton addClientToDataBaseButton;
    private JLabel companyLabel;
    private JLabel contactLabel;
    private JLabel clientTitleLabel;
    private JPanel clientOrangeTitlePanel;
    private JTextField nametTextField;
    private JLabel nameLabel;
    private Client client;

    public AddClient(JFrame parent) {
        super(parent);
        setTitle("Resources Pop-Out Screen");
        setContentPane(mainAddClientPanel);
        setMinimumSize(new Dimension(300, 200));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    public JButton getAddClientButton() {
        return addClientToDataBaseButton;
    }

    public JTextField getCompanyTextField() {
        return companyTextField;
    }

    public JTextField getContactTextField() {
        return contactTextField;
    }

    public JTextField getNametTextField() {
        return nametTextField;
    }

}
