package ejb.manager;

import data.Manager;

import java.util.List;

public interface IManager {

    // Create
    void addManager(String token, Manager manager);
    // Retrieve
    List<Manager> getAllManagers(String token);
    Manager getManager(long id);
    // Update
    void updateManager(String token, Manager manager);
    // Delete
    void deleteManager(String token, long id);

}
