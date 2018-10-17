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
}
