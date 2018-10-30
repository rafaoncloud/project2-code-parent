package dto;

import java.io.Serializable;
import java.util.Date;

public class Manager extends GenericUser implements Serializable {

    public Manager() { }

    public Manager(long id, String email, String password, String name, Date birthDate, String address, String phoneNumber, String token, Date createdOn, Country country) {
        super(id, email, password, name, birthDate, address, phoneNumber, token, createdOn ,country);
    }
}
