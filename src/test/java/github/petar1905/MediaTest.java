package github.petar1905;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import github.petar1905.auxillary.classes.Database;
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.Media;

/**
 * Unit test for simple App.
 */
public class MediaTest 
{
    /**
     * Rigorous Test :-)
     * @throws SQLException 
     * @throws UserException 
     * @throws IOException 
     * @throws MediaException 
     */
    @Test
    public void testMedia() throws IOException, SQLException, MediaException
    {
        Database.getInstance().initializeDatabase();
        Media media = new Media();
        media.setName("Under the Yoke");
        media.setDescription("UTY Description");
        media.setAuthor("Ivan Vazov");
        media.setGenre("Novel");
        media.setYear(1893);
        media.setQuantity(15);

        Media media2 = new Media(media.getId());
        boolean descriptionsMatch = media.getDescription().equals(media2.getDescription());
        boolean namesMatch = media.getName().equals(media2.getName());
        boolean authorsMatch = media.getAuthor().equals(media2.getAuthor());
        boolean yearsMatch = media.getYear() == media2.getYear();
        boolean genresMatch = media.getGenre().equals(media2.getGenre());
        assertTrue(descriptionsMatch);
        assertTrue(namesMatch);
        assertTrue(authorsMatch);
        assertTrue(yearsMatch);
        assertTrue(genresMatch);
    }
}
