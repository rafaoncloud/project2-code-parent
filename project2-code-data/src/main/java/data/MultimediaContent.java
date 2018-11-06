package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class MultimediaContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contentPath;
    private String title;
    @ManyToOne
    private MultimediaContentCategory category;
    //@Temporal(TemporalType.DATE)
    private int yearOfRelease;
    private String directorName;
    // The UserEntity is the owner of the relation
    @ManyToMany(mappedBy = "watchList")
    private List<User> users;
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdOn; // = new Date();

    public MultimediaContent(){ }

    public MultimediaContent(String contentPath, String title, MultimediaContentCategory category, int yearOfRelease, String directorName, Date createdOn) {
        this.contentPath = contentPath;
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.users = new ArrayList<>();
        this.createdOn = createdOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MultimediaContentCategory getCategory() {
        return category;
    }

    public void setCategory(MultimediaContentCategory category) {
        this.category = category;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<data.User> users) { this.users = users; }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        String text = "[Multimedia Content]";

        text += "\nId: " + id + "\nPath: " + contentPath + "\nTitle: " + title + "\nCategory: " + category +
                "\nYear of Release: " + yearOfRelease + "\nDirector Name: " + directorName +
                "\nUsers: ";

        if(users == null)
            text += "0";
        else
            text += users.size();

        return text;
    }
}
