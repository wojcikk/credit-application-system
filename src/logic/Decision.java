package logic;

import logic.data.DataCollection;
import logic.scoring.ScoringSystem;

public class Decision {
    private final DataCollection dataCollection;
    //private final MandatoryRequirements mandatoryRequirements;
    private final ScoringSystem scoringSystem;
    private boolean decision;

    public Decision(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
        //mandatoryRequirements = new MandatoryRequirements(dataCollection);
        scoringSystem = new ScoringSystem(dataCollection);
        getDecision();
    }

    public void getDecision() {
        //setDecision(mandatoryRequirements.isFlag());
        System.out.println(decision);
        System.out.println("Score: " + scoringSystem.getScore() + "/xxx");
    }


    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }
}
