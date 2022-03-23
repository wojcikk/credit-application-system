package GUI.creditTermsPage.buttons;

import GUI.creditTermsPage.panels.MainPanelCreditTerms;
import GUI.errors.Errors;
import logic.*;
import logic.data.*;

import javax.swing.*;
import java.awt.*;

public class NextButtonCreditTerms {

    private boolean flag = true;

    public JButton createNextButton(MainPanelCreditTerms mainPanelCreditTerms, PersonalData personalData, ContactData contactData, FinancialData financialData) {
        JButton button = new JButton("FINISH CALCULATIONS");
        button.setMaximumSize(new Dimension(100000, 100));

        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        button.setBackground(new Color(250, 250, 250));


        button.setFont(new Font("Consolas", Font.PLAIN, 18));
        button.setForeground(Color.DARK_GRAY);

        button.addActionListener(e -> {
            if(e.getSource() == button) {
                Errors errors = new Errors();

                flag = errors.checkCreditTermsFields(
                        mainPanelCreditTerms.getPurposeOfLoanPanel(), mainPanelCreditTerms.getPurposesBox().getSelectedItem().toString(),
                        mainPanelCreditTerms.getAmountOfLoanPanel(), mainPanelCreditTerms.getAmountOfLoan(),
                        mainPanelCreditTerms.getPeriodOfLoanPanel(), mainPanelCreditTerms.getPeriodsBox().getSelectedItem().toString(),
                        mainPanelCreditTerms.getOwnContributionInLoanPanel(), mainPanelCreditTerms.getOwnContributionInLoan()
                );

                if(flag) {
                    CreditTermsData creditTermsData = new CreditTermsData(
                            mainPanelCreditTerms.getPurposesBox().getSelectedItem().toString(),
                            Long.parseLong(mainPanelCreditTerms.getAmountOfLoan().getText()),
                            Long.parseLong(mainPanelCreditTerms.getPeriodsBox().getSelectedItem().toString()),
                            Long.parseLong(mainPanelCreditTerms.getOwnContributionInLoan().getText())
                    );

                    new PrintData(personalData, contactData, financialData, creditTermsData);
                    DataCollection dataCollection = new DataCollection(personalData, contactData, financialData, creditTermsData);
                    new Decision(dataCollection);
                }
            }
        });

        return button;
    }
}