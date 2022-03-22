package logic.scoring;

import logic.data.DataCollection;

public class ScoringSystem {
    private final DataCollection dataCollection;
    private final PersonalPoints personalPoints;
    private final FinancialPoints financialPoints;
    private final CreditTermsPoints creditTermsPoints;
    private int score;

    public ScoringSystem(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        this.personalPoints = new PersonalPoints(dataCollection);
        this.financialPoints = new FinancialPoints(dataCollection);
        this.creditTermsPoints = new CreditTermsPoints(dataCollection);
    }

    public int getScore() {
        PersonalPoints personalPoints = new PersonalPoints(dataCollection);
        FinancialPoints financialPoints = new FinancialPoints(dataCollection);
        CreditTermsPoints creditTermsPoints = new CreditTermsPoints(dataCollection);

        int personalScore = personalPoints.getPersonalPoints();
        int financialScore = financialPoints.getFinancialPoints();
        int creditTermsScore = creditTermsPoints.getCreditTermsPoints();

        this.score = personalScore + financialScore + creditTermsScore;

        System.out.println("Personal points: " + personalScore + "/300");
        System.out.println("Financial points: " + financialScore + "/1400");
        System.out.println("Credit terms points: " + creditTermsScore + "/300");

        return score;
    }


}
