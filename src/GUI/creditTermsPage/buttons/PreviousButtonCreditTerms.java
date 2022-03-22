package GUI.creditTermsPage.buttons;

import GUI.creditTermsPage.panels.MainPanelCreditTerms;
import GUI.financialDataPage.FinancialDataPage;
import logic.data.ContactData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButtonCreditTerms {

    public JButton createPreviousButton(MainPanelCreditTerms mainPanel, PersonalData personalData, ContactData contactData) {
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
                    mainPanel.getCreditTermsPage().dispose();
                    new FinancialDataPage(personalData, contactData);

                }
            }
        });

        return button;
    }
}
