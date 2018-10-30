package dto;

public class Country {
    private long CountryId;
    private String CountryName;


    public Country() { }

    public Country(long id, String name) {
        this.CountryId = id;
        this.CountryName = name;
    }

    public Country(String name) {
        this.CountryName = name;
    }

    public long getCountryId() {
        return CountryId;
    }

    public void setCountryId(long countryId) {
        this.CountryId = countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountyName(String countyName) {
        this.CountryName = countyName;
    }

}
