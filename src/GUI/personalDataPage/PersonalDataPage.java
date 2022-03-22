package GUI.personalDataPage;

import GUI.Footer;
import GUI.Header;
import GUI.personalDataPage.panels.MainPanelPersonal;

import javax.swing.*;
import java.awt.*;

public class PersonalDataPage extends JFrame {
    // PANELS
    private final Header headerClass = new Header();
    private final MainPanelPersonal mainPanelPersonal = new MainPanelPersonal(this);
    private final Footer footerClass = new Footer();

    GraphicsEnvironment graphics =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();


    public PersonalDataPage() {
        this.setMinimumSize(new Dimension(800, 800));
//        this.setPreferredSize(new Dimension(800, 800));

        this.setTitle("Personal Data Page");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel headerPanel = headerClass.createHeaderPanel();
        JPanel footerPanel = footerClass.createFooterPanel();

        JPanel mainPanel = this.mainPanelPersonal.createMainPanel();

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
