package admin;

import javax.ejb.Stateless;

@Stateless
public class ActivateEJBs {

    // If remove it, it can't recognize (null) the business layers EJBs

    public String getName(String name){
        return "My name is:" + name;
    }
}
