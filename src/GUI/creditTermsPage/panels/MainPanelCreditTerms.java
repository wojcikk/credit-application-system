package GUI.creditTermsPage.panels;

import GUI.creditTermsPage.CreditTermsPage;
import GUI.creditTermsPage.buttons.NextButtonCreditTerms;
import GUI.creditTermsPage.buttons.PreviousButtonCreditTerms;
import GUI.creditTermsPage.dataArrays.ArrayOfPeriods;
import GUI.creditTermsPage.dataArrays.ArrayOfPurposes;
import GUI.template.ComboBoxPanel;
import GUI.template.StatusBar;
import GUI.template.TextFieldPanel;
import GUI.template.TitlePanel;
import logic.data.ContactData;
import logic.data.FinancialData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;

public class MainPanelCreditTerms {
    private final CreditTermsPage creditTermsPage;

    private JComboBox<String> purposesBox;
    private JTextField amountOfLoan;
    private JComboBox<String> periodsBox;
    private JTextField ownContributionInLoan;


    private JPanel purposeOfLoanPanel;
    private JPanel amountOfLoanPanel;
    private JPanel periodOfLoanPanel;
    private JPanel ownContributionInLoanPanel;

    public MainPanelCreditTerms(CreditTermsPage creditTermsPage) {
        this.creditTermsPage = creditTermsPage;
    }


    public JPanel createMainPanel(PersonalData personalData, ContactData contactData, FinancialData financialData) {
        JPanel panel = new JPanel();

        ArrayOfPurposes purposes = new ArrayOfPurposes();
        ArrayOfPeriods periods = new ArrayOfPeriods();

        purposesBox = new JComboBox<>(purposes.getTypes());
        amountOfLoan = new JTextField();
        periodsBox = new JComboBox<>(periods.getTypes());
        ownContributionInLoan = new JTextField();

        TextFieldPanel textFieldClass = new TextFieldPanel();
        ComboBoxPanel comboBoxClass = new ComboBoxPanel();

        TitlePanel titlePanelClass = new TitlePanel();

        StatusBar statusBarClass = new StatusBar();

        PreviousButtonCreditTerms previousButtonClass = new PreviousButtonCreditTerms();
        NextButtonCreditTerms nextButtonClass = new NextButtonCreditTerms();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panel.setBackground(Color.white);

        JPanel titlePanel = titlePanelClass.createTitlePanel("CREDIT TERMS DATA");
        JPanel statusBar = statusBarClass.createStatusBarPanel(4);

        purposeOfLoanPanel = comboBoxClass.createPanel(40, "PURPOSE OF LOAN", purposesBox);
        amountOfLoanPanel = textFieldClass.createPanel(45, "AMOUNT OF LOAN", "Enter amount", amountOfLoan);
        periodOfLoanPanel = comboBoxClass.createPanel(45, "PERIOD OF LOAN", periodsBox);
        ownContributionInLoanPanel = textFieldClass.createPanel(10, "OWN CONTRIBUTION OF LOAN", "Enter amount of own contribution", ownContributionInLoan);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout());
        buttons.setMaximumSize(new Dimension(10000, 100));
        JButton nextButton = nextButtonClass.createNextButton(this, personalData, contactData, financialData);
        JButton previousButton = previousButtonClass.createPreviousButton(this, personalData, contactData, financialData);
        buttons.add(previousButton);
        buttons.add(nextButton);

        panel.add(Box.createVerticalGlue());
        panel.add(titlePanel);
        panel.add(statusBar);
        panel.add(Box.createVerticalGlue());
        panel.add(purposeOfLoanPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(amountOfLoanPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(periodOfLoanPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(ownContributionInLoanPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(buttons);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    public CreditTermsPage getCreditTermsPage() {
        return creditTermsPage;
    }

    public JComboBox<String> getPurposesBox() {
        return purposesBox;
    }

    public JTextField getAmountOfLoan() {
        return amountOfLoan;
    }

    public JComboBox<String> getPeriodsBox() {
        return periodsBox;
    }

    public JTextField getOwnContributionInLoan() {
        return ownContributionInLoan;
    }

    public JPanel getPurposeOfLoanPanel() {
        return purposeOfLoanPanel;
    }

    public JPanel getAmountOfLoanPanel() {
        return amountOfLoanPanel;
    }

    public JPanel getPeriodOfLoanPanel() {
        return periodOfLoanPanel;
    }

    public JPanel getOwnContributionInLoanPanel() {
        return ownContributionInLoanPanel;
    }
}
