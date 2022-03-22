package GUI.errors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Errors {
    private boolean flag;

    public boolean checkPersonalFields(JPanel nameField, JTextField nameTextField,
                               JPanel surnameField, JTextField surnameTextField,
                               JPanel mothersMaidenNameField, JTextField mothersMaidenNameTextField,
                               JPanel dateOfBirth, String dayText,
                               String monthText,
                               String yearText,
                               JPanel martialStatusPanel, String statusBox,
                               JPanel educationPanel, String stagesBox

                               ) {
        setFlag(true);

        checkTextField("Enter", nameField, nameTextField);
        checkTextField("Enter", surnameField, surnameTextField);
        checkTextField("Enter", mothersMaidenNameField, mothersMaidenNameTextField);
        checkTextBox("-", dateOfBirth, dayText);
        checkTextBox("-", dateOfBirth, monthText);
        checkTextBox("-", dateOfBirth, yearText);
        checkTextBox("-", martialStatusPanel, statusBox);
        checkTextBox("-", educationPanel, stagesBox);

        return flag;
    }

    public boolean checkContactFields(JPanel emailPanel, JTextField emailTextField,
                                       JPanel numberPanel, JTextField numberTextField,
                                       JPanel streetPanel, JTextField streetTextField,
                                       JPanel houseNumberPanel, JTextField houseNumberTextField,
                                       JPanel provincePanel, JTextField provinceTextField,
                                       JPanel cityPanel, JTextField cityTextField,
                                       JPanel countryPanel, JTextField countryTextField) {
        setFlag(true);

        checkEmail("Enter", emailPanel, emailTextField);
        checkNumber("Enter", numberPanel, numberTextField);
        checkTextField("Enter", streetPanel, streetTextField);
        checkTextField("Enter", houseNumberPanel, houseNumberTextField);
        checkTextField("Enter", provincePanel, provinceTextField);
        checkTextField("Enter", cityPanel, cityTextField);
        checkTextField("Enter", countryPanel, countryTextField);


        return flag;
    }

    public boolean checkFinancialFields(JPanel typeOfIncomePanel, String typeOfIncomePanelText,
                                        JPanel annualIncomePanel, JTextField numberTextField,
                                        JPanel annualExpensePanel, JTextField countryTextField,
                                        JPanel realEstateOwnedPanel, ButtonGroup propertyButtonGroup,
                                        JPanel propertyDetailsPanel, JTextField valueOfProperties,
                                        JPanel sourceOfIncomePanel, ArrayList<JCheckBox> box,
                                        JPanel currentDebtPanel, ButtonGroup debtButtonGroup,
                                        JPanel debtDetailsPanel, JTextField valueOfDebt
    ) {
        setFlag(true);

        checkTextBox("-", typeOfIncomePanel, typeOfIncomePanelText);
        checkValue("Enter", annualIncomePanel, numberTextField);
        checkValue("Enter", annualExpensePanel, countryTextField);
        checkButtonGroup(realEstateOwnedPanel, propertyButtonGroup);
        checkUnderButtonTextField("Enter", propertyDetailsPanel, valueOfProperties, propertyButtonGroup);
        checkCheckBoxes(sourceOfIncomePanel, box);
        checkButtonGroup(currentDebtPanel, debtButtonGroup);
        checkUnderButtonTextField("Enter", debtDetailsPanel, valueOfDebt, debtButtonGroup);

        return flag;
    }

    public boolean checkCreditTermsFields(
            JPanel purposeOfLoanPanel, String purposeOfLoanText,
            JPanel amountOfLoanPanel, JTextField amountOfLoan,
            JPanel periodOfLoanPanel, String periodOfLoanText
    ) {
        setFlag(true);

        checkTextBox("-", purposeOfLoanPanel, purposeOfLoanText);
        checkValue("Enter", amountOfLoanPanel, amountOfLoan);
        checkTextBox("-", periodOfLoanPanel, periodOfLoanText);

        return flag;
    }

    private void checkCheckBoxes(JPanel panel, ArrayList<JCheckBox> box) {
        boolean selected = false;
        panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        for(int i = 0; i < box.size() && !selected; i++)
            if(box.get(i).isSelected())
                selected = true;

        if(selected == false)
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));

    }

    private void checkButtonGroup(JPanel panel, ButtonGroup buttonGroup) {
        ArrayList<AbstractButton> buttons = Collections.list(buttonGroup.getElements());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        if(!buttons.get(0).isSelected() && !buttons.get(1).isSelected())
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
    }

    private void checkUnderButtonTextField(String text, JPanel panel, JTextField textField, ButtonGroup buttonGroup) {
        ArrayList<AbstractButton> buttons = Collections.list(buttonGroup.getElements());
        setNormalDesign(panel, textField);
        if(buttons.get(0).isSelected() && textField.getText().contains(text) || textField.getText().contains("Wrong") || textField.getText().isEmpty()) {
            setWrongInputDesign(panel, textField);
        } else if (buttons.get(0).isSelected()) {
            for(int i = 0; i < textField.getText().length(); i++) {
                char t = textField.getText().substring(i, i+1).charAt(0);
                if(!Character.isDigit(t)) {
                    setWrongInputDesign(panel, textField);
                    textField.setText("Wrong input - value can only contain digits");
                }
            }
        }
    }

    private void checkTextField(String text, JPanel panel, JTextField textField) {
        setNormalDesign(panel, textField);
        if(textField.getText().contains(text) || textField.getText().contains("Wrong") || textField.getText().isEmpty()) {
            setWrongInputDesign(panel, textField);
        }
    }

    private void checkTextBox(String text, JPanel panel, String textBox) {
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        if(textBox.equals(text)) {
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            setFlag(false);
        }
    }

    private void checkEmail(String text, JPanel panel, JTextField textField) {
        setNormalDesign(panel, textField);
        if(textField.getText().contains(text) || textField.getText().contains("Wrong input") || textField.getText().isEmpty()) {
            setWrongInputDesign(panel, textField);
        } else if(!textField.getText().contains("@")) {
            setWrongInputDesign(panel, textField);
            textField.setText("Wrong input - email need to contain \"@\"");
        }
    }

    private void checkValue(String text, JPanel panel, JTextField textField) {
        setNormalDesign(panel, textField);
        if(textField.getText().contains(text) || textField.getText().contains("Wrong input") || textField.getText().isEmpty()) {
            setWrongInputDesign(panel, textField);
        } else {
            for(int i = 0; i < textField.getText().length(); i++) {
                char t = textField.getText().substring(i, i+1).charAt(0);
                if(!Character.isDigit(t)) {
                    setWrongInputDesign(panel, textField);
                    textField.setText("Wrong input - value can only contain digits");
                }
            }
        }
    }

    private void checkNumber(String text, JPanel panel, JTextField textField) {
        setNormalDesign(panel, textField);
        if(textField.getText().contains(text) || textField.getText().contains("Wrong input") || textField.getText().isEmpty()) {
            setWrongInputDesign(panel, textField);
        } else if(textField.getText().length() != 9) {
            setWrongInputDesign(panel, textField);
            textField.setText("Wrong input - number must consist of 9 digits");
        } else {
            for(int i = 0; i < textField.getText().length(); i++) {
                char t = textField.getText().substring(i, i+1).charAt(0);
                if(!Character.isDigit(t)) {
                    setWrongInputDesign(panel, textField);
                    textField.setText("Wrong input - number can only contain digits");
                }
            }
        }
    }

    private void setNormalDesign(JPanel panel, JTextField textField) {
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        textField.setForeground(Color.black);
    }

    private void setWrongInputDesign(JPanel panel, JTextField textField) {
        panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        textField.setText("Wrong input");
        textField.setForeground(Color.red);
        setFlag(false);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
