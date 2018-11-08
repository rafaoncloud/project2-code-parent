package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User extends GenericUser implements Serializable {

    private String creditCardNumber;
    private Boolean hasSubscriptionUpToDate;

    @ManyToMany
    protected List<MultimediaContent> watchList;

    public User() { }

    public User(long id, String email, String password, String name, Date birthDate, String address, String phoneNumber, String creditCardNumber,Date createdOn , String token, Country country, Boolean hasSubscriptionUpToDate) {
        super(id, email, password, name, birthDate, address, phoneNumber, createdOn ,token,country);
        this.creditCardNumber = creditCardNumber;
        this.hasSubscriptionUpToDate = hasSubscriptionUpToDate;
        this.watchList = new ArrayList<>();
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Boolean getHasSubscriptionUpToDate() {
        return hasSubscriptionUpToDate;
    }


    public void setHasSubscriptionUpToDate(Boolean hasSubscriptionUpToDate) {
        this.hasSubscriptionUpToDate = hasSubscriptionUpToDate;
    }

    public boolean addContentToWatchList(MultimediaContent content){
        for(MultimediaContent contentInWatchList : watchList){
            if(content.getId() == contentInWatchList.getId()){
                return false;
            }
        }
        watchList.add(content);
        return true;
    }

    public List<MultimediaContent> getWatchList() {
        return watchList;
    }

    public boolean removeMultimediaContentFromUserWatchList(long contentId) {
        for(MultimediaContent content : watchList){
            if(contentId == content.getId()){
                content.removeUser(this);
                watchList.remove(content);
                return true;
            }
        }
        return false;
    }

}
