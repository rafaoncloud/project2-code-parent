package ejb;

import dto.GenericUser;
import dto.User;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class GenericUserEJB
{

    @PersistenceContext
    private EntityManager em;

    public GenericUser login(String email, String password) throws Exception {

        try
        {

            data.GenericUser user = loginUserCRUD(email,password);

            if (user instanceof data.Manager)
            {
                dto.Manager dtoManager = new dto.Manager();
                Utils.getDozerBeanMapper().map(((data.Manager)user), dtoManager);
                return dtoManager;
            }
            else if (user instanceof data.User)
            {
                dto.User dtoUser= new dto.User();
                Utils.getDozerBeanMapper().map(((data.User)user), dtoUser);
                return dtoUser;
            }

        }catch(Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
        return  null;
    }

    public void logout(String token) throws Exception {

        try
        {
            logoutCRUD(token);
        }
        catch(Exception e)
        {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public boolean isTokenValid(String token)
    {
        try
        {
            return isTokenValidCRUD(token);
        }
        catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    public GenericUser getGenericUserByEmail(String email) throws Exception {

//        if(token.length() == 0)
//            throw new Exception("Authentication Fail.");

        data.GenericUser genericUser = getGenericUserByEmailCRUD(email );

        if(genericUser == null)
            return null;

        if (genericUser instanceof data.Manager)
        {
            dto.Manager dtoManager = new dto.Manager();
            Utils.getDozerBeanMapper().map(((data.Manager)genericUser), dtoManager);
            return dtoManager;
        }
        else if (genericUser instanceof data.User)
        {
            dto.User dtoUser= new dto.User();
            Utils.getDozerBeanMapper().map(((data.User)genericUser), dtoUser);
            return dtoUser;
        }

        dto.GenericUser dtoUser = new dto.GenericUser();


        return dtoUser;
    }

    //
    // CRUD Operations
    //
    private data.GenericUser loginUserCRUD (String email, String password) throws Exception
    {
        try
        {
            for (int i = 0; i < Utils.USERS_TABLE.length; i++)
            {
                String queryText = "Select distinct u from " + Utils.USERS_TABLE[i] + "  u Where u.email = :email and u.password = :password";

                Query query = em.createQuery( queryText );

                query.setParameter( "email", email );
                query.setParameter( "password", password );

                List<data.GenericUser> users = query.getResultList();

                if (users != null && users.size() == 1) {
                    String token = Utils.sha1( new Date().toString() + users.get( 0 ).getId() );
                    users.get( 0 ).setToken( token );
                    em.persist( users.get( 0 ) );
                    return users.get( 0 );
                }
            }

        }
        catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }

        return null;
    }

    private void logoutCRUD(String token)
    {
        try
        {
            for (int i = 0; i < Utils.USERS_TABLE.length; i++)
            {
                String queryText = "from " + Utils.USERS_TABLE[i] + " u where u.token = :token";
                Query query = em.createQuery( queryText );

                query.setParameter( "token", token );

                List<data.GenericUser> users = query.getResultList();

                if (users.size() != 1)
                    continue;

                users.get( 0 ).setToken( null );
                em.persist( users.get( 0 ) );
                break;

            }
        }catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw  ex;
        }
    }

    private boolean isTokenValidCRUD (String token)
    {
        try
        {
            for (int i = 0; i < Utils.USERS_TABLE.length; i++)
            {
                String queryText = "from " + Utils.USERS_TABLE[i] + "  u where u.token = :token";
                Query query = em.createQuery( queryText );

                query.setParameter( "token", token );

                List<User> users = query.getResultList();

                if (users.size() > 0) {
                    return true;
                }
            }
        }
        catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
        return   false;
    }

    private data.GenericUser getGenericUserByEmailCRUD (String email) throws Exception
    {

        try
        {
            for (int i = 0; i < Utils.USERS_TABLE.length; i++)
            {
                String queryText = "Select distinct u from " + Utils.USERS_TABLE[i] + " u Where u.email = :email";

                Query query = em.createQuery(queryText);

                query.setParameter("email", email);

                List< data.GenericUser> users = query.getResultList();

                if (users != null && users.size() == 1)
                {
                    String token = Utils.sha1(new Date().toString() + users.get(0).getId());
                    users.get(0).setToken(token);
                    em.persist(users.get(0));
                    return users.get(0);
                }
            }
        }
        catch (Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }

        return null;
    }

}
