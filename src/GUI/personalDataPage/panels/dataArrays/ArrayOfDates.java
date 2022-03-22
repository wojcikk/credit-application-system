package GUI.personalDataPage.panels.dataArrays;

public class ArrayOfDates {

    String[] days = new String[32];
    String[] months = new String[13];
    String[] years = new String[123];


    public ArrayOfDates() {
        days[0] = "-";
        for(Integer i = 1; i < 32; i++)
            days[i] = i.toString();

        Integer year;
        for(Integer i = 0; i < 122; i++) {
            year = i + 1901;
            years[i] = year.toString();
        }
        years[122] = "-";

        months[0] = "-";
        months[1] = "January";
        months[2] = "February";
        months[3] = "March";
        months[4] = "April";
        months[5] = "May";
        months[6] = "June";
        months[7] = "July";
        months[8] = "August";
        months[9] = "September";
        months[10] = "October";
        months[11] = "November";
        months[12] = "December";
    }

    public String[] getDays() {
        return days;
    }

    public String[] getMonths() {
        return months;
    }

    public String[] getYears() {
        return years;
    }
}
