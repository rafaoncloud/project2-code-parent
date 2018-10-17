package ejb;

import dto.MultimediaContent;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class MultimediaContentEJB /*implements IMultimediaContentRemote/*, IMultimediaContentLocal*/ {

    @PersistenceContext
    private EntityManager em;


    public MultimediaContentEJB(){ }

    public void addMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception {

        // Convert to JPA Entity
        data.MultimediaContent contentEntity = new data.MultimediaContent();
        Utils.getDozerBeanMapper().map(multimediaContent,contentEntity);



        // CRUD Operation
        try {
            em.persist(multimediaContent);
            Utils.getLogger().info(multimediaContent.getTitle() + "multimedia content created.");
        }catch (Exception e){
                Utils.getLogger().error(e.getMessage());
                throw e;
        }
    }

    public MultimediaContent getMultimediaContent(String token, long id) throws Exception {


        // CRUD Operation
        try {
            data.MultimediaContent content = getMultimediaContentCRUD(token, id);
            MultimediaContent multimediaContent = new MultimediaContent();

            Utils.getDozerBeanMapper().map(content, multimediaContent);

            return multimediaContent;
        }catch (Exception e){
            throw e;
        }
    }

    public List<MultimediaContent> getMultimediaContent(String token, boolean ascend) throws Exception {
        return null;
    }

    public List<MultimediaContent> getMultimediaContentFromCategory(String token, dto.EMultimediaContentCategory category, boolean ascend) throws Exception {
        return null;
    }

    public List<MultimediaContent> getMultimediaContentFromDirector(String token, String directorName, boolean ascend) throws Exception {
        return null;
    }

    public List<MultimediaContent> getMultimediaContentBetweenYearsRange(String token, int minYear, int maxYear, boolean ascend) throws Exception {
        return null;
    }

    public void updateMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception {

    }

    public void deleteMultimediaContent(String token, long id) throws Exception {
        deleteMultimediaContentCRUD(token,id);
    }

    //
    //CRUD Operations
    //
    private data.MultimediaContent getMultimediaContentCRUD(String token, long id) throws Exception{

        // CRUD Operation
        data.MultimediaContent content = null;
        try{
            content = em.find(data.MultimediaContent.class, id);

            if(content == null){
                throw new Exception("Multimedia Content with " + id + " not found.");
            }

            return content;
        }catch(Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
    private void deleteMultimediaContentCRUD(String token, long id) throws Exception{

        // CRUD Operation
        try {
            MultimediaContent multimediaContent = getMultimediaContent(token,id);
            Utils.getLogger().info(multimediaContent.getTitle() + "multimedia content created.");
        }catch (Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
}
