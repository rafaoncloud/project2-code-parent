package dto;

import data.EMultimediaContentCategory;
import data.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultimediaContent {

    private long id;
    private String contentPath;
    private String title;
    private EMultimediaContentCategory category;
    private Date yearOfRelease;
    private String directorName;
    private List<User> users;

    public MultimediaContent(){ }

    public MultimediaContent(long id, String contentPath, String title, EMultimediaContentCategory category, Date yearOfRelease, String directorName,
                             List<User> users) {
        this.id = id;
        this.contentPath = contentPath;
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.users = users;
    }

    public MultimediaContent(long id, String contentPath, String title, EMultimediaContentCategory category, Date yearOfRelease, String directorName) {
        this.id = id;
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

    public EMultimediaContentCategory getCategory() {
        return category;
    }

    public void setCategory(EMultimediaContentCategory category) {
        this.category = category;
    }

    public Date getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Date yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
