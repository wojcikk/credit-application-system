package logic.scoring;

import logic.data.DataCollection;

public class CreditTermsPoints {

    private final DataCollection dataCollection;

    public CreditTermsPoints(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
    }

    public int getCreditTermsPoints() {
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
}
