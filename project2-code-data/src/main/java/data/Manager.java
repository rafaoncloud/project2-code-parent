package data;

import java.util.Date;

public class Manager extends GenericUser{

    public Manager(){ }

    public Manager(String email, String password, String name, Date birthDate, String address, String phoneNumber, String creditCardNumber) {
        super(email, password, name, birthDate, address, phoneNumber, creditCardNumber);
    }
}
