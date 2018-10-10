package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String password; // Is it needed

    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();

    private String creditCardNumber;

    private Boolean hasSubscriptionUpToDate;

    @ManyToMany()
    @JoinTable(name = "person_links",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "multimedia_content_id", referencedColumnName = "id", nullable = false)})
    private List<MultimediaContentEntity> watchList;


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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<MultimediaContentEntity> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<MultimediaContentEntity> watchList) {
        this.watchList = watchList;
    }

    public MultimediaContentEntity getSpecificContentFromWatchList(int index){
        return this.watchList.get(index);
    }

    public void addContentToWatchList(MultimediaContentEntity content){
        watchList.add(content);
    }
}
