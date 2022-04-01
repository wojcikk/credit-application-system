package database;

import logic.Decision;
import logic.data.DataCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String CONNECTION_PATH = "jdbc:sqlite:C:\\Programy\\SQLite\\creditApplicationSystemDatabase\\users.db";
    private static final String USERS_TABLE_NAME = "users";
    private final DataCollection dataCollection;
    private final Decision decision;

    public Database(DataCollection dataCollection, Decision decision) {
        this.dataCollection = dataCollection;
        this.decision = decision;
        createDatabase();
    }

    public void createDatabase() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_PATH);
            Statement statement = connection.createStatement();
            createTable(statement);
            insertUser(statement);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS " + USERS_TABLE_NAME + "(" +
                "id integer PRIMARY KEY AUTOINCREMENT, " +
                "name text NOT NULL, " +
                "surname text NOT NULL, " +
                "mothersMaidenName text NOT NULL, " +
                "dayOfBirth text NOT NULL, " +
                "monthOfBirth text NOT NULL, " +
                "yearOfBirth text NOT NULL, " +
                "martialStatus text NOT NULL, " +
                "education text NOT NULL, " +
                "email text NOT NULL, " +
                "number text NOT NULL, " +
                "street text NOT NULL, " +
                "houseNumber text NOT NULL, " +
                "province text NOT NULL, " +
                "city text NOT NULL, " +
                "country text NOT NULL, " +
                "typeOfIncome text NOT NULL, " +
                "annualIncome integer NOT NULL, " +
                "annualExpenses integer NOT NULL, " +
                "propertiesWorth integer NOT NULL, " +
                "sourceOfIncome text NOT NULL, " +
                "debtWorth integer NOT NULL, " +
                "purposeOfLoan text NOT NULL, " +
                "amountOfLoan integer NOT NULL, " +
                "periodOfLoan integer NOT NULL, " +
                "ownContribution integer NOT NULL, " +
                "decision text NOT NULL" +
                ")");
    }

    private void insertUser(Statement statement) throws SQLException {
        statement.execute("INSERT INTO " + USERS_TABLE_NAME +
                "(name, " +
                "surname, " +
                "mothersMaidenName, " +
                "dayOfBirth, " +
                "monthOfBirth, " +
                "yearOfBirth, " +
                "martialStatus, " +
                "education, " +
                "email, " +
                "number, " +
                "street, " +
                "houseNumber, " +
                "province, " +
                "city, " +
                "country, " +
                "typeOfIncome, " +
                "annualIncome, " +
                "annualExpenses, " +
                "propertiesWorth, " +
                "sourceOfIncome, " +
                "debtWorth, " +
                "purposeOfLoan, " +
                "amountOfLoan, " +
                "periodOfLoan, " +
                "ownContribution," +
                "decision)" +
                "VALUES(" +
                "'" + dataCollection.getPersonalData().getName() + "', " +
                "'" + dataCollection.getPersonalData().getSurname() + "', " +
                "'" + dataCollection.getPersonalData().getMothersMaidenName() + "', " +
                "'" + dataCollection.getPersonalData().getDayOfBirth() + "', " +
                "'" + dataCollection.getPersonalData().getMonthOfBirth() + "', " +
                "'" + dataCollection.getPersonalData().getYearOfBirth() + "', " +
                "'" + dataCollection.getPersonalData().getMartialStatus() + "', " +
                "'" + dataCollection.getPersonalData().getEducation() + "', " +
                "'" + dataCollection.getContactData().getEmail() + "', " +
                "'" + dataCollection.getContactData().getNumber() + "', " +
                "'" + dataCollection.getContactData().getStreet() + "', " +
                "'" + dataCollection.getContactData().getHouseNumber() + "', " +
                "'" + dataCollection.getContactData().getProvince() + "', " +
                "'" + dataCollection.getContactData().getCity() + "', " +
                "'" + dataCollection.getContactData().getCountry() + "', " +
                "'" + dataCollection.getFinancialData().getTypeOfContract() + "', " +
                dataCollection.getFinancialData().getAnnualIncome() + ", " +
                dataCollection.getFinancialData().getAnnualExpenses() + ", " +
                dataCollection.getFinancialData().getPropertiesValue() + ", " +
                "'" + dataCollection.getFinancialData().getSourcesOfIncomeString() + "', " +
                dataCollection.getFinancialData().getDebt() + ", " +
                "'" + dataCollection.getCreditTermsData().getPurposeOfLoan() + "', " +
                dataCollection.getCreditTermsData().getAmountOfLoan() + ", " +
                dataCollection.getCreditTermsData().getPeriodOfLoan() + ", " +
                dataCollection.getCreditTermsData().getOwnContributionInLoan() + ", " +
                "'" + decision.getDecisionPrompt() + "' "  +
                ")"
                );
    }
}
