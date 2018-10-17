package dto;

import java.util.Date;

public class Manager extends GenericUser {

    public Manager() { }

    public Manager(long id, String email, String password, String token, String name, Date birthDate, String address, String phoneNumber) {
        super(id, email, password, token, name, birthDate, address, phoneNumber);
    }
}
