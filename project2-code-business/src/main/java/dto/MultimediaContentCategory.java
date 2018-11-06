package dto;

public class MultimediaContentCategory
{
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
