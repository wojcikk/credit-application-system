package GUI.financialDataPage.buttons;

import GUI.creditTermsPage.CreditTermsPage;
import GUI.errors.Errors;
import GUI.financialDataPage.panels.MainPanelFinancial;
import logic.data.ContactData;
import logic.data.FinancialData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;

public class NextButtonFinancial {

    private boolean flag = true;

    public JButton createNextButton(MainPanelFinancial mainPanelFinancial, PersonalData personalData, ContactData contactData) {
        JButton button = new JButton("NEXT");
        button.setMaximumSize(new Dimension(100000, 100));

        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        button.setBackground(new Color(250, 250, 250));


        button.setFont(new Font("Consolas", Font.PLAIN, 18));
        button.setForeground(Color.DARK_GRAY);

        button.addActionListener(e -> {
            if(e.getSource() == button) {
                Errors errors = new Errors();

                flag = errors.checkFinancialFields(
                        mainPanelFinancial.getTypeOfIncomePanel(), mainPanelFinancial.getTypesBox().getSelectedItem().toString(),
                        mainPanelFinancial.getAnnualIncomePanel(), mainPanelFinancial.getAnnualIncome(),
                        mainPanelFinancial.getAnnualExpensesPanel(), mainPanelFinancial.getAnnualExpenses(),
                        mainPanelFinancial.getRealEstateOwnedPanel(), mainPanelFinancial.getPropertyGroup(),
                        mainPanelFinancial.getPropertyDetailsPanel(), mainPanelFinancial.getValueOfProperties(),
                        mainPanelFinancial.getSourceOfIncomePanel(), mainPanelFinancial.getBox(),
                        mainPanelFinancial.getCurrentDebtPanel(), mainPanelFinancial.getDebtGroup(),
                        mainPanelFinancial.getDebtDetailsPanel(), mainPanelFinancial.getValueOfDebt()

                );

                if(flag) {
                    FinancialData financialData = new FinancialData(mainPanelFinancial.getTypesBox().getSelectedItem().toString(),
                            mainPanelFinancial.getAnnualIncome().getText(),
                            mainPanelFinancial.getAnnualExpenses().getText(),
                            mainPanelFinancial.getValueOfProperties().getText(),
                            mainPanelFinancial.getBox(),
                            mainPanelFinancial.getValueOfDebt().getText()
                    );

                    mainPanelFinancial.getFinancialDataPage().dispose();
                    new CreditTermsPage(personalData, contactData, financialData);
                }
            }
        });

        return button;
    }
}