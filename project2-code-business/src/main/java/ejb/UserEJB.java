package ejb;

import dto.Country;
import dto.GenericUser;
import dto.User;
import email.SendEmail;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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


    public UserEJB() {
    }


    public void addUser(User user) throws Exception {

        try {

            data.User userEntity = new data.User();
            Utils.getDozerBeanMapper().map(user, userEntity);

            addUserCRUD(userEntity);

            Utils.getLogger().info("User " + user.getEmail() + " created.");
        } catch (Exception ex) {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }


    public List<dto.User> getAllUsers(String token) throws Exception {
        try {

            List<data.User> usersEntities = getAllUsersCRUD();
            List<dto.User> users = new ArrayList<>();

            for (data.User userEntity : usersEntities) {
                dto.User user = new dto.User();
                Utils.getDozerBeanMapper().map(userEntity, user);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public User getUser(String token, long id) throws Exception {

        if (token.length() == 0)
            throw new Exception("Authentication Fail.");

        dto.User dtoUser = new dto.User();

        utils.Utils.getDozerBeanMapper().map(getUserCRUD(token, id), dtoUser);

        return dtoUser;
    }

    public User adminOnlyGetUser(long id) throws Exception {

        dto.User dtoUser = new dto.User();

        utils.Utils.getDozerBeanMapper().map(getUserCRUD("", id), dtoUser);

        return dtoUser;
    }

    public void updateUser(String token, User user) throws Exception {
        data.User userEntity = new data.User();
        Utils.getDozerBeanMapper().map(user, userEntity);

        updateUserCRUD(token, userEntity);

        Utils.getLogger().info("User '" + user.getEmail() + "' was edited.");
    }

    public void deleteUser(String token, long id) throws Exception {
        try {
            if (!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            deleteUserCRUD(token, id);

            Utils.getLogger().info("Multimedia Content " + id + " deleted.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public void adminOnlyUpdateUserSubscription(long id, boolean isSubscribed) throws Exception {
        try {
            updateUserSubscriptionCRUD(id,isSubscribed);

            Utils.getLogger().info("ID " + id + " subscription updated.");
        } catch (Exception e) {
            throw e;
        }
    }

    public List<dto.User> adminOnlyListAllUsers() throws Exception {
        try {

            List<data.User> usersEntities = getAllUsersCRUD();
            List<dto.User> users = new ArrayList<>();

            for (data.User userEntity : usersEntities) {
                dto.User user = new dto.User();
                Utils.getDozerBeanMapper().map(userEntity, user);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    //
    // CRUD Operations
    //
    private void addUserCRUD(data.User user) throws Exception {
        // CRUD Operation
        try {
            //Verificar se o email já existe na BD
            if (genericUserEJB.getGenericUserByEmail(user.getEmail()) != null)
                throw new Exception("Account already exists!");

            user.setHasSubscriptionUpToDate(Utils.getRandomBoolean());

            em.persist(user);

            Utils.getLogger().info(user.getEmail() + " User Created.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<data.User> getAllUsersCRUD() throws Exception {
        try {
            String queryText = "from User u";
            Query query = em.createQuery(queryText);

            return query.getResultList();
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private data.User getUserCRUD(String token, long id) throws Exception {
        try {
            data.User user = em.find(data.User.class, id);

            if (user == null)
                throw new Exception("User with ID " + id + " not found.");

            return user;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void updateUserSubscriptionCRUD(long id, boolean isSubscribed) throws Exception {
        try {

            data.User user = em.find(data.User.class, id);
            user.setHasSubscriptionUpToDate(isSubscribed);

            if(!isSubscribed){
                SendEmail.sendEmail(user.getEmail());
            }

            Utils.getLogger().info("ID " + user.getId() + " subscription updated.");
        } catch (Exception e) {
            throw e;
        }
    }

    private void updateUserCRUD(String token, data.User user) throws Exception {

        try {
            if (!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            data.User editUser = getUserCRUD(token, user.getId());

            Utils.getDozerBeanMapper().map(user, editUser);

            em.persist(editUser);

        } catch (Exception e) {
            throw e;
        }

    }

    private void deleteUserCRUD(String token, long id) throws Exception {
        try {
            if (!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            em.remove(getUserCRUD(token, id));

            Utils.getLogger().info(id + " ID user deleted.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
}
