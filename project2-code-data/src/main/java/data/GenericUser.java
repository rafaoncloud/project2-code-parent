package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public class GenericUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String email;
    protected String password; // Is it needed
    protected String token;
    protected String name;
    @Temporal(TemporalType.DATE)
    protected Date birthDate;
    protected String address;
    protected String phoneNumber;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdOn = new Date();

    public GenericUser() {

    }

    public GenericUser(String email, String password, String name, Date birthDate, String address, String phoneNumber, String creditCardNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
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

    public Date getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthDate = birthdate;
    }
}
