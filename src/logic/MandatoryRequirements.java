package logic;

import logic.data.DataCollection;

public class MandatoryRequirements {
    private final DataCollection dataCollection;
    private boolean flag;

    public MandatoryRequirements(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        check();
    }

    private void check() {
        setFlag(true);
        comparisonOfIncomeAndExpenses();
        if(isFlag()) comparisonOfProfitAndDebt();
        if(isFlag()) ageVerification();
    }

    private void comparisonOfIncomeAndExpenses() {
        if(Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < Integer.parseInt(dataCollection.getFinancialData().getAnnualExpenses()))
            setFlag(false);
    }

    private void comparisonOfProfitAndDebt() {
        if(Integer.parseInt(dataCollection.getFinancialData().getDebt()) > Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) - Integer.parseInt(dataCollection.getFinancialData().getAnnualExpenses()))
            setFlag(false);
    }

    private void ageVerification() {
        if(Integer.parseInt(java.time.LocalDate.now().toString().substring(0,4)) - Integer.parseInt(dataCollection.getPersonalData().getYearOfBirth()) < 18)
            setFlag(false);

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
