package ejb;

import data.MultimediaContentCategory;
import data.User;
import dto.MultimediaContent;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class MultimediaContentEJB /*implements IMultimediaContentRemote/*, IMultimediaContentLocal*/ {

    @PersistenceContext
    private EntityManager em;


    @Inject
    GenericUserEJB genericUserEJB;

    public MultimediaContentEJB() {
    }

    public String echo(String name){
        return "Test echo: " + name;
    }

    public void addMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception {

        try
        {
            multimediaContent.setId(null);
            data.MultimediaContent multimediaContentEntity = new data.MultimediaContent();

            Utils.getDozerBeanMapper().map(multimediaContent,multimediaContentEntity);

            addMultimediaContentCRUD(token,multimediaContentEntity);

            Utils.getLogger().info("Multimedia Content " + multimediaContent.getTitle() + " added.");
        }
        catch(Exception e)
        {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public MultimediaContent getMultimediaContent(String token, long id) throws Exception {

        try
        {
            data.MultimediaContent multimediaContentEntity = getMultimediaContentCRUD(token,id);

            MultimediaContent multimediaContent = new MultimediaContent();

            Utils.getDozerBeanMapper().map(multimediaContentEntity,multimediaContent);

            return multimediaContent;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<MultimediaContent> getAllMultimediaContent(String token, boolean ascend) throws Exception
    {

        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            List<data.MultimediaContent> multimediaContentEntities = getAllMultimediaContentCRUD(token,ascend);

            List<MultimediaContent> multimediaContents = new ArrayList<>();

            for(data.MultimediaContent contentEntity : multimediaContentEntities){
                MultimediaContent content = new MultimediaContent();
                Utils.getDozerBeanMapper().map(contentEntity, content);
                multimediaContents.add(content);
            }

            return multimediaContents;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<MultimediaContent> getMultimediaContentFromCategory(String token, long categoryId, boolean ascend) throws Exception
    {
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            List<data.MultimediaContent> multimediaContentEntities = getAllMultimediaContentByCategoryCRUD(token,categoryId,ascend);

            List<MultimediaContent> multimediaContents = new ArrayList<>();

            for(data.MultimediaContent contentEntity : multimediaContentEntities){
                MultimediaContent content = new MultimediaContent();
                Utils.getDozerBeanMapper().map(contentEntity, content);
                multimediaContents.add(content);
            }
            return multimediaContents;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<MultimediaContent> getMultimediaContentFromDirector(String token, String directorName, boolean ascend) throws Exception
    {
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            List<data.MultimediaContent> multimediaContentEntities = getAllMultimediaContentByDirectorNameCRUD(token,directorName,ascend);

            List<MultimediaContent> multimediaContents = new ArrayList<>();

            for(data.MultimediaContent contentEntity : multimediaContentEntities){
                MultimediaContent content = new MultimediaContent();
                Utils.getDozerBeanMapper().map(contentEntity, content);
                multimediaContents.add(content);
            }
            return multimediaContents;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<MultimediaContent> getMultimediaContentBetweenYearsRange(String token, int minYear, int maxYear, boolean ascend) throws Exception
    {
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            List<data.MultimediaContent> multimediaContentEntities = getAllMultimediaByYearRangeContentCRUD(token,minYear,maxYear,ascend);

            List<MultimediaContent> multimediaContents = new ArrayList<>();

            for(data.MultimediaContent contentEntity : multimediaContentEntities){
                MultimediaContent content = new MultimediaContent();
                Utils.getDozerBeanMapper().map(contentEntity, content);
                multimediaContents.add(content);
            }
            return multimediaContents;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<MultimediaContent> getTopMultimediaContent(String token, int top, boolean ascend) throws Exception
    {
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            List<data.MultimediaContent> multimediaContentEntities = getTopMultimediaContentCRUD(token,top,ascend);

            List<MultimediaContent> multimediaContents = new ArrayList<>();

            for(data.MultimediaContent contentEntity : multimediaContentEntities){
                MultimediaContent content = new MultimediaContent();
                Utils.getDozerBeanMapper().map(contentEntity, content);
                multimediaContents.add(content);
            }
            return multimediaContents;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
    public void updateMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception
    {

        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            data.MultimediaContent multimediaContentEntity = new data.MultimediaContent();

            Utils.getDozerBeanMapper().map(multimediaContent, multimediaContentEntity);

            updateMultimediaContentCRUD(token, multimediaContentEntity);

            Utils.getLogger().info("Multimedia Content " + multimediaContent.getTitle() + " edited.");
        }catch(Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public void deleteMultimediaContent(String token, long id) throws Exception
    {
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            deleteMultimediaContentCRUD(token, id);

            Utils.getLogger().info("Multimedia Content " + id + " deleted.");
        }catch (Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    //
    // CRUD Operations
    //
    private void addMultimediaContentCRUD(String token, data.MultimediaContent multimediaContent) throws Exception
    {
        // CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            em.persist(multimediaContent);

            Utils.getLogger().info(multimediaContent.getTitle() + "multimedia content created.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private data.MultimediaContent getMultimediaContentCRUD(String token, long id) throws Exception
    {

        // CRUD Operation
        data.MultimediaContent content = null;
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            content = em.find(data.MultimediaContent.class, id);

            if (content == null) {
                throw new Exception("Multimedia Content with " + id + " not found.");
            }

            return content;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<data.MultimediaContent> getAllMultimediaContentCRUD(String token, boolean ascend) throws Exception
    {
        // CRUD Operation

        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            String isAsc = Utils.ascOrDesc(ascend);
            String queryText = "from MultimediaContent c order by c.title " + isAsc;
            Query query = em.createQuery(queryText);

            return query.getResultList();
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<data.MultimediaContent> getAllMultimediaContentByCategoryCRUD(String token, long categoryId, boolean ascend) throws Exception {
        // CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            String isAsc = Utils.ascOrDesc(ascend);
            String queryText = "from MultimediaContent c where c.categoryId = :categoryId order by c.title " + isAsc;

            Query query = em.createQuery(queryText);
            query.setParameter("categoryId", categoryId);

            return query.getResultList();
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<data.MultimediaContent> getAllMultimediaContentByDirectorNameCRUD(String token, String dirName, boolean ascend) throws Exception
    {
        // CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            String isAsc = Utils.ascOrDesc(ascend);
            String queryText = "from MultimediaContent c where c.directorName = :directorName order by c.title " + isAsc;

            Query query = em.createQuery(queryText);
            query.setParameter("directorName", dirName);

            return query.getResultList();
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<data.MultimediaContent> getAllMultimediaByYearRangeContentCRUD(String token, int minYear,int maxYear, boolean ascend) throws Exception
    {
        // CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            String isAsc = Utils.ascOrDesc(ascend);
            String queryText = "from MultimediaContent c where c.minYear >= :minYear, c.maxYear <= :maxYear order by c.title " + isAsc;
            Query query = em.createQuery(queryText);

            query.setParameter("minYear",minYear);
            query.setParameter("maxYear",maxYear);

            return query.getResultList();
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<data.MultimediaContent> getTopMultimediaContentCRUD(String token, int top, boolean ascend) throws Exception
    {
        // CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            String isAsc = Utils.ascOrDesc(ascend);
            String queryText = "from MultimediaContent m order by m.title " + isAsc;
            Query query = em.createQuery(queryText);

            query.setMaxResults(top);

            return query.getResultList();
        } catch (Exception e)
        {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private void updateMultimediaContentCRUD(String token, data.MultimediaContent multimediaContent) throws Exception
    {
        //CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            // Get the Multimedia Content Entity from the Database
            data.MultimediaContent multimediaContentEntity = getMultimediaContentCRUD(token, multimediaContent.getId());

            // Erase the relationed users and create new entry to add Users
            // multimediaContentEntity.setUsers(new ArrayList<>());

            List<User> users = multimediaContentEntity.getUsers();
            Utils.getDozerBeanMapper().map(multimediaContent, multimediaContentEntity);
            multimediaContentEntity.setUsers(users);

            Utils.getLogger().info("ID " + multimediaContentEntity.getId() + " Multimedia Content was updated.");
        } catch (Exception ex) {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    private void deleteMultimediaContentCRUD(String token, long id) throws Exception
    {

        // CRUD Operation
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            em.remove(getMultimediaContentCRUD(token, id));

            Utils.getLogger().info(id + " ID multimedia content deleted.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
}
