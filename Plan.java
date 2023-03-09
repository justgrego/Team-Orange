import java.io.File;

public class Plan {
    private String name;
    private File plan;

    public Plan(String name, File plan) {
        this.name = name;
        this.plan = plan;
    }

    public String toString(){
        return name;
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
