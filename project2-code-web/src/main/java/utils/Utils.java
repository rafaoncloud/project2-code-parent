package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static Date ParseDate(String dateStr) throws Exception {
        try
        {
            if(dateStr != null)
            {
                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
                Date date =  formatter.parse( dateStr );
                return new Date(date.getYear(), date.getMonth(), date.getDay(), 0, 0);
            }
        }
        catch (Exception ex)
        {
            throw new Exception("Invalid Date");
        }

        return null;
    }

}
