package utils;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Utils {

    private static Logger loggerSingleton = null;

    private static DozerBeanMapper dozerBeanMapperSingleton = null;

    public static final String[] USERS_TABLE = {"Manager", "User"};

    public static Logger getLogger() {
        //Singleton
        if (loggerSingleton == null)
            loggerSingleton = LoggerFactory.getLogger("BussinessLayer");

        return loggerSingleton;
    }

    public static DozerBeanMapper getDozerBeanMapper() {
        //Singleton
        if (dozerBeanMapperSingleton == null)
            dozerBeanMapperSingleton = new DozerBeanMapper();

        return dozerBeanMapperSingleton;
    }

    public static String ascOrDesc(boolean ascend) {
        if (ascend)
            return " asc";

        return " desc";
    }
}
