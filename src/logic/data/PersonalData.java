package logic.data;

public class PersonalData {
    private final String name;
    private final String surname;
    private final String mothersMaidenName;
    private final String dayOfBirth;
    private final String monthOfBirth;
    private final String yearOfBirth;
    private final String martialStatus;
    private final String education;

    public PersonalData(String name, String surname, String mothersMaidenName, String dayOfBirth, String monthOfBirth, String yearOfBirth, String martialStatus, String education) {
        this.name = name;
        this.surname = surname;
        this.mothersMaidenName = mothersMaidenName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.martialStatus = martialStatus;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public String getEducation() {
        return education;
    }
}
