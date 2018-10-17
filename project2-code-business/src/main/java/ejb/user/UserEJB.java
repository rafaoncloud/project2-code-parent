package ejb.user;

import dto.Manager;
import dto.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserEJB implements IUserRemote, IUserLocal {

    public UserEJB(){ }


    @Override
    public void addUser(User user) throws Exception {

    }

    @Override
    public List<User> getAllUsers(String token) throws Exception {
        return null;
    }

    @Override
    public User getUser(String token, long id) throws Exception {
        return null;
    }

    @Override
    public void updateUser(String token, User user) throws Exception {

    }

    @Override
    public void deleteUser(String token, long id) throws Exception {

    }
}
