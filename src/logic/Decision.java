package logic;

import logic.data.DataCollection;
import logic.scoring.ScoringSystem;

public class Decision {
    private final DataCollection dataCollection;
    private final MandatoryRequirements mandatoryRequirements;
    private final PrivilegeRequirements privilegeRequirements;
    private final ScoringSystem scoringSystem;
    private boolean decision;
    private String decisionPrompt;
    private String reasonPrompt;

    public Decision(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        mandatoryRequirements = new MandatoryRequirements(dataCollection);
        privilegeRequirements = new PrivilegeRequirements(dataCollection);
        scoringSystem = new ScoringSystem(dataCollection);
        getDecision();
    }

    public void getDecision() {
        int score = scoringSystem.getScore();
        if(privilegeRequirements.isFlag()) {
            System.out.println("Decision positive" + privilegeRequirements.getReason());
            setDecisionPrompt("Decision positive");
            setReasonPrompt(privilegeRequirements.getReason().toString());
            setDecision(true);
        } else if(!mandatoryRequirements.isFlag()) {
            System.out.println("Decision negative" + mandatoryRequirements.getReason().toString());
            setDecisionPrompt("Decision negative");
            setReasonPrompt(mandatoryRequirements.getReason().toString());
            setDecision(false);
        } else if(score >= 1000) {
            System.out.println("Decision positive");
            setDecisionPrompt("Decision positive");
            setDecision(true);
        } else if (score >= 500 && checkExtraRequirement()) {
            System.out.println("Decision positive, with extra check");
            setDecisionPrompt("Decision positive, with extra check");
            setDecision(true);
        } else {
            System.out.println("Decision negative");
            setDecisionPrompt("Decision negative");
            setDecision(false);
        }
        scoringSystem.printScore();
    }

    private boolean checkExtraRequirement() {
        long profit = dataCollection.getFinancialData().getAnnualIncome() - dataCollection.getFinancialData().getAnnualExpenses();
        return profit * dataCollection.getCreditTermsData().getPeriodOfLoan() >= dataCollection.getCreditTermsData().getAmountOfLoan();
    }


    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    public String getDecisionPrompt() {
        return decisionPrompt;
    }

    public void setDecisionPrompt(String decisionPrompt) {
        this.decisionPrompt = decisionPrompt;
    }

    public String getReasonPrompt() {
        return reasonPrompt;
    }

    public void setReasonPrompt(String reasonPrompt) {
        this.reasonPrompt = reasonPrompt;
    }

    public ScoringSystem getScoringSystem() {
        return scoringSystem;
    }
}
