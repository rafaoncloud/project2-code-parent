package ejb;

import data.Country;
import data.MultimediaContentCategory;
import dto.EMultimediaContentCategory;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class MultimediaContentCategoryEJB {

    @PersistenceContext
    private EntityManager em;


    @Inject
    GenericUserEJB genericUserEJB;

    public void addMultimediaContentCategory() throws Exception
    {
        try
        {

            for (EMultimediaContentCategory c : EMultimediaContentCategory.values()) {

                MultimediaContentCategory category= new MultimediaContentCategory();
                category.setCategory( c.toString() );
                addMultimediaContentCategoryCRUD(category);
            }

        }
        catch(Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    public dto.MultimediaContentCategory getMultimediaContentCategory(String token, long categoryId) throws Exception
    {
        dto.MultimediaContentCategory dtoCategory = new dto.MultimediaContentCategory();

        utils.Utils.getDozerBeanMapper().map(getCategoryCRUD(token, categoryId ), dtoCategory);

        return dtoCategory;
    }

    public List<dto.MultimediaContentCategory> getAllMultimediaContentCategory(String token, boolean descending) throws Exception
    {
        List<dto.MultimediaContentCategory> dtoCategory = new ArrayList<>();

        try
        {
            List<data.MultimediaContentCategory> jpaCategory =  getAllCategoryCRUD (token,descending);

            for (data.MultimediaContentCategory c : jpaCategory)
            {
                dto.MultimediaContentCategory dtoMultimediaContentCategory = new dto.MultimediaContentCategory();
                utils.Utils.getDozerBeanMapper().map(c, dtoMultimediaContentCategory);
                dtoCategory.add(dtoMultimediaContentCategory);
            }
        }
        catch(Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
        return dtoCategory;
    }


    //
    // CRUD Operations
    //
    private data.MultimediaContentCategory getCategoryCRUD(String token,long categoryId) throws Exception
    {
        try
        {
            if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");

            data.MultimediaContentCategory category = em.find(data.MultimediaContentCategory.class , categoryId);

            if (category == null)
                throw new Exception("Category with Id " + categoryId + " not found.");

            return category;
        }
        catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    private List<data.MultimediaContentCategory> getAllCategoryCRUD(String token,boolean descending) throws Exception
    {
        try
        {
            /*if(!genericUserEJB.isTokenValid( token ))
                throw new Exception("Authentication Fail.");*/

            String queryText = "from MultimediaContentCategory c order by c.category";

            if (descending)
                queryText += " desc";
            else
                queryText += " asc";

            Query query = em.createQuery(queryText);

            return query.getResultList();
        }
        catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    private void addMultimediaContentCategoryCRUD(data.MultimediaContentCategory category) throws Exception {
        // CRUD Operation
        try
        {
            em.persist(category);

        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
}
