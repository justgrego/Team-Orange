/**
 * @author Michael Tuskan
 *
 * Client Class
 */
public class Material {
    private String material;
    private int quantity;

    public Material(String material, int quantity) {
        this.material = material;
        this.quantity = quantity;

    }

    public String getMaterial() {
        return material;
    }

    public void setCompany(String material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "<html>Building Material: <br/><br/><br/>Quantity: " + quantity + "<br/><br/>Material Type: " + material + "<html>";
    }
    public String toStringForDb() {
        return material + "," + quantity;
    }
}
