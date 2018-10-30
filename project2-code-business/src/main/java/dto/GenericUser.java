package dto;

import java.io.Serializable;
import java.util.Date;

public class GenericUser implements Serializable {
    protected Long id;
    protected String email;
    protected String password; // Is it needed
    protected String name;
    protected Date birthDate;
    protected String address;
    protected String phoneNumber;
    protected Date createdOn;
    protected String token;
    protected Country country;

    public GenericUser() {
        this.country = new Country();
    }


    GenericUser(long id, String email, String password, String name, Date birthDate, String address, String phoneNumber, String token, Date createdOn,  Country country) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.token = token;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreateDate() {
        return createdOn;
    }

    public void setCreateDate(Date createdOn) {
        this.createdOn = createdOn;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
