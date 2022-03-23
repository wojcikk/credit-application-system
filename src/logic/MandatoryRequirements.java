package logic;

import logic.data.DataCollection;

public class MandatoryRequirements {
    private final DataCollection dataCollection;
    private boolean flag;
    private StringBuilder reason;

    public MandatoryRequirements(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        reason = new StringBuilder();
        check();
    }

    private void check() {
        setFlag(true);
        comparisonOfIncomeAndExpenses();
        if(dataCollection.getFinancialData().getDebt() != -1) comparisonOfProfitAndDebt();
        ageVerification();
        ownContributionVerification();
    }

    private void comparisonOfIncomeAndExpenses() {
        if(dataCollection.getFinancialData().getAnnualIncome() < dataCollection.getFinancialData().getAnnualExpenses()) {
            setFlag(false);
            reason.append(", ");
            reason.append("annual income is smaller than annual expenses");
        }
    }

    private void comparisonOfProfitAndDebt() {
        if(dataCollection.getFinancialData().getDebt() > dataCollection.getFinancialData().getAnnualIncome() - dataCollection.getFinancialData().getAnnualExpenses()) {
            setFlag(false);
            reason.append(", ");
            reason.append("total debt is bigger than annual profit");
        }
    }

    private void ageVerification() {
        if(java.time.LocalDate.now().getYear() - Integer.parseInt(dataCollection.getPersonalData().getYearOfBirth()) < 18) {
            setFlag(false);
            reason.append(", ");
            reason.append("client is underage");
        }
    }

    private void ownContributionVerification() {
        if((dataCollection.getCreditTermsData().getOwnContributionInLoan() / dataCollection.getCreditTermsData().getAmountOfLoan() * 100) < 5) {
            setFlag(false);
            reason.append(", ");
            reason.append("own contribution is less than 10%");
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
