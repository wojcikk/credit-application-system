package logic.scoring;

import logic.data.DataCollection;

public class PersonalPoints {
    private final DataCollection dataCollection;
    private StringBuilder pointsView = new StringBuilder();

    public PersonalPoints(DataCollection dataCollection) {
        this.dataCollection = dataCollection;
    }

    public int getPersonalPoints() {
        int points = 0;

        points += getMartialStatusPoints();
        points += getEducationPoints();

        pointsView.append("PERSONAL POINTS:\n");
        pointsView.append("martial status: " + getMartialStatusPoints() + "\n");
        pointsView.append("education: " + getEducationPoints() + "\n");

        return points;
    }

    private int getMartialStatusPoints() {
        if(dataCollection.getPersonalData().getMartialStatus().toLowerCase().equals("seperated"))
            return 100;
        else if(dataCollection.getPersonalData().getMartialStatus().toLowerCase().equals("married"))
            return 200;
        else
            return -1;
    }

    private int getEducationPoints() {
        if(dataCollection.getPersonalData().getEducation().toLowerCase().equals("primary"))
            return -150;
        else if(dataCollection.getPersonalData().getEducation().toLowerCase().equals("middle"))
            return -100;
        else if(dataCollection.getPersonalData().getEducation().toLowerCase().equals("secondary"))
            return -50;
        else if(dataCollection.getPersonalData().getEducation().toLowerCase().equals("post secondary"))
            return 0;
        else if(dataCollection.getPersonalData().getEducation().toLowerCase().equals("tertiary"))
            return 100;
        else if(dataCollection.getPersonalData().getEducation().toLowerCase().equals("none"))
            return -200;
        else
            return -1;
    }

    public StringBuilder getPointsView() {
        return pointsView;
    }
}
