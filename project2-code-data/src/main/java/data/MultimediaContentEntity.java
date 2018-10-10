package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MultimediaContent")
public class MultimediaContentEntity implements Serializable {

    public enum EMultimediaContentCategory {
        ACTION,
        ADVENTURE,
        COMEDY,
        CRIME,
        DRAMA,
        FANTASY,
        HISTORICAL,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String contentPath;

    private String title;

    private EMultimediaContentCategory category;

    private Date yearOfRelease;

    private String directorName;

    // The UserEntity is the owner of the relation
    @ManyToMany(mappedBy = "watchList")
    private List<UserEntity> users = new ArrayList<>();


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
}
