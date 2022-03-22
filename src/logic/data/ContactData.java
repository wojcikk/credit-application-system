package logic.data;

public class ContactData {
    private final String email;
    private final String number;
    private final String street;
    private final String houseNumber;
    private final String province;
    private final String city;
    private final String country;

    public ContactData(String email, String number, String street, String houseNumber, String province, String city, String country) {
        this.email = email;
        this.number = number;
        this.street = street;
        this.houseNumber = houseNumber;
        this.province = province;
        this.city = city;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
