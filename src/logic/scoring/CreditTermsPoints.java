package logic.scoring;

import logic.data.DataCollection;

public class CreditTermsPoints {

    private final DataCollection dataCollection;
    private StringBuilder pointsView = new StringBuilder();

    public CreditTermsPoints(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
    }

    public int getCreditTermsPoints() {
        int points = 0;

        points += getPurposeOfLoanPoints();
        points += getOwnContributionPoints();

        pointsView.append("CREDIT TERMS POINTS:\n");
        pointsView.append("purpose of loan: " + getPurposeOfLoanPoints() + "\n");
        pointsView.append("own contribution percentage: " + getOwnContributionPoints() + "\n");

        return points;
    }

    private int getPurposeOfLoanPoints() {
        String path = dataCollection.getCreditTermsData().getPurposeOfLoan().toLowerCase();

        if(path.equals("real estate investment"))
            return 300;
        else if(path.equals("business investments"))
            return 200;
        else if(path.equals("consolidate debt to pay off bills"))
            return -100;
        else if(path.equals("cover unplanned emergency expenses"))
            return 0;
        else if(path.equals("make necessary home repairs"))
            return 50;
        else if(path.equals("finance funeral expenses"))
            return 100;
        else if(path.equals("help cover moving costs"))
            return 0;
        else if(path.equals("make a large purchase"))
            return 0;
        else if(path.equals("contribution to gambling"))
            return -300;
        else if(path.equals("none"))
            return -200;
        else
            return -1;
    }

    private int getOwnContributionPoints() {
        double percentage = (double) dataCollection.getCreditTermsData().getOwnContributionInLoan() / (double) dataCollection.getCreditTermsData().getAmountOfLoan() * 100;
        if(percentage >= 5 && percentage < 25)
            return 100;
        else if(percentage < 50)
            return 200;
        else if(percentage >= 50)
            return 500;
        else
            return -1;
    }

    public StringBuilder getPointsView() {
        return pointsView;
    }
}
