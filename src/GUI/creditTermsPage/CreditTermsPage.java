package GUI.creditTermsPage;

import GUI.Footer;
import GUI.Header;
import GUI.creditTermsPage.panels.MainPanelCreditTerms;
import logic.data.ContactData;
import logic.data.FinancialData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;

public class CreditTermsPage extends JFrame{
    // PANELS
    private final Header headerClass = new Header();
    private final MainPanelCreditTerms mainPanel = new MainPanelCreditTerms(this);
    private final Footer footerClass = new Footer();

    GraphicsEnvironment graphics =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();


    public CreditTermsPage(PersonalData personalData, ContactData contactData, FinancialData financialData) {
        this.setMinimumSize(new Dimension(800, 800));
//        this.setPreferredSize(new Dimension(800, 800));

        this.setTitle("Credit Terms Page");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel headerPanel = headerClass.createHeaderPanel();
        JPanel footerPanel = footerClass.createFooterPanel();

        JPanel mainPanel = this.mainPanel.createMainPanel(personalData, contactData, financialData);

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
