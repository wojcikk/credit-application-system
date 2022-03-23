package logic;

import logic.data.DataCollection;

public class PrivilegeRequirements {
    private final DataCollection dataCollection;
    private boolean flag;
    private StringBuilder reason;

    public PrivilegeRequirements(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        reason = new StringBuilder();
        check();
    }

    private void check() {
        setFlag(true);
        comparisonOfProfitAndLoan();
    }

    private void comparisonOfProfitAndLoan() {
        long profit = (dataCollection.getFinancialData().getAnnualIncome() - dataCollection.getFinancialData().getAnnualExpenses()) * dataCollection.getCreditTermsData().getPeriodOfLoan();
        if(profit > 2 * dataCollection.getCreditTermsData().getAmountOfLoan()) {
            setFlag(true);
            reason.append(", with privilege decision");
        } else {
            setFlag(false);
        }
    }



    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public StringBuilder getReason() {
        return reason;
    }
}