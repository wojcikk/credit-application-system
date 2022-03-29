package GUI.financialDataPage.panels;

import GUI.financialDataPage.FinancialDataPage;
import GUI.financialDataPage.buttons.NextButtonFinancial;
import GUI.financialDataPage.buttons.PreviousButtonFinancial;
import GUI.financialDataPage.dataArrays.ArrayOfTypes;
import GUI.template.*;
import logic.data.ContactData;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanelFinancial {
    private final FinancialDataPage financialDataPage;

    private JComboBox<String> typesBox;
    private JTextField annualIncome;
    private JTextField annualExpenses;
    private ButtonGroup propertyGroup;
    private JTextField valueOfProperties;
    private JPanel sourceOfIncomePanel;
    private ArrayList<JCheckBox> box;
    private JTextField valueOfDebt;
    private ButtonGroup debtGroup;


    public MainPanelFinancial(FinancialDataPage financialDataPage) {
        this.financialDataPage = financialDataPage;
    }
    JPanel typeOfIncomePanel;
    JPanel annualIncomePanel;
    JPanel annualExpensesPanel;
    JPanel propertyDetailsPanel;
    JPanel realEstateOwnedPanel;
    JPanel debtDetailsPanel;
    JPanel currentDebtPanel;

    public JPanel createMainPanel(PersonalData personalData, ContactData contactData) {
        JPanel panel = new JPanel();

        ArrayOfTypes types = new ArrayOfTypes();

        typesBox = new JComboBox<>(types.getTypes());
        annualIncome = new JTextField();
        annualExpenses = new JTextField();
        propertyGroup = new ButtonGroup();
        valueOfProperties = new JTextField();
        box = new ArrayList<>();
        valueOfDebt = new JTextField();
        debtGroup = new ButtonGroup();

        TextFieldPanel textFieldClass = new TextFieldPanel();
        ComboBoxPanel comboBoxClass = new ComboBoxPanel();
        TextFieldUnderDecisionPanel textFieldUnderDecisionClass = new TextFieldUnderDecisionPanel();
        SpecialPanel specialPanelClass = new SpecialPanel();

        TitlePanel titlePanelClass = new TitlePanel();

        StatusBar statusBarClass = new StatusBar();

        PreviousButtonFinancial previousButtonClass = new PreviousButtonFinancial();
        NextButtonFinancial nextButtonClass = new NextButtonFinancial();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panel.setBackground(Color.white);

        JPanel titlePanel = titlePanelClass.createTitlePanel("FINANCIAL DATA");
        JPanel statusBar = statusBarClass.createStatusBarPanel(3);

        typeOfIncomePanel = comboBoxClass.createPanel(45, "TYPE OF INCOME", typesBox);
        annualIncomePanel = textFieldClass.createPanel(55, "ANNUAL INCOME", "Enter income", annualIncome);
        annualExpensesPanel = textFieldClass.createPanel(45, "ANNUAL EXPENSES", "Enter expenses", annualExpenses);
        propertyDetailsPanel = textFieldClass.createPanel(55, "Total worth: ", "Enter value", valueOfProperties);
        propertyDetailsPanel.setVisible(false);
        realEstateOwnedPanel = textFieldUnderDecisionClass.createPanel(35, "REAL ESTATE OWNED", "Do you own any property?", propertyDetailsPanel, propertyGroup);
        sourceOfIncomePanel = specialPanelClass.createSourceOfIncome(box);
        debtDetailsPanel = textFieldClass.createPanel(60, "Total debt: ", "Enter value", valueOfDebt);
        debtDetailsPanel.setVisible(false);
        currentDebtPanel = textFieldUnderDecisionClass.createPanel(55, "CURRENT DEBT", "Do you have any obligations?", debtDetailsPanel, debtGroup);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout());
        buttons.setMaximumSize(new Dimension(10000, 100));
        JButton nextButton = nextButtonClass.createNextButton(this, personalData, contactData);
        JButton previousButton = previousButtonClass.createPreviousButton(this, personalData, contactData);
        buttons.add(previousButton);
        buttons.add(nextButton);

        panel.add(Box.createVerticalGlue());
        panel.add(titlePanel);
        panel.add(statusBar);
        panel.add(Box.createVerticalGlue());
        panel.add(typeOfIncomePanel);
        panel.add(Box.createVerticalGlue());
        panel.add(annualIncomePanel);
        panel.add(Box.createVerticalGlue());
        panel.add(annualExpensesPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(realEstateOwnedPanel);
        panel.add(propertyDetailsPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(sourceOfIncomePanel);
        panel.add(Box.createVerticalGlue());
        panel.add(currentDebtPanel);
        panel.add(debtDetailsPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(buttons);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    public FinancialDataPage getFinancialDataPage() {
        return financialDataPage;
    }

    public JComboBox<String> getTypesBox() {
        return typesBox;
    }

    public JTextField getAnnualIncome() {
        return annualIncome;
    }

    public JTextField getAnnualExpenses() {
        return annualExpenses;
    }

    public ButtonGroup getPropertyGroup() {
        return propertyGroup;
    }

    public JTextField getValueOfProperties() {
        return valueOfProperties;
    }

    public ArrayList<JCheckBox> getBox() {
        return box;
    }

    public JTextField getValueOfDebt() {
        return valueOfDebt;
    }

    public ButtonGroup getDebtGroup() {
        return debtGroup;
    }

    public JPanel getTypeOfIncomePanel() {
        return typeOfIncomePanel;
    }

    public JPanel getAnnualIncomePanel() {
        return annualIncomePanel;
    }

    public JPanel getAnnualExpensesPanel() {
        return annualExpensesPanel;
    }

    public JPanel getPropertyDetailsPanel() {
        return propertyDetailsPanel;
    }

    public JPanel getRealEstateOwnedPanel() {
        return realEstateOwnedPanel;
    }

    public JPanel getSourceOfIncomePanel() {
        return sourceOfIncomePanel;
    }

    public JPanel getDebtDetailsPanel() {
        return debtDetailsPanel;
    }

    public JPanel getCurrentDebtPanel() {
        return currentDebtPanel;
    }
}
