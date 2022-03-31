package GUI.errors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Errors {
    private boolean flag;
    private final String textFieldKeyword = "Enter";
    private final String textBoxKeyword = "-";
    private final String errorKeyword = "Wrong";

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

        checkStringTextField(nameField, nameTextField);
        checkStringTextField(surnameField, surnameTextField);
        checkStringTextField(mothersMaidenNameField, mothersMaidenNameTextField);
        checkTextBox(dateOfBirth, dayText);
        checkTextBox(dateOfBirth, monthText);
        checkTextBox(dateOfBirth, yearText);
        checkTextBox(martialStatusPanel, statusBox);
        checkTextBox(educationPanel, stagesBox);

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

        checkEmail(emailPanel, emailTextField);
        checkNumber(numberPanel, numberTextField);
        checkStringTextField(streetPanel, streetTextField);
        checkTextFieldBasis(houseNumberPanel, houseNumberTextField);
        checkStringTextField(provincePanel, provinceTextField);
        checkStringTextField(cityPanel, cityTextField);
        checkStringTextField(countryPanel, countryTextField);


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

        checkTextBox(typeOfIncomePanel, typeOfIncomePanelText);
        checkValue(annualIncomePanel, numberTextField);
        checkValue(annualExpensePanel, countryTextField);
        checkButtonGroup(realEstateOwnedPanel, propertyButtonGroup);
        checkUnderButtonTextField(propertyDetailsPanel, valueOfProperties, propertyButtonGroup);
        checkCheckBoxes(sourceOfIncomePanel, box);
        checkButtonGroup(currentDebtPanel, debtButtonGroup);
        checkUnderButtonTextField(debtDetailsPanel, valueOfDebt, debtButtonGroup);

        return flag;
    }

    public boolean checkCreditTermsFields(
            JPanel purposeOfLoanPanel, String purposeOfLoanText,
            JPanel amountOfLoanPanel, JTextField amountOfLoan,
            JPanel periodOfLoanPanel, String periodOfLoanText,
            JPanel ownContributionInLoanPanel, JTextField ownContributionInLoan
    ) {
        setFlag(true);

        checkTextBox(purposeOfLoanPanel, purposeOfLoanText);
        checkValue(amountOfLoanPanel, amountOfLoan);
        checkTextBox(periodOfLoanPanel, periodOfLoanText);
        checkValue(ownContributionInLoanPanel, ownContributionInLoan);

        return flag;
    }

    private void checkCheckBoxes(JPanel panel, ArrayList<JCheckBox> box) {
        boolean selected = false;
        panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        for(int i = 0; i < box.size() && !selected; i++)
            if(box.get(i).isSelected())
                selected = true;

        if(!selected) {
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            setFlag(false);
        }

    }

    private void checkButtonGroup(JPanel panel, ButtonGroup buttonGroup) {
        ArrayList<AbstractButton> buttons = Collections.list(buttonGroup.getElements());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        if(buttons.get(1).isSelected()) {
            setFlag(true);
        } else if(!buttons.get(0).isSelected() && !buttons.get(1).isSelected()) {
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            setFlag(false);
        }
    }

    private void checkUnderButtonTextField(JPanel panel, JTextField textField, ButtonGroup buttonGroup) {
        ArrayList<AbstractButton> buttons = Collections.list(buttonGroup.getElements());
        setNormalDesign(panel, textField);
        if(buttons.get(0).isSelected() && textField.getText().contains(textFieldKeyword) || textField.getText().contains(errorKeyword) || textField.getText().isEmpty()) {
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

    private boolean checkTextFieldBasis(JPanel panel, JTextField textField) {
        setNormalDesign(panel, textField);
        if(textField.getText().contains(textFieldKeyword) || textField.getText().contains(errorKeyword) || textField.getText().isEmpty()) {
            setWrongInputDesign(panel, textField);
            return false;
        } else {
            return true;
        }

    }

    private void checkStringTextField(JPanel panel, JTextField textField) {
        if(checkTextFieldBasis(panel, textField)) {
            for(int i = 0; i < textField.getText().length(); i++) {
                char t = textField.getText().substring(i, i+1).charAt(0);
                if(!Character.isLetter(t)) {
                    setWrongInputDesign(panel, textField);
                    textField.setText("Wrong input - input can only contain letters");
                }
            }
        }
    }

    private void checkTextBox(JPanel panel, String textBox) {
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        if(textBox.equals(textBoxKeyword)) {
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            setFlag(false);
        }
    }

    private void checkEmail(JPanel panel, JTextField textField) {
        if(checkTextFieldBasis(panel, textField)) {
            if(!textField.getText().contains("@")) {
                setWrongInputDesign(panel, textField);
                textField.setText("Wrong input - email need to contain \"@\"");
            }
        }
    }

    private void checkValue(JPanel panel, JTextField textField) {
        if(checkTextFieldBasis(panel, textField)) {
            for(int i = 0; i < textField.getText().length(); i++) {
                char t = textField.getText().substring(i, i+1).charAt(0);
                if(!Character.isDigit(t)) {
                    setWrongInputDesign(panel, textField);
                    textField.setText("Wrong input - value can only contain digits");
                }
            }
        }
    }

    private void checkNumber(JPanel panel, JTextField textField) {
        if(checkTextFieldBasis(panel, textField)) {
            if (textField.getText().length() != 9) {
                setWrongInputDesign(panel, textField);
                textField.setText("Wrong input - number must consist of 9 digits");
            } else {
                for (int i = 0; i < textField.getText().length(); i++) {
                    char t = textField.getText().substring(i, i + 1).charAt(0);
                    if (!Character.isDigit(t)) {
                        setWrongInputDesign(panel, textField);
                        textField.setText("Wrong input - number can only contain digits");
                    }
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
