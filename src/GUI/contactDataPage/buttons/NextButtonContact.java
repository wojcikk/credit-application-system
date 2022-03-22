package GUI.contactDataPage.buttons;

import GUI.contactDataPage.panels.MainPanelContact;
import GUI.errors.Errors;
import GUI.financialDataPage.FinancialDataPage;
import logic.data.ContactData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonContact {

    private boolean flag = true;

    public JButton createNextButton(MainPanelContact mainPanelContact, PersonalData personalData) {
        JButton button = new JButton("NEXT");
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
//                    Errors errors = new Errors();
//
//                    flag = errors.checkContactFields(mainPanelContact.getEmailPanel(), mainPanelContact.getEmailTextField(),
//                            mainPanelContact.getNumberPanel(), mainPanelContact.getNumberTextField(),
//                            mainPanelContact.getStreetPanel(), mainPanelContact.getStreetTextField(),
//                            mainPanelContact.getHouseNumberPanel(), mainPanelContact.getHouseNumberTextField(),
//                            mainPanelContact.getProvincePanel(), mainPanelContact.getProvinceTextField(),
//                            mainPanelContact.getCityPanel(), mainPanelContact.getCityTextField(),
//                            mainPanelContact.getCountryPanel(), mainPanelContact.getCountryTextField()
//                    );

                    if(flag) {
                        ContactData contactData = new ContactData(
                                mainPanelContact.getEmailTextField().getText(),
                                mainPanelContact.getNumberTextField().getText(),
                                mainPanelContact.getStreetTextField().getText(),
                                mainPanelContact.getHouseNumberTextField().getText(),
                                mainPanelContact.getProvinceTextField().getText(),
                                mainPanelContact.getCityTextField().getText(),
                                mainPanelContact.getCountryTextField().getText()
                        );

                        mainPanelContact.getContactDataPage().dispose();
                        new FinancialDataPage(personalData, contactData);
                    }
                }
            }
        });

        return button;
    }
}