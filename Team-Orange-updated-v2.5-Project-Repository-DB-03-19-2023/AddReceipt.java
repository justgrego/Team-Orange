import javax.swing.*;
import java.awt.*;
/**
 * @author Michael Tuskan
 *
 * AddReceipt Class
 */
public class AddReceipt extends JDialog{
    private JPanel mainAddReceiptPanel;
    private JPanel addReceiptPanel;
    private JTextField typeTextField;
    private JTextField quantityTextField;
    private JTextField priceTextField;
    private JLabel itemLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JLabel receiptTitleLabel;
    private JPanel receiptOrangeTitleLabel;
    private JButton addReceiptToDataBaseButton;

    public AddReceipt(JFrame parent) {
        super(parent);
        setTitle("Resources Pop-Out Screen");
        setContentPane(mainAddReceiptPanel);
        setMinimumSize(new Dimension(300, 200));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public JButton getAddReceiptButton() {
        return addReceiptToDataBaseButton;
    }

    public JTextField getTypeTextField() {
        return typeTextField;
    }
    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }
}
