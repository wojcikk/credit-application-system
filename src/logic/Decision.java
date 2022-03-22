package logic;

import logic.data.DataCollection;
import logic.scoring.ScoringSystem;

public class Decision {
    private final DataCollection dataCollection;
    private final MandatoryRequirements mandatoryRequirements;
    private final ScoringSystem scoringSystem;
    private boolean decision;

    public Decision(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        mandatoryRequirements = new MandatoryRequirements(dataCollection);
        scoringSystem = new ScoringSystem(dataCollection);
        getDecision();
    }

    public void getDecision() {
        int score = scoringSystem.getScore();
        if(!mandatoryRequirements.isFlag()) {
            System.out.println("Decision negative, cause of mandatory requirements");
            setDecision(false);
        } else if(score >= 1100) {
            System.out.println("Decision positive");
            setDecision(true);
        } else if (score >= 500 && checkExtraRequirement()) {
            System.out.println("Decision positive, with extra check");
            setDecision(true);
        } else {
            System.out.println("Decision negative");
            setDecision(false);
        }
        scoringSystem.printScore();
    }

    private boolean checkExtraRequirement() {
        int profit = Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) - Integer.parseInt(dataCollection.getFinancialData().getAnnualExpenses());
        if(profit * Integer.parseInt(dataCollection.getCreditTermsData().getPeriodOfLoan()) >= Integer.parseInt(dataCollection.getCreditTermsData().getAmountOfLoan()))
            return true;
        else
            return false;
    }


    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }
}
