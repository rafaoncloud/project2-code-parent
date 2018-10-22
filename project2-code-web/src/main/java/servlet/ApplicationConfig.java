package servlet;

import dto.MultimediaContent;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    /*public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        set.add(dto.MultimediaContent.class);
        set.add(dto.User.class);
        set.add(dto.Manager.class);
        return set;
    }*/

//    public ApplicationConfig() { }

//    @Override
//    public Set<Object> getSingletons() {
//        HashSet<Object> set = new HashSet<Object>();
//        return set;
//    }
}
