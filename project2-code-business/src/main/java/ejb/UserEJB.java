package ejb;

import dto.Country;
import dto.GenericUser;
import dto.User;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

    @Inject
    CountryEJB countryEJB;

    @Inject
    GenericUserEJB genericUserEJB;


    public UserEJB(){ }


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

        utils.Utils.getDozerBeanMapper().map(getUserCRUD(token, id ), dtoUser);

        return dtoUser;
    }

    public void updateUser(String token, User user) throws Exception {
        data.User userEntity = new data.User();
        Utils.getDozerBeanMapper().map(user,userEntity);

        updateUserCRUD(token,userEntity);

        Utils.getLogger().info("User '" + user.getEmail() + "' was edited.");
    }

    public void deleteUser(String token, long id) throws Exception {

    }


    //
    // CRUD Operations
    //
    private void addUserCRUD(data.User user) throws Exception {
        // CRUD Operation
        try
        {
            //Verificar se o email já existe na BD
            if(genericUserEJB.getGenericUserByEmail(user.getEmail()) != null)
                throw new Exception("Account already exists!");

            user.setHasSubscriptionUpToDate(Utils.getRandomBoolean());

            em.persist(user);

            Utils.getLogger().info(user.getEmail() + " User Created.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }









    private List<data.User> getAllUsersCRUD(String token) throws Exception {
        return null;
    }

    private data.User getUserCRUD(String token, long id) throws Exception {
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



    private void updateUserCRUD(String token, data.User user) throws Exception {

        try
        {
            if(!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            data.User editUser = getUserCRUD(token, user.getId());

            Utils.getDozerBeanMapper().map(user, editUser);

            em.persist( editUser  );

        }catch (Exception ex)
        {
            throw ex;
        }

    }

    private void deleteUserCRUD(String token, long id) throws Exception {

    }
}
