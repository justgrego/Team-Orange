/**
 * @author Michael Tuskan
 *
 * Client Class
 */
public class Client {
    private String name;
    private String contact;
    private String company;

//    private String invoice;


    public Client(String name, String contact, String company) {
        this.name = name;
        this.contact = contact;
        this.company = company;

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "<html>Client List:<br/><br/><br/> Client Name: " +  name
                + "<br/><br/>Company: " + company
                + "<br/><br/>Contact Information: " + contact + "<html>";
    }

    public String toStringForDb() {
        return name + "," + company + "," + contact;
    }
}
