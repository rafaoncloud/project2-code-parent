package dto;


import data.MultimediaContent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User extends GenericUser implements Serializable {

    private String creditCardNumber;
    private Boolean hasSubscriptionUpToDate;
    private List<MultimediaContent> watchList;

    public User(String creditCardNumber, List<MultimediaContent> watchList) {
        this.creditCardNumber = creditCardNumber;
        this.watchList = watchList;
        this.hasSubscriptionUpToDate = true;
    }

    public User(long id, String email, String password, String token, String name, Date birthDate, String address, String phoneNumber, String creditCardNumber, List<MultimediaContent> watchList) {
        super(id, email, password, token, name, birthDate, address, phoneNumber);
        this.creditCardNumber = creditCardNumber;
        this.watchList = watchList;
    }

    public Boolean getHasSubscriptionUpToDate() {
        return hasSubscriptionUpToDate;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public List<MultimediaContent> getWatchList() {
        return watchList;
    }

    public void addContentToWatchList(MultimediaContent multimediaContent) {
        this.watchList.add(multimediaContent);
    }
}
