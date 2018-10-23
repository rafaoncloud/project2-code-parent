package servlet;

import javax.ejb.Stateless;

@Stateless
public class HelloService {

    // If remove it, it can't recognize (null) the business layers EJBs

    public String getName(String name){
        return "My name is:" + name;
    }
}
