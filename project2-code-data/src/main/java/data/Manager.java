package data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Manager extends GenericUser implements Serializable {

    public Manager(){ }

    public Manager(String email, String password, String name, Date birthDate, String address, String phoneNumber, String creditCardNumber) {
        super(email, password, name, birthDate, address, phoneNumber, creditCardNumber);
    }
}
