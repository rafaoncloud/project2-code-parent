package data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long CountryId;
    protected String CountryName;

    public Country()
    {

    }
    public Country(long countryId, String countyName) {
        this.CountryId = countryId;
        this.CountryName = countyName;

    }

    public Country(String countyName) {
        this.CountryName = countyName;
    }

    public long getCountryId() {
        return CountryId;
    }

    public void setCountryId(long countryId) {
        this.CountryId = countryId;
    }

    public String getCountyName() {
        return CountryName;
    }

    public void setCountyName(String countyName) {
        this.CountryName = countyName;
    }

    @Override
    public String toString() {
        String text = "[Country]";

        text += "\nCountryId: " + CountryId + "    CountyName: " + CountryName;

        return text;
    }
}
