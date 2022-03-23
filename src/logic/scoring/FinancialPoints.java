package logic.scoring;

import logic.data.DataCollection;

public class FinancialPoints {

    private final DataCollection dataCollection;
    private StringBuilder pointsView = new StringBuilder();

    public FinancialPoints(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
    }

    public int getFinancialPoints() {
        int points = 0;

        points += getTypeOfIncomePoints();
        points += getAnnualIncomePoints();
        if(dataCollection.getFinancialData().getPropertiesValue() != -1)
            points += getPropertiesValuePoints();
        points += getSourceOfIncomePoints();
        if(dataCollection.getFinancialData().getDebt() != -1)
            points += getDebtPoints();

        pointsView.append("FINANCIAL POINTS:\n");
        pointsView.append("type of income: " + getTypeOfIncomePoints() + "\n");
        pointsView.append("annual income: " + getAnnualIncomePoints() + "\n");
        if(dataCollection.getFinancialData().getPropertiesValue() != -1)
            pointsView.append("properties value: " + getPropertiesValuePoints() + "\n");
        pointsView.append("source of income: " + getSourceOfIncomePoints() + "\n");
        if(dataCollection.getFinancialData().getDebt() != -1)
            pointsView.append("debt ratio: " + getDebtPoints() + "\n");

        return points;
    }


    private int getTypeOfIncomePoints() {
        if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("self employment"))
            return 50;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("employment contract"))
            return 100;
        else if(dataCollection.getFinancialData().getTypeOfContract().toLowerCase().equals("commission contract"))
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
        if (dataCollection.getFinancialData().getAnnualIncome() < 12000)
            return -100;
        else if (dataCollection.getFinancialData().getAnnualIncome() < 36000)
            return -50;
        else if (dataCollection.getFinancialData().getAnnualIncome() < 72000)
            return 0;
        else if (dataCollection.getFinancialData().getAnnualIncome() < 120000)
            return 50;
        else if (dataCollection.getFinancialData().getAnnualIncome() < 240000)
            return 150;
        else if (dataCollection.getFinancialData().getAnnualIncome() < 600000)
            return 300;
        else if (dataCollection.getFinancialData().getAnnualIncome() >= 600000)
            return 500;
        else
            return -1;
    }

    private int getPropertiesValuePoints() {
        if (dataCollection.getFinancialData().getPropertiesValue() < 100000)
            return 0;
        else if (dataCollection.getFinancialData().getPropertiesValue() < 500000)
            return 50;
        else if (dataCollection.getFinancialData().getPropertiesValue() < 1000000)
            return 100;
        else if (dataCollection.getFinancialData().getPropertiesValue() < 2000000)
            return 150;
        else if (dataCollection.getFinancialData().getPropertiesValue() < 5000000)
            return 250;
        else if (dataCollection.getFinancialData().getPropertiesValue() >= 5000000)
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
        double ratio = ((double) dataCollection.getFinancialData().getAnnualIncome() - (double) dataCollection.getFinancialData().getAnnualExpenses()) / (double) dataCollection.getFinancialData().getDebt();

        if(ratio < 2)
            return -250;
        else if(ratio < 5)
            return -100;
        else if(ratio >= 5)
            return 0;
        else
            return -1;
    }

    public StringBuilder getPointsView() {
        return pointsView;
    }
}
