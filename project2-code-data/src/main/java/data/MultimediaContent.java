package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class MultimediaContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contentPath;
    private String title;
    private EMultimediaContentCategory category;
    @Temporal(TemporalType.DATE)
    private Date yearOfRelease;
    private String directorName;
    // The UserEntity is the owner of the relation
    @ManyToMany(mappedBy = "watchList")
    private List<User> users;

    public MultimediaContent(){ }

    public MultimediaContent(String contentPath, String title, EMultimediaContentCategory category, Date yearOfRelease, String directorName) {
        this.contentPath = contentPath;
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.users = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EMultimediaContentCategory getCategory() {
        return category;
    }

    public void setCategory(EMultimediaContentCategory category) {
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

    public Date getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Date yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<data.User> users) { this.users = users; }

    public void removeUser(User user){
        this.users.remove(user);
    }
}
