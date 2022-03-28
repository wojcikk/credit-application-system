package logic;

import logic.data.DataCollection;

public class PrivilegeRequirements {
    private final DataCollection dataCollection;
    private MandatoryRequirements mandatoryRequirements;
    private boolean flag;
    private StringBuilder reason;

    public PrivilegeRequirements(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        reason = new StringBuilder();
        check();
    }

    private void check() {
        setFlag(false);
        ageVerification();
        if(isFlag()) comparisonOfProfitAndLoan();
    }

    private void comparisonOfProfitAndLoan() {
        long profit = (dataCollection.getFinancialData().getAnnualIncome() - dataCollection.getFinancialData().getAnnualExpenses()) * dataCollection.getCreditTermsData().getPeriodOfLoan();
        if(profit > 2 * dataCollection.getCreditTermsData().getAmountOfLoan()) {
            setFlag(true);
            reason.append(", with privilege decision");
        }
    }

    public void ageVerification() {
        if(java.time.LocalDate.now().getYear() - Integer.parseInt(dataCollection.getPersonalData().getYearOfBirth()) < 18) {
            setFlag(false);
            reason.append(", ");
            reason.append("client is underage");
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