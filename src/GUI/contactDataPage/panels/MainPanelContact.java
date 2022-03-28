package GUI.contactDataPage.panels;

import GUI.contactDataPage.ContactDataPage;
import GUI.contactDataPage.buttons.NextButtonContact;
import GUI.contactDataPage.buttons.PreviousButtonContact;
import GUI.template.StatusBar;
import GUI.template.TextFieldPanel;
import GUI.template.TitlePanel;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;

public class MainPanelContact {
    // BUTTONS
    private final ContactDataPage contactDataPage;

    private JTextField emailTextField;
    private JTextField numberTextField;
    private JTextField streetTextField;
    private JTextField houseNumberTextField;
    private JTextField provinceTextField;
    private JTextField cityTextField;
    private JTextField countryTextField;

    private JPanel emailPanel;
    private JPanel numberPanel;
    private JPanel streetPanel;
    private JPanel houseNumberPanel;
    private JPanel provincePanel;
    private JPanel cityPanel;
    private JPanel countryPanel;

    public MainPanelContact(ContactDataPage contactDataPage) {
        this.contactDataPage = contactDataPage;
    }



    public JPanel createMainPanel(PersonalData personalData) {
        JPanel panel = new JPanel();

        emailTextField = new JTextField();
        numberTextField = new JTextField();
        streetTextField = new JTextField();
        houseNumberTextField = new JTextField();
        provinceTextField = new JTextField();
        cityTextField = new JTextField();
        countryTextField = new JTextField();

        TextFieldPanel textFieldClass = new TextFieldPanel();

        TitlePanel titlePanelClass = new TitlePanel();

        StatusBar statusBarClass = new StatusBar();

        NextButtonContact nextButtonClass = new NextButtonContact();
        PreviousButtonContact previousButtonClass = new PreviousButtonContact();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panel.setBackground(Color.white);

        JPanel titlePanel = titlePanelClass.createTitlePanel("CONTACT DATA");

        JPanel statusBar = statusBarClass.createStatusBarPanel(2);

        emailPanel = textFieldClass.createPanel(90, "EMAIL", "Enter email", emailTextField);
        numberPanel = textFieldClass.createPanel(80, "NUMBER", "Enter number", numberTextField);

        JPanel address1 = new JPanel();
        address1.setLayout(new GridLayout());
        address1.setMaximumSize(new Dimension(10000, 100));
        streetPanel =  textFieldClass.createPanel(80, "STREET", "Enter street", streetTextField);
        houseNumberPanel = textFieldClass.createPanel(55, "HOUSE NUMBER", "Enter house number", houseNumberTextField);
        address1.add(streetPanel);
        address1.add(houseNumberPanel);

        JPanel address2 = new JPanel();
        address2.setLayout(new GridLayout());
        address2.setMaximumSize(new Dimension(10000, 100));
        provincePanel = textFieldClass.createPanel(75, "PROVINCE", "Enter province", provinceTextField);
        cityPanel = textFieldClass.createPanel(90, "CITY", "Enter city", cityTextField);
        address2.add(provincePanel);
        address2.add(cityPanel);

        countryPanel = textFieldClass.createPanel(80, "COUNTRY", "Enter country", countryTextField);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout());
        buttons.setMaximumSize(new Dimension(10000, 100));
        JButton nextButton = nextButtonClass.createNextButton(this, personalData);
        JButton previousButton = previousButtonClass.createPreviousButton(this, personalData);
        buttons.add(previousButton);
        buttons.add(nextButton);


        panel.add(Box.createVerticalGlue());
        panel.add(titlePanel);
        panel.add(statusBar);
        panel.add(Box.createVerticalGlue());
        panel.add(emailPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(numberPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(address1);
        panel.add(Box.createVerticalGlue());
        panel.add(address2);
        panel.add(Box.createVerticalGlue());
        panel.add(countryPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(buttons);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    public ContactDataPage getContactDataPage() {
        return contactDataPage;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getNumberTextField() {
        return numberTextField;
    }

    public JTextField getStreetTextField() {
        return streetTextField;
    }

    public JTextField getHouseNumberTextField() {
        return houseNumberTextField;
    }

    public JTextField getProvinceTextField() {
        return provinceTextField;
    }

    public JTextField getCityTextField() {
        return cityTextField;
    }

    public JTextField getCountryTextField() {
        return countryTextField;
    }

    public JPanel getEmailPanel() {
        return emailPanel;
    }

    public JPanel getNumberPanel() {
        return numberPanel;
    }

    public JPanel getStreetPanel() {
        return streetPanel;
    }

    public JPanel getHouseNumberPanel() {
        return houseNumberPanel;
    }

    public JPanel getProvincePanel() {
        return provincePanel;
    }

    public JPanel getCityPanel() {
        return cityPanel;
    }

    public JPanel getCountryPanel() {
        return countryPanel;
    }


}
