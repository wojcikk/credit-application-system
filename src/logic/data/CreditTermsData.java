package logic.data;

public class CreditTermsData {
    private final String purposeOfLoan;
    private final long amountOfLoan;
    private final long periodOfLoan;
    private final long ownContributionInLoan;

    public CreditTermsData(String purposeOfLoan, long amountOfLoan, long periodOfLoan, long ownContributionInLoan) {
        this.purposeOfLoan = purposeOfLoan;
        this.amountOfLoan = amountOfLoan;
        this.periodOfLoan = periodOfLoan;
        this.ownContributionInLoan = ownContributionInLoan;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public long getAmountOfLoan() {
        return amountOfLoan;
    }

    public long getPeriodOfLoan() {
        return periodOfLoan;
    }

    public long getOwnContributionInLoan() {
        return ownContributionInLoan;
    }
}
