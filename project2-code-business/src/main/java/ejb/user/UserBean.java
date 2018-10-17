package ejb.user;

import javax.ejb.Stateless;

@Stateless
public class UserBean implements IUserRemote, IUserLocal {

    public UserBean(){ }
}
