package co.za.ssquared.cruddemo.cucumber.module.employee.types;

public class AddressRow {

    private int addressIndex;
    private String streetName;
    private String cityName;
    private String zip;
    private String country;

    public AddressRow(int addressIndex, String streetName, String cityName, String zip, String country) {
        this.addressIndex = addressIndex;
        this.streetName = streetName;
        this.cityName = cityName;
        this.zip = zip;
        this.country = country;
    }

    public int getAddressIndex() {
        return addressIndex;
    }

    public void setAddressIndex(int addressIndex) {
        this.addressIndex = addressIndex;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
