package data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MultimediaContentCategory  implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String category;

    public MultimediaContentCategory(){

    }

    public MultimediaContentCategory(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
