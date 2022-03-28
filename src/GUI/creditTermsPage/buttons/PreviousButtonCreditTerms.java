package GUI.creditTermsPage.buttons;

import GUI.contactDataPage.ContactDataPage;
import GUI.creditTermsPage.panels.MainPanelCreditTerms;
import GUI.financialDataPage.FinancialDataPage;
import logic.data.ContactData;
import logic.data.FinancialData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class PreviousButtonCreditTerms {

    public JButton createPreviousButton(MainPanelCreditTerms mainPanel, PersonalData personalData, ContactData contactData, FinancialData financialData) {
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

                    FinancialDataPage financialDataPage = new FinancialDataPage(personalData, contactData);

                    restorePage(financialDataPage, financialData);
                }
            }
        });

        return button;
    }

    private void restorePage(FinancialDataPage financialDataPage, FinancialData financialData) {
        financialDataPage.getMainPanel().getTypesBox().setSelectedItem(financialData.getTypeOfContract());
        financialDataPage.getMainPanel().getAnnualIncome().setText(String.valueOf(financialData.getAnnualIncome()));
        financialDataPage.getMainPanel().getAnnualExpenses().setText(String.valueOf(financialData.getAnnualExpenses()));

        if(financialData.getPropertiesValue() != -1) {
            financialDataPage.getMainPanel().getPropertyGroup().getElements().nextElement().setSelected(true);
            financialDataPage.getMainPanel().getPropertyDetailsPanel().setVisible(true);
            financialDataPage.getMainPanel().getValueOfProperties().setText(String.valueOf(financialData.getPropertiesValue()));
        } else {
            Collections.list(financialDataPage.getMainPanel().getPropertyGroup().getElements()).get(1).setSelected(true);
        }


        for(int i = 0; i < financialData.getSourcesOfIncome().size(); i++)
            if(financialData.getSourcesOfIncome().get(i).isSelected())
                financialDataPage.getMainPanel().getBox().get(i).setSelected(true);



        if(financialData.getDebt() != -1) {
            financialDataPage.getMainPanel().getDebtGroup().getElements().nextElement().setSelected(true);
            financialDataPage.getMainPanel().getDebtDetailsPanel().setVisible(true);
            financialDataPage.getMainPanel().getValueOfDebt().setText(String.valueOf(financialData.getDebt()));
        } else {
            Collections.list(financialDataPage.getMainPanel().getDebtGroup().getElements()).get(1).setSelected(true);
        }
    }
}
