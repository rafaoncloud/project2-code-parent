package data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User extends GenericUser implements Serializable {

    private String creditCardNumber;
    private Boolean hasSubscriptionUpToDate;

    @ManyToMany
    //@JoinTable(name = "person_links",
    //        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)},
    //        inverseJoinColumns = {@JoinColumn(name = "multimedia_content_id", referencedColumnName = "id", nullable = false)})
    protected List<MultimediaContent> watchList;

    public User() { }

    public User(String email, String password, String name, Date birthDate, String address, String phoneNumber,
                String creditCardNumber) {
        super(email, password, name, birthDate, address, phoneNumber, creditCardNumber);
        this.creditCardNumber = creditCardNumber;
        this.hasSubscriptionUpToDate = true;
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

    public List<MultimediaContent> getWatchList() {
        return watchList;
    }

    public void removeMultimediaContentFromUserWatchList(int index) {
        MultimediaContent multimediaContent =  this.watchList.get(index);
        multimediaContent.removeUser(this);
    }
}
