package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultimediaContent implements Serializable {

    private Long id;
    private String contentPath;
    private String title;
    private EMultimediaContentCategory category;
    private int yearOfRelease;
    private String directorName;
    private List<User> users;

    public MultimediaContent(){ }

    public MultimediaContent(long id, String contentPath, String title, EMultimediaContentCategory category, int yearOfRelease, String directorName,
                             List<User> users) {
        this.id = id;
        this.contentPath = contentPath;
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.users = users;
    }

    public MultimediaContent(long id, String contentPath, String title, EMultimediaContentCategory category, int yearOfRelease, String directorName) {
        this.id = id;
        this.contentPath = contentPath;
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.users = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
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
