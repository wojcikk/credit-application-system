package logic.data;

import javax.swing.*;
import java.util.ArrayList;

public class FinancialData {
    private final String typeOfContract;
    private final long annualIncome;
    private final long annualExpenses;
    private final long propertiesValue;
    private final ArrayList<JCheckBox> sourcesOfIncome;
    private final long debt;

    public FinancialData(String typeOfContract, long annualIncome, long annualExpenses, long propertiesValue, ArrayList<JCheckBox> sourcesOfIncome, long debt) {
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

    public long getAnnualIncome() {
        return annualIncome;
    }

    public long getAnnualExpenses() {
        return annualExpenses;
    }

    public long getPropertiesValue() {
        return propertiesValue;
    }

    public ArrayList<JCheckBox> getSourcesOfIncome() {
        return sourcesOfIncome;
    }

    public String getSourcesOfIncomeString() {
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < sourcesOfIncome.size() && sourcesOfIncome.get(i).isSelected(); i++) {
            text.append(sourcesOfIncome.get(i).getText());
            if (i != (sourcesOfIncome.size() - 1)) text.append(", ");
        }
        return text.toString();
    }

    public long getDebt() {
        return debt;
    }
}
