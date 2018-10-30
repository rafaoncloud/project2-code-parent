package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User extends GenericUser implements Serializable {

    private String creditCardNumber;
    private Boolean hasSubscriptionUpToDate;
    protected List<MultimediaContent> watchList;

    public User(){

    }

    public User(String creditCardNumber, List<MultimediaContent> watchList) {
        this.creditCardNumber = creditCardNumber;
        this.watchList = watchList;
        this.hasSubscriptionUpToDate = true;
    }

    public User(long id, String email, String password, String name, Date birthDate, String address, String phoneNumber, String creditCardNumber, String token, Date createdOn, Country country) {
        super(id, email, password, name, birthDate, address, phoneNumber,token, createdOn, country);
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
