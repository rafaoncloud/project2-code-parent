package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public class GenericUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String email;
    protected String password; // Is it needed
    protected String name;
    @Temporal(TemporalType.DATE)
    protected Date birthDate;
    protected String address;
    protected String phoneNumber;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdOn; // = new Date();
    protected String token;
    @ManyToOne
    protected Country country;

    public GenericUser() {
    }

    public GenericUser(long id, String email, String password, String name, Date birthDate, String address, String phoneNumber, Date createdOn, String token, Country country) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.country = country;
        this.createdOn = createdOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getCreateDate() {
        return createdOn;
    }

    public void setCreateDate(Date createdOn) {
        this.createdOn = createdOn;
    }


    public String getToken() {
        return token;
    }

     public void setToken(String token) {
       this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
