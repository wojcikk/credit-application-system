package logic.data;

import javax.swing.*;
import java.util.ArrayList;

public class FinancialData {
    private final String typeOfContract;
    private final String annualIncome;
    private final String annualExpenses;
    private final String propertiesValue;
    private final ArrayList<JCheckBox> sourcesOfIncome;
    private final String debt;

    public FinancialData(String typeOfContract, String annualIncome, String annualExpenses, String propertiesValue, ArrayList<JCheckBox> sourcesOfIncome, String debt) {
        this.typeOfContract = typeOfContract;
        this.annualIncome = annualIncome;
        this.annualExpenses = annualExpenses;
        this.propertiesValue = propertiesValue;
        this.sourcesOfIncome = sourcesOfIncome;
        this.debt = debt;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public String getAnnualExpenses() {
        return annualExpenses;
    }

    public String getPropertiesValue() {
        return propertiesValue;
    }

    public ArrayList<JCheckBox> getSourcesOfIncome() {
//        for(int i = 0; i < sourcesOfIncome.size(); i++) {
//            if(sourcesOfIncome.get(i).isSelected())
//                System.out.print(sourcesOfIncome.get(i).getText() + "\t\t");
//        }
//        System.out.println();
        return sourcesOfIncome;
    }

    public String getDebt() {
        return debt;
    }
}
