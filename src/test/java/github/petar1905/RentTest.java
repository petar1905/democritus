package github.petar1905;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import org.junit.Test;
import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.DateUtilities;
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.Media;
import github.petar1905.models.Rent;
import github.petar1905.models.User;

/**
 * Unit test for simple App.
 */
public class RentTest 
{
    /**
     * Rigorous Test :-)
     * @throws SQLException 
     * @throws UserException 
     * @throws IOException 
     * @throws MediaException 
     * @throws ParseException 
     * @throws RentException 
     */
    @Test
    public void testRents() throws IOException, SQLException, MediaException, UserException, ParseException, RentException
    {
        Database.getInstance().initializeDatabase();
        Media media = new Media();
        media.setName("The Hunt for Red October");
        media.setDescription("THRO Description");
        media.setAuthor("Tom Clancy");
        media.setGenre("Novel");
        media.setYear(1965);
        media.setQuantity(10);

        User user = new User();
        user.setName("Konstantin");

        Date startDate = DateUtilities.dateFrom("2024-05-24");
        Date endDate = DateUtilities.dateFrom("2024-06-20");
        Rent rent1 = new Rent(user, media, startDate, endDate);
        Rent rent2 = new Rent(rent1.getId());

        boolean mediaMatch = rent1.getMedia().getId() == rent2.getMedia().getId();
        boolean userMatch = rent1.getUser().getId() == rent2.getUser().getId();

        long rent1startDate = rent1.getStartDate().getTime();
        long rent2startDate = rent2.getStartDate().getTime();
        boolean startDateMatch = rent1startDate == rent2startDate;

        long rent1endDate = rent1.getEndDate().getTime();
        long rent2endDate = rent2.getEndDate().getTime();
        boolean endDateMatch = rent1endDate == rent2endDate;

        assertTrue(mediaMatch);
        assertTrue(userMatch);
        assertTrue(startDateMatch);
        assertTrue(endDateMatch);

    }
}
