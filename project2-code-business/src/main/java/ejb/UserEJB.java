package ejb;

import dto.User;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class UserEJB /*implements IUserRemote, IUserLocal*/ {

    @PersistenceContext
    private EntityManager em;

    public UserEJB(){ }

    public void addUser(User user) throws Exception {

        try{
            user.setId(null);
            data.User userEntity = new data.User();

            Utils.getDozerBeanMapper().map(user,userEntity);

            //System.out.println("1:" + user.toString());
            //System.out.println("2:" + user.toString());

            //data.Test test = new data.Test();
            //test.setId(null);
            //test.setName("Rafa");
            //em.persist(test);

            addUserCRUD(userEntity);

            Utils.getLogger().info("User " + user.getEmail() + " created.");
        }catch(Exception e){
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<User> getAllUsers(String token) throws Exception {
        return null;
    }

    public User getUser(String token, long id) throws Exception {
        return null;
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
        try {
            System.out.println("add User before\n");
            em.persist(user);
            System.out.println("add User after\n");
            Utils.getLogger().info(user.getEmail() + " User Created.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private List<User> getAllUsersCRUD(String token) throws Exception {
        return null;
    }

    private User getUserCRUD(String token, long id) throws Exception {
        return null;
    }

    private void updateUserCRUD(String token, User user) throws Exception {

    }

    private void deleteUserCRUD(String token, long id) throws Exception {

    }
}
