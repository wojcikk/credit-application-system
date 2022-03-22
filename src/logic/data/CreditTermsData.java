package logic.data;

public class CreditTermsData {
    private final String purposeOfLoan;
    private final String amountOfLoan;
    private final String periodOfLoan;

    public CreditTermsData(String purposeOfLoan, String amountOfLoan, String periodOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
        this.amountOfLoan = amountOfLoan;
        this.periodOfLoan = periodOfLoan;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public String getAmountOfLoan() {
        return amountOfLoan;
    }

    public String getPeriodOfLoan() {
        return periodOfLoan;
    }
}
