/**
 * author: JD Sawyer
 */
public class Receipt {
    private int quantity;
    private String item;
    private double price;

    @Override
    public String toString() {
        return "<html>Receipt:<br/><br/><br/> Quantity: " + quantity +"<br/><br/> Item: "+ item
                + "<br/><br/> Subtotal: $" + price +"<br/><br/> Total: $" + quantity * price + "<html>";
    }

    public String toStringForDb() {
        return item + "," + quantity + "," + price;
    }

    public Receipt(int quantity, String name, double price) {
        this.quantity = quantity;
        this.item = name;
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return item;
    }

    public void setType(String type) {
        this.item = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}