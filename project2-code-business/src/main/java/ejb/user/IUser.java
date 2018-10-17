package ejb.user;

import dto.Manager;
import dto.User;

import java.util.List;

public interface IUser {

    // Create
    void addUser(User user) throws Exception;
    // Retrieve
    List<User> getAllUsers(String token) throws Exception;
    User getUser(String token, long id) throws Exception;
    // Update
    void updateUser(String token, User user) throws Exception;
    // Delete
    void deleteUser(String token, long id) throws Exception;
}
