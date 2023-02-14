import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * AboutScreen Class
 * @Version Michael Tuskan
 */
class AboutScreen {

    JButton aboutButton;

    About[] aboutData;
    public AboutScreen()  throws IOException {
        aboutButton = new JButton("About");
        aboutData = new About[5];

    }

    public JPanel aboutScreenButtonAndJPanel() {
        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridBagLayout());
        aboutPanel.setBackground(new Color(255,176,129));
        aboutButton.setForeground(new Color(101,96, 93));
        aboutButton.setBackground(new Color(255,224, 205));
        aboutPanel.add(aboutButton, aboutScreenSpacing());
        return aboutPanel;
    }

    public JButton getAboutButton() { return aboutButton; }

    public GridBagConstraints aboutScreenSpacing() {
        GridBagConstraints spacing = new GridBagConstraints();
        spacing.weightx = 1;
        spacing.weighty = .25;
        spacing.ipady = 15;
        spacing.ipadx = 45;
        return spacing;
    }

    public void openAboutScreen() {
        JFrame aboutScreen = new JFrame();
        aboutScreen.getContentPane().setBackground(new Color(192,192,192));
        aboutScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aboutScreen.setPreferredSize(new Dimension(600,600));
        aboutScreen.pack();
        aboutScreen.setLocationRelativeTo(null);
        aboutScreen.setLocation(600,600);
        aboutScreen.setSize(500,500);
        aboutScreen.setVisible(true);
    }

}
