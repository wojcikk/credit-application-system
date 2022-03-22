package logic.scoring;

import logic.data.DataCollection;

public class FinancialPoints {

    private final DataCollection dataCollection;

    public FinancialPoints(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
    }

    public int getFinancialPoints() {
        int points = 0;

        points += getTypeOfIncomePoints();
        points += getAnnualIncomePoints();
        points += getPropertiesValuePoints();
        points += getSourceOfIncomePoints();
        points += getDebtPoints();

        return points;
    }


    private int getTypeOfIncomePoints() {
        if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("self employment"))
            return 50;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("employment contract"))
            return 100;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("comission contract"))
            return -100;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("specific-task contract"))
            return -50;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("student and postgraduate intership contract"))
            return -100;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("retirement"))
            return -50;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("none"))
            return -200;
        else
            return -1;
    }

    private int getAnnualIncomePoints() {
        if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < 12000)
            return -100;
        else if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < 36000)
            return -50;
        else if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < 72000)
            return 0;
        else if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < 120000)
            return 50;
        else if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < 240000)
            return 150;
        else if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) < 600000)
            return 300;
        else if (Integer.parseInt(dataCollection.getFinancialData().getAnnualIncome()) >= 600000)
            return 500;
        else
            return -1;
    }

    private int getPropertiesValuePoints() {
        if (Integer.parseInt(dataCollection.getFinancialData().getPropertiesValue()) < 100000)
            return 0;
        else if (Integer.parseInt(dataCollection.getFinancialData().getPropertiesValue()) < 500000)
            return 50;
        else if (Integer.parseInt(dataCollection.getFinancialData().getPropertiesValue()) < 1000000)
            return 100;
        else if (Integer.parseInt(dataCollection.getFinancialData().getPropertiesValue()) < 2000000)
            return 150;
        else if (Integer.parseInt(dataCollection.getFinancialData().getPropertiesValue()) < 5000000)
            return 250;
        else if (Integer.parseInt(dataCollection.getFinancialData().getPropertiesValue()) >= 5000000)
            return 500;
        else
            return -1;
    }

    private int getSourceOfIncomePoints() {
        int points = 0;
        for(int i = 0; i < dataCollection.getFinancialData().getSourcesOfIncome().size(); i++) {
            if(dataCollection.getFinancialData().getSourcesOfIncome().get(i).isSelected()) {
                System.out.println(dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase());
                if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("contract salary"))
                    points += 150;
                else if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("self employment income"))
                    points += 50;
                else if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("pension"))
                    points += -50;
                else if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("scholarships"))
                    points += -100;
                else if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("real estate rent income"))
                    points += +100;
                else if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("other benefits"))
                    points += 0;
                else if (dataCollection.getFinancialData().getSourcesOfIncome().get(i).getText().toLowerCase().equals("none"))
                    points += -200;
            }
        }
        return points;
    }

    private int getDebtPoints() {
        double ratio = (Double.parseDouble(dataCollection.getFinancialData().getAnnualIncome()) - Double.parseDouble(dataCollection.getFinancialData().getAnnualExpenses())) / Double.parseDouble(dataCollection.getFinancialData().getDebt());

        if(ratio < 2)
            return -250;
        else if(ratio < 5)
            return -100;
        else if(ratio >= 5)
            return 0;
        else
            return -1;
    }

}
