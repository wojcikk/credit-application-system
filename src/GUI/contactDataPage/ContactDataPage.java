package GUI.contactDataPage;

import GUI.Footer;
import GUI.Header;
import GUI.contactDataPage.panels.MainPanelContact;
import logic.data.PersonalData;


import javax.swing.*;
import java.awt.*;

public class ContactDataPage extends JFrame{
    // PANELS
    private final Header headerClass = new Header();
    private final MainPanelContact mainPanel = new MainPanelContact(this);
    private final Footer footerClass = new Footer();

    GraphicsEnvironment graphics =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();


    public ContactDataPage(PersonalData personalData) {
        this.setMinimumSize(new Dimension(800, 800));
//        this.setPreferredSize(new Dimension(800, 800));

        this.setTitle("Contact Data Page");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel headerPanel = headerClass.createHeaderPanel();
        JPanel footerPanel = footerClass.createFooterPanel();

        JPanel mainPanel = this.mainPanel.createMainPanel(personalData);

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