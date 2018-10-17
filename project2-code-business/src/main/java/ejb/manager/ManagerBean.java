package ejb.manager;

import javax.ejb.Stateless;

@Stateless
public class ManagerBean implements IManagerRemote, IManagerLocal {

    public ManagerBean() { }
}
