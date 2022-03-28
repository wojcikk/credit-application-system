package GUI.financialDataPage.buttons;

import GUI.contactDataPage.ContactDataPage;
import GUI.financialDataPage.panels.MainPanelFinancial;
import GUI.personalDataPage.PersonalDataPage;
import logic.data.ContactData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButtonFinancial {

    public JButton createPreviousButton(MainPanelFinancial mainPanel, PersonalData personalData, ContactData contactData) {
        JButton button = new JButton("PREV");
        button.setMaximumSize(new Dimension(100000, 100));

        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        button.setBackground(new Color(250, 250, 250));


        button.setFont(new Font("Consolas", Font.PLAIN, 18));
        button.setForeground(Color.DARK_GRAY);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button) {
                    mainPanel.getFinancialDataPage().dispose();
                    ContactDataPage contactDataPage = new ContactDataPage(personalData);

                    restorePage(contactDataPage, contactData);
                }
            }
        });

        return button;
    }

    private void restorePage(ContactDataPage contactDataPage, ContactData contactData) {
        contactDataPage.getMainPanel().getEmailTextField().setText(contactData.getEmail());
        contactDataPage.getMainPanel().getNumberTextField().setText(contactData.getNumber());
        contactDataPage.getMainPanel().getStreetTextField().setText(contactData.getStreet());
        contactDataPage.getMainPanel().getHouseNumberTextField().setText(contactData.getHouseNumber());
        contactDataPage.getMainPanel().getProvinceTextField().setText(contactData.getProvince());
        contactDataPage.getMainPanel().getCityTextField().setText(contactData.getCity());
        contactDataPage.getMainPanel().getCountryTextField().setText(contactData.getCountry());
    }
}
