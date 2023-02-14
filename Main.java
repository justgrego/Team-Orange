import java.io.IOException;

/**
 * Main Class
 * @Version Michael Tuskan
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Default Message to Client");
        MyApp app = new MyApp();
        app.runApplication();
    }
}