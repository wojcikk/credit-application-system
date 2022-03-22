package GUI.startingPage;

import GUI.Footer;
import GUI.Header;
import GUI.startingPage.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class StartingPage extends JFrame {

    // PANELS
    private final Header headerClass = new Header();
    private final MainPanel mainPanelClass = new MainPanel(this);
    private final Footer footerClass = new Footer();
    GraphicsEnvironment graphics =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public StartingPage() {
        this.setMinimumSize(new Dimension(800, 800));
//        this.setPreferredSize(new Dimension(800, 800));

        this.setTitle("Starting Page");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel headerPanel = headerClass.createHeaderPanel();
        JPanel footerPanel = footerClass.createFooterPanel();

        JPanel mainPanel = mainPanelClass.createMainPanel();

        container.add(headerPanel);
        container.add(mainPanel);
        container.add(footerPanel);

        container.setBackground(Color.WHITE);

        this.add(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setVisible(true);
        device.setFullScreenWindow(this);
    }
}
