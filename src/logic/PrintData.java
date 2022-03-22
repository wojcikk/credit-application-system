package logic;

import logic.data.ContactData;
import logic.data.CreditTermsData;
import logic.data.FinancialData;
import logic.data.PersonalData;

public class PrintData {
    private final PersonalData personalData;
    private final ContactData contactData;
    private final FinancialData financialData;
    private final CreditTermsData creditTermsData;

    public PrintData(PersonalData personalData, ContactData contactData, FinancialData financialData, CreditTermsData creditTermsData) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financialData = financialData;
        this.creditTermsData = creditTermsData;
        printData();
    }

    public void printData() {
        System.out.println(personalData.getName());
        System.out.println(personalData.getSurname());
        System.out.println(personalData.getMothersMaidenName());
        System.out.println(personalData.getDayOfBirth());
        System.out.println(personalData.getMonthOfBirth());
        System.out.println(personalData.getYearOfBirth());
        System.out.println(personalData.getMartialStatus());
        System.out.println(personalData.getEducation());

        System.out.println(contactData.getEmail());
        System.out.println(contactData.getStreet());
        System.out.println(contactData.getHouseNumber());
        System.out.println(contactData.getProvince());
        System.out.println(contactData.getCity());
        System.out.println(contactData.getCountry());

        System.out.println(financialData.getTypeOfContract());
        System.out.println(financialData.getAnnualIncome());
        System.out.println(financialData.getAnnualExpenses());
        System.out.println(financialData.getPropertiesValue());
        System.out.println(financialData.getSourcesOfIncome());
        System.out.println(financialData.getDebt());

        System.out.println(creditTermsData.getPurposeOfLoan());
        System.out.println(creditTermsData.getAmountOfLoan());
        System.out.println(creditTermsData.getPeriodOfLoan());
    }
}
