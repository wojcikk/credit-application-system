package logic.scoring;

import logic.data.DataCollection;

public class ScoringSystem {
    private final DataCollection dataCollection;
    private final PersonalPoints personalPoints;
    private final FinancialPoints financialPoints;
    private final CreditTermsPoints creditTermsPoints;
    private final int personalScore;
    private final int financialScore;
    private final int creditTermsScore;
    private int score;

    public ScoringSystem(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        this.personalPoints = new PersonalPoints(dataCollection);
        this.financialPoints = new FinancialPoints(dataCollection);
        this.creditTermsPoints = new CreditTermsPoints(dataCollection);
        this.personalScore = personalPoints.getPersonalPoints();
        this.financialScore = financialPoints.getFinancialPoints();
        this.creditTermsScore = creditTermsPoints.getCreditTermsPoints();
    }

    public int getScore() {
        this.score = personalScore + financialScore + creditTermsScore;

        return score;
    }

    public void printScore() {
        System.out.println("Total points: " + score);
        System.out.println(personalPoints.getPointsView());
        System.out.println(financialPoints.getPointsView());
        System.out.println(creditTermsPoints.getPointsView());
//        System.out.println("Personal points: " + personalScore);
//        System.out.println("Financial points: " + financialScore);
//        System.out.println("Credit terms points: " + creditTermsScore);
    }


}
