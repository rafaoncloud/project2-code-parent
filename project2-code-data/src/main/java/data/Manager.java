package data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Manager extends GenericUser implements Serializable {

    public Manager(){ }

    public Manager(long id, String email, String password, String name, Date birthDate, String address, String phoneNumber,Date createdOn, String token, Country country) {
        super(id, email, password, name, birthDate, address, phoneNumber, createdOn ,token, country);
    }
}
