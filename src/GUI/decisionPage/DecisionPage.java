package GUI.decisionPage;

import GUI.Footer;
import GUI.Header;
import GUI.decisionPage.panels.MainPanelDecision;
import GUI.financialDataPage.panels.MainPanelFinancial;
import logic.Decision;
import logic.data.ContactData;
import logic.data.DataCollection;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;

public class DecisionPage extends JFrame {
    private final Header headerClass = new Header();
    private final MainPanelDecision mainPanel = new MainPanelDecision();
    private final Footer footerClass = new Footer();

    GraphicsEnvironment graphics =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();


    public DecisionPage(DataCollection dataCollection, Decision decision) {
        this.setMinimumSize(new Dimension(800, 800));
//        this.setPreferredSize(new Dimension(800, 800));

        this.setTitle("Contact Data Page");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel headerPanel = headerClass.createHeaderPanel();
        JPanel footerPanel = footerClass.createFooterPanel();

        JPanel mainPanel = this.mainPanel.createMainPanel(decision);

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
