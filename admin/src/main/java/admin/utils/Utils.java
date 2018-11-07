import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static Logger loggerSingleton = null;

    public static Logger getLogger() {
        //Singleton
        if (loggerSingleton == null)
            loggerSingleton = LoggerFactory.getLogger( "BussinessLayer" );

        return loggerSingleton;
    }
}
