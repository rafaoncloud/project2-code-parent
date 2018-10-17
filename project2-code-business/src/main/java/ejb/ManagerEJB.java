package ejb;

import data.Manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class ManagerEJB /* implements IManagerRemote, IManagerLocal */ {

    public ManagerEJB() { }

    public void addManager(String token, Manager manager) {

    }

    public List<Manager> getAllManagers(String token) {
        return null;
    }

    public Manager getManager(long id) {
        return null;
    }

    public void updateManager(String token, Manager manager) {

    }

    public void deleteManager(String token, long id) {

    }
}
