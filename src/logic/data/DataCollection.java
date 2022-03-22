package logic.data;

import logic.data.ContactData;
import logic.data.CreditTermsData;
import logic.data.FinancialData;
import logic.data.PersonalData;

public class DataCollection {

    private final PersonalData personalData;
    private final ContactData contactData;
    private final FinancialData financialData;
    private final CreditTermsData creditTermsData;

    public DataCollection(PersonalData personalData, ContactData contactData, FinancialData financialData, CreditTermsData creditTermsData) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financialData = financialData;
        this.creditTermsData = creditTermsData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public FinancialData getFinancialData() {
        return financialData;
    }

    public CreditTermsData getCreditTermsData() {
        return creditTermsData;
    }
}
