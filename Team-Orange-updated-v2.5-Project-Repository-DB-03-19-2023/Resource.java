import javax.swing.*;
import java.awt.*;
/**
 * @author Michael Tuskan
 *
 * Resource Class
 */
public class Resource extends JDialog{
    private JPanel mainResourcePanel;
    private JPanel resourcePanel;
    private JLabel resourceLabel;
    private JButton remove;
    private int receiptIndex;
    private int clientIndex;
    private int materialIndex;
    private int planIndex;


    public Resource(JFrame parent) {
        super(parent);
        setTitle("Resources Pop-Out Screen");
        setContentPane(mainResourcePanel);
        setMinimumSize(new Dimension(300, 450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        receiptIndex = 0;
        materialIndex = 0;
        planIndex = 0;
        clientIndex = 0;

    }

    public JLabel getResourceLabel() {
        return resourceLabel;
    }

    public void setReceiptIndexForPostRemoval(int receiptIndex) {
        this.receiptIndex = receiptIndex;
    }

    public int getReceiptIndexForPostRemoval() {
        return this.receiptIndex;
    }

    public void setMaterialIndexForPostRemoval(int materialIndex) {
        this.materialIndex = materialIndex;
    }

    public int getMaterialIndexForPostRemoval() {
        return this.materialIndex;
    }

    public void setPlanIndexForPostRemoval(int planIndex) {
        this.planIndex = planIndex;
    }

    public int getPlanIndexForPostRemoval() {
        return this.planIndex;
    }

    public void setClientIndexForPostRemoval(int clientIndex) {
        this.clientIndex = clientIndex;
    }

    public int getClientIndexForPostRemoval() {
        return this.clientIndex;
    }


    public JButton getRemoveButton() {
        return remove;
    }
}
