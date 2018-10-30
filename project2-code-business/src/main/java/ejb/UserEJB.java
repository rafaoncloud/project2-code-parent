package ejb;

import dto.User;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Date;

@Stateless
@LocalBean
public class UserEJB /*implements IUserRemote, IUserLocal*/ {

    @PersistenceContext
    private EntityManager em;

    public UserEJB(){ }

    public User login(String email, String password) throws Exception {

        try{
            dto.User dtoUser= new dto.User(  );
            data.User user = loginCRUD(email,password);

            Utils.getDozerBeanMapper().map(user,dtoUser);

            return dtoUser;

        }catch(Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public void addUser(User user) throws Exception {

        try
        {

            data.User userEntity = new data.User();
            Utils.getDozerBeanMapper().map(user,userEntity);

            addUserCRUD(userEntity);

            Utils.getLogger().info("User " + user.getEmail() + " created.");
        }
        catch(Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    public List<User> getAllUsers(String token) throws Exception {
        return null;
    }

    public User getUser(String token, long id) throws Exception {

        if(token.length() == 0)
            throw new Exception("Authentication Fail.");

        dto.User dtoUser = new dto.User();

        utils.Utils.getDozerBeanMapper().map(getUserCRUD( id ), dtoUser);

        return dtoUser;
    }

    public void updateUser(String token, User user) throws Exception {

    }

    public void deleteUser(String token, long id) throws Exception {

    }

    public boolean userAlreadyExists(String token, String email) throws Exception{

        for (int i = 0; i < Utils.USERS_TABLE.length; i++)
        {
            String queryText = "from " + Utils.USERS_TABLE[i] + " u where u.email = :email";

            Query query = (Query) em.createQuery(queryText);

            query.setParameter("email", email);

            List<User> users = query.getResultList();

            if (!users.isEmpty())
                return true;
        }
        return false;
    }

    //
    // CRUD Operations
    //
    private void addUserCRUD(data.User user) throws Exception {
        // CRUD Operation
        try
        {
            //Verificar se o email já existe na BD
            if(GetUserByEmailCRUD(user.getEmail()) != null)
                throw new Exception("Account already exists!");

            em.persist(user);

            Utils.getLogger().info(user.getEmail() + " User Created.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private data.User loginCRUD (String email, String password) throws Exception
    {

        try
        {
            String queryText = "Select distinct u from User u Where u.email = :email and u.password = :password";

            Query query = em.createQuery(queryText);

            query.setParameter("email", email);
            query.setParameter("password", password);

            List<data.User> users = query.getResultList();

            if (users != null && users.size() == 1)
            {
                String token = Utils.sha1(new Date().toString() + users.get(0).getId());
                users.get(0).setToken(token);
                em.persist(users.get(0));
                return users.get(0);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }

        return null;
    }

    private List<data.User> getAllUsersCRUD(String token) throws Exception {
        return null;
    }

    private data.User getUserCRUD(long id) throws Exception {
        try
        {
            data.User user = em.find(data.User.class , id);

            if (user == null)
                throw new Exception("User with ID " + id + " not found.");

            return user;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }


    private data.User GetUserByEmailCRUD (String email) throws Exception
    {

        try
        {
            String queryText = "Select distinct u from User u Where u.email = :email";

            Query query = em.createQuery(queryText);

            query.setParameter("email", email);

            List<data.User> users = query.getResultList();

            if (users != null && users.size() == 1)
            {
                String token = Utils.sha1(new Date().toString() + users.get(0).getId());
                users.get(0).setToken(token);
                em.persist(users.get(0));
                return users.get(0);
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }

        return null;
    }

    private void updateUserCRUD(String token, User user) throws Exception {

    }

    private void deleteUserCRUD(String token, long id) throws Exception {

    }
}
