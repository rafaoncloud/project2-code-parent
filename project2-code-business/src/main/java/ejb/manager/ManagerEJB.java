package ejb.manager;

import data.Manager;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ManagerEJB implements IManagerRemote, IManagerLocal {

    public ManagerEJB() { }

    @Override
    public void addManager(String token, Manager manager) {

    }

    @Override
    public List<Manager> getAllManagers(String token) {
        return null;
    }

    @Override
    public Manager getManager(long id) {
        return null;
    }

    @Override
    public void updateManager(String token, Manager manager) {

    }

    @Override
    public void deleteManager(String token, long id) {

    }
}
