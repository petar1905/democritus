package github.petar1905.auxillary.classes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtilities {
    public static Date dateFrom(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = format.parse(dateString);
        return new Date(date.getTime());
    }
}
