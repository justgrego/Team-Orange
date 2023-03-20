import java.io.File;

/**
 * author: JD Sawyer
 */
public class Plan {
    private String name;
    private File plan;

    public Plan(String name, File plan) {
        this.name = name;
        this.plan = plan;
    }

    public String toString(){
        return "<html>Plan:<br/><br/><br/>Plan Name: " + name + "<br/><br/><html>" +"File: " + plan.getName();
    }

    public String toStringForDb() {
        return name + "," + plan.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getPlan() {
        return plan;
    }

    public void setPlan(File plan) {
        this.plan = plan;
    }
}